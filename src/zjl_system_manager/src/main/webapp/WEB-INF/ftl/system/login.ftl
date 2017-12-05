
<!DOCTYPE html>
<#assign base=contextPath />
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>系统 - 登录</title>
    <meta name="keywords" content="后台bootstrap框架,后台HTML,响应式后台">
    <meta name="description" content="基于Bootstrap3最新版本开发的扁平化主题，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="${contextPath}/content/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="${contextPath}/content/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
	</head>
   <body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">H+</h1>

            </div>
            <h3>欢迎使用</h3>

            <form class="m-t" role="form">
                <div class="form-group">
                    <input type="text" id="userAccount" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" id="userPwd" class="form-control" placeholder="密码" required="">
                </div>
                 <div style="text-align: left; margin-left: 10px;">
                <label><input type="checkbox" checked="checked"  id="rememberMe"style="width: 10px; height: 10px;">记住我</label>
                </div>
                <button type="button" class="btn btn-primary block full-width m-b" onclick="login()">登 录</button>


                <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>
    
    <script src="${contextPath}/content/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="${contextPath}/content/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${contextPath}/content/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
 		
    </body>
    <script>
    	function login(){
    	var data={userAccount:$('#userAccount').val(),passWord:$('#userPwd').val(),rememberMe:$("#rememberMe").is(':checked')}
    		$.post("${contextPath}/permissions/systemuser/login.shtml",data,function(result){
    			if(result.Code==1){
    				 swal({
			            title: "提示",
			            text: result.Msg,
			            type: "success"
			        });
			        window.location.href="${contextPath}/system/index.shtml";
    			}else{
			       swal({
			            title: "提示",
			            text: result.Msg,
			            type: "error"
			        });
    			}
    		},'json')
    	}
    </script>
   
</html>

