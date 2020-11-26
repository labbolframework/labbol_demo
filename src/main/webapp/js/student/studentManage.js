Coe.initialize();
Co.initialize();

Ext.onReady(function() {
	var API = {
		saveStudent : rootPath + "/student/save",
		queryStudent : rootPath + "/student/query",
		deleteStudent : rootPath + "/student/delete",
		retrieveStudent : rootPath + "/student/retrieve",
		
		modifyStudentAge : rootPath + "/student/modifyStudentAge"
	};
	
	//============================ Model =========================
	Co.defineModel("Student", ["id","schoolId","name","age","birthdate","schoolName"]);
	//============================ Store =========================
	var studentGridStore = Co.gridStore("studentGridStore", API.queryStudent, "Student", {
		autoLoad : false,
		output : "studentTbar",
		sorters : [{
			property : "createTime",
			direction : "desc"
		}]
	});
		
	//============================ View =========================
	var studentTbar = Co.toolbar("studentTbar", [{
			type : "+", 
			handler : addStudent,
			showAtContextMenu : true
		},{
			type : "*",
			handler : deleteStudent,
			showAtContextMenu : true
		},{
			type : "-",
			handler : editStudent,
			showAtContextMenu : true
		},{
			type : "-",
			text : "修改年龄",
			handler : function(){
				var record = Co.getGridSelectSingleRecord(studentGrid);
				if(record){
					Co.request(API.modifyStudentAge,{"studentId":record.data.id},function(result){
						if(result.success){
							Co.alert("修改成功",function(){
								Co.load(studentGridStore);
							});
						}
					});
				}
			},
			showAtContextMenu : true
		},"->",{
			type : "@",
			handler : searchStudent,
			searchField : [],
			searchEmptyText : []
		}
	]);
	
	var studentColumns = [
		Co.gridRowNumberer(),
		{header : "主键", dataIndex : "id", width : 200, hidden : true},
		{header : "学校ID", dataIndex : "schoolId", width : 200, hidden : false},
		{header : "姓名", dataIndex : "name", width : 200, hidden : false},
		{header : "年龄", dataIndex : "age", width : 200, hidden : false},
		{header : "出生年月", dataIndex : "birthdate", width : 200, hidden : false},
		{header : "学校名称", dataIndex : "schoolName", width : 200, hidden : false}
	];
	
	var studentGrid = Co.grid("studentGrid", studentGridStore, studentColumns, studentTbar, null, {
		listeners : {
			itemdblclick : function(view, record) {
				editStudent();
			}
		}
	});
	
	Co.load(studentGridStore);
	
	var studentForm = Co.form(API.saveStudent, [{
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
				id : "schoolId",
				name : "model.schoolId",
				fieldLabel : "学校ID",
				allowBlank : true,
				editable : true,
				readOnly : false,
				maxLength: 32,
				maxLengthText: "学校ID最多32个字！",
				enforceMaxLength: false
			}]
		},{
			columnWidth : .5,
			border : false,
			bodyCls : "panel-background-color",
			layout : "form",
			items : [{
				xtype : "textfield",
				id : "name",
				name : "model.name",
				fieldLabel : "姓名",
				allowBlank : true,
				editable : true,
				readOnly : false,
				maxLength: 128,
				maxLengthText: "姓名最多128个字！",
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
				xtype : "textfield",
				id : "age",
				name : "model.age",
				fieldLabel : "年龄",
				allowBlank : true,
				editable : true,
				readOnly : false
			}]
		},{
			columnWidth : .5,
			border : false,
			bodyCls : "panel-background-color",
			layout : "form",
			items : [{
				xtype : "datefield",
				id : "birthdate",
				name : "model.birthdate",
				fieldLabel : "出生年月",
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
	
	var studentFormWindow = Co.formWindow("新增", studentForm, 650, 210, "fit", {
		okHandler : saveStudent
	});
	
	Ext.create("Ext.container.Viewport", {
		layout : "fit",
		items : studentGrid
	});
	//============================ Function =========================
	function addStudent() {
		Co.resetForm(studentForm, true);
		studentFormWindow.setTitle("新增");
		studentFormWindow.show();
	}
	
	function saveStudent() {
		Co.formSave(studentForm, function(form, action){
			Co.alert("保存成功！", function(){
				studentFormWindow.hide();
				Co.reload(studentGridStore);
			});
		});
	}
	
	function editStudent() {
		Co.formLoad(studentForm, studentGrid, API.retrieveStudent, function(result, opts, selectedId){
			if (true === result.success) {
				studentFormWindow.setTitle("修改");
				studentFormWindow.show();
			} else {
				Co.showError(result.msg || "数据加载失败！");
			}
		});
	}
	
	function deleteStudent() {
		Co.gridDelete(studentGrid, API.deleteStudent, function(result){
			if (result.success === true) {
				Co.alert("删除成功！", function(){
					Co.reload(studentGridStore);
				});
			} else {
				Co.alert(result.msg);
			}
		});	
	}
	
	function searchStudent() {
		Co.load(studentGridStore);
	}
});