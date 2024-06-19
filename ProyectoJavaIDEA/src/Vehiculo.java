public  class Vehiculo {
    private String color; // Color del vehículo
    private String modelo; // Modelo del vehículo
    private String marca; // Marca del vehículo
    private int caballosDeFuerza; // Caballos de fuerza del vehículo
    private double peso; // Peso del vehículo en kilogramos
    private double velocidad; // Velocidad máxima del vehículo en km/h

    public Vehiculo(String color, String modelo, String marca, int caballosDeFuerza, double peso, double velocidad) {
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.caballosDeFuerza = caballosDeFuerza;
        this.peso = peso;
        this.velocidad = velocidad;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getCaballosDeFuerza() {
        return caballosDeFuerza;
    }

    public double getPeso() {
        return peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

}


