package dpasoftware.acomersedijo.presentacion.servicios.administracion.registrarPago;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

@Validation
public class ActionRegistrarPago extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	
	private static final String DATOS_EMPRESA = "datosEmpresa";
	
	private Long idEmpresa;
	private String documentoPagador;
	private String numeroConsignacion;
	private String totalPagado;
	private String fechaPago;
	private Empresa empresa;
	
	private ICtrlEmpresa ctrlEmpresa;

	public String inicio() {
		return INPUT;
	}
	
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="documentoPagador", message="Debe especificar el documento del pagador."),
            @RequiredStringValidator(fieldName="numeroConsignacion", message="Debe especificar el número de la consignación bancaria."),
            @RequiredStringValidator(fieldName="totalPagado", message="Debe especificar el total pagado."),
            @RequiredStringValidator(fieldName="fechaPago", message="Debe especificar la fecha del pago.")
        },
        requiredFields={
        	@RequiredFieldValidator(fieldName="idEmpresa", message="Debe especificar el id de la empresa.")
        }
    )
	public String registrarPago() {
		
		empresa = ctrlEmpresa.obtenerEmpresaPorId(idEmpresa);
		
		if(empresa == null) {
			addActionError("No se encontró la empresa con el id especificado.");
			return INPUT;
		}
		
		return DATOS_EMPRESA;
	}
	
	public String realizarRegistro() {
		
		String resultado = ctrlEmpresa.registrarPago(idEmpresa, documentoPagador, numeroConsignacion, totalPagado, fechaPago);
		
		if(resultado != null) {
			addActionError(resultado);
			return INPUT;
		}
		
		addActionMessage("Pago confirmado satisfactoriamente.");
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

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
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

}
