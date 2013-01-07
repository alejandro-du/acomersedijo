<%-- 
    Author     : Alejandro
    Descripcion: Presenta los resultados de búsqueda.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <div class="post">
            
            <h2 class="title">
            	<s:property value="%{crudTitle}" />
			</h2>
        
            <display:table name="lista"
                           pagesize="30"
                           class="crud"
                           export="true"
                           decorator="dpasoftware.acomersedijo.presentacion.comun.impl.DecoradorCrud"
                           requestURI="#session['servicio'].url + 'buscar.html'">

                <s:iterator value="fields" id="field">
					<s:if test="!hidden">
						<display:column title="${field.label}" property="${field.property}" sortable="${field.sortable}" escapeXml="${escapeXml}" />
					</s:if>
                </s:iterator>

            </display:table>
	            
		</div>
        
        <div class="post">
            <br/>
            <input align="right" type="button" value="Volver" onclick="history.back()" style="padding: 8px; height: 100%; width: 100%;" />
        </div>

		<br/>
		<s:url id="buscar" value="crud!search.html" />
        <a href="${buscar}">Buscar...</a>
		<br/>
		<br/>
		<s:url id="crear" value="crud!create.html" />
        <a href="${crear}">Crear nuevo...</a>

    </body>
</html>
