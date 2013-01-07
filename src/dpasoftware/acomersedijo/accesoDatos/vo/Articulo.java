package dpasoftware.acomersedijo.accesoDatos.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Alejandro.
 */
@Entity
@Table(name="articulo",
       uniqueConstraints=@UniqueConstraint(columnNames={"art_titulo", "art_texto"}))
public class Articulo implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String titulo;
    private String subTitulo;
    private Seccion seccion;
    private Boolean publicado;
    private String resumen;
    private String texto;
    private Long visitas;
    private List<Ciudad> ciudades;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name="art_id")
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
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " " + getTitulo();
    }

    @Column(name="art_titulo", nullable=false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name="art_sub_titulo")
    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    @Column(name="art_publicado", nullable=false)
    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

    @Column(name="art_resumen", length=5000, nullable=false)
	public String getResumen() {
		return resumen;
	}

    @Column(name="art_texto", length=50000, nullable=false)
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @ManyToOne
    @JoinColumn(name="sec_id", nullable=false)
    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @OneToMany
    @JoinTable(joinColumns=@JoinColumn(name="art_id"), inverseJoinColumns=@JoinColumn(name="ciu_id"))
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

    @Column(name="art_visitas")
	public Long getVisitas() {
		return visitas;
	}

	public void setVisitas(Long visitas) {
		this.visitas = visitas;
	}

}
