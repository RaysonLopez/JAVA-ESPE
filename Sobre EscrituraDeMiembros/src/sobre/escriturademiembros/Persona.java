package sobre.escriturademiembros;

public class Persona extends Animal {
    @Override//Sobreescribiendo el metodo comer
    public void comer(){
        System.out.println("Estoy comiendo sentado y con cubiertos");
    }
    
}
