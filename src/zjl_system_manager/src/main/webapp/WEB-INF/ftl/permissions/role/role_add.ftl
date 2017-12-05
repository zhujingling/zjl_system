  <@container.container 1>
    <div class="ibox float-e-margins">
	<div class="ibox-content">
		 <form class="form-horizontal m-t" id="form">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色名称：</label>
                <div class="col-sm-8">
                    <input id="roleName" name="roleName" minlength="2" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">角色类型：</label>
                <div class="col-sm-8">
                    <input id="roleType"  name="roleType" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">角色编号：</label>
                <div class="col-sm-8">
                    <input id="roleCode"  name="roleCode"  type="text" class="form-control" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">排序：</label>
                <div class="col-sm-8">
                    <input id="orderNo" name="orderNo"  type="text"  class="form-control" required="" aria-required="true">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-3">
                    <button class="btn btn-primary" onclick="AddRole()">保存</button>
                    <button class="btn btn-default" onclick="Reset()">重置</button>
                </div>
            </div>
        </form>
	</div>
</div>
  </@container.container> 
   <@container.js 1>    
    <script src="${contextPath}/content/js/permissions/role.js"></script>
    <script src="${contextPath}/content/js/bootstrap-table-object.js"></script>
    <script src="${contextPath}/content/js/tools.js"></script>
   
   </@container.js>   