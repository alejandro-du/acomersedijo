<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para modificar VOs.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
		<s:set name="action" value="'crud!doUpdate.html'" />
		<s:set name="subTitle" value="'Modificar'" />
		<s:set name="submitLabel" value="'Modificar'" />

		<%@ include file="form.jsp" %>

        <div class="post">
            <br/>
            <input align="right" type="button" value="Volver" onclick="history.back()" style="padding: 8px; height: 100%; width: 100%;" />
        </div>

		<br/>
		<s:url id="buscar" value="crud!search.html" />
        <a href="${buscar}">Buscar...</a>
		<br/>
		<br/>
		<s:url id="crear" value="crud!create.html" />
        <a href="${crear}">Crear nuevo...</a>

    </body>
</html>
