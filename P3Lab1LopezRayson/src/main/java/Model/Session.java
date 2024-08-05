/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rayson
 */
public class Session {
    private static Session session;
    private   String user;
    private  String password; 

    public static Session getSession() {
        if(session==null){
            session=new Session();
        }
        return session;
    }

    public static void setSession(Session session) {
        Session.session = session;
    }
    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
