<%-- 
    Author     : Alejandro
    Descripcion: Muestra el formulario para denegar un pago.
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
            <s:form action="/servicios/administracion/denegarPago/denegarPago.html" cssClass="ram">
                
                <%@ include file="/comun/notaCamposObligatorios.jsp" %>

                <s:textfield label="Id de la empresa" name="idEmpresa" required="true" />
                <s:textfield label="Documento del pagador" name="documentoPagador" required="true" />
                <s:textfield label="Número de consignación" name="numeroConsignacion" required="true" />
                <s:textfield label="Total pagado" name="totalPagado" required="true" />

                <s:textfield label="Fecha del pago" name="fechaPago" id="fecha" readonly="true" required="true" />
                <%@ include file="/comun/calendar.jsp" %>
                <script>calendar("fecha", "fecha", true)</script>

                <s:submit value="Verificar información" />
                
            </s:form>
        </p>

    </body>
</html>
