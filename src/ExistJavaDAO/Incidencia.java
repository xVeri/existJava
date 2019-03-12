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
public class Incidencia {
    private String id;
    private String fromUser;
    private String toUser;
    private String message;
    private boolean isUrgent;

    public Incidencia(String id, Empleado fromUser, String toUser, String message, boolean isUrgent) {
        this.id = id;
        this.fromUser = fromUser.getUserName();
        this.toUser = toUser;
        this.message = message;
        this.isUrgent = isUrgent;
    }
}
