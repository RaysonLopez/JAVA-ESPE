/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login.Modelo;

import java.util.prefs.Preferences;

/**
 *
 * @author Rayson
 */
public class ModeloLogin {
    private String userId;
    private String userPassword;
    private Preferences prefs;

    public ModeloLogin(String userId, String userPassword, Preferences prefs) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.prefs = prefs;
    }
    
    public ModeloLogin(){
        
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Preferences getPrefs() {
        return prefs;
    }

    public void setPrefs(Preferences prefs) {
        this.prefs = prefs;
    }
    
}
