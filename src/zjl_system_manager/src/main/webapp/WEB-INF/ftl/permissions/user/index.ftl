 <@container.container 1>  
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
	                <div class="ibox-title">
	                    <h5>查询列表</h5>
	                    <div class="ibox-tools">
	                        <a class="collapse-link">
	                            <i class="fa fa-chevron-up"></i>
	                        </a>                       
	                        <a class="close-link">
	                            <i class="fa fa-times"></i>
	                        </a>
	                    </div>
	                </div>
	                <div class="ibox-content">
                        <div class="row">
                        	<div class="col-sm-4">
                        	     <div class="form-group">
		                            <label class="col-sm-3 control-label">姓名：</label>
		                            <div class="col-sm-8">
		                                <input id="userAccount" name="userAccount" type="text" class="form-control">
		                            </div>
		                        </div>
                        	</div>
                        	<div class="col-sm-4">
                        	     <div class="form-group">
		                            <div class="col-sm-4 col-sm-offset-3">
		                                <button class="btn btn-primary" type="button">搜索</button>
		                            </div>
		                        </div>
                        	</div>
                        </div>
                    </form>
	              </div>
             </div>
             
             <div class="col-sm-12">
                 <div class="btn-group hidden-xs" id="myTableToolBar" role="group"></div>
                 <table class="table table-striped" id="mytable"></table>
             </div>
        </div>
   </@container.container> 
   <@container.js 1>    
    <script src="${contextPath}/content/js/permissions/user.js"></script>
    <script src="${contextPath}/content/js/bootstrap-table-object.js"></script>
    <script src="${contextPath}/content/js/tools.js"></script>
   </@container.js>   