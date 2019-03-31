/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

import java.util.List;
import org.xmldb.api.base.XMLDBException;

/**
 *
 * @author mfontana
 */
public interface DAOInterface {

    // Método para insertar un nuevo empleado.
    public boolean insertEmpleado(Empleado e) throws XMLDBException;

    // Método para validar el login de un empleado.
    public boolean loginEmpleado(String user, String pass) throws XMLDBException;

    // Método para modificar el perfil de un empleado.
    public void updateEmpleado(Empleado e) throws XMLDBException;

    // Método para eliminar un empleado.
    public boolean removeEmpleado(Empleado e) throws XMLDBException;

    // Obtener una Incidencia a partir de su Id.
    public Incidencia getIncidenciaById(String id) throws XMLDBException, MyException;

    // Obtener una lista de todas las incidencias
    public List<Incidencia> selectAllIncidencias() throws XMLDBException;

    // Insertar una incidencia a partir de un objeto incidencia
    public boolean insertIncidencia(Incidencia i) throws XMLDBException;

    // Obtener la lista de incidencias con destino un determinado
    // empleado, a partir de un objeto empleado.
    public List<Incidencia> getIncidenciaByDestino(Empleado e) throws XMLDBException;

    // Obtener la lista de incidencias con origen un determinado
    // empleado, a partir de un objeto empleado.
    public List<Incidencia> getIncidenciaByOrigen(Empleado e) throws XMLDBException;

    
    // Método para insertar un evento en la tabla historial.
    // Pasaremos como parámetro un objeto tipo evento, y no devolverá nada.
    // Llamaremos a este método desde los métodos
    // que producen los eventos, que son 3:
    // 1) Cuando un usuario hace login 
    // 2) Cuando un usuario crea una incidencia de tipo urgente 
    // 3) Cuando se consultan las incidencias destinadas a un usuario 
    public void insertarEvento(Evento e) throws XMLDBException;
    
    // Obtener la fecha-hora del último inicio de sesión para un empleado.
    public Evento getUltimoInicioSesion(Empleado e) throws XMLDBException;

    // Obtener el ranking de los empleados por cantidad de incidencias
    // urgentes creadas (más incidencias urgentes primero).
    public RankingTO getRankingEmpleados();

}
