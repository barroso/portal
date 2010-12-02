<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setLocale value="${locale}" />
<c:set var="ctx">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Portal</title>


<link rel="stylesheet" href="${ctx}/ext-3.3.0/resources/css/ext-all.css" type="text/css">
<script src="${ctx}/ext-3.3.0/adapter/ext/ext-base.js"></script>
<script src="${ctx}/ext-3.3.0/ext-all.js"></script>

<script type="text/javascript">
	Ext.onReady(function() {		
		  var config = {
		    restful: true,
		    reader: new Ext.data.JsonReader({
		      totalProperty: 'total',
		      root: 'rows',
			fields : [ 
				{name : 'login', type : 'string'}, 
				{name : 'senha', type : 'string'}, 
				{name : 'email',type : 'string'}
				 ]		      
		    }),
		    proxy: new Ext.data.HttpProxy(
		    		new Ext.data.Connection({
		    			url: 'http://localhost:8080/portal/extjs/grid/dados.json'
					})
		    ),
		    writer: new Ext.data.JsonWriter({
		      encode: false
		    })
		  };
	
		var store = new Ext.data.Store(config);
		store.load();

		var grid = new Ext.grid.GridPanel( {
			store : store,
			columns : [ 
				{id : 'login', header : 'login', width : 200, sortable : true, dataIndex : 'login'}, 
				{header : 'senha', width : 150, sortable : true, dataIndex : 'senha'}, 
				{header : 'email', width : 150, sortable : true, dataIndex : 'email'}
				 ],
	        autoExpandColumn: 'login',
	        height: 350,
	        width: 600,
	        title: 'Usuários'
							 
		});

		grid.render('grid-example');

	});
</script>
</head>
<body>
<div id="grid-example"></div>
<%@ include file="/footer.jsp"%>