package ru.job4j.test.task.four;
/*
2.	Создайте Windows Forms приложения

с полями для ввода названия товара, цены товара, количество товара,
а также двумя кнопками следующий заказ и итого.

При нажатии на первую кнопку поля ввода очищаются и заказ добавляется в список заказов.
При нажатии на итого выводится в диалоговом окне информация обо всех заказах, суммах заказов и общая сумма заказов.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Solution2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // установка надписи
        Text text = new Text("Hello METANIT.COM!");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(80);   // установка положения надписи по оси X

        Group group = new Group(text);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }
}
