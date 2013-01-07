<%-- 
    Author     : Alejandro
    Description: Muestra un artículo.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>
<%@ taglib prefix="sql" uri="/WEB-INF/tld/sql.tld" %>

<div class="post">
    
    <h2 class="title">
    	<s:property value="articulo.titulo"/>
	</h2>

    <h3 class="posted">
		<s:property value="articulo.subTitulo"/>
	</h3>
    
    <div class="story">
        <p>
			<s:property value="articulo.texto" escape="false" />
        </p>
    </div>

    <div class="meta">
    </div>


    <div class="post">

        <input align="right" type="button" value="Volver" onclick="history.back()" style="padding: 8px; height: 100%; width: 100%;" />
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
            
            <s:form action="/servicios/articulos/comentarArticulo.html" cssClass="formularioComentario">
                
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

                <s:hidden name="id" value="%{articulo.id}" />

                <s:submit value="Enviar" />

            </s:form>
            
        </div>

        <display:table name="listaComentarios" class="comentarios" pagesize = "7" export="false" requestURI="/servicios/articulos/verEvento.html" decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorComentarios">

            <display:column property="texto" title="" />

        </display:table>
        
    </div>




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