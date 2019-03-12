/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

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
    private Date lastLogin;

    public Empleado(String userName, String firstName, String lastName, String password, Date lastLogin) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public String getUserName() {
        return userName;
    }
    
    
}
