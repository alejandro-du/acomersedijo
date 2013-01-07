package dpasoftware.acomersedijo.presentacion.servicios.editarAnuncio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.UrlValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.accesoDatos.vo.Zona;
import dpasoftware.acomersedijo.biz.controlador.ICtrlCiudad;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlRegistro;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSector;
import dpasoftware.acomersedijo.biz.controlador.ICtrlZona;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Alejandro.
 */
@Validation
public class ActionEditarAnuncio extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private Empresa empresa;
    private List<Sector> listaSectores; // lista de todos los sectores
    private List<Ciudad> listaCiudades; // lista de todos las ciudades
    private List<Zona> listaZonas; // lista de todos las zonas
    private boolean eliminarImagen;
    
    private ICtrlRegistro ctrlAnunciante;
    private ICtrlEmpresa ctrlEmpresa;
    private ICtrlSector ctrlSector;
    private ICtrlCiudad ctrlCiudad;
    private ICtrlZona ctrlZona;
    private ICtrlPlan ctrlPlan;

    
    public void cargarZonas() {
        
        if(empresa != null && empresa.getZona() != null && empresa.getZona().getCiudad() != null) {
            listaZonas = ctrlZona.buscarPorCiudadId(empresa.getZona().getCiudad().getId());
        }
        
        if(listaZonas == null) {
            listaZonas = new ArrayList<Zona>();
        }
    }
    
    @Override
    public void prepare() {
        
        super.prepare();
        
        setListaSectores(getCtrlSector().buscarTodosLosSectores());
        setListaCiudades(getCtrlCiudad().buscarTodasLasCiudades());
        cargarZonas();
        
        if(empresa != null) {
            Empresa empresaAntigua = ctrlEmpresa.obtenerEmpresaPorId(empresa.getId());

            if(empresaAntigua == null || !ctrlPlan.validarPlan(empresaAntigua.getPlan())) {
                addActionError("Ha ocurrido un error con la configuración.");
            }
            
            empresa.setPlan(empresaAntigua.getPlan());
        }
        
    }
    
    public String inicio() {
        
        empresa = ctrlEmpresa.obtenerEmpresaPorUsuario((Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO));
        cargarZonas();
        return OK;
    }

    // NOTA: Las validaciones deben ser congruentes con el servicio "Administrar empresas".
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="empresa.nombre", message="Debe especificar un nombre."),
            @RequiredStringValidator(fieldName="empresa.direccion", message="Debe especificar una dirección."),
            @RequiredStringValidator(fieldName="empresa.precioPromedio", message="Debe especificar un precio promedio del plato.")
        },
        requiredFields= {
            @RequiredFieldValidator(key="", fieldName="empresa.sector.id", message="Debe seleccionar una especialidad."),
            @RequiredFieldValidator(fieldName="empresa.zona.id", message="Debe seleccionar una zona."),
            @RequiredFieldValidator(fieldName="empresa.plan", message="El plan es nulo.")
        },
        stringLengthFields={
            @StringLengthFieldValidator(fieldName="empresa.nombre", message="El nombre debe tener entre 1 y 50 caracteres.", minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="empresa.telefono", message="El telefono debe tener entre 1 y 50 caracteres.", minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="empresa.direccion", message="La dirección debe tener entre 1 y 50 caracteres.", minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="empresa.email", message="El email debe tener entre 5 y 80 caracteres.", minLength="5", maxLength="80"),
            @StringLengthFieldValidator(fieldName="empresa.website", message="La URL del website debe tener entre 1 y 100 caracteres.", minLength="1", maxLength="100"),
            @StringLengthFieldValidator(fieldName="empresa.precioPromedio", message="El precio promedio debe tener entre 1 y 50 caracteres.", minLength="1", maxLength="50")
        },
        urls= {
            @UrlValidator(fieldName="empresa.website", message="Debe proporcionar una url válida (http, https o ftp).")
        },
        regexFields={
            @RegexFieldValidator(fieldName="empresa.precioPromedio", message="El precio promedio sólo puede contener números, signos de moneda ($), comillas sencillas (') y puntos (.).", expression="[0-9$'.]*"),
            @RegexFieldValidator(fieldName="empresa.telefono", message="El teléfono sólo puede contener espacios, guiones, letras y números.", expression="[0-9A-Za-z- ]*"),
            @RegexFieldValidator(fieldName="empresa.puntos", message="El campo puntos sólo puede contener números.", expression="[0-9]*")
            },
        emails={@EmailValidator(fieldName="empresa.email", message="Debe especificar un email válido.")}
    )
    public String guardarAnuncio() {
        
        Empresa empresaAntigua = ctrlEmpresa.obtenerEmpresaPorId(empresa.getId());
        
        if(empresaAntigua == null || !ctrlPlan.validarPlan(empresaAntigua.getPlan())) {
            addActionError("No se pudo guardar su anuncio. Ha ocurrido un error con la configuración.");
            return INPUT;
        }
        
        empresa.setPlan(empresaAntigua.getPlan());
        
        if(empresa.getAnuncio() != null && empresa.getAnuncio().length() > empresa.getPlan().getCaracteresHtml()) {
            addActionError("Su anuncio tiene " + empresa.getAnuncio().length() + " caracteres HTML. Su plan permite hasta " + empresa.getPlan().getCaracteresHtml() + " caracteres HTML.");
            return INPUT;
        }
        
        MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest();
        File files[] = multiWrapper.getFiles("imagen");
        File file = null;
        
        if(files != null && files.length > 0) {
             file = files[0];
        }

        if (multiWrapper.hasErrors()) {
            addActionError("No se puede guardar el archivo de imagen.");
            return INPUT;
        }
        
        if(!ctrlEmpresa.guardarAnuncio(empresa, (Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO), file, ServletActionContext.getServletContext().getRealPath("/"), getSesion().getContextPath(), eliminarImagen)) {
            addActionError("No se puede guardar el anuncio.");
            return ERROR;
        }
        
        addActionMessage("Su anuncio ha sido guardado y publicado.");
        return INPUT;
    }
    
    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Sector> getListaSectores() {
        return listaSectores;
    }

    public void setListaSectores(List<Sector> listaSectores) {
        this.listaSectores = listaSectores;
    }

    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public ICtrlEmpresa getCtrlEmpresa() {
        return ctrlEmpresa;
    }

    public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
        this.ctrlEmpresa = ctrlEmpresa;
    }

    public ICtrlSector getCtrlSector() {
        return ctrlSector;
    }

    public void setCtrlSector(ICtrlSector ctrlSector) {
        this.ctrlSector = ctrlSector;
    }

    public ICtrlCiudad getCtrlCiudad() {
        return ctrlCiudad;
    }

    public void setCtrlCiudad(ICtrlCiudad ctrlCiudad) {
        this.ctrlCiudad = ctrlCiudad;
    }

    public ICtrlRegistro getCtrlAnunciante() {
        return ctrlAnunciante;
    }

    public void setCtrlAnunciante(ICtrlRegistro ctrlAnunciante) {
        this.ctrlAnunciante = ctrlAnunciante;
    }

    public boolean isEliminarImagen() {
        return eliminarImagen;
    }

    public void setEliminarImagen(boolean eliminarImagen) {
        this.eliminarImagen = eliminarImagen;
    }

    public ICtrlPlan getCtrlPlan() {
        return ctrlPlan;
    }

    public void setCtrlPlan(ICtrlPlan ctrlPlan) {
        this.ctrlPlan = ctrlPlan;
    }

    public ICtrlZona getCtrlZona() {
        return ctrlZona;
    }

    public void setCtrlZona(ICtrlZona ctrlZona) {
        this.ctrlZona = ctrlZona;
    }

    public List<Zona> getListaZonas() {
        return listaZonas;
    }

    public void setListaZonas(List<Zona> listaZonas) {
        this.listaZonas = listaZonas;
    }

}
