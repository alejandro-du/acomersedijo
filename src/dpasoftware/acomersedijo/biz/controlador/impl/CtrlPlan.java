package dpasoftware.acomersedijo.biz.controlador.impl;

import java.text.DecimalFormat;
import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoPlan;
import dpasoftware.acomersedijo.accesoDatos.vo.Plan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;

/**
 *
 * @author Alejandro
 */
public class CtrlPlan implements ICtrlPlan {

    private double precioImagen;
    private double precioLinkWebsite;
    private double precioBannerAib;
    private double precioBannerAii;
    private double precioBannerAim;
    private double precioBannerAsm;
    private double precioBannerAdt;
    private double precioEstrella1;
    private double precioEstrella2;
    private double precioEstrella3;
    private double precioEstrella4;
    private double precioEstrella5;
    private double precioAnuncioBasico;
    private double precioAnuncioAvanzado;
    private double precioAnuncioEmpresarial;
    private long caracteresHtmlBasico;
    private long caracteresHtmlAvanzado;
    private long caracteresHtmlEmpresarial;
    
    private IDaoPlan daoPlan;
    private ICtrlUsuario ctrlUsuario;
    
    
    @Override
    public Plan obtenerPlanGratuito() {
    	
    	Plan plan = new Plan();
    	
    	plan.setId(null);
    	plan.setPlanAnterior(null);
    	plan.setDocumentoPagador(null);
    	plan.setFechaConfirmacionRegistro(null);
    	plan.setFechaPago(null);
    	plan.setFechaSolicitudRegistro(null);
    	plan.setNumeroConsignacion(null);
    	plan.setNotificacionPago(false);
    	
    	plan.setImagen(false);
    	plan.setCaracteresHtml(0L);
    	plan.setEstrellas(0L);
    	plan.setLinkWebsite(false);
    	plan.setBannerAdt(false);
    	plan.setBannerAib(false);
    	plan.setBannerAii(false);
    	plan.setBannerAim(false);
    	plan.setBannerAsm(false);
    	
    	plan.setPrecio(0.0);

    	return plan;
    }
    
    public String format(Object number) {
        
        DecimalFormat format = new DecimalFormat("#.00");
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        
        return "$" + format.format(number);
    }
    
	public boolean validarPlan(Plan plan) {
        return (
            plan != null
            && plan.getCaracteresHtml() != null
            && plan.getEstrellas() != null
            && (
                plan.getCaracteresHtml().equals(0L)
                || plan.getCaracteresHtml().equals(getCaracteresHtmlBasico())
                || plan.getCaracteresHtml().equals(getCaracteresHtmlAvanzado())
                || plan.getCaracteresHtml().equals(getCaracteresHtmlEmpresarial())
            )
            && (
                plan.getEstrellas().equals(0L)
                || plan.getEstrellas().equals(1L)
                || plan.getEstrellas().equals(2L)
                || plan.getEstrellas().equals(3L)
                || plan.getEstrellas().equals(4L)
                || plan.getEstrellas().equals(5L)
            )
        );
    }

    public double calcularPrecioPlan(Plan plan) {
        
        if(!validarPlan(plan)) {
            throw new RuntimeException("Plan no válido.");
        }
        
        return
            (plan.getBannerAdt() ? getPrecioBannerAdt() : 0)
            + (plan.getBannerAib() ? getPrecioBannerAib() : 0)
            + (plan.getBannerAii() ? getPrecioBannerAii() : 0)
            + (plan.getBannerAim() ? getPrecioBannerAim() : 0)
            + (plan.getBannerAsm() ? getPrecioBannerAsm() : 0)
            + (plan.getLinkWebsite() ? getPrecioLinkWebsite() : 0)
            + (plan.getImagen() ? getPrecioImagen() : 0)
            + (plan.getEstrellas().equals(1L) ? getPrecioEstrella1() : 0)
            + (plan.getEstrellas().equals(2L) ? getPrecioEstrella2() : 0)
            + (plan.getEstrellas().equals(3L) ? getPrecioEstrella3() : 0)
            + (plan.getEstrellas().equals(4L) ? getPrecioEstrella4() : 0)
            + (plan.getEstrellas().equals(5L) ? getPrecioEstrella5() : 0)
            + (plan.getCaracteresHtml().equals(getCaracteresHtmlBasico()) ? getPrecioAnuncioBasico() : 0)
            + (plan.getCaracteresHtml().equals(getCaracteresHtmlAvanzado()) ? getPrecioAnuncioAvanzado() : 0)
            + (plan.getCaracteresHtml().equals(getCaracteresHtmlEmpresarial()) ? getPrecioAnuncioEmpresarial() : 0);
    }

    @Override
	public List<Plan> buscarTodosLosPlanes() {
		return daoPlan.listarTodos();
	}

	@Override
	public List<Plan> buscarPlanes(Plan plan) {
		return daoPlan.listar(plan);
	}

