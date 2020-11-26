Coe.initialize();
Co.initialize();

Ext.onReady(function() {
	var API = {
		saveSchool : rootPath + "/school/save",
		querySchool : rootPath + "/school/query",
		deleteSchool : rootPath + "/school/delete",
		retrieveSchool : rootPath + "/school/retrieve"
	};
	
	//============================ Model =========================
	Co.defineModel("School", ["id","name","schoolMaster","startDate"]);
	//============================ Store =========================
	var schoolGridStore = Co.gridStore("schoolGridStore", API.querySchool, "School", {
		autoLoad : false,
		output : "schoolTbar",
		sorters : [{
			property : "createTime",
			direction : "desc"
		}]
	});
		
	//============================ View =========================
	var schoolTbar = Co.toolbar("schoolTbar", [{
			type : "+", 
			handler : addSchool,
			showAtContextMenu : true
		},{
			type : "*",
			handler : deleteSchool,
			showAtContextMenu : true
		},{
			type : "-",
			handler : editSchool,
			showAtContextMenu : true
		},"->",{
			type : "@",
			handler : searchSchool,
			searchField : [],
			searchEmptyText : []
		}
	]);
	
	var schoolColumns = [
		Co.gridRowNumberer(),
		{header : "主键", dataIndex : "id", width : 250, hidden : true},
		{header : "名称", dataIndex : "name", width : 250, hidden : false},
		{header : "校长", dataIndex : "schoolMaster", width : 250, hidden : false},
		{header : "创办日期", dataIndex : "startDate", width : 250, hidden : false}
	];
	
	var schoolGrid = Co.grid("schoolGrid", schoolGridStore, schoolColumns, schoolTbar, null, {
		listeners : {
			itemdblclick : function(view, record) {
				editSchool();
			}
		}
	});
	
	Co.load(schoolGridStore);
	
	var schoolForm = Co.form(API.saveSchool, [{
		layout : "column",
		border : false,
		bodyCls : "panel-background-color",
		items : [{
			columnWidth : .5,
			border : false,
			bodyCls : "panel-background-color",
			layout : "form",
			items : [{
				xtype : "textfield",
				id : "name",
				name : "model.name",
				fieldLabel : "名称",
				allowBlank : true,
				editable : true,
				readOnly : false,
				maxLength: 128,
				maxLengthText: "名称最多128个字！",
				enforceMaxLength: false
			}]
		},{
			columnWidth : .5,
			border : false,
			bodyCls : "panel-background-color",
			layout : "form",
			items : [{
				xtype : "textfield",
				id : "schoolMaster",
				name : "model.schoolMaster",
				fieldLabel : "校长",
				allowBlank : true,
				editable : true,
				readOnly : false,
				maxLength: 128,
				maxLengthText: "校长最多128个字！",
				enforceMaxLength: false
			}]
		}]
	},{
		layout : "column",
		border : false,
		bodyCls : "panel-background-color",
		items : [{
			columnWidth : .5,
			border : false,
			bodyCls : "panel-background-color",
			layout : "form",
			items : [{
				xtype : "datefield",
				id : "startDate",
				name : "model.startDate",
				fieldLabel : "创办日期",
				allowBlank : true,
				editable : true,
				readOnly : false,
				format: Co.dateFormat
			}]
		}]
	},{
		xtype : "hiddenfield",
		id : "id",
		name : "model.id"
	}]);
	
	var schoolFormWindow = Co.formWindow("新增", schoolForm, 650, 180, "fit", {
		okHandler : saveSchool
	});
	
	Ext.create("Ext.container.Viewport", {
		layout : "fit",
		items : schoolGrid
	});
	//============================ Function =========================
	function addSchool() {
		Co.resetForm(schoolForm, true);
		schoolFormWindow.setTitle("新增");
		schoolFormWindow.show();
	}
	
	function saveSchool() {
		Co.formSave(schoolForm, function(form, action){
			Co.alert("保存成功！", function(){
				schoolFormWindow.hide();
				Co.reload(schoolGridStore);
			});
		});
	}
	
	function editSchool() {
		Co.formLoad(schoolForm, schoolGrid, API.retrieveSchool, function(result, opts, selectedId){
			if (true === result.success) {
				schoolFormWindow.setTitle("修改");
				schoolFormWindow.show();
			} else {
				Co.showError(result.msg || "数据加载失败！");
			}
		});
	}
	
	function deleteSchool() {
		Co.gridDelete(schoolGrid, API.deleteSchool, function(result){
			if (result.success === true) {
				Co.alert("删除成功！", function(){
					Co.reload(schoolGridStore);
				});
			} else {
				Co.alert(result.msg);
			}
		});	
	}
	
	function searchSchool() {
		Co.load(schoolGridStore);
	}
});