function AjaxLogin(){
	$.ajax(
			{ 		
		url:"./login",
		type:"post",
		dataType:"json",
		data:$("#formData").serialize(),
		success:function(result){//result是ajax()的默认返回
			//alert("返回信息是"+result["statusCode"]+result["msg"]);
			$("#logined")[0].innerText="the interface return msg返回的信息-"+result["msg"]+result["statusCode"];
		},
		error:function(result){
			alert("登录失败"+result);	
		}
	}
			)
	
}