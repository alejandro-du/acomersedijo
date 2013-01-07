<%-- 
    Author     : Alejandro
    Descripcion: Muestra un formulario para VOs.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

        <div class="post">
            
            <h2 class="title">
            	<s:property value="crudTitle" />
			</h2>

            <h3 class="posted">
				<s:property value="subTitle" />
			</h3>

		</div>

		<br/>

		<s:actionmessage />
		<s:actionerror/>

        <s:form action="%{action}" cssClass="ram">

			<%@ include file="/comun/notaCamposObligatorios.jsp" %>

			<s:iterator value="fields" id="field">
				
				<s:if test="!hidden">
				
					<s:if test="type == 'String'">
						<s:textfield label="%{label}" name="%{name}" value="%{value}" required="%{required}" disabled="%{disabled}" readonly="%{readOnly}" />
					</s:if>
		
					<s:if test="type == 'Boolean'">
	                    <s:checkbox label="%{label}" name="%{name}" required="%{required}" disabled="%{disabled}" />
					</s:if>
	
					<s:if test="type == 'Long'">
						<s:textfield label="%{label}" name="%{name}" value="%{value}" required="%{required}" disabled="%{disabled}" readonly="%{readOnly}" />
					</s:if>
	
					<s:if test="type == 'Date'">
		                <s:textfield label="%{label}" name="%{name}" id="%{name}" required="%{required}" readonly="true" disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'DateTime'">
		                <s:textfield label="%{label}" name="%{name}" id="%{name}" required="%{required}" readonly="true" disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'TextArea'">
		                <s:textarea label="%{label}" name="%{name}" id="%{name}" cols="54" cssStyle="height: 200px;" required="%{required}" readonly="true" disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'RichTextEditor'">
		                <tr>
		                    <td></td>
		                    <td width="100%">
		                        <s:textarea label="%{label}" id="%{name}" name="%{name}" value = "%{value}" required="%{required}" disabled="%{disabled}" readonly="%{readOnly}" />
		                    </td>
		                </tr>
					</s:if>
		
					<s:if test="type == 'List<Grupo>'">
		
			            <s:select label="Grupos"
			                      name="vo.gupos.id"
			                      value="%{vo.grupos.{id}}"
			                      list="listaGrupos"
			                      listKey="id"
			                      listValue="nombre"
			                      multiple="true"
			                      size="6"
			                      required="%{required}"
			                      disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'List<Servicio>'">
		
			            <s:select label="Servicios"
			                      name="vo.servicios.id"
			                      value="%{vo.servicios.{id}}"
			                      list="listaServicios"
			                      listKey="id"
			                      listValue="nombre"
			                      multiple="true"
			                      size="15"
			                      required="%{required}"
			                      disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'List<Ciudad>'">
		
			            <s:select label="Ciudades"
			                      name="vo.ciudades.id"
			                      value="%{vo.ciudades.{id}}"
			                      list="listaCiudades"
			                      listKey="id"
			                      listValue="nombre"
			                      multiple="true"
			                      size="15"
			                      required="%{required}"
			                      disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Ciudad'">
	
	                    <s:select label="Ciudad"
	                              name="vo.ciudad.id"
	                              list="listaCiudades"
	                              listKey="id"
	                              listValue="nombre"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
	
					<s:if test="type == 'Menu'">
		
	                    <s:select label="Menú"
	                              name="vo.menu.id"
	                              list="listaMenus"
	                              listKey="id"
	                              listValue="nombre"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Empresa'">
		
	                    <s:select label="Empresa"
	                              name="vo.empresa.id"
	                              list="listaEmpresas"
	                              listKey="id"
	                              listValue="nombre"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Zona'">
		
	                    <s:select label="Zona"
	                              name="vo.zona.id"
	                              list="listaZonas"
	                              listKey="id"
	                              listValue="nombre"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Sector'">
		
	                    <s:select label="Sector"
	                              name="vo.sector.id"
	                              list="listaSectores"
	                              listKey="id"
	                              listValue="nombre"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Usuario'">
		
	                    <s:select label="Usuario (id)"
	                              name="vo.usuario.id"
	                              list="listaUsuarios"
	                              listKey="id"
	                              listValue="id"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Plan'">
		
	                    <s:select label="Plan (id)"
	                              name="%{name}.id"
	                              list="listaPlanes"
	                              listKey="id"
	                              listValue="id"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Evento'">
		
	                    <s:select label="Evento"
	                              name="vo.evento.id"
	                              list="listaEventos"
	                              listKey="id"
	                              listValue="titulo"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Articulo'">
		
	                    <s:select label="Artículo"
	                              name="vo.articulo.id"
	                              list="listaArticulos"
	                              listKey="id"
	                              listValue="titulo"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Pais'">
		
	                    <s:select label="País"
	                              name="vo.pais.id"
	                              list="listaPaises"
	                              listKey="id"
	                              listValue="nombre"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
		
					<s:if test="type == 'Seccion'">
		
	                    <s:select label="Sección"
	                              name="vo.seccion.id"
	                              value="vo.seccion.id"
	                              list="listaSecciones"
	                              listKey="id"
	                              listValue="nombre"
	                              headerKey="-1"
	                              headerValue="--Seleccione--"
			                      required="%{required}"
	                              disabled="%{disabled}" />
					</s:if>
	
				</s:if>

				<s:else>
					<s:hidden name="%{name}" value="%{value}"/>
				</s:else>

			</s:iterator>

            <%@ include file="/comun/calendar.jsp" %>
            <%@ include file="/comun/editor.jsp" %>

			<s:iterator value="fields" id="field">
				<s:if test="type == 'DateTime'">
					<script>
						calendar("${name}", "${name}", true);
					</script>
				</s:if>
				<s:elseif test="type == 'Date'">
					<script>
						calendar("${name}", "${name}", false);
					</script>
				</s:elseif>
				<s:elseif test="type == 'RichTextEditor'">
	                <script>
	                	editor("${name}");
					</script>
				</s:elseif>
			</s:iterator>

            <s:submit value="%{submitLabel}" />

        </s:form>
