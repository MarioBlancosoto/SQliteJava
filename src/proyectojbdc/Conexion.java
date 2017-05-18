
package proyectojbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    Alumno alumno = new Alumno();
    ArrayList<Alumno>alumnos = new ArrayList<Alumno>();
    private Connection conectar;
    ResultSet result;
    private String ruta ="/home/mbs/NetBeansProjects/ProyectoJBDC/Alumno.db";
    
    public void cargarArray(){
    alumnos.add(new Alumno(JOptionPane.showInputDialog("Inserta el nombre"),JOptionPane.showInputDialog("inserta el apellido "),JOptionPane.showInputDialog("Inserta el DNI")));
    }
    public void drivers(){
        //Carga de drivers
        try {
            Class.forName("org.sqlite.JDBC");
                    
                    } catch (ClassNotFoundException ex) {
            System.out.println("Drivers non atopados");;
        }
        
    }
    public void conectar(){
        //conexión a  la base de datos,se pasa la ruta por un string con la ruta a la BD
        try {
            conectar = DriverManager.getConnection("jdbc:sqlite:"+ruta);
            System.out.println("Conexión Realizada Correctamente a :"+ruta);
        } catch (SQLException ex) {
            System.out.println("Error de Conexión"+ex.getMessage()+" a "+ruta);;
        }
        
    }
    public void insertarAlumno(){
        
        try {
           //preparedStatement,es como un Objeto Statement pero recibe una acción sobre la BD predefinida o preparada
            PreparedStatement ps = conectar.prepareStatement("Insert into Alumno(nombre,apellidos,dni) values(?,?,?)");
            for(int i=0;i<alumnos.size();i++){
            ps.setString(1,alumnos.get(i).getNome());
            ps.setString(2,alumnos.get(i).getApelido());
            ps.setString(3,alumnos.get(i).getDni());
            ps.execute();
            }
        } catch (SQLException ex) {
            System.out.println("Error,Fallo al insertar :"+ex.getMessage());
        }
        
    }
    
    public void visualizarAlmuno(){
        
        try {
            PreparedStatement ver = conectar.prepareStatement("Select * from Alumno");
           result = ver.executeQuery();
           while(result.next()){
               System.out.println("Nombre  "+":"+ result.getString("nombre"));
               System.out.println("Apellidos "+" :"+result.getString("apellidos"));
               System.out.println("dni"+" :"+result.getString("dni"));
           }
        } catch (SQLException ex) {
            System.out.println("Error al leer  la BD: "+ex.getMessage());
        }
        
    }
    public void borrarAlumno(){
        try {
            PreparedStatement borrar = conectar.prepareStatement("delete from Alumno where dni = ?");
           for(int i=0;i<alumnos.size();i++){
           
            borrar.setString(3,alumnos.get(i).getDni());
            borrar.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
