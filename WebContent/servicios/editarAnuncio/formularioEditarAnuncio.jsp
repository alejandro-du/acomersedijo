<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario de edición del anuncio.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<%
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", -1);
%>

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
            
            <h2 class="title">Editar anuncio</h2>
            <h3 class="posted">Cree o edite su anuncio</h3>

            <s:actionerror />
            <s:actionmessage />

            <script>

                function mostrarOcultarUpload()
                {
                    var eliminar = document.getElementById("eliminar");
                    var upload = document.getElementById("upload");
                    var imagen = document.getElementById("imagen");
                    
                    if(eliminar.checked) {
                        upload.value = "";
                        upload.style.display = "none";
                        imagen.style.display = "none";
                    }
                    else {
                        upload.style.display = "block";
                        imagen.style.display = "block";
                    }
                }
                
            </script>
            
            <p>
                
                <s:form action="/servicios/editarAnuncio/guardarAnuncio.html"  method="POST" enctype="multipart/form-data" cssClass="ram">
                    
                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>

					<s:if test="empresa.planSolicitado.precio > 0 && (empresa.planSolicitado.fechaPago == null || empresa.planSolicitado.fechaPago == '')">
                        <tr>
                            <td colspan="2" class="required">
                                <strong>NOTA: </strong>
								<i>Recuerde que debe realizar el pago de las características adicionales de su plan.</i>
                            </td>
                        </tr>
					</s:if>
                        
                    <s:if test="empresa.plan.imagen && (empresa.plan.fechaPago != null && empresa.plan.fechaPago != '')">

                        <s:if test="empresa.urlImagen != null && !empresa.urlImagen.trim().equals('')">

                            <td>
                                <div class="imagenEmpresa">
                                    <img id="imagen" src="${empresa.urlImagen}" />
                                </div>
                            </td>

                            <s:checkbox label="Eliminar imagen o foto" id="eliminar" name="eliminarImagen" onchange="mostrarOcultarUpload();" />

                        </s:if>
                        
                        <s:file label="Imagen o foto" id="upload" name="imagen" accept="image" />
                    
                    </s:if>

                    <td colspan="2">
                        <div class="nota">
                            La información de los siguientes campos aparecerá en su anuncio y permitirá
                            que los visitantes del sitio web lo encuentren con nuestros buscadores.
                        </div>
                    </td>

                    <s:textfield label="Nombre" name="empresa.nombre" value="%{empresa.nombre}" required="true" />
                    <s:textfield label="Teléfono" name="empresa.telefono" value = "%{empresa.telefono}" required="false" />
                    <s:checkbox label="Domicilios" name="empresa.domicilios" />
                    <s:textfield label="Dirección" name="empresa.direccion" value = "%{empresa.direccion}" required="true" />

                    <s:if test="empresa.plan.linkWebsite && (empresa.plan.fechaPago != null && empresa.plan.fechaPago != '')">
                        <s:textfield label="Email" name="empresa.email" value = "%{empresa.email}" required="false" />
                        <s:textfield label="Website" name="empresa.website" value = "%{empresa.website}" required="false" />
                    </s:if>

                    <s:select label="Especialidad"
                              name="empresa.sector.id"
                              value="%{empresa.sector.{id}}"
                              list="listaSectores"
                              listKey="id"
                              listValue="nombre"
                              headerKey="null"
                              headerValue="--Seleccione--"
                              required="true" />

                    <s:select label="Ciudad"
                              id="listaCiudades"
                              name="empresa.zona.ciudad.id"
                              list="listaCiudades"
                              listKey="id"
                              listValue="nombre"
                              headerKey="null"
                              headerValue="--Seleccione--"
                              required="true"
                              value="%{empresa.zona.ciudad.id}"
                              onchange="cargarZonas('listaCiudades', 'listaZonas', {'null' : '--Seleccione--'}, 'null');" />
                    
                    <s:select label="Zona"
                              id="listaZonas"
                              name="empresa.zona.id"
                              list="listaZonas"
                              listKey="id"
                              listValue="nombre"
                              headerKey="null"
                              headerValue="--Seleccione--"
                              required="true"
                              value="%{empresa.zona.id}" />
                            
                    <s:textfield label="Precio promedio del plato" name="empresa.precioPromedio" required="true" />
                    
                    <td colspan="2">
                        <div class="nota">
                            Seleccione las formas de pago que acepta en su restaurante. Debe seleccionar al menos una opción.
                        </div>
                    </td>

                    <s:checkbox label="Efectivo" name="empresa.pagoEfectivo" />
                    <s:checkbox label="American Express" name="empresa.pagoAmericanExpress" />
                    <s:checkbox label="Diners Club" name="empresa.pagoDinersClub" />
                    <s:checkbox label="Master Card" name="empresa.pagoMasterCard" />
                    <s:checkbox label="Maestro" name="empresa.pagoMaestro" />
                    <s:checkbox label="Visa" name="empresa.pagoVisa" />
                    
                    <s:if test="empresa.plan.caracteresHtml > 0 && (empresa.plan.fechaPago != null && empresa.plan.fechaPago != '')">
                        <td colspan="2">
                            <div class="nota">
                                Use el siguiente espacio para agregar todo tipo de información adicional.
                            </div>
                        </td>

                        <tr>
                            <td></td>
                            <td width="100%">
                                <s:textarea label="Anuncio" id="editor" name="empresa.anuncio" value = "%{empresa.anuncio}" />
                                <%@ include file="/comun/editor.jsp" %>
                                <script>editor("editor")</script>
                            </td>
                        </tr>
                    </s:if>
                    
                    <s:hidden name="empresa.id" value="%{empresa.id}" />
                    <s:hidden name="empresa.plan.id" value="%{empresa.plan.id}" />
                    <s:hidden name="empresa.planSolicitado.id" value="%{empresa.planSolicitado.id}" />
                    <s:hidden name="empresa.activa" value="%{empresa.activa}" />
                    <s:hidden name="empresa.usuario.id" value="%{empresa.usuario.id}" />
                    <s:hidden name="empresa.visitas" value="%{empresa.visitas}" />
                    <s:hidden name="empresa.urlImagen" value="%{empresa.urlImagen}" />

                    <s:if test="!empresa.activa">
                        <td colspan="2">
                            <div class="nota">
                                <s:url id="contactenos" value="/servicios/contactenos" includeParams="false" />
                                <strong>NOTA: Su anuncio ha sido desactivado. Si desconoce el motivo, <a href="${contactenos}">comuníquese con !A comer se dijo!</a>.</strong>
                            </div>
                        </td>
                    </s:if>
                    
                    <s:submit value="Guardar y publicar mi anuncio" />

                </s:form>
            </p>
        </div>

    </body>
</html>
