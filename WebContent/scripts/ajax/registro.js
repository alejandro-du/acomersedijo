

function mostrarImagen(n) {
    
    for(i = 0; i <= 7; i++) {
        var div = document.getElementById("imagen" + i);
        if(i == n) {
            div.style.display = "block";
        }
        else {
            div.style.display = "none";
        }
    }
    
}


function actualizarPrecio() {

    dwr.util.setValue("total", "Calculando...");

    AjaxRegistro.calcularPrecioTotal(
        document.getElementById("imagen").checked,
        document.getElementById("linkWebsite").checked,
        document.getElementById("bannerAdt").checked,
        document.getElementById("bannerAib").checked,
        document.getElementById("bannerAii").checked,
        document.getElementById("bannerAim").checked,
        document.getElementById("bannerAsm").checked,
        dwr.util.getValue("estrellas"),
        dwr.util.getValue("caracteresHtml"),
        function(data)
    {
        var formaPagoDiv = document.getElementById("formaPago");
        
        if(data == null || data == "$,00") {
        	dwr.util.setValue("total", "GRATIS");
        	document.getElementById("notaFormasPago").style.display = "none";
        }
        else {
        	dwr.util.setValue("total", "" + data);
        	document.getElementById("notaFormasPago").style.display = "";
        }
    });

}

