
<%-- 
    Author     : Alejandro
    Descripcion: Muestra todas las empresas de un determinado sector.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    
    <body>
        
        <div class="post">
            
            <h2 class="title">
                <c:out value="${sector.nombre}" />
            </h2>
            
            <s:actionerror />
            
            <display:table class="sector" name="listaEmpresas" pagesize = "20" export="true" requestURI="/servicios/empresas/verSector.html" decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorEmpresas">

                <display:column title="Restaurante" property="nombre" sortable="true" />
                <display:column title="Zona" property="zona.nombre" sortable="true" />
                <display:column title="Dirección" property="direccion" sortable="true" />
                <display:column title="Precio promedio" property="precioPromedio" sortable="true" />
                <display:column title="Visitas" property="visitas" sortable="true" />

            </display:table>
            
            <s:if test="%{listaEmpresas == null || listaEmpresas.isEmpty()}">
                <p>
                    <s:url id="registro" value="/servicios/registrarse" includeParams="false" />
                    <strong>¡Sea el primero en anunciar en esta categoría! </strong>
                    <a href="${registro}">Registre su restaurante</a> para que sea listado de inmediato <strong> en esta página</strong>, ¡es muy fácil!.
                </p>

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


            </s:if>
            <s:else>
                
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

                </script>
                
                <br/>
                <h3>
                    Comentarios
                    <h3 id="comentar" class="posted"><a href="" onclick="mostrarFormulario(); return false;">Comentar</a></h3>
                </h3>
                
                <div id="formulario" style="display:none;">
                    
                    <s:form action="/servicios/empresas/comentarSector.html" cssClass="formularioComentario">
                        
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

                        <s:hidden name="id" value="%{sector.id}" />

                        <s:submit value="Enviar" />

                    </s:form>

                </div>
                
                
                <display:table name="listaComentarios" class="comentarios" pagesize = "7" export="false" requestURI="/servicios/empresas/verSector.html" decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorComentarios">

                    <display:column property="texto" title="" escapeXml="false" />

                </display:table>
                
            </s:else>
            
        </div>

		<br/><br/>
        
        <div>
            <img src="${urlBanner}" />
        </div>
        
    </body>
</html>






