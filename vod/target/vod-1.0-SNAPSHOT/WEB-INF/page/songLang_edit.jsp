<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<!-- h-ui的css -->
		<link href="<%=basePath%>/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
		<link  href="<%=basePath%>/static/h-ui.admin/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
		<!-- 图标样式的css -->
		<link href="<%=basePath%>/static/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
		<!-- 美化表单元素的css -->
		<link  href="<%=basePath%>/static/icheck/icheck.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<article class="page-container">
			<form action="<%=basePath%>/songLang/${requestUrl}.do" method="post" class="form form-horizontal" id="edit_form" onsubmit="return requestForm()">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>歌曲语种名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text"  value="${songLang.language}" 
							id="language" name="language">
					</div>
				</div>
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<input type="hidden" id="lang_id" value="${songLang.id}">
						<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
					</div>
				</div>
			</form>
		</article>
	</body>
	<!-- h-ui的js -->
	<script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/h-ui/js/H-ui.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!-- 弹出层js -->
	<script type="text/javascript" src="<%=basePath%>/static/layer/layer.js"></script>
	<!-- 美化表单元素的js -->
	<script type="text/javascript" src="<%=basePath%>/static/icheck/jquery.icheck.min.js"></script>
	<!-- 表单验证的js -->
	<script type="text/javascript" src="<%=basePath%>/static/jquery.validation/1.14.0/jquery.validate.min.js"></script> 
	<script type="text/javascript" src="<%=basePath%>/static/jquery.validation/1.14.0/validate-methods.js"></script> 
	<script type="text/javascript" src="<%=basePath%>/static/jquery.validation/1.14.0/messages_zh.min.js"></script>
	
	<script type="text/javascript">
	
		function requestForm(){
			var status=false;
			//封装请求数据对象
			var requestData=null;
			/* lang_name_eng=lang_name_eng.replace(/\s/g,"-"); */
			var language=$("#language").val();
			if(language==null||language==''){
				layer.msg("请输入歌曲语种!");
				return false;
			}
			
			var lang_id=$("#lang_id").val();
			//如果不存在编号则是新增,否则的话是修改
			if(lang_id!=''){
				requestData={"language":language,"langId":lang_id};
			}else{
				requestData={"language":language};
			}
			//获取请求路径
			var form=$("#edit_form");
			var url=form.attr("action");
			$.ajax({ 
				url: url, 
				data:requestData,
				type:"post",
				async:false,
				success: function(result){
					status=result;
		      	}
			});
			if(status){
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}else{
				return false;
			}
		}
		$(function(){
			$('.skin-minimal input').iCheck({
				checkboxClass: 'icheckbox-blue',
				radioClass: 'iradio-blue',
				increaseArea: '20%'
			});
		});
	</script>  
</html>