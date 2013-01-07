<%-- 
    Author     : Jorge
    Descripcion: formulario para actualizar datos del usuario.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h2>Actualizar Datos</h2>
        
        Por favor, introduzca los datos que desea modificar.
        
        <s:actionmessage />
        <s:actionerror />
        
        <p>
            <s:form action="/servicios/actualizarDatos/actualizarDatos.html" cssClass="ram">
                
                <%@ include file="/comun/notaCamposObligatorios.jsp" %>
                
                <td colspan="2">
                    <div class="nota">
                        <s:url id="contactenos" value="/servicios/contactenos" includeParams="false" />
                        Por motivos de seguridad no es posible modificar su email. <br/>
                        Para actualizar este dato, <a href="${contactenos}">comuníquese con !A comer se dijo!</a>.
                    </div>
                </td>

                <s:textfield label="Email" name="usuario.email" required="true" readonly="true" />
                <s:textfield label="Primer nombre" name="usuario.nombre1" required="true" />
                <s:textfield label="Segundo nombre" name="usuario.nombre2" />
                <s:textfield label="Primer apellido" name="usuario.apellido1" required="true" />
                <s:textfield label="Segundo apellido" name="usuario.apellido2" />
                <s:password label="Contraseña actual" name="password" required="true" />
                <s:password label="Contraseña nueva" name="nuevoPassword" />
                <s:password label="Confirme su nueva contraseña" name="nuevoPassword2" />
                
                <s:hidden name="usuario.activo" value="%{usuario.activo}" />
                
                <s:submit value="Actualizar Datos" />

            </s:form>
        </p>
    </body>
</html>