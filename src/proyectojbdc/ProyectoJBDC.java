
package proyectojbdc;


public class ProyectoJBDC {

  
    public static void main(String[] args) {
      Conexion con = new Conexion();
      //con.cargarArray();
      con.drivers();
      con.conectar();
     // con.insertarAlumno();
      con.visualizarAlmuno();
      con.borrarAlumno();
    }
    
}
