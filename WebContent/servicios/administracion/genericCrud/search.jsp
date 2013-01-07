<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para buscar VOs.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        
		<s:set name="action" value="'crud!doSearch.html'" />
		<s:set name="subTitle" value="'Buscar'" />
		<s:set name="submitLabel" value="'Buscar'" />
		
		<%@ include file="form.jsp" %>

		<br/>
		<s:url id="crear" value="crud!create.html" />
        <a href="${crear}">Crear nuevo...</a>

    </body>
</html>
