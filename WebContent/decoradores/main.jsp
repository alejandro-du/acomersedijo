<%-- 
    Document   : main.jsp
    Created on : Feb 2, 2008, 11:22:38 PM
    Author     : Alejandro
    Descripcion: Decorador para páginas de navegación con header, footer, contenido y menú.
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
            
            <table>
				<thead>
					<tr>
		                <th>
		                    <%@ include file="/comun/header.jsp" %>
		                </th>
					</tr>
				</thead>
            </table>
                
            <table>
                <tr>
                    <td>
                        <%@ include file="/comun/buscador.jsp" %>
                        
                        <%@ include file="/comun/menu.jsp" %>
                    </td>
                    
                    <td>
                        <div id="content" style="margin-top: 6px;">
                            <decorator:body />
                        </div>
                    </td>
                </tr>
                
            </table>
            
            <%@ include file="/comun/footer.jsp" %>
            
            
            
        </div>
        
    </body>
</html>
