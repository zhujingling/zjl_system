  <@container.container 1>
   <div class="row">
	    <div class="ibox float-e-margins">
		<div class="ibox-content">
			  <ul id="zTree" class="ztree"></ul>
		</div>
    </div>
	 <div class="row">
        <div class="col-md-12">
            <button class="btn btn-sm btn-info" type="button" id="btn_save">
                <i class="ace-icon fa fa-check bigger-110"></i>保存
            </button>
            &nbsp;
            <button class="btn btn-sm btn-danger" type="button" id="btn_close">
                <i class="ace-icon fa fa-close bigger-110"></i>关闭
            </button>
        </div>
    </div>
</div>
  </@container.container> 
   <@container.js 1>    
    <script src="${contextPath}/content/js/permissions/button.js"></script>
    <script src="${contextPath}/content/js/bootstrap-table-object.js"></script>
    <script src="${contextPath}/content/js/tools.js"></script>
    <script>
       $(function(){
        	  var setting = {
	            check: {
	                enable: true,
	                chkboxType: { "Y": "ps", "N": "ps" }
	            },
	            data: {
	                simpleData: {
	                    enable: true
	                }
	            }
	        };
			var params={"menuId":window.parent.MgrMenu.seItem.id};
	        var ztree = new $ZTree("zTree", ctxPath+"/permissions/systembutton/buttonztree.shtml",params);
	        ztree.setSettings(setting);
	        ztree.init();
	        
	        $("#btn_save").click(function(){
	       		var zTree = $.fn.zTree.getZTreeObj("zTree");
	       		var nodes = zTree.getCheckedNodes();
		        var ids = "";
		        for (var i = 1, l = nodes.length; i < l; i++) {
		            ids +=  nodes[i].id+ ",";
		        }
		    ids=ids.substring(0,ids.length-1)
		    var data={"menuId":window.parent.MgrMenu.seItem.id,"buttonsId":ids};
		    $.post(ctxPath+"/permissions/systemmenu/allocationrolemenubutton.shtml",data,function(result){
		    		swal({
						title : "提示",
						text : result.Msg,
						type : "success"
					});
		     },'json');
       });
       })
       
       
       
    </script>
   </@container.js>   