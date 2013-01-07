<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para crear VOs.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
		<s:set name="action" value="'crud!doCreate.html'" />
		<s:set name="subTitle" value="'Crear'" />
		<s:set name="submitLabel" value="'Crear'" />

		<%@ include file="form.jsp" %>

		<br/>
		<s:url id="buscar" value="crud!search.html" />
        <a href="${buscar}">Buscar...</a>

    </body>
</html>
