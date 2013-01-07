<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario de contacto.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <div class="post">
            
            <h2 class="title">Contáctenos</h2>
            <h3 class="posted">Póngase en contacto con nosotros sobre cualquier inquietud referente al sitio web</h3>

            <s:actionerror />
            <s:actionmessage />

            <!--TODO: Colocar información real de contacto. -->
            <h3>¡A comer se dijo!</h3>
            <strong>XXXXXXX XXXXXX</strong><br/>
            Teléfono (s): xxxxxxxxx - xxxxxxxxx.<br/>
            Bogotá, Colombia.<br/>

            <h3>Enviar un mensaje</h3>

            <p>
                <s:form action="/servicios/contactenos/enviarMensaje.html" cssClass="ram">

                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>

                    <s:textfield label="Su email" name="email" required="true" />
                    <s:textfield label="Título del mensaje" name="titulo" required="true" />
                    <s:textarea label="Mensaje" name="mensaje" cols="43" cssStyle="height: 180px;" required="true" />
                    <s:checkbox label="Envíeme una copia de este mensaje" name="enviarCopia" />

                    <%@ include file="/comun/captcha.jsp" %>

                    <s:submit value="Enviar" />

                </s:form>
            </p>

			Diseño web adaptado de <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.
            
        </div>

    </body>
</html>
