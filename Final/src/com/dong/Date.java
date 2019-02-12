package com.dong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Date {
	public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
		 try {
			    //驱动类com.mysql.jdbc.Driver
	            //就在 mysql-connector-java-5.0.8-bin.jar中
	            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
	            Class.forName("com.mysql.jdbc.Driver");
	 
	            // 建立与数据库的Connection连接
	            // 这里需要提供：
	            // 数据库所处于的ip:127.0.0.1 (本机)
	            // 数据库的端口号： 3306 （mysql专用端口号）
	            // 数据库名称 how2java
	            // 编码方式 UTF-8
	            // 账号 root
	            // 密码 admin
	 
	            c = DriverManager.getConnection(
	            		"jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
	            		"root", "admin");
	 
	            System.out.println("连接成功，获取连接对象： " + c);
	            // 注意：使用的是 java.sql.Statement
	            // 不要不小心使用到： com.mysql.jdbc.Statement;
	            s = c.createStatement();
	            System.out.println("获取 Statement对象： " + s);
	            // 准备sql语句
	            // 注意： 字符串要用单引号'
	          /*String sql = "insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";插
	            String sql = "delete from hero where id = 5";删
	            String sql = "update hero set name = 'name 5' where id = 3";改
	            s.execute(sql);
	            System.out.println("执行插入语句成功");*/
	            String sql = "select * from hero";
	         // 执行查询语句，并把结果集返回给ResultSet
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                int id = rs.getInt("id");// 可以使用字段名
	                String name = rs.getString(2);// 也可以使用字段的顺序
	                float hp = rs.getFloat("hp");
	                int damage = rs.getInt(4);
	                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
	            }
	            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
	            // rs.close();
	            
	            PreparedStatement ps = c.prepareStatement(sql);
	            ps.setString(1, "提莫");
	            ps.setFloat(2, 313.0f);
	            ps.setInt(3, 50);
	            ps.execute();
	            // PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
	            // 数据库对带?的SQL进行预编译
	  
	            // 每次执行，只需要传输参数到数据库端
	            // 1. 网络传输量比Statement更小
	            // 2. 数据库不需要再进行编译，响应更快
	            for (int i = 0; i < 10; i++) {
	                ps.setString(1, "提莫");
	                ps.setFloat(2, 313.0f);
	                ps.setInt(3, 50);
	                ps.execute();
	            }
	            
	            /*PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
                ) {
  
            ps.setString(1, "盖伦");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
   
            // 执行插入语句
            ps.execute();
   
            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
            }*/
	            
	        /*// 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
  
            DatabaseMetaData dbmd = c.getMetaData();
  
            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());
  
            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();
  
            while (rs.next()) {
                System.out.println("数据库名称:\t"+rs.getString(1));
            }*/
	            
	        /*// 有事务的前提下
            // 在事务中的多个操作，要么都成功，要么都失败
  
            c.setAutoCommit(false);
  
            // 加血的SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
  
            // 减血的SQL
            // 不小心写错写成了 updata(而非update)
  
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
  
            // 手动提交
            c.commit();*/
	            
	 
		 } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	     } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	     }finally {
	            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
	            // 先关闭Statement
	            if (s != null)
	                try {
	                    s.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            // 后关闭Connection
	            if (c != null)
	                try {
	                    c.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	     }
	}
}
