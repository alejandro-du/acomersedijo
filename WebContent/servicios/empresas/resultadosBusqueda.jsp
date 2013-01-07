<%-- 
    Author     : Alejandro
    Descripcion: Muestra los resultados de búsqueda de empresas.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <div class="post">
            <h2 class="title">Resultados de la búsqueda</h2>

            <display:table id="tabla" class="sector" name="listaEmpresas" pagesize = "20" export="true" requestURI="/servicios/empresas/buscar.html" decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorEmpresas">

                <display:column title="Restaurante" property="nombre" sortable="true" />
                <display:column title="Zona" property="zona.nombre" sortable="true" />
                <display:column title="Dirección" property="direccion" sortable="true" />
                <display:column title="Precio promedio" property="precioPromedio" sortable="true" />
                <display:column title="Visitas" property="visitas" sortable="true" />
                <display:column title="Especialidad" property="sector.nombre" sortable="true" />

            </display:table>
            
            <s:if test="%{listaEmpresas == null || listaEmpresas.isEmpty()}">
                <p>
                    Por favor intente con otra cadena de búsqueda.
                </p>

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
            
            <s:hidden name="cadenaBusqueda" value="%{cadenaBusqueda}" />
        
        </div>
        
        <div>
            <img src="${urlBanner}" />
        </div>
        
    </body>
</html>
