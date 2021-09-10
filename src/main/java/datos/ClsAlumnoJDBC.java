
package datos;

import dominio.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ClsAlumnoJDBC {
    private static final String SQL_SELECT = "select * from tb_empleados";
    private static final String SQL_UPDATE = "update tb_empleados set nombre=?,enero=?,febrero=?, marzo=? where id=?";
    private static final String SQL_INSERT = "insert into tb_empleados(nombre,enero,febrero,marzo) values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from tb_empleados where id=?";
    
    
    public List<ClsAlumno> seleccion(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsAlumno alumno = null;
        List <ClsAlumno> alumnos = new ArrayList<ClsAlumno>();
        
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int enero = rs.getInt("enero");
                int febrero = rs.getInt("febrero");
                int marzo = rs.getInt("marzo");
                
                alumno = new ClsAlumno();
                alumno.setId(id);
                alumno.setNombre(nombre);
                alumno.setEnero(enero);
                alumno.setFebrero(febrero);
                alumno.setMarzo(marzo);
                
                alumnos.add(alumno);
                                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return alumnos; 
    }
    
    public int insert(ClsAlumno alumno){//inserta alumnos, creamos la parte de insert y le mandamos como parametro alumno
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();//realizamos la conexion
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getNombre());//le mandamos lo parametros
            stmt.setDouble(2, alumno.getEnero());
            stmt.setDouble(3, alumno.getFebrero());
            stmt.setDouble(4, alumno.getMarzo());
            
            System.out.println("ejecutando query:" + SQL_INSERT);//ejecutamos el query con insert
            rows = stmt.executeUpdate();//eje el udate
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }
    

    public int deleteDatos(ClsAlumno alumno){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();//realizamos la conexion
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getId());
            System.out.println("Dato eleminado exitosamente:" + SQL_DELETE);//ejecutamos el query con insert
            rows = stmt.executeUpdate();//eje el udate
            System.out.println("Error no se ha eliminado:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }
  
 Scanner t = new Scanner(System.in);
 Scanner t2 = new Scanner(System.in);
 String x;
 public void menu(){
        String opc = "";
        do{ClsAlumnoJDBC alJDBC=new ClsAlumnoJDBC();
            System.out.println("1- Insertar Informacion");
            System.out.println("2- Ver Informacion");
            System.out.println("3- Eliminar Dato");
            System.out.println("4- --------");
            System.out.println("5- Salir");
            opc = t.nextLine();
            switch(opc){
                
                case "1":
                    ClsAlumno Insertar = new ClsAlumno();
               
                    System.out.println("Ingrese nombre del empleado:");
                    x= t2.nextLine();
                    Insertar.setNombre(x);
                   
                    System.out.println("Ingrese Enero");
                    x=t2.nextLine();
                    Insertar.setEnero(Integer.parseInt(x));
                   
                    System.out.println("Ingrese Febrero");
                    x=t2.nextLine();
                    Insertar.setFebrero(Integer.parseInt(x));
                    
                    System.out.println("Ingrese Marzo");
                    x=t2.nextLine();
                    Insertar.setMarzo(Integer.parseInt(x));
                    alJDBC.insert(Insertar);
 
                break;

                case "2":  List<ClsAlumno>todos=alJDBC.seleccion();
                
     
                for (ClsAlumno alumno:todos){
                System.out.println("alumnos"+alumno);
                }
    
                break;   
                case "3":   ClsAlumno delete = new ClsAlumno();
                             
                System.out.println("Ingrese Id a eliminar:");
                x= t2.nextLine();
                delete.setId(Integer.parseInt(x));
                alJDBC.deleteDatos(delete);
                break;
               
                case "4":        
                
                break;}
            
            }while(!opc.equals("5"));
    }
}
        
       
  