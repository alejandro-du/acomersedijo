<%-- 
    Author     : Alejandro
    Description: JSP de inicio para usuarios no autenticados.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>
<%@ taglib prefix="sql" uri="/WEB-INF/tld/sql.tld" %>

<s:actionerror />
<s:actionmessage />

<s:url id="estrella" value="/images/estrella.png" />





<s:iterator value="articulos1">
	<%@ include file="/comun/resumenArticulo.jsp" %>
</s:iterator>







<s:if test="eventos.size >= 1">

	<s:url id="eventos" value="/servicios/eventos/verEventos.html" />

    <div class="post">
		<h2 class="title">
	        <a href="${eventos}">
				Próximos eventos
			</a>
		</h2>
        <h3 class="posted">Conozca los eventos organizados por nuestros patrocinadores</h3><br/>
    </div>

    <div class="eventos">

        <s:iterator value="eventos">
            <div class="evento">

                <s:url id="verEvento" value="%{'/servicios/eventos/verEvento.html?id=' + id}" />

                <h3>
                    <a href="${verEvento}">
                        <s:property value="%{titulo}" />
                    </a>

                    <c:forEach begin="1" end="${estrellas.plan.estrellas}" >
                        <img src="${estrella}" />
                    </c:forEach>
                </h3>

                <s:property value="%{descripcion}" />

                <a href="${verEvento}">Más información...</a>
            </div>
        </s:iterator>

		<div style="text-align: right;">
			<strong>
				<a href="${eventos}">
					Ver todos los eventos
				</a>
			</strong>
		</div>

    </div>
    
    <div class="post">
        <div class="meta">
        </div>
    </div>

</s:if>








<s:iterator value="articulos2">
	<%@ include file="/comun/resumenArticulo.jsp" %>
</s:iterator>








<div class="post">

	<s:if test="topEmpresas.size >= 1">
	    <h2 class="title">Top 5</h2>
	    <h3 class="posted">Los 5 restaurantes más visitados en <strong>¡A comer se dijo!</strong></h3>
	</s:if>

    <table>
        <tr>
            <td style="width:100%;">

                <div class="story">
                    <ol>
                        <s:iterator value="topEmpresas">
                            <li>

                                <s:url id="url" value="%{'/servicios/empresas/verEmpresa.html?id=' + id}" />
                                <s:a href="%{url}">
                                    <c:out value="${nombre}" />
                                </s:a>

                                <c:forEach begin="1" end="${estrellas}" >
                                    <img src="${estrella}" />
                                </c:forEach>

                                <s:if test="urlImagen != null && !urlImagen.trim().equals('')">
                                    <div class="imagenEmpresa">
                                        <s:a href="%{url}">
                                            <img src="${urlImagen}" style="float:left; margin-right:10px;" />
                                        </s:a>
                                    </div>
                                </s:if>
                                <div class="posted">
                                    <c:out value="Visitado ${visitas} veces" /><br/>
                                    <s:url id="cereal" value="/images/icons/cereal.png" />
                                    <img src="${cereal}" />
                                    <c:out value="${sector.nombre}" /><br/>
                                    <s:url id="globe" value="/images/icons/globe.png" />
                                    <img src="${globe}" />
                                    <c:out value="${direccion} - (Zona ${zona.nombre})" /><br/>
                                    <s:url id="dollar" value="/images/icons/dollar.png" />
                                    <img src="${dollar}" />
                                    <c:out value="Precio promedio: ${precioPromedio}" />
                                </div>
                            </li>
                            <br/>
                        </s:iterator>
                    </ol>

                </div>

				<s:if test="topEmpresas.size <= 3">

					<script type="text/javascript"><!--
					google_ad_client = "pub-6102689346312026";
					/* acsd top 5 336x280, creado 9/09/08 */
					google_ad_slot = "3917842186";
					google_ad_width = 336;
					google_ad_height = 280;
					//-->
					</script>
					<script type="text/javascript"
					src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
					</script>

				</s:if>

				<s:if test="topEmpresas.size <= 0">

					<script type="text/javascript"><!--
					google_ad_client = "pub-6102689346312026";
					/* acsd top 5 imagen 336x280, creado 9/09/08 */
					google_ad_slot = "3691493587";
					google_ad_width = 336;
					google_ad_height = 280;
					//-->
					</script>
					<script type="text/javascript"
					src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
					</script>

				</s:if>

            </td>

            <td>
                <div>
                    <img src="${urlBannerAdt}" />
                </div>
            </td>

        </tr>

    </table>

    <div class="meta">
    </div>
</div>







<s:iterator value="articulos3">
	<%@ include file="/comun/resumenArticulo.jsp" %>
</s:iterator>






<div class="story">

    <blockquote>
        <p>&#8220;La buena comida, entra antes por los sentidos que por la barriga.&#8221;</p>
    </blockquote>

</div>

<div>
    <img src="${urlBannerAii}" />
</div>
