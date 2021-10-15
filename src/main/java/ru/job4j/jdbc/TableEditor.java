package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    private Statement statement;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
        statement = connection.createStatement();
    }

    private Connection getConnection() throws Exception {
        FileInputStream fis = new FileInputStream("src\\data\\add.properties");
        properties.load(fis);
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, login, password);
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties());
        final String tableName = "demo_table";
        tableEditor.dropTable(tableName);
        tableEditor.createTable(tableName);
        tableEditor.addColumn("demo_table", "id", "serial primary key");
        tableEditor.addColumn("demo_table", "name", "varchar(255)");
        tableEditor.renameColumn("demo_table", "name", "nameN");
        tableEditor.dropColumn("demo_table", "id");
        System.out.println(getTableScheme(tableEditor.connection, tableName));
        tableEditor.connection.close();
        tableEditor.statement.close();
    }

    private void initConnection() throws Exception {
        connection = getConnection();
    }

    public void createTable(String tableName) throws SQLException {
        statement.execute("create table if not exists " + tableName + "();");
    }

    public void dropTable(String tableName) throws SQLException {
        statement.execute("drop table " + tableName + ";");
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format("alter table %s add column %s %s;", tableName, columnName, type);
        statement.execute(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format("alter table %s drop column %s;", tableName, columnName);
        statement.execute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format("alter table %s rename column %s to %s;", tableName, columnName, newColumnName);
        statement.execute(sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}