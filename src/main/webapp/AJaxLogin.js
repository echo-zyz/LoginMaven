function AjaxLogin(){
	$.ajax(
			{ 		
		url:"./login",
		type:"post",
		dataType:"json",
		data:$("#formData").serialize(),
		success:function(result){//result��ajax()Ĭ�Ϸ���
			//alert("��¼�ɹ�"+result["statusCode"]+result["msg"]);
			$("#logined")[0].innerText="the interface return msg：成功"+result["msg"]+result["statusCode"];
		},
		error:function(result){
			alert("失败"+result);	
		}
	}
			)
	
}