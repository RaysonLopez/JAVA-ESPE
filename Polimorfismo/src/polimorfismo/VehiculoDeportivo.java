package polimorfismo;
public class VehiculoDeportivo extends Vehiculo{
   private int cilindrada;

    public VehiculoDeportivo(int cilindrada, String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }
   @Override
    public String mostrarDatos(){
        return "la matricula es: "+matricula+"\n"+"La marca es: "+marca+"\n"+"El modelo es: "+ modelo+"\n"+ "La cilindrada es: "+ cilindrada;
    }
}
