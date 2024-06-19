public class Camioneta extends Vehiculo {
    private int capacidadCarga;
    private int numAsientos;
    private boolean traccionVF;

    public Camioneta(String color,String modelo,String marca,int caballosDeFuerza,double peso,double velocidad,int capacidadCarga,int numAsientos,boolean traccionVF){
        super(color,modelo,marca,caballosDeFuerza,peso,velocidad);
        this.capacidadCarga=capacidadCarga;
        this.numAsientos=numAsientos;
        this.traccionVF=traccionVF;
    }
    public void MostrarDatos(){
        System.out.println("COLOR: "+getColor()+"\n"+"MODELO: "+getModelo()+"\n"+"MARCA: "+getMarca());


    }
}
