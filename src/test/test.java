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
    public void testadd() throws Exception {

        String cName ="功夫熊猫";
        String cStuid ="2022441212191";
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


    @Test
    public void testUpdate() throws Exception {
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
        System.out.println(count>0);

        pstmt.close();
        connection.close();

    }

    @Test
    public void testDeleteById() throws Exception {
        int cId=7;

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
        System.out.println(count>0);

        pstmt.close();
        connection.close();

    }
}
