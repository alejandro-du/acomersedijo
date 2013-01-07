package dpasoftware.acomersedijo.accesoDatos.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name="evento")
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String titulo;
    private String fecha;
    private String hora;
    private String precio;
    private String descripcion;
    private String informes;
    private String lugar;
    private Long visitas;
    private Empresa empresa;
    private Zona zona;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " " + getTitulo();
    }

    @Column(name="eve_titulo", nullable=false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name="eve_precio")
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Column(name="eve_descripcion", length=500, nullable=false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="eve_informes")
    public String getInformes() {
        return informes;
    }

    public void setInformes(String informes) {
        this.informes = informes;
    }

    @ManyToOne
    @JoinColumn(name="zon_id", nullable=false)
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Column(name="eve_fecha", nullable=false)
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Column(name="eve_hora")
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @ManyToOne
    @JoinColumn(name="emp_id", nullable=false)
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Column(name="eve_lugar")
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Column(name="eve_visitas", nullable=false)
    public Long getVisitas() {
        return visitas;
    }

    public void setVisitas(Long visitas) {
        this.visitas = visitas;
    }

}
