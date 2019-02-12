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
			    //������com.mysql.jdbc.Driver
	            //���� mysql-connector-java-5.0.8-bin.jar��
	            //��������˵�һ������ĵ������ͻ��׳�ClassNotFoundException
	            Class.forName("com.mysql.jdbc.Driver");
	 
	            // ���������ݿ��Connection����
	            // ������Ҫ�ṩ��
	            // ���ݿ������ڵ�ip:127.0.0.1 (����)
	            // ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ�
	            // ���ݿ����� how2java
	            // ���뷽ʽ UTF-8
	            // �˺� root
	            // ���� admin
	 
	            c = DriverManager.getConnection(
	            		"jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
	            		"root", "admin");
	 
	            System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);
	            // ע�⣺ʹ�õ��� java.sql.Statement
	            // ��Ҫ��С��ʹ�õ��� com.mysql.jdbc.Statement;
	            s = c.createStatement();
	            System.out.println("��ȡ Statement���� " + s);
	            // ׼��sql���
	            // ע�⣺ �ַ���Ҫ�õ�����'
	          /*String sql = "insert into hero values(null,"+"'��Ī'"+","+313.0f+","+50+")";��
	            String sql = "delete from hero where id = 5";ɾ
	            String sql = "update hero set name = 'name 5' where id = 3";��
	            s.execute(sql);
	            System.out.println("ִ�в������ɹ�");*/
	            String sql = "select * from hero";
	         // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                int id = rs.getInt("id");// ����ʹ���ֶ���
	                String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
	                float hp = rs.getFloat("hp");
	                int damage = rs.getInt(4);
	                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
	            }
	            // ��һ��Ҫ������ر�ReultSet����ΪStatement�رյ�ʱ�򣬻��Զ��ر�ResultSet
	            // rs.close();
	            
	            PreparedStatement ps = c.prepareStatement(sql);
	            ps.setString(1, "��Ī");
	            ps.setFloat(2, 313.0f);
	            ps.setInt(3, 50);
	            ps.execute();
	            // PreparedStatement ִ��10�Σ�ֻ��Ҫ1�ΰ�SQL��䴫�䵽���ݿ��
	            // ���ݿ�Դ�?��SQL����Ԥ����
	  
	            // ÿ��ִ�У�ֻ��Ҫ������������ݿ��
	            // 1. ���紫������Statement��С
	            // 2. ���ݿⲻ��Ҫ�ٽ��б��룬��Ӧ����
	            for (int i = 0; i < 10; i++) {
	                ps.setString(1, "��Ī");
	                ps.setFloat(2, 313.0f);
	                ps.setInt(3, 50);
	                ps.execute();
	            }
	            
	            /*PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
                ) {
  
            ps.setString(1, "����");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
   
            // ִ�в������
            ps.execute();
   
            // ��ִ�����������MySQL��Ϊ�²�������ݷ���һ��������id
            // JDBCͨ��getGeneratedKeys��ȡ��id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
            }*/
	            
	        /*// �鿴���ݿ�����Ԫ����
            // �����ݿ�������汾�������汾��������Щ���ݿ�ȵ�
  
            DatabaseMetaData dbmd = c.getMetaData();
  
            // ��ȡ���ݿ��������Ʒ����
            System.out.println("���ݿ��Ʒ����:\t"+dbmd.getDatabaseProductName());
            // ��ȡ���ݿ��������Ʒ�汾��
            System.out.println("���ݿ��Ʒ�汾:\t"+dbmd.getDatabaseProductVersion());
            // ��ȡ���ݿ�������������ͱ���֮��ķָ��� ��test.user
            System.out.println("���ݿ�ͱ�ָ���:\t"+dbmd.getCatalogSeparator());
            // ��ȡ�����汾
            System.out.println("�����汾:\t"+dbmd.getDriverVersion());
  
            System.out.println("���õ����ݿ��б�");
            // ��ȡ���ݿ�����
            ResultSet rs = dbmd.getCatalogs();
  
            while (rs.next()) {
                System.out.println("���ݿ�����:\t"+rs.getString(1));
            }*/
	            
	        /*// �������ǰ����
            // �������еĶ��������Ҫô���ɹ���Ҫô��ʧ��
  
            c.setAutoCommit(false);
  
            // ��Ѫ��SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
  
            // ��Ѫ��SQL
            // ��С��д��д���� updata(����update)
  
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
  
            // �ֶ��ύ
            c.commit();*/
	            
	 
		 } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	     } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	     }finally {
	            // ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
	            // �ȹر�Statement
	            if (s != null)
	                try {
	                    s.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            // ��ر�Connection
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
