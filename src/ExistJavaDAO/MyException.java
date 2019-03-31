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
        "<Error> Ya existe un usuario con este username <Error>",
        "<Error> Debes estar loggeado para realizar esta operación <Error>",
        "<Info> No has escrito bien el nombre de usuario. Operación cancelada <Info>",
        "<Error> Ya existe una incidencia con esta id <Error>"
    };
}
