<%-- 
    Author     : Alejandro
    Descripcion: Permite seleccionar la ciudad para la cual se desea navegar.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>


<html>
    <head>
		<link rel="shortcut icon" href="<s:url value='/images/icons/favicon.png' encode='false' includeParams='none'/>">
		<link rel="icon" href="<s:url value='/images/icons/favicon.png' encode='false' includeParams='none'/>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>¡A comer se dijo! - Bienvenido</title>
        <meta name="keywords" content="restaurantes, eventos, fiestas, comer, directorio" />
        <meta name="description" content="Directorio de restaurantes" />
		<meta http-equiv="Content-language" content="es">
    </head>
    <body>
        
    <body>

        <div id="wrapperWelcome">
            
            <h1>¡A comer se dijo!</h1>
            
            <s:actionerror />
            <s:actionmessage />

            Por favor, seleccione una ciudad.
            <br/><br/>
            
            <div id="wrapperWelcomeCities">
            
            <s:iterator value="ciudades" >
                
                <s:url id="seleccionarCiudad" value="%{'/servicios/seleccionarCiudad/seleccionarCiudad.html?id=' + id}" />
                    
                    <a href="${seleccionarCiudad}">
                        <s:property value="%{nombre}" />
                    </a>

            </s:iterator>

            </div>

			<%@ include file="/comun/footer.jsp" %>

        </div>
        

    </body>
</html>
