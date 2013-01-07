<%-- 
    Author     : Alejandro
    Descripción: Muestra el cuadro de búsqueda.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ include file="/comun/include.jsp" %>

                
<div id="categories" class="boxed">
    
    <h2 class="heading">
        Buscar
    </h2>
    
    <div class="content">
                
        <s:form action="/servicios/empresas/buscar.html">
            
            <s:textfield name="cadenaBusqueda" cssStyle="width: 162px;" />
            <s:submit value="Buscar" />
            
        </s:form>
        
        <ul>
            <li>
                <s:url id="avanzada" value="/servicios/empresas/busquedaAvanzada.html" includeParams="false" />
                <a href="${avanzada}">Búsqueda detallada...</a>
            </li>
        </ul>
                
    </div>
    
</div>
