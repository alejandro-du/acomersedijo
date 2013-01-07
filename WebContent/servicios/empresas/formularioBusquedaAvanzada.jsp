<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario de busqueda avanzada.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
        
        <s:url id="urlDwrZona" value="/dwr/interface/AjaxZona.js" />
        <s:url id="urlDwrEngine" value="/dwr/engine.js" />
        <s:url id="urlDwrUtil" value="/dwr/util.js" />
        <s:url id="urlAjaxZona" value="/scripts/ajax/zona.js" />
        <script type='text/javascript' src="${urlDwrZona}"></script>
        <script type='text/javascript' src="${urlDwrEngine}"></script>
        <script type='text/javascript' src="${urlDwrUtil}"></script>
        <script type='text/javascript' src="${urlAjaxZona}"></script>

        <div class="post">
            
            <h2 class="title">Buscar restaurantes</h2>
            <h3 class="posted">Búsqueda detallada</h3>

            <s:actionerror />
            <s:actionmessage />

            <p>
                
                <s:form action="/servicios/empresas/realizarBusquedaAvanzada.html" cssClass="ram">
                    
                    <td colspan="2">
                        <div class="nota">
                            Por favor llene los campos por los cuales desea realizar la búsqueda.
                        </div>
                    </td>

                    <s:select label="Ciudad"
                              id="listaCiudades"
                              name="empresa.zona.ciudad.id"
                              list="listaCiudades"
                              listKey="id"
                              listValue="nombre"
                              headerKey="-1"
                              headerValue="--Seleccione--"
                              onchange="cargarZonas('listaCiudades', 'listaZonas', {'-1' : '--Seleccione--'}, '-1');" />
                    
                    <s:select label="Zona"
                              id="listaZonas"
                              name="empresa.zona.id"
                              list="#{}"
                              listKey="id"
                              listValue="nombre"
                              headerKey="-1"
                              headerValue="--Seleccione--" />
    
                    <s:select label="Especialidad"
                              name="empresa.sector.id"
                              value="%{empresa.sector.{id}}"
                              list="listaSectores"
                              listKey="id"
                              listValue="nombre"
                              headerKey="-1"
                              headerValue="--Seleccione--" />

                    <s:textfield label="Nombre" name="empresa.nombre" value="%{empresa.nombre}" />
                    <s:textfield label="Teléfono" name="empresa.telefono" value = "%{empresa.telefono}" />
                    <s:textfield label="Dirección" name="empresa.direccion" value = "%{empresa.direccion}" />
                    <s:textfield label="Email" name="empresa.email" value = "%{empresa.email}" />
                    <s:textfield label="Website" name="empresa.website" value = "%{empresa.website}" />
                    <s:textfield label="Texto en el anuncio" name="empresa.anuncio" value = "%{empresa.anuncio}" />

                    <s:submit value="Buscar" />

                </s:form>
            </p>
        </div>

    </body>
</html>
