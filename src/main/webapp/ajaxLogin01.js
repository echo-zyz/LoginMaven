function AjaxLogin(){
	$.ajax(
			{
		contentType: "application/x-www-form-urlencoded;charset=utf-8",		
		url:"./login",
		type:"post",
		dataType:"json",
		data:$("#formData").serialize(),//注意序列化
		success:function(result){//result是ajax里面默认的返回
			//alert("��¼�ɹ�"+result["statusCode"]+result["msg"]);
			$("#logined")[0].innerText="the interface return msg：成功"+result["msg"]+result["statusCode"];
		},
		error:function(result){
			alert("登录失败"+result);	
		}
	}
			)
	
}