<%-- 
    Author     : Alejandro
    Descripcion: Muestra la información de la empresa antes de denegar un pago.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <h2>Denegar pago</h2>
        
        <s:actionerror />
        <s:actionmessage />
        
        <p>
            <s:form action="denegarPago!realizarDenegar.html" cssClass="ram" namespace="/servicios/administracion/denegarPago" cssStyle="width:100%;">

				Verifique que los datos son correctos y confirme el envío de la notificación.
                
				<tr><td><br/></td></tr>

				<tr>
					<td>
						Email del usuario:
					</td>
					<td>
						<s:property value="empresa.usuario.email" />
					</td>
				</tr>
				<tr>
					<td>
						Id del plan:
					</td>
					<td>
						<s:property value="empresa.planSolicitado.id" />
					</td>
				</tr>
				<tr>
					<td>
						Precio del plan:
					</td>
					<td>
						<s:property value="empresa.planSolicitado.precio" />
					</td>
				</tr>
				<tr>
					<td>
						Nombre de la empresa:
					</td>
					<td>
					<s:property value="empresa.nombre" />
					</td>
				</tr>
				<tr>

				<s:textarea label="Mensaje" name="infoAdicional" value="%{infoAdicional}" wrap="true" rows="5" cssStyle="width:100%;" required="true" />

				<tr><td><br/></td></tr>

				<s:hidden name="idEmpresa" value="%{idEmpresa}" />
				<s:hidden name="documentoPagador" value="%{documentoPagador}" />
				<s:hidden name="numeroConsignacion" value="%{numeroConsignacion}" />
				<s:hidden name="totalPagado" value="%{totalPagado}" />
				<s:hidden name="fechaPago" value="%{fechaPago}" />

                <s:submit value="Denegar pago" />
                
            </s:form>
        </p>

        <div class="post">
            <div class="meta">
                <br/>
                <input align="right" type="button" value="Cancelar" onclick="history.back()" style="padding: 8px; height: 100%; width: 100%;" />
            </div>
        
        </div>
            

    </body>
</html>
