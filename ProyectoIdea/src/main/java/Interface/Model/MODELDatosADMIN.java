/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface.Model;

/**
 *
 * @author Rayson
 */
public class MODELDatosADMIN {
    private String usuario;
    private String password;
    private String names;
    public MODELDatosADMIN(String usuario, String password ) {
        this.usuario = usuario;
        this.password = password;
    }
    public MODELDatosADMIN(){
        
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
