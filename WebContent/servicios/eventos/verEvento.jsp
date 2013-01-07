<%-- 
    Author     : Alejandro
    Descripcion: Muestra toda la información de un evento.
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
            <h2 class="title">
                <s:property value="evento.titulo" />
            </h2>
            
            <s:url id="estrella" value="/images/estrella.png" />
            <h3 class="posted">
                <s:property value="evento.empresa.nombre" />
                <c:forEach begin="1" end="${evento.empresa.plan.estrellas}" >
                    <img src="${estrella}" />
                </c:forEach>
            </h3>
            <br/>
            
            <s:property value="evento.descripcion" />
            <br/><br/>
            
            <table class="datosEmpresa">

                <tr>
                    <td>
                        Fecha (año-mes-día):
                    </td>
                    <td>
                        <s:url id="calendar" value="/images/icons/calendar.png" />
                        <img src="${calendar}" />
                        <s:property value="evento.fecha" />
                    </td>
                </tr>

                <tr>
                    <td>
                        Hora:
                    </td>
                    <td>
                        <s:url id="clock" value="/images/icons/clock.png" />
                        <img src="${clock}" />
                        <s:property value="evento.hora" />
                    </td>
                </tr>

                <tr>
                    <td>
                        Lugar:
                    </td>
                    <td>
                        <s:url id="city" value="/images/icons/city.png" />
                        <img src="${city}" />
                        <s:property value="evento.lugar" /> (<s:property value="evento.zona.ciudad.nombre" /> - <s:property value="evento.zona.nombre" />)
                    </td>
                </tr>

                <tr>
                    <td>
                        Precio:
                    </td>
                    <td>
                        <s:url id="money" value="/images/icons/money.png" />
                        <img src="${money}" />
                        <s:property value="evento.precio" />
                    </td>
                </tr>

                <tr>
                    <td>
                        Informes:
                    </td>
                    <td>
                        <s:url id="help" value="/images/icons/help16.png" />
                        <img src="${help}" />
                        <s:property value="evento.informes" />
                    </td>
                </tr>


            </table>

        </div>
        
        <div class="post">
            <br/>
            <input align="right" type="button" value="Volver a la lista" onclick="history.back()" style="padding: 8px; height: 100%; width: 100%;" />
        </div>
        
        <br/>
            
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
                
                <s:form action="/servicios/eventos/comentarEvento.html" cssClass="formularioComentario">
                    
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

                    <s:hidden name="id" value="%{evento.id}" />

                    <s:submit value="Enviar" />

                </s:form>
                
            </div>

            <display:table name="listaComentarios" class="comentarios" pagesize = "7" export="false" requestURI="/servicios/eventos/verEvento.html" decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorComentarios">

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
