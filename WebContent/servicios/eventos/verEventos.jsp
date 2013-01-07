<%-- 
    Author     : Alejandro
    Descripcion: Muestra una lista con los próximos eventos.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <div class="post">
            <h2 class="title">Próximos eventos</h2>

            <display:table id="tabla" class="sector" name="listaEventos" pagesize = "20" export="true" requestURI="/servicios/eventos/verEventos.html" decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorEventos">

                <display:column title="Evento" property="titulo" sortable="true" />
                <display:column title="Fecha" property="fecha" sortable="true" />
                <display:column title="Lugar" property="lugar" sortable="true" />

            </display:table>
            
            <s:if test="%{listaEventos == null || listaEventos.isEmpty()}">
                <p>
                    No hay eventos para mostrar.
                </p>
            </s:if>
            
        </div>
        
        <div class="post">
            <br/>
            <input align="right" type="button" value="Volver" onclick="history.back()" style="padding: 8px; height: 100%; width: 100%;" />
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
