package com.kc.firstlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

public class MysqlUtils {
	//获得数据库连接
	private Connection myConnerctor;
	public void CreateConnection() {
		 try {
		    	Properties prop=new Properties();//实例化properties
		    	prop.load(this.getClass().getResourceAsStream("/inter.properties"));//加载inter.properties文件
		    	String dburl=prop.getProperty("DBURL");
		    	String dbuser=prop.getProperty("DBUSER");
		    	String dbpwd=prop.getProperty("DBPWD");
		    	System.out.println(dbpwd);
	            //加载mysql驱动 注意这个之前maven要配置mysql依赖
				Class.forName("com.mysql.jdbc.Driver");
				myConnerctor=DriverManager.getConnection(dburl, dbuser, dbpwd);//用properties里面参数链接数据库
		        //操作数据库实现增删改查
				//Statement myst=	myConnerctor.createStatement();
                DriverManager.setLoginTimeout(10);//设置超时时间
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	public boolean Login(String name,String pwd) {
		String sql="select * from userinfo where username='"+name+"' and pwd='"+pwd+"';";
		//String sql="SELECT * FROM userinfo;";
		ResultSet rs=null;//保存结果
		Statement sm;//声明Statement对象
		try {
			sm=myConnerctor.createStatement();//通过数据库连接实例化Statement对象
			rs=sm.executeQuery(sql);//执行查询
			if(rs!=null&&rs.next()) {//如果查询成功rs!=null，rs.next()表示集合有下一个元素并且读取
				ResultSetMetaData rsmd=rs.getMetaData();//用元组数据逐个读取 查表头
				HashMap<String,String> map=new HashMap<String,String>();//声明map来存储内容
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					map.put(rsmd.getColumnClassName(i), rs.getString(i));//从sql中的列队1开始，历遍一行数据中的每个列内容，以键值对的形式存到map
				}
				//System.out.println(map);
				sm.close();
				rs.close();//关闭statement对象和查询结果，释放资源
				return true;
			}
		} catch (SQLException e) {	
		}
		return false;
		
		
	}
	public static void main(String[] args) {
		String result="";
		MysqlUtils mysql=new MysqlUtils();//实例化
		mysql.CreateConnection();//调用数据库完成连接
		//myslq.Login("kuangchao", "123456");//通过login()完成查询 如果能查询到用户名和密码就认为登录成功
		if(mysql.Login("Will","123456")) {
			result="{\"statusCode\":\"1\",\"msg\":\"登录成功！\"}";
			System.out.println(result);
		}
		else {
			result="{\"statusCode\":\"0\",\"msg\":\"登录失败！\"}";
			System.out.println(result);
		}
	}
	

}

