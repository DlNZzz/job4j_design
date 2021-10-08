package ru.job4j.test.task.task.two.four;

public class BankAccount {

    private int account;
    private String name;
    private int balance;

    public BankAccount(int account, String name, int balance) {
        this.account = account;
        this.name = name;
        this.balance = balance;
    }

    public void replenishment(int money) {
        balance += money;
    }

    public void output(int money) {
        balance -= money;
    }

    public void info() {
        System.out.printf("account - %d\nname - %s\nbalance - %d\n", account, name, balance);
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1, "a", 13);
        bankAccount.replenishment(12);
        bankAccount.output(2);
        bankAccount.info();
    }
}
