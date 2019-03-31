/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author xveri
 */
class Evento {
    private String userName;
    private String message;
    private int type;
    
    public Evento() {}

    public Evento(String userName, Empleado x, int type) {
        this.userName = userName;
        this.message = setMessage(x, type);
        this.type = type;
    }
    
    private String setMessage(Empleado x, int type) {
        Date date = new Date();
        SimpleDateFormat y = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String aux = "";
        switch(type) {
            case 0:
                aux = "User '" + x.getUserName() + "' logged into the system at " + y.format(date);
                break;
            case 1:
                aux = "User '" + x.getUserName() + "' created an urgent incident at " + y.format(date);
                break;
            case 2:
                aux = "User '" + x.getUserName() + "' made a query at " + y.format(date);
                break;
        }
        return aux;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

