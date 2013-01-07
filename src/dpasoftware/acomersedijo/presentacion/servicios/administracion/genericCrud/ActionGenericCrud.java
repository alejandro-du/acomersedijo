package dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import org.apache.struts2.ServletActionContext;

import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;
import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.accesoDatos.vo.Pais;
import dpasoftware.acomersedijo.accesoDatos.vo.Plan;
import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.accesoDatos.vo.Zona;
import dpasoftware.acomersedijo.biz.controlador.ICtrlArticulo;
import dpasoftware.acomersedijo.biz.controlador.ICtrlCiudad;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEvento;
import dpasoftware.acomersedijo.biz.controlador.ICtrlGrupo;
import dpasoftware.acomersedijo.biz.controlador.ICtrlMenu;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPais;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSeccion;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSector;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlZona;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;


/**
*
* @author Alejandro
*/
public abstract class ActionGenericCrud<T> extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	public static final String SEARCH = "search";
	public static final String LIST = "list";
	public static final String READ = "read";
	public static final String UPDATE = "update";
	public static final String CREATE = "create";
	
	private String crudTitle;
	private List<Field> fields;
	private Long id;
	
    private ICtrlPlan ctrlPlan;
    private ICtrlGrupo ctrlGrupo;
    private ICtrlCiudad ctrlCiudad;
    private ICtrlMenu ctrlMenu;
    private ICtrlServicio ctrlServicio;
    private ICtrlZona ctrlZona;
    private ICtrlSector ctrlSector;
    private ICtrlUsuario ctrlUsuario;
    private ICtrlEvento ctrlEvento;
    private ICtrlArticulo ctrlArticulo;
    private ICtrlPais ctrlPais;
    private ICtrlSeccion ctrlSeccion;
    private ICtrlEmpresa ctrlEmpresa;
    
    public abstract List<T> getLista();
	public abstract T getVo();
	public abstract T getVo(Long id);
	public abstract void setVo(T vo);
	public abstract boolean eliminarVo();
	public abstract boolean guardarVo();
	
	
    @SuppressWarnings("unchecked")
	public void prepare() {
    	
    	super.prepare();
    	
    	if(getVo() == null) {
    		
    		Class<T> clase = null;
            Type genericSuperclass = getClass().getGenericSuperclass();
    		
            if (genericSuperclass instanceof ParameterizedType) {
                try {
                    ParameterizedType paramType = (ParameterizedType) genericSuperclass;
                    clase = (Class<T>) paramType.getActualTypeArguments()[0];
                    setVo(clase.newInstance());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
    	}
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String createFields(String action, boolean defaultHideId) {
		
		Class<T> clase = null;
        Type genericSuperclass = getClass().getGenericSuperclass();
		
        if (genericSuperclass instanceof ParameterizedType) {
            try {
                ParameterizedType paramType = (ParameterizedType) genericSuperclass;
                clase = (Class<T>) paramType.getActualTypeArguments()[0];

            } catch (Exception ex) {
                ex.printStackTrace();
                return ERROR;
            }
        }
        
		Method metodos[] = clase.getMethods();
		fields = new ArrayList<Field>();
		
		Properties prop = new Properties();

	    try {
	        prop.load(new FileInputStream(ServletActionContext.getServletContext().getRealPath("/").replace("\\", "/") + "WEB-INF/classes/crud.properties"));
	        
	    } catch (IOException e) {
	    	// no se han definido propiedades, usar valores por defecto
	    }
	    
		crudTitle = prop.getProperty("crud." + clase.getSimpleName() + ".title");

		for(Method m : metodos) {
			
			if(m.getName().startsWith("get") && !m.getName().equals("getClass")) {
				
				Field f = new Field();
				
				// obtener el nombre del campo correspondiente al getter
				String label = m.getName().substring(3); // primera en mayúscula
				String property = ("" + label.charAt(0)).toLowerCase() + label.substring(1); // primera en minúscula
				String name = property;
				
				f.setProperty(property);
				f.setName("vo." + name);
				f.setLabel(label);
				f.setSortable("true");
				f.setEscapeXml("false");
				f.setHidden(false);
				f.setDisabled("false");
				f.setReadOnly("false");
				f.setRequired("false");
				
				if(m.isAnnotationPresent(Column.class)) {
					if(!m.getAnnotation(Column.class).nullable()) {
						f.setRequired("true");
					}
				}
				else if(m.isAnnotationPresent(JoinColumn.class)) {
					if(!m.getAnnotation(JoinColumn.class).nullable()) {
						f.setRequired("true");
					}
				}
				
				if(property.equals("id")) {
					f.setHidden(defaultHideId);
				}
			
				
				if(getVo() != null) {
					
					try {
						Object value = "";
						
						if(m.getReturnType().getSimpleName().equals("List")) {
							
							List list = (List) m.invoke(getVo());
							
							if(list != null) {
								for(Object o : list) {
									value = "" + value + o + "<br/>";
								}
							}
						}
						else {
							value = m.invoke(getVo());
							if(value == null) {
								value = "";
							}
						}
						
						f.setValue("" + value);
						
					} catch (Exception e) {
						e.printStackTrace();
						return ERROR;
					}
				}
				
				String type = prop.getProperty("crud." + clase.getSimpleName() + "." + action + "." + name + ".type");
				String hidden = prop.getProperty("crud." + clase.getSimpleName() + "." + action + "." + name + ".hidden");
				String sortable = prop.getProperty("crud." + clase.getSimpleName() + "." + action + "." + name + ".sortable");
				String escapeXml = prop.getProperty("crud." + clase.getSimpleName() + "." + action + "." + name + ".escapeXml");
				String labelProp = prop.getProperty("crud." + clase.getSimpleName() + "." + action + "." + name + ".label");
				String disabled = prop.getProperty("crud." + clase.getSimpleName() + "." + action + "." + name + ".disabled");
				String readOnly = prop.getProperty("crud." + clase.getSimpleName() + "." + action + "." + name + ".readOnly");
				
				if(hidden != null) {
					f.setHidden(hidden.equals("true"));
				}
				if(sortable != null) {
					f.setSortable(sortable);
				}
				if(escapeXml != null) {
					f.setEscapeXml(escapeXml);
				}
				if(labelProp != null) {
					f.setLabel(labelProp);
				}
				if(disabled != null) {
					f.setDisabled(disabled);
				}
				if(readOnly != null) {
					f.setReadOnly(readOnly);
				}
				
				if(type != null) {
					f.setType(type);
				}
				else {
					
					String typeParameter = "" + m.getGenericReturnType();
					String returnType = m.getReturnType().getSimpleName();
					
					if(typeParameter.contains("List") || typeParameter.contains("Set")) {
						typeParameter = "<" + typeParameter.substring(typeParameter.lastIndexOf(".") + 1);
					}
					else {
						typeParameter = "";
					}
					
					if(name.toLowerCase().contains("fecha")) {
						returnType = "DateTime";
					}
					
					f.setType(returnType + typeParameter);
				}
				
				fields.add(f);
			}
		}
		
		return action;
	}
	
	public String search() {
		return createFields(SEARCH, true);
	}
	
	public String doSearch() {
		return createFields(LIST, false);
	}
	
	public String doRead() {
		setVo(getVo(id));
		return createFields(READ, false);
	}
	
	public String doDelete() {
		
		setVo(getVo(id));
		
		if(!eliminarVo()) {
			addActionError("No se pudo eliminar el registro.");
			return createFields(READ, false);
		}
		
		setVo(null);
		addActionMessage("Registro eliminado.");
		return createFields(SEARCH, true);
	}
	
	public String update() {
		setVo(getVo(id));
		return createFields(UPDATE, true);
	}
	
	public String doUpdate() {
		return doSave("No se pudo modificar el registro.", "Registro modificado.", UPDATE, SEARCH, true, true);
	}
	
	public String create() {
		return createFields(CREATE, true);
	}
	
	public String doCreate() {
		return doSave("No se pudo guardar el registro.", "Registro guardado.", CREATE, SEARCH, true, true);
	}
	
	public String doSave(String errorMessage, String successMessage, String errorReturn, String successReturn, boolean errorDefaultShowId, boolean successDefaultShowId) {
		
		if(!guardarVo()) {
			addActionError(errorMessage);
			return createFields(errorReturn, errorDefaultShowId);
		}
		
		setVo(null);
		addActionMessage(successMessage);
		
		return createFields(successReturn, successDefaultShowId);
	}
	
	
	
	// Getters para listas
	
	public List<Grupo> getListaGrupos() {
		return ctrlGrupo.buscarTodosLosGrupos();
	}
	
	public List<Empresa> getListaEmpresas() {
		return ctrlEmpresa.buscarTodasLasEmpresas();
	}
	
	public List<Ciudad> getListaCiudades() {
		return ctrlCiudad.buscarTodasLasCiudades();
	}
	
	public List<Menu> getListaMenus() {
		return ctrlMenu.buscarTodosLosMenus();
	}
	
	public List<Servicio> getListaServicios() {
		return ctrlServicio.buscarTodosLosServicios();
	}
	
	public List<Zona> getListaZonas() {
		return ctrlZona.buscarTodasLasZonas();
	}
	
	public List<Sector> getListaSectores() {
		return ctrlSector.buscarTodosLosSectores();
	}
	
	public List<Usuario> getListaUsuarios() {
		return ctrlUsuario.buscarTodosLosUsuarios();
	}
	
	public List<Evento> getListaEventos() {
		return ctrlEvento.buscarTodosLosEventos();
	}
	
	public List<Articulo> getListaArticulos() {
		return ctrlArticulo.buscarTodosLosArticulos();
	}
	
	public List<Pais> getListaPaises() {
		return ctrlPais.buscarTodosLosPaises();
	}
	
	public List<Seccion> getListaSecciones() {
		return ctrlSeccion.buscarTodasLasSecciones();
	}
	
	public List<Plan> getListaPlanes() {
		return ctrlPlan.buscarTodosLosPlanes();
	}
	
	
	
	
	
	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public ICtrlPlan getCtrlPlan() {
		return ctrlPlan;
	}
	
	public void setCtrlPlan(ICtrlPlan ctrlPlan) {
		this.ctrlPlan = ctrlPlan;
	}

	public ICtrlGrupo getCtrlGrupo() {
		return ctrlGrupo;
	}

	public void setCtrlGrupo(ICtrlGrupo ctrlGrupo) {
		this.ctrlGrupo = ctrlGrupo;
	}

	public ICtrlCiudad getCtrlCiudad() {
		return ctrlCiudad;
	}

	public void setCtrlCiudad(ICtrlCiudad ctrlCiudad) {
		this.ctrlCiudad = ctrlCiudad;
	}

	public ICtrlMenu getCtrlMenu() {
		return ctrlMenu;
	}

	public void setCtrlMenu(ICtrlMenu ctrlMenu) {
		this.ctrlMenu = ctrlMenu;
	}

	public ICtrlServicio getCtrlServicio() {
		return ctrlServicio;
	}

	public void setCtrlServicio(ICtrlServicio ctrlServicio) {
		this.ctrlServicio = ctrlServicio;
	}

	public ICtrlZona getCtrlZona() {
		return ctrlZona;
	}

	public void setCtrlZona(ICtrlZona ctrlZona) {
		this.ctrlZona = ctrlZona;
	}

	public ICtrlSector getCtrlSector() {
		return ctrlSector;
	}

	public void setCtrlSector(ICtrlSector ctrlSector) {
		this.ctrlSector = ctrlSector;
	}

	public ICtrlUsuario getCtrlUsuario() {
		return ctrlUsuario;
	}

	public void setCtrlUsuario(ICtrlUsuario ctrlUsuario) {
		this.ctrlUsuario = ctrlUsuario;
	}

	public ICtrlEvento getCtrlEvento() {
		return ctrlEvento;
	}

	public void setCtrlEvento(ICtrlEvento ctrlEvento) {
		this.ctrlEvento = ctrlEvento;
	}

	public ICtrlArticulo getCtrlArticulo() {
		return ctrlArticulo;
	}

	public void setCtrlArticulo(ICtrlArticulo ctrlArticulo) {
		this.ctrlArticulo = ctrlArticulo;
	}

	public ICtrlPais getCtrlPais() {
		return ctrlPais;
	}

	public void setCtrlPais(ICtrlPais ctrlPais) {
		this.ctrlPais = ctrlPais;
	}

	public ICtrlSeccion getCtrlSeccion() {
		return ctrlSeccion;
	}

	public void setCtrlSeccion(ICtrlSeccion ctrlSeccion) {
		this.ctrlSeccion = ctrlSeccion;
	}

	public String getCrudTitle() {
		return crudTitle;
	}

	public void setCrudTitle(String crudTitle) {
		this.crudTitle = crudTitle;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public ICtrlEmpresa getCtrlEmpresa() {
		return ctrlEmpresa;
	}

	public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
		this.ctrlEmpresa = ctrlEmpresa;
	}

}
