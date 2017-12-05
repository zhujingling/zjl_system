  <@container.container 1>
    <div class="ibox float-e-margins">
	<div class="ibox-content">
		 <form class="form-horizontal m-t" id="form">
            <div class="form-group">
                <label class="col-sm-3 control-label">菜单名称：</label>
                <div class="col-sm-8">
                    <input id="menuName" name="menuName" minlength="2" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">菜单URL：</label>
                <div class="col-sm-8">
                    <input id="menuUrl"  name="menuUrl" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">父级菜单：</label>
                <div class="col-sm-8">
                    <select id="parentId"  name="parentId"  type="text" class="form-control" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">菜单图标：</label>
                <div class="col-sm-8">
                    <input id="icon" name="icon"  type="text"  class="form-control" required="" aria-required="true">
                </div>
            </div>
             <div class="form-group">
                <label class="col-sm-3 control-label">排序：</label>
                <div class="col-sm-8">
                   <input  id="orderNo" name="orderNo"  class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">层级：</label>
                <div class="col-sm-8">
                   <input  id="levels" name="levels"  class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">备注：</label>
                <div class="col-sm-8">
                   <input  id="remarks" name="remarks"  class="form-control" required="" aria-required="true">
                </div>
            </div>
             
            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-3">
                    <button class="btn btn-primary" onclick="AddMenu()">保存</button>
                    <button class="btn btn-default" onclick="Reset()">重置</button>
                </div>
            </div>
        </form>
	</div>
</div>
  </@container.container> 
   <@container.js 1>    
    <script src="${contextPath}/content/js/permissions/menu.js"></script>
    <script src="${contextPath}/content/js/bootstrap-table-object.js"></script>
    <script src="${contextPath}/content/js/tools.js"></script>
   
   </@container.js>   