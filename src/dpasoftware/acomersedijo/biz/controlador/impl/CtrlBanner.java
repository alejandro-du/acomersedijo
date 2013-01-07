package dpasoftware.acomersedijo.biz.controlador.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.biz.comun.IImageUploader;
import dpasoftware.acomersedijo.biz.controlador.ICtrlBanner;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;

/**
 *
 * @author Alejandro
 */
public class CtrlBanner implements ICtrlBanner {
    
    private String tipoAib;
    private String tipoAii;
    private String tipoAim;
    private String tipoAsm;
    private String tipoAdt;
    private String directorioBanners;
    private Integer anchoAdt;
    private Integer anchoAib;
    private Integer anchoAii;
    private Integer anchoAsm;
    private Integer altoAdt;
    private Integer altoAib;
    private Integer altoAii;
    private Integer altoAsm;
    private Integer numeroEmpresasBannerAim;
    
    private ICtrlEmpresa ctrlEmpresa;
    private IImageUploader imageUploader;

    public String obtenerUrlBanner(Ciudad ciudad, String tipo, String path) {
        
        List<Empresa> lista = null;
        String banner = "";
        Random rand = new Random();
        rand.setSeed(Calendar.getInstance().getTimeInMillis());
        
        if(tipo.equals(getTipoAim())) {
            
            lista = ctrlEmpresa.buscarEmpresasAim(ciudad);
            
            if(lista != null && lista.size() > 0) {
                
                banner = "<div class='aim'><h3>Recomendados</h3>";
                        
                for(int i = 0; i < numeroEmpresasBannerAim; i++) {
                    
                    if(lista.isEmpty()) {
                        break;
                    }
                    
                    Empresa e = lista.get(rand.nextInt(lista.size()));
                    lista.remove(e);
                    banner += "<a href='" + path + e.getId() + "'>";
                    banner += e.getNombre();
                    banner += "</a>";
                    banner += "<br/>";
                }
                
                banner += "</div>";
            }
        }
        else {
            
            List<Empresa> listaSinUrlNull = new ArrayList<Empresa>();
            
            if(tipo.equals(getTipoAii())) {
                
            	lista = ctrlEmpresa.buscarEmpresasAii(ciudad);
                
                if(lista == null || lista.size() <= 0) {
                	banner = "/" + directorioBanners + tipoAii + "/" + "default.png";
                }
                else {
	                for(Empresa e : lista) {
	                    if(e.getUrlBannerAii() != null && !e.getUrlBannerAii().equals("")) {
	                        listaSinUrlNull.add(e);
	                    }
	                }
	                
	                if(!listaSinUrlNull.isEmpty()) {
	                	banner = listaSinUrlNull.get(rand.nextInt(listaSinUrlNull.size())).getUrlBannerAii();
	                }
	                else {
	                	banner = "/" + directorioBanners + tipoAii + "/" + "default.png";
	                }
                }
            }
            else if(tipo.equals(getTipoAib())) {
            	
                lista = ctrlEmpresa.buscarEmpresasAib(ciudad);

                if(lista == null || lista.size() <= 0) {
                	banner = "/" + directorioBanners + tipoAib + "/" + "default.png";
                }
                else {
	                for(Empresa e : lista) {
	                    if(e.getUrlBannerAib() != null && !e.getUrlBannerAib().equals("")) {
	                        listaSinUrlNull.add(e);
	                    }
	                }
	                
	                if(!listaSinUrlNull.isEmpty()) {
	                	banner = listaSinUrlNull.get(rand.nextInt(listaSinUrlNull.size())).getUrlBannerAib();
	                }
	                else {
	                	banner = "/" + directorioBanners + tipoAib + "/" + "default.png";
	                }
                }
            }
            else if(tipo.equals(getTipoAsm())) {
            	
                lista = ctrlEmpresa.buscarEmpresasAsm(ciudad);

                if(lista == null || lista.size() <= 0) {
                	banner = "/" + directorioBanners + tipoAsm + "/" + "default.png";
                }
                else {
	                for(Empresa e : lista) {
	                    if(e.getUrlBannerAsm() != null && !e.getUrlBannerAsm().equals("")) {
	                        listaSinUrlNull.add(e);
	                    }
	                }
	                
	                if(!listaSinUrlNull.isEmpty()) {
	                	banner = listaSinUrlNull.get(rand.nextInt(listaSinUrlNull.size())).getUrlBannerAsm();
	                }
	                else {
	                	banner = "/" + directorioBanners + tipoAsm + "/" + "default.png";
	                }
                }
            }
            else if(tipo.equals(getTipoAdt())) {
            	
                lista = ctrlEmpresa.buscarEmpresasAdt(ciudad);

                if(lista == null || lista.size() <= 0) {
                	banner = "/" + directorioBanners + tipoAdt + "/" + "default.png";
                }
                else {
	                for(Empresa e : lista) {
	                    if(e.getUrlBannerAdt() != null && !e.getUrlBannerAdt().equals("")) {
	                        listaSinUrlNull.add(e);
	                    }
	                }
	                
	                if(!listaSinUrlNull.isEmpty()) {
	                	banner = listaSinUrlNull.get(rand.nextInt(listaSinUrlNull.size())).getUrlBannerAdt();
	                }
	                else {
	                	banner = "/" + directorioBanners + tipoAdt + "/" + "default.png";
	                }
                }
            }
        }
        
        return banner;
    }
    
