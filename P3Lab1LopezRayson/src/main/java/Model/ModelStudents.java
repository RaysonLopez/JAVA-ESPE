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
public class ModelStudents extends ModelPersona{
    private Document student;
    public ModelStudents(String id, String user, String name, String lastname, String birthday, String gender, String email, String password, String carrer, String period, String matters, String schedule) {
        super(id, user, name, lastname, birthday, gender, email, password, carrer, period, matters, schedule);
    }



    
    
    
    
}
