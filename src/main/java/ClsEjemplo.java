
import datos.ClsAlumnoJDBC;
import dominio.ClsAlumno;
import java.sql.*;
import java.util.*;


/**
 *
 * @author PC
 */
public class ClsEjemplo {
    
    public static void ej1(){
    
        
        //paso 1 definir el string de conexion
        String url = "jdbc:mysql://localhost:3306/dbempleados?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try{
         //paso 2 crear el obj conexion
         Connection conexion = DriverManager.getConnection(url,"root","Jesus21%");
         
         //paso 3 crear el objeto statement
         Statement sentencia = conexion.createStatement();
         
         //paso 4 crear instruccion
         String sql = "select * from tb_empleados";
         
         //paso 5 ejecutamos el query
         ResultSet resultado = sentencia.executeQuery(sql);
         
         //paso 6 procesar el resultado
         while(resultado.next()){
             System.out.println("id = "+resultado.getInt(1));//No.1 es el numero de columna
             System.out.println("Nombre = "+resultado.getString(2));
             System.out.println("Enero = "+resultado.getInt(3));
             System.out.println("Febrero = "+resultado.getInt(4));
             System.out.println("Marzo = "+resultado.getInt(5));
             
         }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);  
        }
    }

    
    
    public static void main(String[] args) {
    ClsAlumnoJDBC alu = new ClsAlumnoJDBC();
    alu.menu();
    
    
   /*
    ej1();
    alu.setNombre("Juan");
    alu.setEnero(80);
    alu.setFebrero(90);
    alu.setMarzo(10);
    
    alumnoJDBC.insert(alu);//lo invocamos con el insert
    
    
    List<ClsAlumno> todos = alumnoJDBC.seleccion();
    
    for (ClsAlumno al : todos){
        System.out.println("Alumno = " + al);
 
    
    }*/
   
  }
}