    public boolean cargarBanners(Empresa empresa,
                                 File fileAdt,
                                 File fileAib,
                                 File fileAii,
                                 File fileAsm,
                                 boolean eliminarAdt,
                                 boolean eliminarAib,
                                 boolean eliminarAii,
                                 boolean eliminarAsm,
                                 String path,
                                 String webapp) {
        
        if(empresa == null || empresa.getId() == null) {
            return false;
        }
        
        empresa = ctrlEmpresa.obtenerEmpresaPorId(empresa.getId());
        
        if(empresa == null || empresa.getId() == null) {
            return false;
        }
        
        if(empresa.getPlan().getBannerAdt()) {
            if(!imageUploader.cargarImagen(fileAdt, eliminarAdt, path + getDirectorioBanners() + getTipoAdt() + "/" + empresa.getId() + ".png", anchoAdt, altoAdt)) {
                return false;
            }
            else { // archivos OK
                if(eliminarAdt) {
                    empresa.setUrlBannerAdt(null);
                }
                else {
                    empresa.setUrlBannerAdt("/" + directorioBanners + tipoAdt + "/" + empresa.getId() + ".png");
                    ctrlEmpresa.guardarEmpresa(empresa);
                }
            }
        }
        
        if(empresa.getPlan().getBannerAib()) {
            if(!imageUploader.cargarImagen(fileAib, eliminarAib, path + getDirectorioBanners() + getTipoAib() + "/" + empresa.getId() + ".png", anchoAib, altoAib)) {
                return false;
            }
            else { // archivos OK
                if(eliminarAib) {
                    empresa.setUrlBannerAib(null);
                }
                else {
                    empresa.setUrlBannerAib("/" + directorioBanners + tipoAib + "/" + empresa.getId() + ".png");
                    ctrlEmpresa.guardarEmpresa(empresa);
                }
            }
        }
        
        if(empresa.getPlan().getBannerAii()) {
            if(!imageUploader.cargarImagen(fileAii, eliminarAii, path + getDirectorioBanners() + getTipoAii() + "/" + empresa.getId() + ".png", anchoAii, altoAii)) {
                return false;
            }
            else { // archivos OK
                if(eliminarAii) {
                    empresa.setUrlBannerAii(null);
                }
                else {
                    empresa.setUrlBannerAii("/" + directorioBanners + tipoAii + "/" + empresa.getId() + ".png");
                    ctrlEmpresa.guardarEmpresa(empresa);
                }
            }
        }
        
        if(empresa.getPlan().getBannerAsm()) {
            if(!imageUploader.cargarImagen(fileAsm, eliminarAsm, path + getDirectorioBanners() + getTipoAsm() + "/" + empresa.getId() + ".png", anchoAsm, altoAsm)) {
                return false;
            }
            else { // archivos OK
                if(eliminarAsm) {
                    empresa.setUrlBannerAsm(null);
                }
                else {
                    empresa.setUrlBannerAsm("/" + directorioBanners + tipoAsm + "/" + empresa.getId() + ".png");
                    ctrlEmpresa.guardarEmpresa(empresa);
                }
            }
        }
        
        return true;
    }

    public String getTipoAib() {
        return tipoAib;
    }

    public void setTipoAib(String tipoAib) {
        this.tipoAib = tipoAib;
    }

    public String getTipoAii() {
        return tipoAii;
    }

    public void setTipoAii(String tipoAii) {
        this.tipoAii = tipoAii;
    }

    public String getTipoAim() {
        return tipoAim;
    }

    public void setTipoAim(String tipoAim) {
        this.tipoAim = tipoAim;
    }

    public String getTipoAsm() {
        return tipoAsm;
    }

    public void setTipoAsm(String tipoAsm) {
        this.tipoAsm = tipoAsm;
    }

    public String getTipoAdt() {
        return tipoAdt;
    }

    public void setTipoAdt(String tipoAdt) {
        this.tipoAdt = tipoAdt;
    }

    public String getDirectorioBanners() {
        return directorioBanners;
    }

    public void setDirectorioBanners(String directorioBanners) {
        this.directorioBanners = directorioBanners;
    }

    public ICtrlEmpresa getCtrlEmpresa() {
        return ctrlEmpresa;
    }

    public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
        this.ctrlEmpresa = ctrlEmpresa;
    }

    public Integer getAnchoAdt() {
        return anchoAdt;
    }

    public void setAnchoAdt(Integer anchoAdt) {
        this.anchoAdt = anchoAdt;
    }

    public Integer getAnchoAib() {
        return anchoAib;
    }

    public void setAnchoAib(Integer anchoAib) {
        this.anchoAib = anchoAib;
    }

    public Integer getAnchoAii() {
        return anchoAii;
    }

    public void setAnchoAii(Integer anchoAii) {
        this.anchoAii = anchoAii;
    }

    public Integer getAnchoAsm() {
        return anchoAsm;
    }

    public void setAnchoAsm(Integer anchoAsm) {
        this.anchoAsm = anchoAsm;
    }

    public Integer getAltoAdt() {
        return altoAdt;
    }

    public void setAltoAdt(Integer altoAdt) {
        this.altoAdt = altoAdt;
    }

    public Integer getAltoAib() {
        return altoAib;
    }

    public void setAltoAib(Integer altoAib) {
        this.altoAib = altoAib;
    }

    public Integer getAltoAii() {
        return altoAii;
    }

    public void setAltoAii(Integer altoAii) {
        this.altoAii = altoAii;
    }

    public Integer getAltoAsm() {
        return altoAsm;
    }

    public void setAltoAsm(Integer altoAsm) {
        this.altoAsm = altoAsm;
    }

    public IImageUploader getImageUploader() {
        return imageUploader;
    }

    public void setImageUploader(IImageUploader imageUploader) {
        this.imageUploader = imageUploader;
    }

    public Integer getNumeroEmpresasBannerAim() {
        return numeroEmpresasBannerAim;
    }

    public void setNumeroEmpresasBannerAim(Integer numeroEmpresasBannerAim) {
        this.numeroEmpresasBannerAim = numeroEmpresasBannerAim;
    }

}
