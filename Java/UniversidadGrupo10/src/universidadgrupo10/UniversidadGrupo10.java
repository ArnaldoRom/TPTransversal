
package universidadgrupo10;

import AccesoADatos.AlumnoData;
import Dominio.Alumno;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UniversidadGrupo10 {

   
    public static void main(String[] args) {
        
        //creamos objeto Alumno para poder hacer las pruebas.
        AlumnoData objetoAlumno = new AlumnoData();
                
        //Probando carga de Alumno
        
        //Alumno alumno = new Alumno(40334343, "Quevedo", "Matias", LocalDate.of(2001,9,11), true);
    
       // objetoAlumno.guardarAlumno(alumno);
            
        
        //Probando el buscador de alumno por id
        /* 
        Alumno alumnos =objetoAlumno.buscarAlumnoPorDni(40590255);
         System.out.println("-----------------------");
         System.out.println("Alumno");
         System.out.println("Nombre:" + alumnos.getNombre());
         System.out.println("Apellido: " + alumnos.getApellido());
         System.out.println("DNI: " + alumnos.getDni());
         System.out.println("Estado: " + alumnos.getFechaDeNacimiento());
        */
        
        
        //Probando la sentencia eliminar
        //objetoAlumno.eliminarAlumno(2);
        
        //probando la sentencia Actualizar Datos del alumno
        //objetoAlumno.actualizarDatosAlumno(alumno);
        
        //modificadores de estado
        //objetoAlumno.desabilitarEstado(41570334);
        //objetoAlumno.habilitarEstado(41570334);
        
        
        //Probando el listar Alumnos ACTIVOS.
         //List<Alumno> alumnos = objetoAlumno.listarAlumnos();
        /*
        for(Alumno alumno : alumnos){
            
            System.out.println("-----------------------");
            System.out.println("Alumno");
            System.out.println("Nombre:" + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("DNI: " + alumno.getDni());
            System.out.println("Estado: " + alumno.getFechaDeNacimiento());
        
        }
        */
    } 
    
}
