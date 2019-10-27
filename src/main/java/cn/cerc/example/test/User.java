package cn.cerc.example.test;

public class User {
    private String name;
    private int age;
    private double amount;

    public User() {

    }

    public User(String user) {
        String[] param = user.split("[,，]");
        if (param == null || param.length != 3) {
            throw new RuntimeException("数据存在错误，添加失败！数据为：" + user);
        }
        this.name = param[0];
        this.age = Integer.valueOf(param[1]);
        this.amount = Double.valueOf(param[2]);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("name:%s age: %d amount:%f", name, age, amount);
    }
}
