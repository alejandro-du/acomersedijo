
function cargarZonas(listaCiudades, listaZonas, header, headerKey) {
    
    if(dwr.util.getValue(listaCiudades) == headerKey) {
        
        dwr.util.removeAllOptions(listaZonas);
        dwr.util.addOptions(listaZonas, header);
        return;
    }
    
    dwr.util.removeAllOptions(listaZonas);
    dwr.util.addOptions(listaZonas, ["Cargando zonas..."]);

    AjaxZona.obtenerZonas(
        dwr.util.getValue(listaCiudades),
        function(data)
    {
        dwr.util.removeAllOptions(listaZonas);
        dwr.util.addOptions(listaZonas, header);
        dwr.util.addOptions(listaZonas, data);
    });

}
