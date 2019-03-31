/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

/**
 *
 * @author xveri
 */
public class MyException extends Exception {
    
    public MyException(int x) {
        super(ERROR[x]);
    }
    
    private static final String[] ERROR = {
        "<Info> No existe una incidencia con esta id <Info>",
        "<Error> Opción incorrecta <Error>",
        "<Error> Credenciales incorrectas <Error>",
        ""
    };
}
