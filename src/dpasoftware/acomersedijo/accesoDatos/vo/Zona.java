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
@Table(name="zona",
       uniqueConstraints=@UniqueConstraint(columnNames={"ciu_id", "zon_nombre"}))
public class Zona implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private Ciudad ciudad;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name="zon_id")
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
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + " " + getNombre();
    }

    @Column(name="zon_nombre", nullable=false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    @JoinColumn(name="ciu_id", nullable=false)
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

}
