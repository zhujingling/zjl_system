  <@container.container 1>
    <div class="ibox float-e-margins">
	<div class="ibox-content">
		 <form class="form-horizontal m-t" id="form">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户账号：</label>
                <div class="col-sm-8">
                    <input id="userAccount" name="userAccount" minlength="2" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">用户姓名：</label>
                <div class="col-sm-8">
                    <input id="userRealName"  name="userRealName" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">用户头像：</label>
                <div class="col-sm-8">
                    <input id="userHeadImg"  name="userHeadImg"  type="text" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">用户电话：</label>
                <div class="col-sm-8">
                    <input id="userTel" name="userTel"  type="text"  class="form-control" required="" aria-required="true">
                </div>
            </div>
             <div class="form-group">
                <label class="col-sm-3 control-label">用户生日：</label>
                <div class="col-sm-8">
                   <input placeholder="日期" id="userBirthday" name="userBirthday"  class="form-control layer-date" required=""  aria-required="true">
                </div>
            </div>
             
            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-3">
                    <button class="btn btn-primary" onclick="AddUser()">保存</button>
                    <button class="btn btn-default" onclick="Reset()">重置</button>
                </div>
            </div>
        </form>
	</div>
</div>
  </@container.container> 
   <@container.js 1>    
    <script src="${contextPath}/content/js/permissions/user.js"></script>
    <script src="${contextPath}/content/js/bootstrap-table-object.js"></script>
    <script src="${contextPath}/content/js/tools.js"></script>
    <script>
	     var start = {
	        elem: "#userBirthday",
	        format: "YYYY/MM/DD",
	        min: laydate.now(),
	        max: "2099-06-16 23:59:59",
	        istime: true,
	        istoday: false
	    };
	     laydate(start);
    </script>
   </@container.js>   