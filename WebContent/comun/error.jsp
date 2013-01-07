<%-- 
    Author     : Alejandro
    Descripcion: JSP para mostrar errores.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <h1>Error</h1>
        
        Ha ocurrido un error en la petición.
        
        <p>
            <s:actionmessage />
            <s:actionerror />
        </p>
        
    </body>
</html>
