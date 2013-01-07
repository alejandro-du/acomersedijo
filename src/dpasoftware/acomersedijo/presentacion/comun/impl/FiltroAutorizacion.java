package dpasoftware.acomersedijo.presentacion.comun.impl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;

import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;

/**
 * Filtro para verificar el acceso a las urls solicitadas (requests).
 * @author Alejandro
 */
public class FiltroAutorizacion implements Filter {
    
    ICtrlServicio ctrlServicio;
    String error;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
        WebApplicationContext webAppContext = (WebApplicationContext) filterConfig.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ctrlServicio = (ICtrlServicio) webAppContext.getBean("ctrlServicio");
        
        // TODO: Corregir acoplamiento con los nombres (usar controlador que proporcione esta info).
        error = "/comun/error.jsp";
    }

    @Override
    public void destroy() {
    }
    
    public String obtenerUrlSolicitada(HttpServletRequest httpServletRequest, String webapp) {
        
        String url = httpServletRequest.getRequestURL().toString();
        
        while(url.contains(webapp)) {
            url = url.substring(url.indexOf(webapp) + webapp.length());
        }
        
        // obtener el parámetro id (único parámetro que se tiene en cuenta para validar urls)
        String sid = httpServletRequest.getParameter(ICtrlServicio.SID);
        
        if(sid != null) {
            url += "?" + ICtrlServicio.SID + "=" + sid;
        }
        
        return url;
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String webapp = httpServletRequest.getContextPath().toString();
        HttpSession sesion = httpServletRequest.getSession();
        Usuario usuarioSesion = (Usuario) sesion.getAttribute(ISesion.USUARIO_AUTENTICADO);
        
        // Si no se especifica el encoding, le indicamos que use el utf-8. De lo contrario, usaría el iso-8859-1
        if(servletRequest.getCharacterEncoding() == null) {
            servletRequest.setCharacterEncoding("utf-8");
        }
        //*
        String urlSolicitada = obtenerUrlSolicitada(httpServletRequest, webapp);
        
        // verificar si no se ha seleccionado una ciudad
        if(sesion.getAttribute(ISesion.CIUDAD) == null) {
            if(!urlSolicitada.contains("seleccionarCiudad")) {
                httpServletResponse.sendRedirect(webapp + "/servicios/seleccionarCiudad/");
                return;
            }
        }
        
        if(!ctrlServicio.usuarioPuedeAcceder(usuarioSesion, urlSolicitada)) {
            
            httpServletResponse.sendRedirect(webapp + error); // no puede acceder
            log("Usuario no autorizado (ip: " + httpServletRequest.getRemoteAddr() + ")", usuarioSesion, null, urlSolicitada);
            return;
        }
        
        Servicio servicioSolicitado = ctrlServicio.obtenerServicioPorUrl(urlSolicitada);
        
        if(servicioSolicitado != null) {
            sesion.setAttribute(ISesion.SERVICIO, servicioSolicitado);
        }
        //*/
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }
    
    private void log(String mensaje, Usuario usuario, Servicio servicioSolicitado, String urlSolicitada) {
        
        String str = "FiltroAutenticacion: " + mensaje;
        
        if(usuario != null) {
            str += " (Usuario id: " + usuario.getId() + ")";
        }
        
        if(servicioSolicitado != null) {
            str += " (Servicio: " + servicioSolicitado.getNombre() + ")";
        }
        
        str += " (Url: " + urlSolicitada + ")";
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, str);
    }
    
}
