/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmldb.api.base.XMLDBException;

/**
 *
 * @author xveri
 */
public class Loops {
    
    EmpresaXND func;
    Boolean logged = false;
    
    public void startProgram() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        func = new EmpresaXND();
        Boolean finish = false;
        while(!finish) {
            menu();
            System.out.print("Opcion: ");
            String option = askString();
            switch(option) {
                case "1":
                    try {
                        firstCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("Hasta pronto!");
                    finish = true;
                default:
                    try {
                        propagateError();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }
    
    private void firstCase() throws MyException {
        System.out.print("Username: ");
        String username = askString();
        System.out.print("Password: ");
        String password = askString();
        try {
            if (func.loginEmpleado(username, password)) {
                logged = true;
                System.out.println("<Info> Loggin realizado con éxito <Info>");
                System.out.println("Bienvenido " + EmpresaXND.loggedEmpleado.getFirstName());
            } else {
                throw new MyException(2); 
            }
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void propagateError() throws MyException{
        throw new MyException(1);
    }
    
    private void menu() {
        System.out.println("\n-------------------------------");
        System.out.println("<Info> Non logged services <Info>");
        System.out.println("1.- Loggin");
        System.out.println("2.- Registro");
        System.out.println("<Info> Logged services <Info>");
        System.out.println("3.- Modificar datos");
        System.out.println("4.- Borrar cuenta");
        System.out.println("5.- Consultar incidencia por ID");
        System.out.println("6.- Consultar todas las incidencias");
        System.out.println("7.- Crear nueva incidencia");
        System.out.println("8.- Consultar incidencia por destino");
        System.out.println("9.- Consultar incidencia por origen");
        System.out.println("0.- Salir");
        System.out.println("-------------------------------\n");
    }
    
    private static String askString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = null;
        try {
            cadena = br.readLine();
        } catch (IOException ex) {
        }
        return cadena;
    }
}
