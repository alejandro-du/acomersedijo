package dpasoftware.acomersedijo.accesoDatos.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name="plan")
public class Plan implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Long estrellas;
    private Boolean imagen;
    private Boolean linkWebsite;
    private Boolean bannerAib;
    private Boolean bannerAii;
    private Boolean bannerAim;
    private Boolean bannerAsm;
    private Boolean bannerAdt;
    private Long caracteresHtml;
    private Double precio;
    private String fechaPago;
    private String documentoPagador;
    private String numeroConsignacion;
    private Plan planAnterior;
    private String fechaSolicitudRegistro;
    private String fechaConfirmacionRegistro;
    private String codigoRegistro;
    private Boolean notificacionPago;
    
    public Plan clone() {
    	
    	Plan plan = new Plan();
    	
         plan.id = null;
         plan.estrellas = this.estrellas;
         plan.imagen = this.imagen;
         plan.linkWebsite = this.linkWebsite;
         plan.bannerAib = this.bannerAib;
         plan.bannerAii = this.bannerAii;
         plan.bannerAim = this.bannerAim;
         plan.bannerAsm = this.bannerAsm;
         plan.bannerAdt = this.bannerAdt;
         plan.caracteresHtml = this.caracteresHtml;
         plan.precio = this.precio;
         plan.fechaPago = this.fechaPago;
         plan.documentoPagador = this.documentoPagador;
         plan.numeroConsignacion = this.numeroConsignacion;
         plan.planAnterior = this.planAnterior;
         plan.fechaSolicitudRegistro = this.fechaSolicitudRegistro;
         plan.fechaConfirmacionRegistro = this.fechaConfirmacionRegistro;
         plan.codigoRegistro = this.codigoRegistro;
         plan.notificacionPago = this.notificacionPago;
    	
    	return plan;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name="pla_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + getId();
    }

    @Column(name="pla_imagen", unique=true, nullable=false)
    public Boolean getImagen() {
        return imagen;
    }

    public void setImagen(Boolean imagen) {
        this.imagen = imagen;
    }

    @Column(name="pla_link_website", nullable=false)
    public Boolean getLinkWebsite() {
        return linkWebsite;
    }

    public void setLinkWebsite(Boolean linkWebsite) {
        this.linkWebsite = linkWebsite;
    }

    @Column(name="pla_banner_aii", nullable=false)
    public Boolean getBannerAii() {
        return bannerAii;
    }

    public void setBannerAii(Boolean bannerAii) {
        this.bannerAii = bannerAii;
    }

    @Column(name="pla_banner_aim", nullable=false)
    public Boolean getBannerAim() {
        return bannerAim;
    }

    public void setBannerAim(Boolean bannerAim) {
        this.bannerAim = bannerAim;
    }

    @Column(name="pla_banner_asm", nullable=false)
    public Boolean getBannerAsm() {
        return bannerAsm;
    }

    public void setBannerAsm(Boolean bannerAsm) {
        this.bannerAsm = bannerAsm;
    }

    @Column(name="pla_banner_adt", nullable=false)
    public Boolean getBannerAdt() {
        return bannerAdt;
    }

    public void setBannerAdt(Boolean bannerAdt) {
        this.bannerAdt = bannerAdt;
    }

    @Column(name="pla_caracteres_html", nullable=false)
    public Long getCaracteresHtml() {
        return caracteresHtml;
    }

    public void setCaracteresHtml(Long caracteresHtml) {
        this.caracteresHtml = caracteresHtml;
    }

    @Column(name="pla_banner_aib", nullable=false)
    public Boolean getBannerAib() {
        return bannerAib;
    }

    public void setBannerAib(Boolean bannerAib) {
        this.bannerAib = bannerAib;
    }

    @Column(name="pla_estrellas", nullable=false)
    public Long getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Long estrellas) {
        this.estrellas = estrellas;
    }

    @Column(name="pla_fecha_pago", nullable=false)
	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

    @Column(name="pla_precio", nullable=false)
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

    @Column(name="pla_documento_pagador")
	public String getDocumentoPagador() {
		return documentoPagador;
	}

	public void setDocumentoPagador(String documentoPagador) {
		this.documentoPagador = documentoPagador;
	}

    @Column(name="pla_numero_consignacion")
	public String getNumeroConsignacion() {
		return numeroConsignacion;
	}

	public void setNumeroConsignacion(String numeroConsignacion) {
		this.numeroConsignacion = numeroConsignacion;
	}

    @OneToOne
    @JoinColumn(name="pla_anterior_id")
	public Plan getPlanAnterior() {
		return planAnterior;
	}

	public void setPlanAnterior(Plan planAnterior) {
		this.planAnterior = planAnterior;
	}

    @Column(name="pla_fecha_solicitud_registro", nullable=false)
	public String getFechaSolicitudRegistro() {
		return fechaSolicitudRegistro;
	}

	public void setFechaSolicitudRegistro(String fechaSolicitudRegistro) {
		this.fechaSolicitudRegistro = fechaSolicitudRegistro;
	}

    @Column(name="pla_fecha_confirmacion_registro")
	public String getFechaConfirmacionRegistro() {
		return fechaConfirmacionRegistro;
	}

	public void setFechaConfirmacionRegistro(String fechaConfirmacionRegistro) {
		this.fechaConfirmacionRegistro = fechaConfirmacionRegistro;
	}

    @Column(name="pla_codigo_registro", unique=true, nullable=false)
    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    @Column(name="pla_notificacion_pago", nullable=false)
	public Boolean getNotificacionPago() {
		return notificacionPago;
	}

	public void setNotificacionPago(Boolean notificacionPago) {
		this.notificacionPago = notificacionPago;
	}

}
