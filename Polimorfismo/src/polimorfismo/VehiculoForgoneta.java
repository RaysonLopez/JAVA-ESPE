package polimorfismo;
public class VehiculoForgoneta extends Vehiculo{
    private int carga;

    public VehiculoForgoneta(int carga, String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.carga = carga;
    }
    

    public int getCarga() {
        return carga;
    }
    @Override
    public String mostrarDatos(){
        return "la matricula es: "+matricula+"\n"+"La marca es: "+marca+"\n"+"El modelo es: "+ modelo+"\n"+"la carga es: "+carga;
    }
}
