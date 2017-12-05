$(function() {
	// 先拿到菜单的toolbar按钮
	$.post(ctxPath + "/permissions/systemrole/getrolemenubutton.shtml",{"menuId":menuId},
			function(result) {
				var defaultColunms = MgrButton.initColumn();
				var table = new BSTable("mytable", ctxPath
						+ "/permissions/systembutton/findbuttonbypage.shtml",
						defaultColunms);
				toolBar("myTableToolBar", result);
				MgrButton.table = table.init();
			}, 'json');

});

/**
 * 系统管理--用户管理的单例对象
 */
var MgrButton = {
	id : "mytable",// 表格id
	seItem : null, // 选中的条目
	table : null,
	layerIndex : -1
};

/**
 * 初始化表格的列
 */
MgrButton.initColumn = function() {
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
		title : '按钮名',
		field : 'buttonName',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '按钮方法',
		field : 'buttonMethod',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '按钮图标',
		field : 'icon',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '按钮样式',
		field : 'style',
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

Add = function() {
	var index = layer.open({
		type : 2,
		title : '添加按钮',
		area : [ '830px', '500px' ], // 宽高
		fix : false, // 不固定
		maxmin : true,
		content : ctxPath + '/permissions/systembutton/button_add.shtml'
	});
	this.layerIndex = index;
}

var ButtonInfoDlg = {
	buttonInfoData : {},
	validateFields : {
		buttonName : {
			validators : {
				notEmpty : {
					message : '按钮名称不能为空'
				}
			}
		},
		buttonMethod : {
			validators : {
				notEmpty : {
					message : '按钮方法不能为空'
				}
			}
		}
	}
};

/**
 * 关闭此对话框
 */
ButtonInfoDlg.close = function() {
	parent.layer.close(window.parent.layerIndex);
};

function AddButton() {
	var form = $("#form").serialize();
	$.post(ctxPath + "/permissions/systembutton/insert.shtml", form, function(
			result) {
		if (result.Code == 1) {
			swal({
				title : "提示",
				text : result.Msg,
				type : "success"
			});
			window.parent.MgrButton.table.refresh();
			ButtonInfoDlg.close();

		} else {
			swal({
				title : "提示",
				text : result.Msg,
				type : "warning"
			});
		}
	}, 'json')
}

function Delete(){
	swal({
		title : "提示",
		text : "啊哈哈",
		type : "warning"
	});
}