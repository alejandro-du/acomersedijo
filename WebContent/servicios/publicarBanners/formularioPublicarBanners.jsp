<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario de publicación de banners.
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
        
        <div class="post">
            
            <h2 class="title">Publicar banners</h2>
            <h3 class="posted">Publique sus banners</h3>

            <s:actionerror />
            <s:actionmessage />

            <script>

                function mostrarOcultarUpload(banner, eliminar, upload)
                {
                    var eliminar = document.getElementById(eliminar);
                    var upload = document.getElementById(upload);
                    var imagen = document.getElementById(banner);
                    
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
                
                function inicializar() {
                    mostrarOcultarUpload('bannerAib', 'eliminarAib', 'uploadAib');
                    mostrarOcultarUpload('bannerAii', 'eliminarAii', 'uploadAii');
                    mostrarOcultarUpload('bannerAsm', 'eliminarAsm', 'uploadAsm');
                    mostrarOcultarUpload('bannerAdt', 'eliminarAdt', 'uploadAdt');
                }
                
                window.onload = inicializar;
                
            </script>
            
            <p>
                
                <s:form action="/servicios/publicarBanners/publicarBanners.html"  method="POST" enctype="multipart/form-data" cssClass="ram">
                    
                    <%@ include file="/comun/notaCamposObligatorios.jsp" %>

					<s:if test="empresa.planSolicitado.precio > 0 && (empresa.planSolicitado.fechaPago == null || empresa.planSolicitado.fechaPago == '')">
                        <tr>
                            <td colspan="2" class="required">
                                <strong>NOTA: </strong>
								<i>Recuerde que debe realizar el pago de las características adicionales de su plan.</i>
                            </td>
                        </tr>
					</s:if>
                    


                    <td colspan="2">
                        <div class="nota">
                            Banner AIB: Banner Aleatorio Inferior en resultados de Búsquedas. Este banner se muestra en la parte inferior
                            en los resultados de búsquedas de restaurantes. Debe proporcionar una imagen de tamaño
                            <c:out value="${ctrlBanner.anchoAib}" /> x <c:out value="${ctrlBanner.altoAib}" /> pixeles.
                        </div>
                    </td>

                    <s:if test="empresa.plan.bannerAib">
                        
                        <s:if test="urlBannerAib != null && !urlBannerAib.trim().equals('')">
                            <tr>
                                <td colspan="2">
                                    <div>
                                        <img id="bannerAib" src="${urlBannerAib}" />
                                    </div>
                                </td>
                            </tr>

                            <s:checkbox label="Eliminar banner AIB" id="eliminarAib" name="eliminarAib" onchange="mostrarOcultarUpload('bannerAib', 'eliminarAib', 'uploadAib');" />

                        </s:if>
                        
                        <s:file label="Imagen o foto" id="uploadAib" name="bannerAib" accept="image" />
                    </s:if>
					<s:elseif test="empresa.planSolicitado.bannerAib && (empresa.planSolicitado.fechaPago == null || empresa.planSolicitado.fechaPago == '')">
                        <tr>
                            <td colspan="2" class="required">
                                <i>Debe realizar el pago para publicar este banner</i>.
                            </td>
                        </tr>
					</s:elseif>
                    <s:else>
                        <tr>
                            <td colspan="2">
                                <i>Su plan no incluye este banner</i>.
                            </td>
                        </tr>
                    </s:else>




                    <td colspan="2">
                        <div class="nota">
                            Banner AII: Banner Aleatorio Inferior en Index (página principal). Este banner se muestra en la parte inferior
                            de la página principal. Debe proporcionar una imagen de tamaño
                            <c:out value="${ctrlBanner.anchoAii}" /> x <c:out value="${ctrlBanner.altoAii}" /> pixeles.
                        </div>
                    </td>

                    <s:if test="empresa.plan.bannerAii">
                        <s:if test="urlBannerAii != null && !urlBannerAii.trim().equals('')">

                            <tr>
                                <td colspan="2">
                                    <div>
                                        <img id="bannerAii" src="${urlBannerAii}" />
                                    </div>
                                </td>
                            </tr>

                            <s:checkbox label="Eliminar banner AII" id="eliminarAii" name="eliminarAii" onchange="mostrarOcultarUpload('bannerAii', 'eliminarAii', 'uploadAii');" />

                        </s:if>
                        
                        <s:file label="Imagen o foto" id="uploadAii" name="bannerAii" accept="image" />
                    </s:if>
					<s:elseif test="empresa.planSolicitado.bannerAii && (empresa.planSolicitado.fechaPago == null || empresa.planSolicitado.fechaPago == '')">
                        <tr>
                            <td colspan="2" class="required">
                                <i>Debe realizar el pago para publicar este banner</i>.
                            </td>
                        </tr>
					</s:elseif>
                    <s:else>
                        <tr>
                            <td colspan="2">
                                <i>Su plan no incluye este banner</i>.
                            </td>
                        </tr>
                    </s:else>



                    <td colspan="2">
                        <div class="nota">
                            Banner ASM: Banner Aleatorio Superior debajo del Menú. Este banner se muestra en la parte inferior
                            del menú principal del sitio. Debe proporcionar una imagen de tamaño
                            <c:out value="${ctrlBanner.anchoAsm}" /> x <c:out value="${ctrlBanner.altoAsm}" /> pixeles.
                        </div>
                    </td>

                    <s:if test="empresa.plan.bannerAsm">
                        <s:if test="urlBannerAsm != null && !urlBannerAsm.trim().equals('')">

                            <tr>
                                <td colspan="2">
                                    <div>
                                        <img id="bannerAsm" src="${urlBannerAsm}" />
                                    </div>
                                </td>
                            </tr>

                            <s:checkbox label="Eliminar banner ASM" id="eliminarAsm" name="eliminarAsm" onchange="mostrarOcultarUpload('bannerAsm', 'eliminarAsm', 'uploadAsm');" />

                        </s:if>
                        
                        <s:file label="Imagen o foto" id="uploadAsm" name="bannerAsm" accept="image" />
                    </s:if>
					<s:elseif test="empresa.planSolicitado.bannerAsm && (empresa.planSolicitado.fechaPago == null || empresa.planSolicitado.fechaPago == '')">
                        <tr>
                            <td colspan="2" class="required">
                                <i>Debe realizar el pago para publicar este banner</i>.
                            </td>
                        </tr>
					</s:elseif>
                    <s:else>
                        <tr>
                            <td colspan="2">
                                <i>Su plan no incluye este banner</i>.
                            </td>
                        </tr>
                    </s:else>



                    <td colspan="2">
                        <div class="nota">
                            Banner ADT: Banner Aleatorio al lado Derecho del Top de restaurantes. Este banner se muestra en la parte derecha
                            del top de restaurantes en la página principal. Debe proporcionar una imagen de tamaño
                            <c:out value="${ctrlBanner.anchoAdt}" /> x <c:out value="${ctrlBanner.altoAdt}" /> pixeles.
                        </div>
                    </td>

                    <s:if test="empresa.plan.bannerAdt">
                        
                        <s:if test="urlBannerAdt != null && !urlBannerAdt.trim().equals('')">

                            <tr>
                                <td colspan="2">
                                    <div>
                                        <img id="bannerAdt" src="${urlBannerAdt}" />
                                    </div>
                                </td>
                            </tr>

                            <s:checkbox label="Eliminar banner ADT" id="eliminarAdt" name="eliminarAdt" onchange="mostrarOcultarUpload('bannerAdt', 'eliminarAdt', 'uploadAdt');" />

                        </s:if>
                        
                        <s:file label="Imagen o foto" id="uploadAdt" name="bannerAdt" accept="image" />
                    </s:if>
					<s:elseif test="empresa.planSolicitado.bannerAdt && (empresa.planSolicitado.fechaPago == null || empresa.planSolicitado.fechaPago == '')">
                        <tr>
                            <td colspan="2" class="required">
                                <i>Debe realizar el pago para publicar este banner</i>.
                            </td>
                        </tr>
					</s:elseif>
                    <s:else>
                        <tr>
                            <td colspan="2">
                                <i>Su plan no incluye este banner</i>.
                            </td>
                        </tr>
                    </s:else>




                    <s:if test="!empresa.activa">
                        <td colspan="2">
                            <div class="nota">
                                <s:url id="contactenos" value="/servicios/contactenos" includeParams="false" />
                                <strong>NOTA: Sus banners han sido desactivados. Si desconoce el motivo, <a href="${contactenos}">comuníquese con !A comer se dijo!</a>.</strong>
                            </div>
                        </td>
                    </s:if>
                    
                    <s:hidden name="empresa.id" value="%{empresa.id}" />
                    <s:hidden name="empresa.plan.id" value="%{empresa.plan.id}" />
                    <s:hidden name="empresa.planSolicitado.id" value="%{empresa.planSolicitado.id}" />
                    <s:hidden name="empresa.activa" value="%{empresa.activa}" />
                    <s:hidden name="empresa.usuario.id" value="%{empresa.usuario.id}" />
                    <s:hidden name="empresa.visitas" value="%{empresa.visitas}" />
                    <s:hidden name="empresa.urlImagen" value="%{empresa.urlImagen}" />
                    
                    <s:submit value="Guardar y publicar mis banners" />

                </s:form>
            </p>
        </div>

    </body>
    
</html>
