<%-- 
    Author     : Alejandro
    Descripcion: Encabezado para decorar las páginas.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp" %>

<link rel="shortcut icon" href="<s:url value='/images/icons/favicon.png' encode='false' includeParams='none'/>">
<link rel="icon" href="<s:url value='/images/icons/favicon.png' encode='false' includeParams='none'/>">
            
<%@ page import="dpasoftware.acomersedijo.presentacion.comun.ISesion" %>
<s:url id="inicio" value="/" includeParams="false" />

<div id="header">
    
    <h1>
        <a href="${inicio}">
            ¡A comer se dijo!
        </a>
    </h1>
    
	<s:property value="#session['ciudad'].nombre" />
    <br/>
    
    <s:url id="urlSeleccionarCiudad" value="/servicios/seleccionarCiudad/" includeParams="false"/>
    <a style="font: normal .75em Tahoma, Arial, Helvetica, sans-serif;" href="${urlSeleccionarCiudad}">Seleccionar otra ciudad</a>
    
</div>

<s:url id="contactenos" value="/" includeParams="false" />
<s:url id="registro" value="/servicios/registrarse" includeParams="false" />
        
<div id="pages">
    
    <table>
        <tr>
            <td style="padding-left: 120px;">
            </td>
            
            <td>
                <a href="${inicio}">
                    Inicio
                </a>
            </td>
            <td>
                <s:url id="contactenos" value="/servicios/contactenos" includeParams="false" />
                <a href="${contactenos}">
                    Contáctenos
                </a>
            </td>
            <td>
                <a href="${registro}">
                    Registre su restaurante
                </a>
            </td>
        </tr>
    </table>
    
    
</div>
