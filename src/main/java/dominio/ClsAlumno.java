
package dominio;

/**
 *
 * @author PC
 */
public class ClsAlumno {
    private int id;
    private String nombre;
    private double enero;
    private double febrero;
    private double marzo;

    @Override
    public String toString() {
        return "ClsAlumno{" + "id=" + id + ", nombre=" + nombre + ", enero=" + enero + ", febrero=" + febrero + ", marzo=" + marzo + '}';
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEnero() {
        return enero;
    }

    public void setEnero(double enero) {
        this.enero = enero;
    }

    public double getFebrero() {
        return febrero;
    }

    public void setFebrero(double febrero) {
        this.febrero = febrero;
    }

    public double getMarzo() {
        return marzo;
    }

    public void setMarzo(double marzo) {
        this.marzo = marzo;
    }
    

    

    
}
