/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package existjava;

import ExistJavaDAO.Loops;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmldb.api.base.XMLDBException;


/**
 *
 * @author xveri
 */
public class ExistJava {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loops x = new Loops();
        try {
            x.startProgram();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | XMLDBException ex) {
            ex.getMessage();
        }
    }   
}
