<%-- 
    Author     : Alejandro
    Descripcion: Muestra una lista con los articulos.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <div class="post">
            <h2 class="title">Articulos</h2>

            <display:table id="tabla" class="sector" name="listaArticulos" pagesize = "20" export="true" requestURI="/servicios/articulos/verArticulos.html">

                <display:column title="Título" property="titulo" sortable="true" />

            </display:table>
            
            <s:if test="%{listaArticulos == null || listaArticulos.isEmpty()}">
                <p>
                    No hay articulos para mostrar.
                </p>
            </s:if>
            
        </div>
        
    </body>
</html>
