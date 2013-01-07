<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para realizar el pago online.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <div class="post">
            
            <h2 class="title">Pagos</h2>
            <h3 class="posted">Realice el pago</h3>

            <s:actionerror />
            <s:actionmessage />
			
            <s:form namespace="/servicios/pagos/" cssClass="ram">
                
				<tr>
					<td colspan="2">
						<h2>Pago vía Internet</h2>
						A continuación será redireccionado a
						<a href='http://www.mercadopago.com'>www.mercadopago.com</a>.
						para que realice su pago.
					</td>
				</tr>

                <s:submit action="inicioPagoOnline" value="Pagar ahora" cssStyle="width:240px;" />
				<tr><td><br/></td></tr>

				<tr>
					<td colspan="2" style="border-top: solid 1px #bbb;">
						<h2>Notificar consignación bancaria:</h2>
						Seleccione esta opción si usted <b>ya efectuó una consignación</b> bancaria.
					</td>
				</tr>

                <s:submit action="inicioNotificarPago" value="Notificar consignación bancaria" cssStyle="width:240px;" />

				<s:hidden name="empresa.id" value="%{empresa.id}" />
				<tr><td></td></tr>
                
            </s:form>
		</div>

    </body>
</html>
