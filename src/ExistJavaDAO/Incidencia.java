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
    private boolean isResolved = false;

    public Incidencia(){}
    
    public Incidencia(String id, String fromUser, String toUser, String message, boolean isUrgent) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.message = message;
        this.isUrgent = isUrgent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public boolean isIsResolved() {
        return isResolved;
    }

    public void setIsResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }
    
    public void resolveIncident() {
        this.isResolved = true;
    }
}
