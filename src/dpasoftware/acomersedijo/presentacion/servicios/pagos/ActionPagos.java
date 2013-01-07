package dpasoftware.acomersedijo.presentacion.servicios.pagos;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

public class ActionPagos extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private Empresa empresa;
	private String documentoPagador;
	private String numeroConsignacion;
	private String fechaPago;
	
	private ICtrlEmpresa ctrlEmpresa;
	
	public String inicio() {
		
		empresa = ctrlEmpresa.obtenerEmpresaPorUsuario(getUsuarioAutenticado());
		
		if(empresa == null) {
			addActionMessage("No se encontró su empresa.");
			return MENSAJE;
		}
		
		if(empresa.getPlan() == null || empresa.getPlanSolicitado().getPrecio() == null || empresa.getPlanSolicitado().getPrecio() <= 0) {
			addActionMessage("Este servicio es sólo para planes con características adicionales.");
			return MENSAJE;
		}
		
		if(empresa.getPlan().getFechaPago() != null && !empresa.getPlan().getFechaPago().equals("")) {
			addActionMessage("Su pago ya ha sido reportado y las características adicionales de su plan han sido activadas.");
			return MENSAJE;
		}
		
		if(empresa.getPlanSolicitado().getNotificacionPago()) {
			addActionMessage("Usted ya ha notificado su pago. Nuestros operadores están verificando la información enviada.");
			return MENSAJE;
		}
		
		return INPUT;
	}
	
	public String inicioNotificarPago() {
		return inicio();
	}
	
	public String notificarPago() {
    	
    	if(documentoPagador == null || documentoPagador.isEmpty()) {
    		addActionError("Debe especificar el documento del pagador.");
    		return INPUT;
    	}
		
    	if(numeroConsignacion == null || numeroConsignacion.isEmpty()) {
    		addActionError("Debe especificar el número de la consignación bancaria.");
    		return INPUT;
    	}
		
    	if(fechaPago == null || fechaPago.isEmpty()) {
    		addActionError("Debe especificar la fecha en la que se realizó la consignación.");
    		return INPUT;
    	}
		
		String resultado = ctrlEmpresa.enviarInformacionDePago(empresa.getId(), documentoPagador, numeroConsignacion, fechaPago);
		
		if(resultado != null) {
    		addActionError(resultado);
    		return INPUT;
		}
		
		addActionMessage("La información de su pago ha sido enviada.<br/><br/>" +
				"Una vez la consignación sea confirmada por uno de nuestros administradores, " +
				"podrá usar los servicios adicionales de su plan. " +
				"Le enviaremos una notificación vía email cuando su pago sea confirmado y su plan sea activado.<br/><br/>" +
				"Gracias.");
		
		return MENSAJE;
	}

	public String inicioPagoOnline() {
		return inicio();
	}
	
	public String pagoOnline() {
		return INPUT;
	}
	
	public ICtrlEmpresa getCtrlEmpresa() {
		return ctrlEmpresa;
	}

	public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
		this.ctrlEmpresa = ctrlEmpresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDocumentoPagador() {
		return documentoPagador;
	}

	public void setDocumentoPagador(String documentoPagador) {
		this.documentoPagador = documentoPagador;
	}

	public String getNumeroConsignacion() {
		return numeroConsignacion;
	}

	public void setNumeroConsignacion(String numeroConsignacion) {
		this.numeroConsignacion = numeroConsignacion;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
}
