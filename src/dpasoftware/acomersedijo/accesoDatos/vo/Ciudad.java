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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name="ciudad",
       uniqueConstraints=@UniqueConstraint(columnNames={"pai_id", "ciu_nombre"}))
public class Ciudad implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombre;
    private Pais pais;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name="ciu_id")
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
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " " + getNombre();
    }

    @Column(name="ciu_nombre", nullable=false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    @JoinColumn(name="pai_id", nullable=false)
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

}
