package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//一些熟悉工作

public class jdbcDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test";
        String username="root";
        String password="1234";
        Connection conn= DriverManager.getConnection(url,username,password);

        //定义Sql
        String sql="update t_member set c_name='超人强' where c_id=5";

        //获取执行Sql的对象Statement
        Statement stmt=conn.createStatement();

        //执行Sql
        int count=stmt.executeUpdate(sql);

        //处理结果
        System.out.println(count);

        //释放资源
        stmt.close();
        conn.close();
    }
}
