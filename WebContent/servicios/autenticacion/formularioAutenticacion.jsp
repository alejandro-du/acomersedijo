<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para autenticarse ante el sistema.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <h2>Iniciar sesión</h2>
        
        <s:actionerror />
        <s:actionmessage />
        
        Por favor, introduzca sus datos.
        
        <p>
            <s:form action="/servicios/autenticacion/autenticar.html" cssClass="ram">
                
                <%@ include file="/comun/notaCamposObligatorios.jsp" %>

                <s:textfield label="Email" name="usuario.email" required="true" />
                <s:password label="Contraseña" name="usuario.password" required="true" />
                <s:submit value="Iniciar sesión" />
                
                <td colspan="2">
                    <div class="nota">
                        <s:url id="reestablecer" value="/servicios/reestablecerPassword" includeParams="false" />
                        Si olvidó su contraseña haga <a href="${reestablecer}">click aquí</a>.
                    </div>
                </td>

            </s:form>
        </p>

        <p>
            <s:url id="registro" value="/servicios/registrarse" includeParams="false" />
            Para registrar su restaurante haga <a href="${registro}">click aquí</a>.
        </p>
    </body>
</html>
