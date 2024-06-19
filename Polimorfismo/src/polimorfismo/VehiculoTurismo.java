package polimorfismo;
public class VehiculoTurismo extends Vehiculo{
    private int nPuertas;

    public VehiculoTurismo(int numeroPuertas, String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.nPuertas = numeroPuertas;
    }

    public int getnPuertas() {
        return nPuertas;
    }
    @Override
    public String mostrarDatos(){
        return "la matricula es: "+matricula+"\n"+"La marca es: "+marca+"\n"+"El modelo es: "+ modelo+"\n"+"El numero de puertas es: "+nPuertas;
    }
    
}
