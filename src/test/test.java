package test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdbc.Work;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class test {
    //获取Connection
    //定义SQL：select*from t_member;
    //获取PreparedStatement对象
    //如果查询所有对象 则不用参数
    //执行SQL
    //处理结果 List<t_member>
    //释放资源


    //要是数据库建表中，如果想使成员的信息包含图片，怎么插入怎么存储        workBench txt
    //如果一个成员有多个身份，比如超人强既可以是技术组，又是节目组         知识：经典五张表



    //批量查询
    @Test
    public void testall() throws Exception {

        Properties prop=new Properties();

        prop.load(new FileInputStream("C:\\Users\\Kuzma\\IdeaProjects\\July two\\jdbc-Demo\\src\\druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection=dataSource.getConnection();

        System.out.println(connection);

        String sql="select*from t_member";

        PreparedStatement pstmt= connection.prepareStatement(sql);

        ResultSet rs= pstmt.executeQuery();

        List<Work> works=new ArrayList<>();

        Work work=null;

        while(rs.next())
        {
            int id = rs.getInt("c_id");
            String name=rs.getString("c_name");
            String stuid=rs.getString("c_stu_id");
            String post=rs.getString("c_post");
            String grade=rs.getString("c_grade");
            String college=rs.getString("c_college");
            String time=rs.getString("c_entrytime");

            work=new Work();
            work.setcId(id);
            work.setcName(name);
            work.setcStuId(stuid);
            work.setcPost(post);
            work.setcGrade(grade);
            work.setC_college(college);
            work.setC_entrytime(time);
            works.add(work);
        }
        System.out.println(works);
        rs.close();
        pstmt.close();
        connection.close();

    }



    @Test
    public void testSomeone() throws Exception {

        Properties prop=new Properties();

        prop.load(new FileInputStream("C:\\Users\\Kuzma\\IdeaProjects\\July two\\jdbc-Demo\\src\\druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection=dataSource.getConnection();

        System.out.println(connection);

        //在此处的SQL中修改查询的对象的c_id即可或者修改where后的表达式查询其他条件的数据
        String sql="select *from t_member where c_id=1;";

        PreparedStatement pstmt= connection.prepareStatement(sql);

        ResultSet rs= pstmt.executeQuery();

        List<Work> works=new ArrayList<>();

        Work work=null;

        while(rs.next()) {
            int id = rs.getInt("c_id");
            String name = rs.getString("c_name");
            String stuid = rs.getString("c_stu_id");
            String post = rs.getString("c_post");
            String grade = rs.getString("c_grade");
            String college = rs.getString("c_college");
            String time = rs.getString("c_entrytime");

            work = new Work();
            work.setcId(id);
            work.setcName(name);
            work.setcStuId(stuid);
            work.setcPost(post);
            work.setcGrade(grade);
            work.setC_college(college);
            work.setC_entrytime(time);
            works.add(work);

        }
        System.out.println(works);
        rs.close();
        pstmt.close();
        connection.close();

    }


    //添加
    @Test
    public void testadd() throws Exception {

        //此处不用添加c_id 因为设置了c_id那列为主键且递增
        String cName ="功夫熊猫";
        String cStuid ="2022741212191";
        String cPost ="技术组UI开发";
        String cGrade ="2021级";
        String cCollege ="计算机学院计科2班";
        String cEnteytime ="2022-9-30";


        Properties prop=new Properties();

        prop.load(new FileInputStream("C:\\Users\\Kuzma\\IdeaProjects\\July two\\jdbc-Demo\\src\\druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection=dataSource.getConnection();

        String sql="insert into t_member ( c_name, c_stu_id, c_post, c_grade, c_college, c_entrytime)values (?,?,?,?,?,?)";

        //获取pstmt对象
        PreparedStatement pstmt= connection.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,cName);
        pstmt.setString(2,cStuid);
        pstmt.setString(3,cPost);
        pstmt.setString(4,cGrade);
        pstmt.setString(5,cCollege);
        pstmt.setString(6,cEnteytime);

        //执行SQL
        int count= pstmt.executeUpdate();

        //处理结果
        if(count>0)
        System.out.println("添加成功");
        else System.out.println("添加失败");

        pstmt.close();
        connection.close();

    }



    //更新
    @Test
    public void testUpdate() throws Exception {

        //此处以c_id来作为更新对象的标志
        int cId=7;
        String cName ="村长";
        String cStuid ="2022441212111";
        String cPost ="技术组UI开发";
        String cGrade ="2021级";
        String cCollege ="计算机学院计科2班";
        String cEnteytime ="2022-9-30";


        Properties prop=new Properties();

        prop.load(new FileInputStream("C:\\Users\\Kuzma\\IdeaProjects\\July two\\jdbc-Demo\\src\\druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection=dataSource.getConnection();

        String sql="update t_member\n" +
                "    set c_name=?,\n" +
                "      c_stu_id=?,\n" +
                "      c_post=?,\n" +
                "      c_grade=?,\n" +
                "      c_college=?,\n" +
                "      c_entrytime=?\n" +
                "where c_id=?";

        //获取pstmt对象
        PreparedStatement pstmt= connection.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,cName);
        pstmt.setString(2,cStuid);
        pstmt.setString(3,cPost);
        pstmt.setString(4,cGrade);
        pstmt.setString(5,cCollege);
        pstmt.setString(6,cEnteytime);
        pstmt.setInt(7,cId);

        //执行SQL
        int count= pstmt.executeUpdate();

        //处理结果
        if (count>0)
        System.out.println("数据更新成功");
        else System.out.println("数据更新失败");

        pstmt.close();
        connection.close();

    }


    //删除
    @Test
    public void testDeleteById() throws Exception {
        int cId=6;

        Properties prop=new Properties();

        prop.load(new FileInputStream("C:\\Users\\Kuzma\\IdeaProjects\\July two\\jdbc-Demo\\src\\druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection=dataSource.getConnection();

        String sql="delete from t_member where c_id=?";

        //获取pstmt对象
        PreparedStatement pstmt= connection.prepareStatement(sql);

        //设置参数
        pstmt.setInt(1,cId);

        //执行SQL
        int count= pstmt.executeUpdate();

        //处理结果
        if (count>0)
            System.out.println("数据删除成功");
        else System.out.println("数据删除失败");

        pstmt.close();
        connection.close();

    }
}
