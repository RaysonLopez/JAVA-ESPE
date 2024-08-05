/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.bson.Document;

/**
 *
 * @author Rayson
 */
public  abstract class ModelPersona {
    private String id;
    private String user;
    private String name;
    private String lastname;
    private String birthday;
    private String gender;
    private String email;
    private String password;
    private String carrer;
    private String period;
    private String matters;
    private String schedule;


    public ModelPersona(String id,String user,String name, String lastname, String birthday, String gender, String email, String password, String carrer, String period, String matters, String schedule) {
        this.id = id;
        this.user=user;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.carrer = carrer;
        this.period = period;
        this.matters = matters;
        this.schedule = schedule;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getMatters() {
        return matters;
    }

    public void setMatters(String matters) {
        this.matters = matters;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
