<%-- 
    Document   : contenido.jsp
    Author     : Alejandro
    Descripcion: Decorador para páginas de navegación con header, contenido y footer.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/comun/include.jsp" %>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>


<html>
    <head>
        <title>¡A comer se dijo! - La mejor guía de restaurantes</title>
        <meta name="keywords" content="restaurantes, eventos, fiestas, comer, directorio" />
        <meta name="description" content="Directorio de restaurantes" />
		<meta http-equiv="Content-language" content="es">
    </head>
    
    <body>
        <div id="wrapper">
            
            <%@ include file="/comun/header.jsp" %>
            
            <div id="content">
                
                <div id="posts">
                    <decorator:body />
                </div>

                <%@ include file="/comun/buscador.jsp" %>
                
                <%@ include file="/comun/menu.jsp" %>
                
            </div>
            
            <%@ include file="/comun/footer.jsp" %>
            
        </div>
        
    </body>
</html>
