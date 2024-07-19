/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Model;

/**
 *
 * @author Rayson
 */
public class MODELDatosCLIENTE {
        String CI;
        String contra;
        String nombres;
        String telf;
        String mail;
        String genero;
        String diaB;
        String mesB;
        String anioB;
        String fecha=diaB+"/"+mesB+"/"+anioB;
        private byte[]imagenAdjunta;

    public MODELDatosCLIENTE(String CI, String contra, String nombres, String telf, String mail, String genero, String diaB, String mesB, String anioB, byte[] imagenAdjunta) {
        this.CI = CI;
        this.contra = contra;
        this.nombres = nombres;
        this.telf = telf;
        this.mail = mail;
        this.genero = genero;
        this.diaB = diaB;
        this.mesB = mesB;
        this.anioB = anioB;
        this.imagenAdjunta = imagenAdjunta;
    }
        
    public MODELDatosCLIENTE(){
        
    }
    public byte[] getImagenAdjunta() {
        return imagenAdjunta;
    }

    public void setImagenAdjunta(byte[] imagenAdjunta) {
        this.imagenAdjunta = imagenAdjunta;
    }
        
        
    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiaB() {
        return diaB;
    }

    public void setDiaB(String diaB) {
        this.diaB = diaB;
    }

    public String getMesB() {
        return mesB;
    }

    public void setMesB(String mesB) {
        this.mesB = mesB;
    }

    public String getAnioB() {
        return anioB;
    }

    public void setAnioB(String anioB) {
        this.anioB = anioB;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
        
}
