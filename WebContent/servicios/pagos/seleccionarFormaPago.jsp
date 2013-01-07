<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para seleccionar una forma de pago.
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
            <h3 class="posted">Seleccione la forma de pago</h3>

            <s:actionerror />
            <s:actionmessage />
			
			<p>
			Por favor seleccione la forma de pago.<br/><br/>
			</p>



            <s:form target="MercadoPago" action="https://www.mercadopago.com/mco/buybutton" method="post" cssClass="ram" cssStyle="width: 100%">
                
				<tr>
					<td colspan="2">
						<h2>Pagar ahora vía Internet</h2>
						Seleccione esta opción <b>si usted no ha pagado</b> y desea hacerlo ahora. Será redireccionado a
						<a href='http://www.mercadopago.com'>www.mercadopago.com</a>.
					</td>
				</tr>

				<s:hidden name="acc_id" value="1744282" />
				<s:hidden name="item_id" value="%{empresa.planSolicitado.id}" />
				<s:hidden name="name" value="Caracteristicas adicionales en acomersedijo.com" />
			
				<s:hidden name="currency" value="COL" />
				<s:hidden name="price" value="%{empresa.planSolicitado.precio}" />

				<s:hidden name="url_cancel" value="" />
				<s:hidden name="url_process" value="" />
				<s:hidden name="url_succesfull" value="" />
				<s:hidden name="url_post" value="" />

				<s:hidden name="shipping_cost" value="" />
				<s:hidden name="enc" value="ROXFfJrHG9qQxlubZ9FD6ssR4wE%3D" />
				<s:hidden name="extraPar" value="" />

                <s:submit value="Pagar ahora vía Internet" cssStyle="width:240px;" />

				<tr><td><br/></td></tr>

            </s:form>

			<br/><br/>



            <s:form action="/servicios/pagos/inicioNotificarPago.html" cssClass="ram" cssStyle="width: 100%">
				<tr>
					<td colspan="2">
						<h2>Notificar consignación bancaria:</h2>
						Seleccione esta opción si usted <b>ya efectuó una consignación</b> bancaria.
					</td>
				</tr>

                <s:submit value="Notificar consignación bancaria" cssStyle="width:240px;" />

				<tr><td><br/></td></tr>
                
            </s:form>

			<br/><br/>



            <s:form cssClass="ram" cssStyle="width: 100%">
				<tr>
					<td colspan="2">
						<h2>Pago en efectivo:</h2>
						Para pagar en efectivo debe dirigirse a nuestras oficinas en XXXXXX (Bogotá).
						<br/>Por favor <b>asegúrese de tener a mano el siguiente código</b> a la hora de cancelar en efectivo:
						<br>
						<s:textfield label="Código" value="%{empresa.id}" readonly="true" />
					</td>
				</tr>

				<tr><td></td></tr>
                
            </s:form>



		</div>

    </body>
</html>
