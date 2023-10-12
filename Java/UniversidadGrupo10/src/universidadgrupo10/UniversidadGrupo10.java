
package universidadgrupo10;

import AccesoADatos.AlumnoData;
import Dominio.Alumno;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UniversidadGrupo10 {

   
    public static void main(String[] args) {
        
        //creamos objeto Alumno para poder hacer las pruebas.
        AlumnoData objetoAlumno = new AlumnoData();
                
        //Probando carga de Alumno
        
        //Alumno alumno = new Alumno(40334343, "Quevedo", "Matias", LocalDate.of(2001,9,11), true);
    
       //objetoAlumno.guardarAlumno(alumno);
       
        
        //Juanjo pasion! att el panda
        
        
        //Probando el buscador de alumno por id
        //objetoAlumno.buscarAlumnoPorDni(40590255);
        
        //Probando la sentencia eliminar
        //objetoAlumno.eliminarAlumno(2);
        
        //probando la sentencia Actualizar Datos del alumno
        //objetoAlumno.actualizarDatosAlumno(alumno);
        
        //modificadores de estado
        //objetoAlumno.desabilitarEstado(41570334);
        //objetoAlumno.habilitarEstado(41570334);
        
        
        //probando el listar Alumnos ACTIVOS.
        //objetoAlumno.listarAlumnos();
        
        
        
    }
    
}
