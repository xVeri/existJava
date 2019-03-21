/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExistJavaDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.transform.OutputKeys;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.CompiledExpression;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author xveri
 */
public class EmpresaXND implements DAOInterface {

    //Start of user variables declaration
    
    private final Database database;
    private final String uri = "xmldb:exist://localhost:8080/exist/xmlrpc";
    private final String user = "admin";
    private final String pass = "";
    private final String colecEmpleados = "/db/empleados/employees";
    private final String colecIncidencias = "/db/empleados/Incidencias";
    private final String colecEvento = "/db/empleados/Eventos";
    private final String colecRankingTO = "/db/empleados/RankingsTO";
    
    
    //Finish of user variables declaration

    //Start of user functions for DAOInterface
    
    public EmpresaXND() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String driver = "org.exist.xmldb.DatabaseImpl";
        Class c1;
        c1 = Class.forName(driver);
        database = (Database) c1.newInstance();
        DatabaseManager.registerDatabase(database);
    }

    @Override
    public boolean insertEmpleado(Empleado e) throws XMLDBException {
        if (!existEmpleado(e)) {
            String query
                    = "update insert <employee>"
                    + "<userName>" + e.getUserName() + "</userName>"
                    + "<firstName>" + e.getFirstName() + "</firstName>"
                    + "<lastName>" + e.getLastName() + "</lastName>"
                    + "<password>" + e.getPassword() + "</password>"
                    + "<lastLogin>" + e.getLastLogin() + "</lastLogin>"
                    + "</employee> into /company";
            executeQueryUpdate(colecEmpleados, query);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean loginEmpleado(String user, String pass) throws XMLDBException {
        String query = "for $l in //empleados/employees let $user := $l/userName let $pass := $l/password"
                + "where $user = '" + user + "' and $pass = '" + pass + "' return $l";
        ResourceSet result = executeXQuery(colecEmpleados, query);
        if (result.getSize() == 1) {
            ResourceIterator iterator = result.getIterator();
            while(iterator.hasMoreResources()) {
                XMLResource res = (XMLResource) iterator.nextResource();
                Node nodo = res.getContentAsDOM();
                NodeList hijo = nodo.getChildNodes();
                NodeList datosEmpleado = hijo.item(0).getChildNodes();
                //FALTA LEER EMPLEADO
            }
        }
        return false;
        //return result.getSize() == 1;
    }

    @Override
    public void updateEmpleado(Empleado e) {
        
    }

    @Override
    public boolean removeEmpleado(Empleado e) {
        return false;
    }
    
    @Override
    public Incidencia getIncidenciaById(String id) {    //TODO
        return new Incidencia("s", new Empleado("s", "a", "s", "a", new Date()), "s", "s", true);
    }
    
    @Override
    public List<Incidencia> selectAllIncidencias() {    //TODO
        return new ArrayList<Incidencia>();
    }

    @Override
    public boolean insertIncidencia(Incidencia i) {
        return false;
    }

    @Override
    public List<Incidencia> getIncidenciaByDestino(Empleado e) {    //TODO
        return new ArrayList<Incidencia>();

    }

    @Override
    public List<Incidencia> getIncidenciaByOrigen(Empleado e) {     //TODO
        return new ArrayList<Incidencia>();
    }

    @Override
    public boolean insertarEvento(Evento e) {
        return false;
    }

    
    @Override
    public Evento getUltimoInicioSesion(Empleado e) {   //TODO
        return new Evento("s", new Empleado("s", "s", "s", "s", new Date()), 0);
    }
    
    @Override
    public RankingTO getRankingEmpleados() {    //TODO
        return new RankingTO();
    }
    
    
    //Finish of user functions for DAOInterface
    
    
    //Start of user extra functions
    
    /**
     * Set Up the XQueryService
     *
     * @param coleccion Path in ExistsDB
     * @return XQueryService ready to use
     * @throws XMLDBException
     */
    private XQueryService setUpQuery(String coleccion) throws XMLDBException {
        Collection col = DatabaseManager.getCollection(uri + coleccion, user, pass);
        XQueryService servicio = (XQueryService) col.getService("XQueryService", "1.0");
        servicio.setProperty(OutputKeys.INDENT, "yes");
        servicio.setProperty(OutputKeys.ENCODING, "UTF-8");
        return servicio;
    }

    /**
     * Executes the Query
     *
     * @param colection Path in ExistsDB
     * @param consulta Query
     * @return ResourceSet of the query
     * @throws XMLDBException
     */
    private ResourceSet executeXQuery(String colection, String consulta) throws XMLDBException {
        XQueryService service = setUpQuery(colection);
        ResourceSet result = service.query(consulta);
        return result;
    }

    /**
     * Returns a boolean based in if a username form Empleado does exist or not
     *
     * @param e Empleado to create
     * @return boolean
     * @throws XMLDBException
     */
    private boolean existEmpleado(Empleado e) throws XMLDBException {
        String query = "for $t in //empleados/employees/userName where $t='" + e.getUserName() + "' return $t";
        ResourceSet result = executeXQuery(colecEmpleados, query);
        return result.getSize() > 0;
    }
    
    /**
     * Executes the query of a selected colection
     * @param colection
     * @param query
     * @throws XMLDBException 
     */
    private void executeQueryUpdate(String colection, String query) throws XMLDBException {
        XQueryService servicio = setUpQuery(colection);
        CompiledExpression consultaCompilada = servicio.compile(query);
        servicio.execute(consultaCompilada);
    }
    
    //Finish of user extra functions
}
