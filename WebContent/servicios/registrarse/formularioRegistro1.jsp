<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario de registro.
--%>

<%
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", -1);
%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <div class="post">
            
            <h2 class="title">Regístrese</h2>
            <h3 class="posted">Formulario de registro - Paso 1 (información básica)</h3>

            <s:actionerror />
			
			<p>
            	Por favor, complete el siguiente formulario. Una vez confirmado su registro (vía email), podrá crear y publicar su anuncio y sus banners.
			</p>

            <p>
                <s:form action="/servicios/registrarse/informacionBasica.html" cssClass="ram">
                    
                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>
                    
                    <s:textfield label="Email" name="empresa.usuario.email" required="true" />
                    <s:textfield label="Confirme su email" name="email2" required="true" />

                    <s:password label="Nueva contraseña" name="empresa.usuario.password" required="true" />
                    <s:password label="Confirme su contraseña" name="password2" required="true" />

                    <s:textfield label="Primer nombre" name="empresa.usuario.nombre1" required="true" />
                    <s:textfield label="Segundo nombre" name="empresa.usuario.nombre2" required="false" />
                    <s:textfield label="Primer apellido" name="empresa.usuario.apellido1" required="true" />
                    <s:textfield label="Segundo apellido" name="empresa.usuario.apellido2" required="false" />
                    
                    <s:submit value="Siguiente" />

                </s:form>
            </p>
        </div>
        
    </body>
</html>
