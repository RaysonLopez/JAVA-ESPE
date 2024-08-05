/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package connectionBD.CRUD;

import org.bson.Document;

/**
 *
 * @author Rayson
 */
public interface MongoCRUD {
    void delete(String user);
    void save(Document document);
    void update(String id,Document document);
    boolean find(String user,String password);
}
