package dpasoftware.acomersedijo.biz.controlador.impl.remoto;

import dpasoftware.acomersedijo.accesoDatos.vo.Plan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;

/**
 *
 * @author Alejandro
 */
public class CtrlRemotoRegistro {
    
    private ICtrlPlan ctrlPlan;
    
    public String calcularPrecioTotal(boolean imagen,
                                      boolean linkWebsite,
                                      boolean bannerAdt,
                                      boolean bannerAib,
                                      boolean bannerAii,
                                      boolean bannerAim,
                                      boolean bannerAsm,
                                      Long estrellas,
                                      Long anuncioCaracteresHtml) {
        
        Plan plan = new Plan();
        
        plan.setImagen(imagen);
        plan.setLinkWebsite(linkWebsite);
        plan.setBannerAdt(bannerAdt);
        plan.setBannerAib(bannerAib);
        plan.setBannerAii(bannerAii);
        plan.setBannerAim(bannerAim);
        plan.setBannerAsm(bannerAsm);
        plan.setEstrellas(estrellas);
        plan.setCaracteresHtml(anuncioCaracteresHtml);
        
        return ctrlPlan.format(ctrlPlan.calcularPrecioPlan(plan));
        
    }

    public ICtrlPlan getCtrlPlan() {
        return ctrlPlan;
    }

    public void setCtrlPlan(ICtrlPlan ctrlPlan) {
        this.ctrlPlan = ctrlPlan;
    }
    
}
