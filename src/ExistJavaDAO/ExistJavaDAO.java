/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

import java.io.File;
import java.util.List;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import javax.xml.transform.OutputKeys;
import org.exist.xmldb.EXistResource;
/**
 *
 * @author xveri
 */
public class ExistJavaDAO implements DAOInterface {

    @Override
    public void insertEmpleado(Empleado e) {
    }
    
    @Override
    public boolean loginEmpleado(String user, String pass) {
    }

    @Override
    public void updateEmpleado(Empleado e) {
    }

    @Override
    public void removeEmpleado(Empleado e) {
    }

    @Override
    public Incidencia getIncidenciaById(int id) {
    }

    @Override
    public List<Incidencia> selectAllIncidencias() {
    }

    @Override
    public void insertIncidencia(Incidencia i) {
    }

    @Override
    public List<Incidencia> getIncidenciaByDestino(Empleado e) {
    }

    @Override
    public List<Incidencia> getIncidenciaByOrigen(Empleado e) {
    }

    @Override
    public void insertarEvento(Evento e) {
    }

    @Override
    public Evento getUltimoInicioSesion(Empleado e) {
    }

    @Override
    public List<RankingTO> getRankingEmpleados() {
    }
    
}
