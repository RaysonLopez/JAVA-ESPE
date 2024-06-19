package polimorfismo;

public class Principal {
    public static void main(String[] args){
        Vehiculo misVehiculos[]=new Vehiculo[4];
        misVehiculos[0]=new Vehiculo("12gb","Ferrari","A8");
        misVehiculos[1]=new VehiculoTurismo(4,"12gb","Ferrari","A8");
        misVehiculos[2]=new VehiculoDeportivo(500,"12gb","Ferrari","A8");
        misVehiculos[3]=new VehiculoFurgoneta(2000,"12gb","Ferrari","A8");
    }
}
