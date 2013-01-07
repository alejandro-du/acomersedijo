<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para reestablecer la contraseña.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <div class="post">
            
            <h2 class="title">Reestablecer contraseña</h2>
            <h3 class="posted">Reestablezca su contraseña de ingreso</h3>

            <s:actionerror />

            Por favor, ingrese sus datos. Una vez confirmados, se le enviará un mensaje de correo con una nueva contraseña.

            <p>
                <s:form action="/servicios/reestablecerPassword/reestablecer.html" cssClass="ram">
                    
                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>

                    <s:textfield label="Email con el que se registró" name="usuario.email" required="true" />

                    <td colspan="2">
                        <div class="nota">
                            Los siguientes datos son necesarios para confirmar que es usted el propietario de la cuenta.
                        </div>
                    </td>

                    <s:textfield label="Primer nombre" name="usuario.nombre1" required="true" />
                    <s:textfield label="Primer apellido" name="usuario.apellido1" required="true" />
                    
                    <s:submit value="Reestablecer contraseña" />

                </s:form>
            </p>
        </div>

    </body>
</html>
