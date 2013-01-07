package dpasoftware.acomersedijo.presentacion.servicios.administracion.denegarPago;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

@Validation
public class ActionDenegarPago extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	
	private static final String DATOS_EMPRESA = "datosEmpresa";
	
	private Long idEmpresa;
	private String documentoPagador;
	private String numeroConsignacion;
	private String totalPagado;
	private String fechaPago;
	private Empresa empresa;
	private String infoAdicional;
	
	private ICtrlEmpresa ctrlEmpresa;

	public String inicio() {
		return INPUT;
	}
	
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="documentoPagador", message="Debe especificar el documento del pagador."),
            @RequiredStringValidator(fieldName="numeroConsignacion", message="Debe especificar el número de la consignación bancaria."),
            @RequiredStringValidator(fieldName="totalPagado", message="Debe especificar el total pagado."),
            @RequiredStringValidator(fieldName="fechaPago", message="Debe especificar la fecha de pago.")
        },
        requiredFields={
        	@RequiredFieldValidator(fieldName="idEmpresa", message="Debe especificar el id de la empresa.")
        }
    )
	public String denegarPago() {
		
		empresa = ctrlEmpresa.obtenerEmpresaPorId(idEmpresa);
		
		if(empresa == null) {
			addActionError("No se encontró la empresa con el id especificado.");
			return INPUT;
		}
		
		infoAdicional = "Los datos que suministró al confirmar su pago no corresponden con ningúna consignación en nuestra " +
						"cuenta bancaria. Por favor verifique que introdujo los datos correctamente e intente de nuevo. Gracias.";

		return DATOS_EMPRESA;
	}
	
	public String realizarDenegar() {
		
		if(infoAdicional == null || infoAdicional.isEmpty()) {
			addActionError("Debe especificar un mensaje.");
			return INPUT;
		}
		
		String resultado = ctrlEmpresa.denegarPago(idEmpresa, documentoPagador, numeroConsignacion, totalPagado, fechaPago, infoAdicional);
		
		if(resultado != null) {
			addActionError(resultado);
			return INPUT;
		}
		
		addActionMessage("Notificación de pago denegado enviada satisfactoriamente.");
		return INPUT;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(String totalPagado) {
		this.totalPagado = totalPagado;
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

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

}
