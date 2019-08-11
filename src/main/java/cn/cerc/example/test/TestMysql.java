package cn.cerc.example.test;

import cn.cerc.jbean.core.Application;
import cn.cerc.jdb.core.IHandle;
import cn.cerc.jdb.mysql.SqlQuery;

public class TestMysql {
    public static void main(String[] args) {
        IHandle handle = Application.getHandle();
        try {
            SqlQuery ds = new SqlQuery(handle);
            ds.add("select * from s_task");
            ds.add("where taskId_='22345646'");
            ds.open();
            if (!ds.eof()) {
                ds.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            handle.closeConnections();
        }
    }
}
