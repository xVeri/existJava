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
public class Empleado {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String lastLogin;
    
    public Empleado() {}

    public Empleado(String userName, String firstName, String lastName, String password, Date lastLogin) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        SimpleDateFormat y = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.lastLogin = y.format(lastLogin);
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public void setLastLogin(Date x) {
        SimpleDateFormat y = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.lastLogin = y.format(x);
    }
}
