<%-- 
    Author     : Alejandro
    Descripcion: Muestra reportes.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>
<%@ taglib prefix="sql" uri="/WEB-INF/tld/sql.tld" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <div class="post">
            
            <h2 class="title">
                <c:out value="${reporte.nombre}" />
            </h2>

            <sql:setDataSource dataSource="jdbc/Acomersedijo" />

            <sql:query var="resultados">
                <c:out value="${reporte.consulta}" escapeXml="false" />
            </sql:query>

            <display:table name="${resultados.rows}" class="crud" export="true" requestURI="/servicios/reportes/reporte.html" pagesize="20" />
            
        </div>
        
    </body>
</html>
