<%-- 
    Author     : Alejandro
    Descripcion: JSP para mostrar mensajes estandar.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje</title>
    </head>
    
    <body>
        
        <h2 class="title">
                Mensaje
        </h2>
        
        <s:actionerror />
        <s:actionmessage />
        
    </body>
    
</html>
