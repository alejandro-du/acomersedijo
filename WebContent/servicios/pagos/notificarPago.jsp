<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para notificar un pago.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
		<script type="text/javascript">

			var confirmo = false;
		
			function confirmar() {
				
				if(!confirmo) {
					alert("Por favor verifique los datos para evitar inconvenientes. Gracias.");
					confirmo = true;
					return false;
				}
				
				return true;
			}
			
		</script>

        <s:url id="contactenos" value="/servicios/contactenos" includeParams="false" />

        <div class="post">
            
            <h2 class="title">Pagos</h2>
            <h3 class="posted">Envíe la información de su consignación por medio de este formulario</h3>

            <s:actionerror />
            <s:actionmessage />

			Por favor introduzca los siguientes datos.<br/><br/>

            <s:form action="/servicios/pagos/notificarPago.html" cssClass="ram">
                
                <%@ include file="/comun/notaCamposObligatorios.jsp" %>

				<tr>
					<td colspan="2" class="required">
						Recuerde que el total consignado debe ser igual al valor presentado a continuación.
						Si el valor que usted consignó no coincide con el valor presentado, por favor
						<a href="${contactenos}">comuníquese con nosotros</a>.
					</td>
				</tr>

                <s:textfield label="Total" name="empresa.planSolicitado.precio" value="%{empresa.planSolicitado.precio}" required="true" readonly="true" />
                <s:textfield label="Documento del pagador" name="documentoPagador" required="true" />
                <s:textfield label="Número de consignación" name="numeroConsignacion" required="true" />

                <s:textfield label="Fecha de consignación (haga clic)" name="fechaPago" id="fecha" readonly="true" required="true" />
                <%@ include file="/comun/calendar.jsp" %>
                <script>calendar("fecha", "fecha", false)</script>

				<s:hidden name="empresa.id" value="%{empresa.id}" />

                <s:submit value="Enviar información" onclick="return confirmar();" />
                
            </s:form>
		</div>

    </body>
</html>
