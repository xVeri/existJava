/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import org.xmldb.api.base.XMLDBException;

/**
 *
 * @author xveri
 */
public class Loops {

    private static EmpresaXND func;
    private static Boolean logged = false;

    public void startProgram() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        func = new EmpresaXND();
        Boolean finish = false;
        while (!finish) {
            menu();
            System.out.print("Opción: ");
            String option = askString();
            switch (option) {
                case "1":
                    try {
                        firstCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "2":
                    try {
                        secondCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "3":
                    try {
                        thirdCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "4":
                    try {
                        fourthCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "5":
                    try {
                        fifthCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "6":
                    try {
                        sixthCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "7":
                    try {
                        seventhCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "8":
                    try {
                        eightCase();
                    } catch (MyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "9":
                    try {
                        ninethCase();
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
    
    private void ninethCase() throws MyException {
        if (!logged) { throw new MyException(4); }        
        try {
            List<Incidencia> aux = func.getIncidenciaByOrigen(EmpresaXND.loggedEmpleado);
            for (Incidencia x : aux) {
                System.out.println("---------------------------");
                System.out.println("Id: " + x.getId());
                System.out.println("From: " + x.getFromUser());
                System.out.println("To: " + x.getToUser());
                System.out.println("Message: " + x.getMessage());
                System.out.println("Urgent: " + (x.isIsUrgent()? "Yes" : "No"));
                System.out.println("Resolved: " + (x.isIsResolved()? "Yes" : "No"));
                System.out.println("---------------------------");
            }
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void eightCase() throws MyException {
        if (!logged) { throw new MyException(4); }        
        try {
            List<Incidencia> aux = func.getIncidenciaByDestino(EmpresaXND.loggedEmpleado);
            for (Incidencia x : aux) {
                System.out.println("---------------------------");
                System.out.println("Id: " + x.getId());
                System.out.println("From: " + x.getFromUser());
                System.out.println("To: " + x.getToUser());
                System.out.println("Message: " + x.getMessage());
                System.out.println("Urgent: " + (x.isIsUrgent()? "Yes" : "No"));
                System.out.println("Resolved: " + (x.isIsResolved()? "Yes" : "No"));
                System.out.println("---------------------------");
            }
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void seventhCase() throws MyException {
        System.out.print("Desired id: ");
        String id = askString();
        System.out.print("Destination user: ");
        String toUser = askString();
        System.out.print("Message: ");
        String message = askString();
        System.out.print("Urgent (Y/N): ");
        String urgent = askString();
        Incidencia e = new Incidencia(id, EmpresaXND.loggedEmpleado.getUserName(), toUser, message, urgent.equalsIgnoreCase("y"));
        try {
            if (func.insertIncidencia(e)) {
                System.out.println("<Info> Incidencia creada con éxito <Info>");
            } else {
                throw new MyException(6);
            }
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void sixthCase() throws MyException {
        if (!logged) { throw new MyException(4); }        
        try {
            List<Incidencia> aux = func.selectAllIncidencias();
            for (Incidencia x : aux) {
                System.out.println("---------------------------");
                System.out.println("Id: " + x.getId());
                System.out.println("From: " + x.getFromUser());
                System.out.println("To: " + x.getToUser());
                System.out.println("Message: " + x.getMessage());
                System.out.println("Urgent: " + (x.isIsUrgent()? "Yes" : "No"));
                System.out.println("Resolved: " + (x.isIsResolved()? "Yes" : "No"));
                System.out.println("---------------------------");
            }
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void fifthCase() throws MyException {
        if (!logged) { throw new MyException(4); }
        System.out.print("Introduce la ID de la incidencia a consultar: ");
        String id = askString();
        try {
            Incidencia x = func.getIncidenciaById(id);
            System.out.println("---------------------------");
            System.out.println("Id: " + x.getId());
            System.out.println("From: " + x.getFromUser());
            System.out.println("To: " + x.getToUser());
            System.out.println("Message: " + x.getMessage());
            System.out.println("Urgent: " + (x.isIsUrgent()? "Yes" : "No"));
            System.out.println("Resolved: " + (x.isIsResolved()? "Yes" : "No"));
            System.out.println("---------------------------");
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void fourthCase() throws MyException {
        if (!logged) { throw new MyException(4); }
        System.out.println(EmpresaXND.loggedEmpleado.getUserName());
        System.out.print("Escribe tu nombre de usuario para borrar la cuenta: ");
        String delete = askString();
        if (delete.equals(EmpresaXND.loggedEmpleado.getUserName())) {
            try {
                func.removeEmpleado(EmpresaXND.loggedEmpleado);
                logged = false;
            } catch (XMLDBException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            throw new MyException(5);
        }
    }
    
    private void thirdCase() throws MyException {
        if (!logged) { throw new MyException(4); }
        System.out.println("<-- Dejar las respuestas en blanco para no modificar el campo -->");
        
        //Name
        System.out.print("New first name: ");
        String firstName = askString();
        if (firstName.equalsIgnoreCase("")) { firstName = EmpresaXND.loggedEmpleado.getFirstName(); }
        EmpresaXND.loggedEmpleado.setFirstName(firstName);
        
        //Surname
        System.out.println("New last name: ");
        String lastName = askString();
        if (lastName.equalsIgnoreCase("")) { lastName = EmpresaXND.loggedEmpleado.getLastName(); }
        EmpresaXND.loggedEmpleado.setLastName(lastName);
        
        //Password
        System.out.println("New password: ");
        String password = askString();
        if (password.equalsIgnoreCase("")) { password = EmpresaXND.loggedEmpleado.getPassword(); }
        EmpresaXND.loggedEmpleado.setPassword(password);
        
        try {
            func.updateEmpleado(EmpresaXND.loggedEmpleado);
            System.out.println("<Info> Usuario modificado con éxito <Info>");   
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    private void secondCase() throws MyException {
        System.out.print("Username: ");
        String username = askString();
        System.out.print("Password: ");
        String password = askString();
        System.out.print("First name: ");
        String firstName = askString();
        System.out.print("Last name: ");
        String lastName = askString();
        Empleado e = new Empleado(username, firstName, lastName, password, new Date());
        try {
            if (func.insertEmpleado(e)) {
                System.out.println("<Info> Usuario registrado con éxito <Info>");
            } else {
                throw new MyException(3);
            }
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
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
                EmpresaXND.loggedEmpleado.setLastLogin(new Date());
                func.updateEmpleado(EmpresaXND.loggedEmpleado);
            } else {
                throw new MyException(2);
            }
        } catch (XMLDBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void propagateError() throws MyException {
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
            System.out.println(ex.getMessage());
        }
        return cadena;
    }
}
