
package universidadgrupo10;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Dominio.Alumno;
import Dominio.Inscripcion;
import Dominio.Materia;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
        
        
        
        
        //probando la sentencia Actualizar Datos del alumno
        //objetoAlumno.actualizarDatosAlumno(alumno);

        
        //modificadores de estado RECIBEN ID
        //objetoAlumno.desabilitarEstado(1);
        //objetoAlumno.habilitarEstado(1);
        
        
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
        
        
        //                                      ENTREGA 2
       MateriaData obtenerMateria = new MateriaData();
        /*
       
        //                          Probando metodo GUARDAR MATERIA
        
        Materia materia = new Materia("Estructuras De Datos y Algoritmos",2, true);
        MateriaData obtenerMateria = new MateriaData();
        
        obtenerMateria.guardarMateria(materia);
        
        */
        
        
        //                          Probando metodo BUSCAR MATERIA
        /*
        Materia mat = obtenerMateria.buscarMateria(5);
        System.out.println("Materia");
        System.out.println("ID: "+ mat.getIdMateria());
        System.out.println("Nombre: "+ mat.getNombre());
        System.out.println("Año: "+ mat.getAnio());
        */
        
        
        //                   Probando metodo Modificar Materia
        
        //Materia materia = new Materia(5, "EDA", 2, true);
        //obtenerMateria.modificarMateria(materia);
        
        
        
        //                  Probando Metodo Eliminar Materia
        
        //obtenerMateria.eliminarMateria(3);
        
        
        //                  Probando Metodo Listar Materias
        /*
        List<Materia> listaPrueba = new ArrayList<>();
        
        listaPrueba = obtenerMateria.listarMaterias();
        System.out.println("--------------------------");
        System.out.println("Listado de materias");
        for(Materia materia : listaPrueba){
            
            System.out.println("-------------------------");
            System.out.println("Materia");
            System.out.println("ID: " + materia.getIdMateria());
            System.out.println("Nombre: " + materia.getNombre());
            System.out.println("Anio: " + materia.getAnio());
        }
        */
        
        
        //         ENTREGA DOS / InscripcionData
        
        
        
        
        //              Probvando el metodo guardarAlumno
        
        
        InscripcionData obtenerInscripcion = new InscripcionData();
        /*
        AlumnoData alumno1 = new AlumnoData();
        MateriaData materia1 = new MateriaData();
        
        
        
        Alumno quevedo = alumno1.buscarAlumnoPorID(9);
        Materia ingles = materia1.buscarMateria(4);
        Inscripcion insc = new Inscripcion(9, quevedo, ingles);
        
        obtenerInscripcion.guardarInscripcion(insc);
        */
        
        
        
        
        //          Probando metodo ListarInscripciones
        
        /*
        List<Inscripcion> inscripciones = obtenerInscripcion.obtenerInscripciones();
        
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("Materia");
            System.out.println("ID Alumno: " + inscripcion.getIdAlumno());
            System.out.println("ID Materia: " + inscripcion.getIdMateria());
            System.out.println("NOTA: " + inscripcion.getNota());
            System.out.println("ID Inscripto: " + inscripcion.getIdInscripto());
        
        }
        */
        
        
        
        //              Probando metodo obtenerAlumnosXMateria
        /*
        List<Alumno> alumnosXMateria = obtenerInscripcion.obtenerAlumnosXMateria(2);

        for (Alumno alumno : alumnosXMateria) {
            System.out.println("-----------------------------------------");
            System.out.println("Alumno: ");
            System.out.println("ID: " + alumno.getIdAlumno());
            System.out.println("Nombre  " + alumno.getNombre());
            System.out.println("Apellido  " + alumno.getApellido());
            System.out.println("DNI: " + alumno.getDni());
            System.out.println("FechaNacimiento: " + alumno.getFechaDeNacimiento());
        }

        */
        
       //            
       
       List<Inscripcion> inscripcionesXAlumnos = obtenerInscripcion.obtenerInscripcionesPorAlumno(9);
        
        for(Inscripcion inscri : inscripcionesXAlumnos){
            System.out.println("----------------------------");
            System.out.println("ID Inscripto: " + inscri.getIdInscripto());
            System.out.println("ID Aumno: " + inscri.getIdAlumno());
            System.out.println("ID Materia" + inscri.getIdMateria());
            System.out.println("Nota: " + inscri.getNota());
        }
        
    } 
    
}
