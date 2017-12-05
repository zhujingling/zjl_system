$(function() {
	// 先拿到菜单的toolbar按钮
	$.post(ctxPath + "/permissions/systemrole/getrolemenubutton.shtml",{"menuId":menuId},
			function(result) {
				var defaultColunms = MgrRole.initColumn();
				var table = new BSTable("mytable", ctxPath
						+ "/permissions/systemrole/findrolebypage.shtml",
						defaultColunms);
				toolBar("myTableToolBar", result);
				MgrRole.table = table.init();
			}, 'json');

});

/**
 * 系统管理--用户管理的单例对象
 */
var MgrRole = {
	id : "mytable",// 表格id
	seItem : null, // 选中的条目
	table : null,
	layerIndex : -1,
	deptid : 0
};

/**
 * 初始化表格的列
 */
MgrRole.initColumn = function() {
	var columns = [ {
		field : 'selectItem',
		radio : true
	}, {
		title : '序号',
		field : 'id',
		align : 'center',
		valign : 'middle',
		formatter : function(value, row, index) {
			return index + 1;
		}
	}, {
		title : '角色名称',
		field : 'roleName',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '角色类型',
		field : 'roleType',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '角色编号',
		field : 'roleCode',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '排序',
		field : 'orderNo',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '创建时间',
		field : 'createTime',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '修改时间',
		field : 'modifyTime',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '创建人',
		field : 'createMan',
		align : 'center',
		valign : 'middle',
		sortable : true
	} ];
	return columns;
};

/**
 * 检查是否选中
 */
MgrRole.check = function() {
	var selected = $('#' + this.id).bootstrapTable('getSelections');
	if (selected.length == 0) {
		swal({
			title : "提示",
			text : "请先选中表格中的某一记录！",
			type : "warning"
		});
		return false;
	} else {
		MgrRole.seItem = selected[0];
		return true;
	}
};

Add = function() {
	var index = layer.open({
		type : 2,
		title : '添加角色',
		area : [ '830px', '500px' ], // 宽高
		fix : false, // 不固定
		maxmin : true,
		content : ctxPath + '/permissions/systemrole/role_add.shtml'
	});
	this.layerIndex = index;
}

AddRole=function(){
	var form = $("#form").serialize();
	$.post(ctxPath + "/permissions/systemrole/insert.shtml", form,
			function(result) {
				if (result.Code == 1) {
					swal({
						title : "提示",
						text : result.Msg,
						type : "success"
					});
					window.parent.MgrRole.table.refresh();
					RoleInfoDlg.close();

				} else {
					swal({
						title : "提示",
						text : result.Msg,
						type : "warning"
					});
				}
			}, 'json')
}

var RoleInfoDlg = {
	roleInfoData : {},
	validateFields : {
		userAccount : {
			validators : {
				notEmpty : {
					message : '账户不能为空'
				}
			}
		},
		userName : {
			validators : {
				notEmpty : {
					message : '姓名不能为空'
				}
			}
		}
	}
};

/**
 * 关闭此对话框
 */
RoleInfoDlg.close = function() {
	parent.layer.close(window.parent.layerIndex);
};
/*
 *  给菜单分配按钮操作
 * */
AllocationMenu = function() {
	if (MgrRole.check()) {
		var index = layer.open({
			type : 2,
			title : '分配菜单',
			area : [ '500px', '500px' ], // 宽高
			fix : false, // 不固定
			maxmin : true,
			content : ctxPath + '/permissions/systemmenu/menu_ztree.shtml'
		});
		this.layerIndex = index;
	}
}

function Reset() {
	RoleInfoDlg.close();
}