package com.kc.firstlogin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class MsqlTest {
	public static void main(String[] args) {
		String url="jdbc:mysql://120.78.238.66:3306/test_project?useSSL=true&serverTimezone=GMT&useUnicode=true&autoReconnect=true&characterEncoding=utf-8";
        String url2="jdbc:mysql://120.78.238.66:3306/test_project?useSSL=false";
		String user="root";
	    String password="kuangchao123456";	
	    try {
            //加载mysql驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库连接
			Connection mysqlConnerctor=DriverManager.getConnection(url2, user, password);
	        //操作数据库实现增删改查
			Statement myst=	mysqlConnerctor.createStatement();
			String inputUser="kuangchao";
			String inputPwd="123456";
			String sql="SELECT * from userinfo where username=\"kuangchao\" and pwd=\"123456\";";
			ResultSet rs=myst.executeQuery(sql);
			System.out.println(rs);
			if(rs.next()) {
				System.out.println("login success"+rs.getString("username")+rs.getString("pwd"));
			}
			else {
				System.out.println("login failed");
			}
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
