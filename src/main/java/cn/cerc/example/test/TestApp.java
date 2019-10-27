package cn.cerc.example.test;

import cn.cerc.example.common.AppDB;
import cn.cerc.jbean.core.Application;
import cn.cerc.jdb.core.IHandle;
import cn.cerc.jdb.mysql.SqlQuery;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestApp {
    private IHandle handle;
    private List<User> users = new ArrayList<>();

    public TestApp(IHandle handle) {
        this.handle = handle;
    }

    public static void main(String[] args) {
        IHandle handle = Application.getHandle();
        try {
            TestApp app = new TestApp(handle);
            app.startApp();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            handle.closeConnections();
        }
    }

    private void startApp() {
        this.mysqlInit();
        if (this.users.size() == 0) {
            System.out.println("数据初始化失败，退出系统");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("系统菜单");
            System.out.println("1、创建用户");
            System.out.println("2、显示系统用户");
            System.out.println("3、退出系统");
            switch (scanner.nextInt()) {
                case 1:
                    this.createUser(scanner);
                    break;
                case 2:
                    this.showUser();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("请选择菜单！");
            }
        }
    }

    private void showUser() {
        for (User user : users)
            System.out.println(user);
    }

    private void createUser(Scanner scanner) {
        User user = new User();
        System.out.println("请输入名字：");
        user.setName(scanner.next());
        System.out.println("请输入年龄：");
        user.setAge(scanner.nextInt());
        System.out.println("请输入金额：");
        user.setAmount(scanner.nextDouble());
        System.out.println(user);
        users.add(user);
        SqlQuery ds = new SqlQuery(handle);
        ds.add("select * from %s", AppDB.Table_User);
        ds.setMaximum(0);
        ds.open();
        ds.append();
        ds.setField("name", user.getName());
        ds.setField("age", user.getAge());
        ds.setField("amount", user.getAmount());
        ds.post();
    }

    private void init() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\13719\\Documents\\i-tool\\a.txt"));
            for (String str : lines) {
                try {
                    users.add(new User(str));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mysqlInit() {
        SqlQuery ds = new SqlQuery(handle);
        ds.add("select * from %s", AppDB.Table_User);
        ds.open();
        while (ds.fetch()) {
            User user = new User();
            user.setAge(ds.getInt("age"));
            user.setAmount(ds.getDouble("amount"));
            user.setName(ds.getString("name"));
            users.add(user);
        }
    }
}
