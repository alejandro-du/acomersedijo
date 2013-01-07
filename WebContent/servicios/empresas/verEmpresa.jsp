
<%-- 
    Author     : Alejandro
    Descripcion: Muestra toda la información de una empresa.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <s:actionerror />

        <div class="post">
            
            <table class="empresa">

                <tr>
                    <td>
                        <h1 style="align: top;">
                            <c:out value="${empresa.nombre}" />
                        </h1>
                        
                        <s:url id="estrella" value="/images/estrella.png" />
                        <c:forEach begin="1" end="${estrellas.plan.estrellas}" >
                            <img src="${estrella}" />
                        </c:forEach>
                        
                        <strong><i>Anuncio vistado <c:out value="${empresa.visitas}" /> veces</i></strong>
                        
                    </td>
                    
                    <s:if test="empresa.urlImagen != null && !empresa.urlImagen.trim().equals('')">
                        <td align="center">
                            <div class="imagenEmpresa">
                                <img src="${empresa.urlImagen}" />
                            </div>
                        </td>
                    </s:if>

                </tr>

                <tr valign="top">
                    <td  colspan="2">
                        <p>
                            <table class="datosEmpresa">

                                <tr>
                                    <td>
                                        Especialidad:
                                    </td>
                                    <td>
                                        <s:url id="cereal" value="/images/icons/cereal.png" />
                                        <img src="${cereal}" />
                                        <c:out value="${empresa.sector.nombre}" />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        Ubicación:
                                    </td>
                                    <td>
                                        <s:url id="globe" value="/images/icons/globe.png" />
                                        <img src="${globe}" />
                                        <c:out value="${empresa.direccion}" /> (<c:out value="${empresa.zona.ciudad.nombre}" />, zona <c:out value="${empresa.zona.nombre}" />)
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        Precio promedio:
                                    </td>
                                    <td>
                                        <s:url id="dollar" value="/images/icons/dollar.png" />
                                        <img src="${dollar}" />
                                        <c:out value="${empresa.precioPromedio}" />
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        Teléfono:
                                    </td>
                                    <td>
                                        <s:url id="phone" value="/images/icons/phone.png" />
                                        <img src="${phone}" />
                                        <c:out value="${empresa.telefono}" /><s:if test="empresa.domicilios"> (servicio a domicilio) </s:if>
                                    </td>
                                </tr>

                                <s:if test="empresa.plan.linkWebsite">

                                    <tr>
                                        <td>
                                            Email:
                                        </td>
                                        <td>
                                            <s:url id="mail" value="/images/icons/mail.png" />
                                            <img src="${mail}" />
                                            <c:out value="${empresa.email}" />
                                        </td>
                                    </tr>


                                    <tr>
                                        <td>
                                            Website:
                                        </td>
                                        <td>
                                            <s:url id="firefox" value="/images/icons/firefox.png" />
                                            <img src="${firefox}" />
                                            <s:url id="website" includeContext="false" includeParams="false" value="%{empresa.website}" />
                                            <s:a href="%{website}" value="%{website}"><c:out value="${website}" /></s:a>
                                        </td>
                                    </tr>

                                </s:if>


                                <tr>
                                    <td colspan="2">
                                        Formas de pago:<br/><br/>
                                        <s:if test="empresa.pagoEfectivo">
                                            &nbsp;
                                            <s:url id="cash" value="/images/icons/payment/cash.png" />
                                            <img src="${cash}" />
                                        </s:if>
                                        <s:if test="empresa.pagoAmericanExpress">
                                            &nbsp;
                                            <s:url id="americanexpress" value="/images/icons/payment/americanexpress.gif" />
                                            <img src="${americanexpress}" />
                                        </s:if>
                                        <s:if test="empresa.pagoDinersClub">
                                            &nbsp;
                                            <s:url id="dinersclub" value="/images/icons/payment/dinersclub.gif" />
                                            <img src="${dinersclub}" />
                                        </s:if>
                                        <s:if test="empresa.pagoMasterCard">
                                            &nbsp;
                                            <s:url id="mastercard" value="/images/icons/payment/mastercard.gif" />
                                            <img src="${mastercard}" />
                                        </s:if>
                                        <s:if test="empresa.pagoMaestro">
                                            &nbsp;
                                            <s:url id="maestro" value="/images/icons/payment/maestro.gif" />
                                            <img src="${maestro}" />
                                        </s:if>
                                        <s:if test="empresa.pagoVisa">
                                            &nbsp;
                                            <s:url id="visa" value="/images/icons/payment/visa.gif" />
                                            <img src="${visa}" />
                                        </s:if>
                                    </td>
                                </tr>

                            </table>
                        </p>
                    </td>

                </tr>

            </table>
            
        </div>
        
        <table>
            <tr>
                <td>
                    <br/>
                    <c:out value="${empresa.anuncio}" escapeXml="false"/>
                </td>
            </tr>
        </table>
            
        <div class="post">
            <div class="meta">
                <br/>
                <input align="right" type="button" value="Volver a la lista" onclick="history.back()" style="padding: 8px; height: 100%; width: 100%;" />
            </div>
        
        </div>
            
        <div class="post">
            <script>

                function mostrarFormulario()
                {
                    var form = document.getElementById("formulario");
                    var link = document.getElementById("comentar");
                    form.style.display = "block";
                    link.style.display = "none";
                }

                function ocultarFormulario()
                {
                    var form = document.getElementById("formulario");
                    form.style.display = "none";
                }


                window.onload = ocultarFormulario;

            </script>

            <h3>
                Comentarios
                <h3 id="comentar" class="posted"><a href="" onclick="mostrarFormulario(); return false;">Comentar</a></h3>
            </h3>

            <div id="formulario" style="display:none;">
                
                <s:form action="/servicios/empresas/comentarEmpresa.html" cssClass="formularioComentario">
                    
                    <tr>
                        <td colspan="2">
                            <strong>Agregar comentario.</strong>
                        </td>
                    </tr>

                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>

                    <s:textfield label="Su nombre" name="comentario.autor" />
                    <s:textfield label="Su email" name="comentario.email" />

                    <tr>
                        <td></td>
                        <td width="100%">
                            <s:textarea label="Comentario" name="comentario.texto" wrap="true" rows="5" cssStyle="width:100%;" required="true" />
                        </td>
                    </tr>

                    <td/>

					<%@ include file="/comun/captcha.jsp" %>

                    <s:hidden name="id" value="%{empresa.id}" />

                    <s:submit value="Enviar" />

                </s:form>
                
            </div>

            <display:table name="listaComentarios" class="comentarios" pagesize = "7" export="false" requestURI="/servicios/empresas/verEmpresa.html" decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorComentarios">

                <display:column property="texto" title="" />

            </display:table>
            
        </div>



		<br/>
		<br/>
		
		<p align="center">
		<script type="text/javascript"><!--
		google_ad_client = "pub-6102689346312026";
		/* acsd banner horizontal artículos 468x60, creado 8/09/08 */
		google_ad_slot = "8324011229";
		google_ad_width = 468;
		google_ad_height = 60;
		//-->
		</script>
		<script type="text/javascript"
		src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
		</script>
		</p>


    </body>
</html>
