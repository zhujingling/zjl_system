<#macro container index>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Guns - 主页</title>
    <link rel="shortcut icon" href="${contextPath}/content/hplus/favicon.ico">    
    <link href="${contextPath}/content/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/plugins/validate/bootstrapValidator.min.css" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/style.min.css?v=4.1.0" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/plugins/ztree/zTreeStyle.css" rel="stylesheet">
    <link href="${contextPath}/content/hplus/css/plugins/jquery-treegrid/css/jquery.treegrid.css" rel="stylesheet"/>
    

 

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
	   <#nested>
	</div>
</#macro>
<#macro js index>
  <!-- 全局js -->
    <script src="${contextPath}/content/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="${contextPath}/content/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${contextPath}/content/hplus/js/plugins/ztree/jquery.ztree.all.min.js"></script>
    
    
    <script src="${contextPath}/content/hplus/js/plugins/layer/layer.min.js"></script>
	<script src="${contextPath}/content/hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="${contextPath}/content/hplus/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script src="${contextPath}/content/hplus/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script src="${contextPath}/content/hplus/js/plugins/validate/bootstrapValidator.min.js"></script>
	
    <script src="${contextPath}/content/hplus/js/plugins/jquery-treegrid/js/jquery.treegrid.min.js"></script>
    <script src="${contextPath}/content/hplus/js/plugins/jquery-treegrid/js/jquery.treegrid.bootstrap3.js"></script>
    <script src="${contextPath}/content/hplus/js/plugins/jquery-treegrid/extension/jquery.treegrid.extension.js"></script>
    
	<script src="${contextPath}/content/hplus/js/demo/bootstrap-table-demo.min.js"></script>	
	<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<script src="${contextPath}/content/hplus/js/content.min.js?v=1.0.0"></script>
	<script src="${contextPath}/content/hplus/js/plugins/layer/laydate/laydate.js"></script>
	<script src="${contextPath}/content/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="${contextPath}/content/js/ztree-object.js"></script>
	<script>
	  var ctxPath="${contextPath}";
	  var menuId="${menuId}";
	</script>
	<#nested>
</body>
</html>
</#macro>


