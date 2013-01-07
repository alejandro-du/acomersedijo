package dpasoftware.acomersedijo.accesoDatos.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Alejandro.
 */
@Entity
@Table(name="empresa")
public class Empresa implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String website;
    private String precioPromedio;
    private Boolean pagoEfectivo;
    private Boolean pagoAmericanExpress;
    private Boolean pagoDinersClub;
    private Boolean pagoMasterCard;
    private Boolean pagoMaestro;
    private Boolean pagoVisa;
    private Boolean domicilios;
    private String anuncio;
    private Long visitas;
    private String urlImagen;
    private String urlBannerAib;
    private String urlBannerAii;
    private String urlBannerAsm;
    private String urlBannerAdt;
    private Boolean activa;
    private Zona zona;
    private Sector sector;
    private Usuario usuario;
    private Plan plan;
    private Plan planSolicitado;
    

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name="emp_id")
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " " + getNombre();
    }

    @Column(name="emp_nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="emp_telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name="emp_direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name="emp_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="emp_website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Column(name="emp_anuncio", length=200000)
    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }

    @Column(name="emp_visitas")
    public Long getVisitas() {
        return visitas;
    }

    public void setVisitas(Long visitas) {
        this.visitas = visitas;
    }

    @ManyToOne
    @JoinColumn(name="sec_id")
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Column(name="emp_url_imagen")
    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @ManyToOne
    @JoinColumn(name="usu_id", unique=true, nullable=true)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @OneToOne
    @JoinColumn(name="pla_id", nullable=false)
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Column(name="emp_activa", nullable=false)
    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    @ManyToOne
    @JoinColumn(name="zon_id")
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Column(name="emp_precio_promedio")
    public String getPrecioPromedio() {
        return precioPromedio;
    }

    public void setPrecioPromedio(String precioPromedio) {
        this.precioPromedio = precioPromedio;
    }

    @Column(name="emp_pago_efectivo")
    public Boolean getPagoEfectivo() {
        return pagoEfectivo;
    }

    public void setPagoEfectivo(Boolean pagoEfectivo) {
        this.pagoEfectivo = pagoEfectivo;
    }

    @Column(name="emp_pago_american_express")
    public Boolean getPagoAmericanExpress() {
        return pagoAmericanExpress;
    }

    public void setPagoAmericanExpress(Boolean pagoAmericanExpress) {
        this.pagoAmericanExpress = pagoAmericanExpress;
    }

    @Column(name="emp_pago_diners_club")
    public Boolean getPagoDinersClub() {
        return pagoDinersClub;
    }

    public void setPagoDinersClub(Boolean pagoDinersClub) {
        this.pagoDinersClub = pagoDinersClub;
    }

    @Column(name="emp_pago_master_card")
    public Boolean getPagoMasterCard() {
        return pagoMasterCard;
    }

    public void setPagoMasterCard(Boolean pagoMasterCard) {
        this.pagoMasterCard = pagoMasterCard;
    }

    @Column(name="emp_pago_maestro")
    public Boolean getPagoMaestro() {
        return pagoMaestro;
    }

    public void setPagoMaestro(Boolean pagoMaestro) {
        this.pagoMaestro = pagoMaestro;
    }

    @Column(name="emp_pago_visa")
    public Boolean getPagoVisa() {
        return pagoVisa;
    }

    public void setPagoVisa(Boolean pagoVisa) {
        this.pagoVisa = pagoVisa;
    }

    @Column(name="emp_domicilios")
    public Boolean getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(Boolean domicilios) {
        this.domicilios = domicilios;
    }

    @Column(name="emp_url_banner_aib")
    public String getUrlBannerAib() {
        return urlBannerAib;
    }

    public void setUrlBannerAib(String urlBannerAib) {
        this.urlBannerAib = urlBannerAib;
    }

    @Column(name="emp_url_banner_aii")
    public String getUrlBannerAii() {
        return urlBannerAii;
    }

    public void setUrlBannerAii(String urlBannerAii) {
        this.urlBannerAii = urlBannerAii;
    }

    @Column(name="emp_url_banner_asm")
    public String getUrlBannerAsm() {
        return urlBannerAsm;
    }

    public void setUrlBannerAsm(String urlBannerAsm) {
        this.urlBannerAsm = urlBannerAsm;
    }

    @Column(name="emp_url_banner_adt")
    public String getUrlBannerAdt() {
        return urlBannerAdt;
    }

    public void setUrlBannerAdt(String urlBannerAdt) {
        this.urlBannerAdt = urlBannerAdt;
    }

    @OneToOne
    @JoinColumn(name="pla_solicitado_id", nullable=false)
    public Plan getPlanSolicitado() {
		return planSolicitado;
	}

	public void setPlanSolicitado(Plan planSolicitado) {
		this.planSolicitado = planSolicitado;
	}

}
