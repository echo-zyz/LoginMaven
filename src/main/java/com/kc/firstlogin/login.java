package com.kc.firstlogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@SuppressWarnings("restriction")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//设置字符编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//setContentType为 text/html
		String ageValue=request.getParameter("年龄");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("用户名的年龄："+ageValue);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("text/javascript;charset=utf-8");
		String userValue=request.getParameter("account");
		String pwdValue=request.getParameter("password");
		//String ageValue=request.getParameter("年龄");
		String result="";
		MysqlUtils mysql=new MysqlUtils();//实例化
		mysql.CreateConnection();//调用数据库完成连接
		mysql.Login(userValue, pwdValue);//通过login()完成查询 如果能查询到用户名和密码就认为登录成功
		System.out.println("sadfasdfasdfuser"+userValue);
		System.out.println(pwdValue);
		if(mysql.Login(userValue,pwdValue)) {
			result="{\"statusCode\":\"1\",\"msg\":\"登录成功！\"}";
		}
		else {
			result="{\"statusCode\":\"0\",\"msg\":\"登录失败！\"}";
		}
		response.getWriter().append(result);
	}
	public static void main(String[] args) {
		login l=new login();
	}
}
