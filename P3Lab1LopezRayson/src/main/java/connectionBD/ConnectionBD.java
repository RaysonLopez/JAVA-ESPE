/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connectionBD;


/**
 *
 * @author Rayson
 */
public abstract class ConnectionBD {
    private String databaseName="P3Lab1LopezRayson";
    private String collectionStudents="studentsData";
    private String collectionMatters="teachersData";

    public ConnectionBD() {
    }

    
    
    
    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        if(databaseName !=null & !databaseName.isEmpty()){
            this.databaseName=databaseName;
        }else{
            throw new IllegalArgumentException("El nombre de la base de datos no puede ser nulo o vacio");
        }
        this.databaseName = databaseName;
    }

    public String getCollectionStudents() {
        return collectionStudents;
    }

    public void setCollectionStudents(String collectionStudents) {
        if(collectionStudents!=null &&!collectionStudents.isEmpty()){
            this.collectionStudents=collectionStudents;
        }else{
            throw new IllegalArgumentException("El nombre de la collecion de los estudiantes no puede ser nulo o vacio");
        }
        this.collectionStudents = collectionStudents;
    }

    public String getCollectionTeachers() {
        return collectionMatters;
    }

    public void setCollectionTeachers(String collectionMatters) {
        if(collectionMatters!=null&& !collectionMatters.isEmpty()){
            this.collectionMatters=collectionMatters;
        }else{
            throw new IllegalArgumentException("El nombre de la collecion de profesores no debe ser nulo o vacio");
        }
    }  
}
