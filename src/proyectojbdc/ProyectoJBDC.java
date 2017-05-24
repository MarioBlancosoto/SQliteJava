
package proyectojbdc;


public class ProyectoJBDC {

  
    public static void main(String[] args) {
      Conexion con = new Conexion();

      
      con.conectar();
   
    // con.visualizarAlmuno();
     //con.borrarAlumno();
     VentanaDatos ventana = new VentanaDatos();
     ventana.setVisible(true);
     
     
    }
    
}
