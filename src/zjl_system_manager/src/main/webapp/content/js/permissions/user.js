$(function() {
	// 先拿到菜单的toolbar按钮
	$.post(ctxPath + "/permissions/systemrole/getrolemenubutton.shtml",{"menuId":menuId},
			function(result) {
				var defaultColunms = MgrUser.initColumn();
				var table = new BSTable("mytable", ctxPath
						+ "/permissions/systemuser/finduserbypage.shtml",
						defaultColunms);
				toolBar("myTableToolBar", result);
				MgrUser.table = table.init();
			}, 'json');

});

/**
 * 系统管理--用户管理的单例对象
 */
var MgrUser = {
	id : "mytable",// 表格id
	seItem : null, // 选中的条目
	table : null,
	layerIndex : -1,
	deptid : 0
};

/**
 * 初始化表格的列
 */
MgrUser.initColumn = function() {
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
		title : '账号',
		field : 'userAccount',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '姓名',
		field : 'userRealName',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '头像',
		field : 'userHeadImg',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '联系电话',
		field : 'userTel',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '出生日期',
		field : 'userBirthday',
		align : 'center',
		valign : 'middle',
		sortable : true
	}, {
		title : '最后登录时间',
		field : 'userLastLoginTime',
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
	}, {
		title : '状态',
		field : 'status',
		align : 'center',
		valign : 'middle',
		sortable : true
	} ];
	return columns;
};

Add = function() {
	var index = layer.open({
		type : 2,
		title : '添加用户',
		area : [ '830px', '500px' ], // 宽高
		fix : false, // 不固定
		maxmin : true,
		content : ctxPath + '/permissions/systemuser/user_add.shtml'
	});
	this.layerIndex = index;
}

var UserInfoDlg = {
	userInfoData : {},
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

MgrUser.check = function() {
	var selected = $('#' + this.id).bootstrapTable('getSelections');
	if (selected.length == 0) {
		swal({
			title : "提示",
			text : "请先选中表格中的某一记录！",
			type : "warning"
		});
		return false;
	} else {
		MgrUser.seItem = selected[0];
		return true;
	}
};

/**
 * 关闭此对话框
 */
UserInfoDlg.close = function() {
	parent.layer.close(window.parent.layerIndex);
};
function AddUser() {
	var form = $("#form").serialize();
	$.post(ctxPath + "/permissions/systemuser/insert.shtml", form,
			function(result) {
				if (result.Code == 1) {
					swal({
						title : "提示",
						text : result.Msg,
						type : "success"
					});
					window.parent.MgrUser.table.refresh();
					UserInfoDlg.close();

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
AllocationRole = function() {
	if (MgrUser.check()) {
		var index = layer.open({
			type : 2,
			title : '分配角色',
			area : [ '500px', '500px' ], // 宽高
			fix : false, // 不固定
			maxmin : true,
			content : ctxPath + '/permissions/systemuser/userrole.shtml'
		});
		this.layerIndex = index;
	}
}

function Reset() {
	UserInfoDlg.close();
}
