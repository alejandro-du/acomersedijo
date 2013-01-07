<%-- 
    Author     : Alejandro
    Descripcion: Presenta los detalles de un VO.
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
        
            <h3 class="posted">
				Detalles
			</h3>

			<br/>

			<s:actionerror/>

			<table class="crud">

				<thead>
					<tr>
						<td colspan="2" style="text-align: right;">

							<s:url id="eliminar" value="/images/icons/x16.png" />
							<a href="crud!doDelete.html?id=${vo.id}" onclick="return confirm('Esta acción eliminará el registro permanentemente.')"><img src="${eliminar}" style="border: 0px;"></a>
							
							<s:url id="modificar" value="/images/icons/edit16.png" />
							<a href="crud!update.html?id=${vo.id}">
								<img src="${modificar}" style="border: 0px;">
							</a>

						</td>
					</tr>
				</thead>

				<s:iterator value="fields" id="field">
					<s:if test="!hidden">
						<tr>
							<td>
								<I><s:property value="label" />:</I>
							</td>
							<td>
								<c:out value="${field.value}" escapeXml="${field.escapeXml}" />
							</td>
						</tr>
					</s:if>
	
				</s:iterator>

			</table>

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
