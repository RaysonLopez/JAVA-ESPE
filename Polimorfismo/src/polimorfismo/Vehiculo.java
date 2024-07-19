package polimorfismo;
public abstract class Vehiculo {
    protected String matricula;
    protected String marca;
    protected String modelo;

    public  abstract String acelerar();
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String mostrarDatos(){
        return null;
    }
}
