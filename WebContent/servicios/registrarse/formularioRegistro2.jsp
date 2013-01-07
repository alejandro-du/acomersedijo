<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para el paso 2 del registro.
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
        
        <s:url id="urlDwrRegistro" value="/dwr/interface/AjaxRegistro.js" />
        <s:url id="urlDwrEngine" value="/dwr/engine.js" />
        <s:url id="urlDwrUtil" value="/dwr/util.js" />
        <s:url id="urlAjaxRegistro" value="/scripts/ajax/registro.js" />
        <script type='text/javascript' src="${urlDwrRegistro}"></script>
        <script type='text/javascript' src="${urlDwrEngine}"></script>
        <script type='text/javascript' src="${urlDwrUtil}"></script>
        <script type='text/javascript' src="${urlAjaxRegistro}"></script>

		<s:url id="estrella" value="/images/estrella.png" />

        <div class="post">
            
            <h2 class="title">Regístrese</h2>
            <h3 class="posted">Formulario de registro - Paso 2 (características adicionales para su plan)</h3>

            <s:actionerror />

			<p>
				Seleccione las características adicionales para su plan. <strong>Todos los precios están en pesos colombianos</strong>.
				Para información más detallada visite <a href="">Características adicionales para su plan</a>.
			</p>

            <p>
                <s:form action="/servicios/registrarse/registrarse.html" cssClass="ram">
                    
                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>
                    
                    <s:set name="x" value="-10" />
                    <s:set name="y" value="-565" />
                    
                    <td colspan="2">
                        <div class="nota">
                            El <strong>número de estrellas</strong>
							<img src="${estrella}" />
							<img src="${estrella}" />
							<img src="${estrella}" />
							<img src="${estrella}" />
							<img src="${estrella}" />
							determinará su <strong>posición en los listados de restaurantes</strong>.
                            Los restaurantes con mayor número de estrellas aparecerán primero.
                        </div>
                    </td>
                    
                    <s:select id="estrellas"
                              label="Estrellas"
                              name="empresa.planSolicitado.estrellas"
                              list="estrellas"
                              headerKey="0"
                              headerValue="0 (gratis)"
                              onchange="actualizarPrecio();" />
					
					<tr><td><br/><br/></td></tr>

                    <td colspan="2">
                        <div class="nota">
							Elija el <strong>tamaño de su anuncio</strong> (texto adicional). La información de su restaurante aparecerá
							cada vez que un visitante haga clic sobre el nombre de su restaurante.
							Adquiriendo esta característica usted podrá:<br/>
							<br/> - Usar un editor para incluir <strong>texto adicional con formato personalizado</strong>.
							<br/> - Incluir <strong>imágenes o fotos</strong> (especificando URLs, no se incluye uploading).
							<br/> - Incluir <strong>presentaciones de Flash</strong> (especificando URLs, no se incluye uploading).
							<br/> - Incorporar <strong>HTML para crear formularios y automatizar procesos</strong> con sus aplicaciones web.
                        </div>
                    </td>
                    
                    <s:select id="caracteresHtml"
                              label="Tamaño del anuncio (en número de caracteres HTML)"
                              name="empresa.planSolicitado.caracteresHtml"
                              list="#{3000:'Básico: 3.000 caracteres ($12.000)',10000:'Avanzado: 10.000 caracteres ($30.000)',50000:'Empresarial: 50.000 caracteres ($48.000)'}"
                              headerKey="0"
                              headerValue="Ninguno: 0 caracteres (gratis)"
                              onchange="actualizarPrecio();" />

					<tr><td><br/><br/></td></tr>

                    <tr>
                        <td colspan="2">
                            <div id="imagen0" style="display:none;">
                                <s:url id="png" value="/images/planes/instrucciones.png" />
                                <img src="${png}" />
                            </div>

                            <div id="imagen1" style="display:none;">
                                <s:url id="png" value="/images/planes/imagen.png" />
                                <img src="${png}" />
                            </div>

                            <div id="imagen2" style="display:none;">
                                <s:url id="png" value="/images/planes/linkwebsite.png" />
                                <img src="${png}" />
                            </div>

                            <div id="imagen3" style="display:none;">
                                <s:url id="png" value="/images/planes/banneraib.png" />
                                <img src="${png}" />
                            </div>

                            <div id="imagen4" style="display:none;">
                                <s:url id="png" value="/images/planes/banneraii.png" />
                                <img src="${png}" />
                            </div>

                            <div id="imagen5" style="display:none;">
                                <s:url id="png" value="/images/planes/banneraim.png" />
                                <img src="${png}" />
                            </div>

                            <div id="imagen6" style="display:none;">
                                <s:url id="png" value="/images/planes/bannerasm.png" />
                                <img src="${png}" />
                            </div>

                             <div id="imagen7" style="display:none;">
                               <s:url id="png" value="/images/planes/banneradt.png" />
                                <img src="${png}" />
                            </div>
                            
                        </td>
                    </tr>

                    <s:checkbox label="Imagen o foto (%{precioImagen})" name="empresa.planSolicitado.imagen" id="imagen" onmouseover="mostrarImagen(1);" onclick="actualizarPrecio();" />
                    <s:checkbox label="Link a website (%{precioLinkWebsite})" name="empresa.planSolicitado.linkWebsite" id="linkWebsite" onmouseover="mostrarImagen(2);" onclick="actualizarPrecio();" />
                    <s:checkbox label="Banner AIB (%{precioBannerAib})" name="empresa.planSolicitado.bannerAib" id="bannerAib" onmouseover="mostrarImagen(3);" onclick="actualizarPrecio();" />
                    <s:checkbox label="Banner AII (%{precioBannerAii})" name="empresa.planSolicitado.bannerAii" id="bannerAii" onmouseover="mostrarImagen(4);" onclick="actualizarPrecio();" />
                    <s:checkbox label="Banner AIM (%{precioBannerAim})" name="empresa.planSolicitado.bannerAim" id="bannerAim" onmouseover="mostrarImagen(5);" onclick="actualizarPrecio();" />
                    <s:checkbox label="Banner ASM (%{precioBannerAsm})" name="empresa.planSolicitado.bannerAsm" id="bannerAsm" onmouseover="mostrarImagen(6);" onclick="actualizarPrecio();" />
                    <s:checkbox label="Banner ADT (%{precioBannerAdt})" name="empresa.planSolicitado.bannerAdt" id="bannerAdt" onmouseover="mostrarImagen(7);" onclick="actualizarPrecio();" />
                
					<tr><td><br/><br/></td></tr>

                    <tr>
                        
                        <td style="border: 1px solid #939A3C; border-right: 0px; color:#000; background: #DCC837;">
                            <strong><font size="5" face="courier, sans-serif, arial">Total a pagar:</font></strong>
                        </td>
                        <td style="border: 1px solid #939A3C; border-left: 0px; color:#000; background: #DCC837;" style="color:#fff; background: #BD4F21;">
                            <strong><font size="5" face="courier, sans-serif, arial"><div id="total">$0.</div></font></strong>
                        </td>
                        
                    </tr>
					
                    <tr>
						<td colspan="2">
	                        <div class="nota" id="notaFormasPago" style="display:none;">
								
								Puede pagar de 3 formas:

								<br/><br/><strong>En efectivo:</strong>
								Debe dirigirse a las oficinas de acomersedijo.com XXXXXXXX y cancelar el total.
								Personalmente registraremos su pago y activaremos las características adicionales de su plan.

								<br/><br/><strong>Consignación bancaria:</strong>
								Debe consignar el total en la cuenta No. XXXXX de Davivienda. Una vez halla realizado la
								consignación, debe informarnos los detalles de la misma (documento del pagador, número de la
								consignación y fecha) usando un formulario web que le será habilitado para tal efecto.
								
								<br/><br/><strong>Vía Internet:</strong>
								Para realizar el pago vía Internet, usted será redireccionado al sitio web
								<a href="http://www.mercadopago.com">www.mercadopago.com</a> donde podrá pagar con tarjeta de
								crédito u otras opciones. El servicio es gratuito, no se cobrará ningún cargo extra.

								<br/><br/><strong>La información detallada para realizar el pago será enviada a su email.</strong>
							</div>
	                    </td>
                    </tr>

					<tr><td><br/></td></tr>

                    <td colspan="2">
                        <div class="nota">
                            Debe aceptar los <a href="">Términos y Condiciones</a> activando la siguiente casilla.
                        </div>
                    </td>

                    <s:checkbox  label="Acepto los Términos y Condiciones." name="aceptaTerminos" />
                    
                    <td/>

					<%@ include file="/comun/captcha.jsp" %>

					<s:hidden name="empresa.usuario.email" value="%{empresa.usuario.email}" />
					<s:hidden name="empresa.usuario.password" value="%{empresa.usuario.password}" />
					<s:hidden name="empresa.usuario.nombre1" value="%{empresa.usuario.nombre1}" />
					<s:hidden name="empresa.usuario.nombre2" value="%{empresa.usuario.nombre2}" />
					<s:hidden name="empresa.usuario.apellido1" value="%{empresa.usuario.apellido1}" />
					<s:hidden name="empresa.usuario.apellido2" value="%{empresa.usuario.apellido2}" />

                    <s:submit value="Registrarse" />

                </s:form>
            </p>
        </div>
        
        <script>
            actualizarPrecio();
            mostrarImagen(0);
        </script>

    </body>
</html>
