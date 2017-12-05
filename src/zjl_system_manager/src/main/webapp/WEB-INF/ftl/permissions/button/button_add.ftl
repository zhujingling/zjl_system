  <@container.container 1>
    <div class="ibox float-e-margins">
	<div class="ibox-content">
		 <form class="form-horizontal m-t" id="form">
            <div class="form-group">
                <label class="col-sm-3 control-label">按钮名称：</label>
                <div class="col-sm-8">
                    <input id="buttonName" name="buttonName" minlength="2" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">按钮方法：</label>
                <div class="col-sm-8">
                    <input id="buttonMethod"  name="buttonMethod" type="text" class="form-control" required="" aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">按钮图标：</label>
                <div class="col-sm-8">
                    <input id="icon"  name="icon"  type="text" class="form-control" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">按钮样式：</label>
                <div class="col-sm-8">
                    <input id="style" name="style"  type="text"  class="form-control" required="" aria-required="true">
                </div>
            </div>
             <div class="form-group">
                <label class="col-sm-3 control-label">排序：</label>
                <div class="col-sm-8">
                   <input  id="orderNo" name="orderNo"  class="form-control layer-date" required=""  aria-required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">备注：</label>
                <div class="col-sm-8">
                   <input  id="remarks" name="remarks"  class="form-control layer-date" required=""  aria-required="true">
                </div>
            </div>
             
            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-3">
                    <button class="btn btn-primary" onclick="AddButton()">保存</button>
                    <button class="btn btn-default" onclick="Reset()">重置</button>
                </div>
            </div>
        </form>
	</div>
</div>
  </@container.container> 
   <@container.js 1>    
    <script src="${contextPath}/content/js/permissions/button.js"></script>
    <script src="${contextPath}/content/js/bootstrap-table-object.js"></script>
    <script src="${contextPath}/content/js/tools.js"></script>
   
   </@container.js>   