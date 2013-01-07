<%-- 
    Author     : Alejandro
    Description: Permite colocar un "captcha" en un formulario.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/comun/include.jsp"%>


<script>

	var nReload = 5;
	
	function generarImagen() {
		
	    if (nReload <= 0) {
	        alert("No es posible generar más imágenes.");
	        return false;
	    }
	    
		nReload--;
		document.captchaImg.src = document.captchaImg.src + '?' + Math.floor(Math.random() * 100);
		return true;
	}
    
</script>

<tr>
	<td></td>

	<td>
		<s:url id="captcha" value="/captcha" />
		<img style="width: 145px;" src="${captcha}" name="captchaImg" onclick="generarImagen();" />
		<h3 class="posted">Haga clic sobre la imagen para obtener una nueva.</h3>		
	</td>

</tr>

<s:textfield label="Código de seguridad" name="captcha" value="" required="true" />
