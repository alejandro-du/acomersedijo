<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para publicación de un nuevo evento.
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
            
            <h2 class="title">Publicar evento</h2>
            <h3 class="posted">Publique un nuevo evento relacionado con su restaurante</h3>

            <s:actionerror />
            <s:actionmessage />
            
            <p>
                
                <s:form action="/servicios/publicarEvento/publicarEvento.html" cssClass="ram">
                    
                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>

                    <td colspan="2">
                        <div class="nota">
							Recuerde que el nombre de su restaurante aparecerá en los detalles del evento.
                        </div>
                    </td>

	                <s:textfield label="Título" name="evento.titulo" required="true" />
                
                    <s:select label="Ciudad"
                              id="listaCiudades"
                              name="evento.zona.ciudad.id"
                              list="listaCiudades"
                              listKey="id"
                              listValue="nombre"
                              headerKey="null"
                              headerValue="--Seleccione--"
                              required="true"
                              value="%{evento.zona.ciudad.id}"
                              onchange="cargarZonas('listaCiudades', 'listaZonas', {'null' : '--Seleccione--'}, 'null');" />
                    
                    <s:select label="Zona"
                              id="listaZonas"
                              name="evento.zona.id"
                              list="listaZonas"
                              listKey="id"
                              listValue="nombre"
                              headerKey="null"
                              headerValue="--Seleccione--"
                              required="true"
                              value="%{evento.zona.id}" />
                            
                    <td colspan="2">
                        <div class="nota">
							<strong>Haga click en el cuadro de texto para abrir un calendario</strong> y seleccione la fecha en la que se
							realizará el evento. Debe seleccionar una fecha que se encuentre dentro de los próximos
							<s:property value="ctrlEvento.diasLimiteProximosEventos" /> días a partir de la fecha actual.
                        </div>
                    </td>

	                <s:textfield label="Fecha" name="evento.fecha" id="fecha" readonly="true" required="true" />
	                <%@ include file="/comun/calendar.jsp" %>
	                <script>calendar("fecha", "fecha", true)</script>

	                <s:textfield label="Hora" name="evento.hora" />
	                <s:textfield label="Precio" name="evento.precio" />
	                <s:textfield label="Informes" name="evento.informes" />
	                <s:textfield label="Lugar" name="evento.lugar" />
	                <s:textarea label="Descripción" name="evento.descripcion" wrap="true" rows="12" cssStyle="width:100%;" required="true" />

					<%@ include file="/comun/captcha.jsp" %>

	                <s:hidden name="evento.id" value="%{evento.id}" />

                    <s:submit value="Publicar evento" />

                </s:form>
            </p>
        </div>

    </body>
    
</html>
