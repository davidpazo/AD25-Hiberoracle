package hiberoracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import orcl.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author oracle
 */
public class Hiberoracle {

    
    public DefaultTableModel listado() {
        DefaultTableModel tabla = new DefaultTableModel ();
        try {
            String consulta = "from Productos";
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(consulta);
            List list = q.list();
            ResultSet rs = (ResultSet) q.list();
           
            Object [] fila = new Object[3];
            while (rs.next()) {
               String cod = rs.getString(1);
               String des = rs.getString(2);
               int prezo = rs.getInt(3);
               
               fila [1] = cod;
               fila [2] = des;
               fila [3] = prezo;
               
               tabla.addRow(fila);
               
            }
  
        } catch (SQLException ex) {
            System.out.println("SQLException "+ ex);
        }
        return tabla;
}
    /*
    private void displayResult(List resultList) {
    Vector<String> tableHeaders = new Vector<String>();
    Vector tableData = new Vector();
    tableHeaders.add("Codigo"); 
    tableHeaders.add("Descripcion");
    tableHeaders.add("Precio");
   

    for(Object o : resultList) {
        
        Vector<Object> oneRow = new Vector<Object>();
        oneRow.add(pro.getActorId());
        oneRow.add(pro.getFirstName());
        oneRow.add(pro.getLastName());
        oneRow.add(pro.getLastUpdate());
        tableData.add(oneRow);
    }
    */
}