	@Override
	public boolean eliminarPlanPorId(Plan plan) {
		return daoPlan.eliminarPorId(plan.getId());
	}

	@Override
	public boolean guardarPlan(Plan plan) {
		return daoPlan.guardarOActualizarPorId(plan);
	}

	@Override
	public Plan obtenerPlanPorId(Long id) {
		return daoPlan.obtenerPorId(id);
	}

    public double getPrecioImagen() {
        return precioImagen;
    }

    public void setPrecioImagen(double precioImagen) {
        this.precioImagen = precioImagen;
    }

    public double getPrecioLinkWebsite() {
        return precioLinkWebsite;
    }

    public void setPrecioLinkWebsite(double precioLinkWebsite) {
        this.precioLinkWebsite = precioLinkWebsite;
    }

    public double getPrecioBannerAib() {
        return precioBannerAib;
    }

    public void setPrecioBannerAib(double precioBannerAib) {
        this.precioBannerAib = precioBannerAib;
    }

    public double getPrecioBannerAii() {
        return precioBannerAii;
    }

    public void setPrecioBannerAii(double precioBannerAii) {
        this.precioBannerAii = precioBannerAii;
    }

    public double getPrecioBannerAim() {
        return precioBannerAim;
    }

    public void setPrecioBannerAim(double precioBannerAim) {
        this.precioBannerAim = precioBannerAim;
    }

    public double getPrecioBannerAsm() {
        return precioBannerAsm;
    }

    public void setPrecioBannerAsm(double precioBannerAsm) {
        this.precioBannerAsm = precioBannerAsm;
    }

    public double getPrecioBannerAdt() {
        return precioBannerAdt;
    }

    public void setPrecioBannerAdt(double precioBannerAdt) {
        this.precioBannerAdt = precioBannerAdt;
    }

    public double getPrecioEstrella1() {
        return precioEstrella1;
    }

    public void setPrecioEstrella1(double precioEstrella1) {
        this.precioEstrella1 = precioEstrella1;
    }

    public double getPrecioEstrella2() {
        return precioEstrella2;
    }

    public void setPrecioEstrella2(double precioEstrella2) {
        this.precioEstrella2 = precioEstrella2;
    }

    public double getPrecioEstrella3() {
        return precioEstrella3;
    }

    public void setPrecioEstrella3(double precioEstrella3) {
        this.precioEstrella3 = precioEstrella3;
    }

    public double getPrecioEstrella4() {
        return precioEstrella4;
    }

    public void setPrecioEstrella4(double precioEstrella4) {
        this.precioEstrella4 = precioEstrella4;
    }

    public double getPrecioEstrella5() {
        return precioEstrella5;
    }

    public void setPrecioEstrella5(double precioEstrella5) {
        this.precioEstrella5 = precioEstrella5;
    }

    public double getPrecioAnuncioBasico() {
        return precioAnuncioBasico;
    }

    public void setPrecioAnuncioBasico(double precioAnuncioBasico) {
        this.precioAnuncioBasico = precioAnuncioBasico;
    }

    public double getPrecioAnuncioAvanzado() {
        return precioAnuncioAvanzado;
    }

    public void setPrecioAnuncioAvanzado(double precioAnuncioAvanzado) {
        this.precioAnuncioAvanzado = precioAnuncioAvanzado;
    }

    public double getPrecioAnuncioEmpresarial() {
        return precioAnuncioEmpresarial;
    }

    public void setPrecioAnuncioEmpresarial(double precioAnuncioEmpresarial) {
        this.precioAnuncioEmpresarial = precioAnuncioEmpresarial;
    }

    public long getCaracteresHtmlBasico() {
        return caracteresHtmlBasico;
    }

    public void setCaracteresHtmlBasico(long caracteresHtmlBasico) {
        this.caracteresHtmlBasico = caracteresHtmlBasico;
    }

    public long getCaracteresHtmlAvanzado() {
        return caracteresHtmlAvanzado;
    }

    public void setCaracteresHtmlAvanzado(long caracteresHtmlAvanzado) {
        this.caracteresHtmlAvanzado = caracteresHtmlAvanzado;
    }

    public long getCaracteresHtmlEmpresarial() {
        return caracteresHtmlEmpresarial;
    }

    public void setCaracteresHtmlEmpresarial(long caracteresHtmlEmpresarial) {
        this.caracteresHtmlEmpresarial = caracteresHtmlEmpresarial;
    }

	public IDaoPlan getDaoPlan() {
		return daoPlan;
	}

	public void setDaoPlan(IDaoPlan daoPlan) {
		this.daoPlan = daoPlan;
	}

	public ICtrlUsuario getCtrlUsuario() {
		return ctrlUsuario;
	}

	public void setCtrlUsuario(ICtrlUsuario ctrlUsuario) {
		this.ctrlUsuario = ctrlUsuario;
	}
    
}
