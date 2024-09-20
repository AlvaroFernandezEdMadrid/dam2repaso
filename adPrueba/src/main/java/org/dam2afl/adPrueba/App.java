package org.dam2afl.adPrueba;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Alumno a, b, c;
      Grupo g;
      
      a=Alumno.builder().
    		  dni("001").
    		  nombre("A1").
    		  edad(20).
    		  build();
      
      b=Alumno.builder().
    		  dni("002").
    		  nombre("A1").
    		  build();
      
      c=new Alumno("003");
      
      g=Grupo.builder().
    		  nombre("G1").
    		  alumno(a).
    		  alumno(b).
    		  build();
    		  
      
     g.addAlumno(c); //Por el @Singular, necesito hacer la funcion de addAlumno en la clase Grupo
      
      System.out.println(g);
      
      System.out.println(a.equals(b));
      
    }
}
