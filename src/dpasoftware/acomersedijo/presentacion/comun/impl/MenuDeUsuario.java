package dpasoftware.acomersedijo.presentacion.comun.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlBanner;
import dpasoftware.acomersedijo.biz.controlador.ICtrlMenu;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSector;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;
import dpasoftware.acomersedijo.presentacion.comun.IMenuDeUsuario;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;

public class MenuDeUsuario implements IMenuDeUsuario {
    
    private String nombre = "";
    private String url = "";
    private List<IMenuDeUsuario> submenuList = new ArrayList<IMenuDeUsuario>();
    
    private ICtrlMenu ctrlMenu;
    private ICtrlServicio ctrlServicio;
    private ICtrlSector ctrlSector;
    private ISesion sesion;
    private ICtrlBanner ctrlBanner;
    
    public void agregarSubmenu(IMenuDeUsuario submenu) {
        getSubmenuList().add(submenu);
    }
    
    public void construirMenu(Usuario usuario, String webContextPath) {
        
        getSubmenuList().clear();
        this.setNombre("Menú principal");
        
        if(webContextPath == null) {
            webContextPath = getSesion().getContextPath();
        }
        
        for(Menu menu : getCtrlMenu().buscarTodosLosMenus()) {
            
            MenuDeUsuario submenu = new MenuDeUsuario();
            submenu.setNombre(menu.getNombre());
            
            for(Servicio servicio : getCtrlServicio().buscarServiciosDelMenu(menu)) {
                
                if(getCtrlServicio().usuarioPuedeAcceder(usuario, servicio)) {
                	
                	// no mostrar la opción iniciar sesión si el usuario está autenticado
                	// TODO: Corregir acoplamiento con el nombre del servicio. Usar controlador.
                	if(usuario == null || usuario.getId() == null || !servicio.getNombre().equals("Iniciar sesión")) {
                        MenuDeUsuario opcion = new MenuDeUsuario();
                        opcion.setNombre(servicio.getNombre());
                        opcion.setUrl(webContextPath + servicio.getUrl());
                        submenu.getSubmenuList().add(opcion);
                	}
                }
            }
            
            if(submenu.getSubmenuList() != null && submenu.getSubmenuList().size() > 0) {
                this.agregarSubmenu(submenu);
            }
        }
    }

    public String getJavaScript(String webContextPath, String realPath) {
        
        if(webContextPath == null) {
            webContextPath = getSesion().getContextPath();
        }
        
        String script = "";
        
        // sectores
        
        List<Sector> listaSectores = ctrlSector.buscarTodosLosSectores();
        
        script += "<div id=\"categories\" class=\"boxed\"><h2 class=\"heading\">Especialidades</h2>";
        script += "<div class=\"content\">";
        script += "<ul id=\"sectores\">";
        
        for(Sector sector : listaSectores) {
            
            script += "<li><a href=\"" + webContextPath + "/servicios/empresas/verSector.html?id=" + sector.getId() + "\">" + sector.getNombre() + "</a></li>";
        }
        
        script += "</ul>";
        script += "</div>";
        script += "</div>";
        
        // servicios
        
        List<IMenuDeUsuario> listaMenu = this.getSubmenuList();
        
        if(this.getSubmenuList() == null) {
            return script;
        }
        
        int i = 1;
        
        for(IMenuDeUsuario menu : listaMenu) { // cada menú
            
            String idMenu = "menu" + i++;
            
            script += "<div id=\"blogroll\" class=\"boxed\"> ";
            script += "<h2 class=\"heading\">" + menu.getNombre() + "</h2>";
            script += "<div class=\"content\">";
            script += "<ul id=\"" + idMenu + "\">";
            
            for(IMenuDeUsuario opcion : menu.getSubmenuList()) { // cada opción
                script += "<li><a href=\"" + opcion.getUrl() + "\">" + opcion.getNombre() + "</a></li>";
            }
            
            script += "</ul>";
            script += "</div>";
            script += "</div>";
        }
        
        Ciudad ciudad = (Ciudad) getSesion().getObjetoDeSesion(ISesion.CIUDAD);
        
        script += "<div class='boxed' style='border:0px;'>";
        script += "<img src='" + webContextPath + ctrlBanner.obtenerUrlBanner(ciudad, ctrlBanner.getTipoAsm(), realPath) + "' />";
        script += "</div>";

        script += ctrlBanner.obtenerUrlBanner(ciudad, ctrlBanner.getTipoAim(), webContextPath + "/servicios/empresas/verEmpresa.html?id=");
        
        return script;
    }
    
    public void cargarMenuEnSesion(Usuario usuario, HttpSession httpSession) {
        
        this.construirMenu((Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO), null);
        getSesion().setObjetoDeSesion(ISesion.JAVASCRIPT_MENU, this.getJavaScript(null, httpSession.getServletContext().getRealPath("/")));
    }

    public void cargarMenuEnSesion(Usuario usuario, String webContextPath, HttpSession httpSession) {
        
        this.construirMenu((Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO), webContextPath);
        httpSession.setAttribute(ISesion.JAVASCRIPT_MENU, this.getJavaScript(webContextPath, httpSession.getServletContext().getRealPath("/")));
    }

    public List<IMenuDeUsuario> getSubmenuList() {
        return submenuList;
    }

    public void setSubmenuList(List<IMenuDeUsuario> submenuList) {
        this.submenuList = submenuList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public

    ICtrlMenu getCtrlMenu() {
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

    public ISesion getSesion() {
        return sesion;
    }

    public void setSesion(ISesion sesion) {
        this.sesion = sesion;
    }

    public ICtrlSector getCtrlSector() {
        return ctrlSector;
    }

    public void setCtrlSector(ICtrlSector ctrlSector) {
        this.ctrlSector = ctrlSector;
    }

    public ICtrlBanner getCtrlBanner() {
        return ctrlBanner;
    }

    public void setCtrlBanner(ICtrlBanner ctrlBanner) {
        this.ctrlBanner = ctrlBanner;
    }

}
