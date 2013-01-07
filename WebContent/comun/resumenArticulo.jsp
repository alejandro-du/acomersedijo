<%-- 
    Author     : Alejandro
    Description: Muestra el resumen de un artículo.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>
<%@ taglib prefix="sql" uri="/WEB-INF/tld/sql.tld" %>

<div class="post">
    
    <h2 class="title">
		<s:url id="verArticulo" value="%{'/servicios/articulos/verArticulo.html?id=' + id}" />
    	<a href="${verArticulo}">
    		<s:property value="titulo"/>
		</a>
	</h2>

    <h3 class="posted">
		<s:property value="subTitulo"/>
	</h3>
    
    <div class="story">
		<s:property value="resumen" escape="false" />
		
		<div style="padding: 0px; margin: 0px; font: normal .7em Tahoma, Arial, Helvetica, sans-serif; text-align: right;">
			<a href="${verArticulo}">
    			Ver más...
			</a>
		</div>
    </div>

    <div class="meta">
    </div>
</div>
