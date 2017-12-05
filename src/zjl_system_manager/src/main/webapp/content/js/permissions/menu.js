$(function() {
	// 先拿到菜单的toolbar按钮
	$.post(ctxPath + "/permissions/systemrole/getrolemenubutton.shtml",{"menuId":menuId},
			function(result) {
				var defaultColunms = MgrMenu.initColumn();
				var table = new BSTreeTable("mytable", ctxPath
						+ "/permissions/systemmenu/findmenubypage.shtml",
						defaultColunms);
				toolBar("myTableToolBar", result);
				// 这个决定展开的箭头是在第几列
				table.setExpandColumn(1);
				table.setIdField("id");
				table.setCodeField("id");
				table.setParentCodeField("parentId");
				table.setExpandAll(true);
				table.init();
				MgrMenu.table = table;
			}, 'json');

});

/**
 * 系统管理--用户管理的单例对象
 */
var MgrMenu = {
	id : "mytable",// 表格id
	seItem : null, // 选中的条目
	table : null,
	layerIndex : -1,
	deptid : 0
};

/**
 * 初始化表格的列
 */
MgrMenu.initColumn = function() {
	var columns = [ {
		field : 'selectItem',
		radio : true
	}, {
		title : 'id',
		field : 'id',
		visible : false,
		align : 'center',
		valign : 'middle'
	}, {
		title : '菜单名',
		field : 'menuName',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '菜单路径',
		field : 'menuUrl',
		align : 'center',
		width : '17%',
		valign : 'middle',
		sortable : true
	},
	// {
	// title : '父节点',
	// field : 'parentId',
	// align : 'center',
	// valign : 'middle',
	// sortable : true
	// },
	{
		title : '图标',
		field : 'icon',
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
		title : '级别',
		field : 'levels',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '备注',
		field : 'remarks',
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
MgrMenu.check = function() {
	var selected = $('#' + this.id).bootstrapTreeTable('getSelections');
	if (selected.length == 0) {
		swal({
			title : "提示",
			text : "请先选中表格中的某一记录！",
			type : "warning"
		});
		return false;
	} else {
		MgrMenu.seItem = selected[0];
		return true;
	}
};

Add = function() {
	var index = layer.open({
		type : 2,
		title : '添加菜单',
		area : [ '830px', '500px' ], // 宽高
		fix : false, // 不固定
		maxmin : true,
		content : ctxPath + '/permissions/systemmenu/menu_add.shtml'
	});
	this.layerIndex = index;
}


/*开始菜单的操作*/
var MenuInfoDlg = {
	menuInfoData : {},
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
MenuInfoDlg.close = function() {
	parent.layer.close(window.parent.layerIndex);
};
/*
 * 添加菜单
 * */
AddMenu = function() {
	var form = $("#form").serialize();
	$.post(ctxPath + "/permissions/systemmenu/insert.shtml", form, function(
			result) {
		if (result.Code == 1) {
			swal({
				title : "提示",
				text : result.Msg,
				type : "success"
			});
			window.parent.MgrMenu.table.refresh();
			MenuInfoDlg.close();

		} else {
			swal({
				title : "提示",
				text : result.Msg,
				type : "warning"
			});
		}
	}, 'json')
}
/*
 *  给菜单分配按钮操作
 * */
AllocationButton = function() {
	if (MgrMenu.check()) {
		var index = layer.open({
			type : 2,
			title : '分配按钮',
			area : [ '500px', '500px' ], // 宽高
			fix : false, // 不固定
			maxmin : true,
			content : ctxPath + '/permissions/systembutton/button_ztree.shtml'
		});
		this.layerIndex = index;
	}
}
function Reset() {
	MenuInfoDlg.close();
}