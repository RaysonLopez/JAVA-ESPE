
package constantes;
public class Constantes {
    private final int edad;
    private String Nombre;

    public Constantes(int edad, String Nombre) {
        this.edad=edad;
        this.Nombre = Nombre;
    }
    public void MostrarDato(){
        System.out.println("El numero es: "+Nombre);
        System.out.println("La edad del chico es: "+edad);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
