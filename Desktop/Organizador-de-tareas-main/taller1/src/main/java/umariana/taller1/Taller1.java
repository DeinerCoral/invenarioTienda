package umariana.taller1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import mundo.Tarea;

/**
 *
 * @Deiner felipe Coral
 */
public class Taller1 {

   
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Tarea> misTareas = new ArrayList<>();

        boolean activo = true;
        do{
            
            System.out.println("---Menu de opciones---------");
            System.out.println("---1.Agregar tarea----------");
            System.out.println("---2.Mostrar tarea----------");
            System.out.println("---3.Ordenar tareas---------");
            System.out.println("---4.Terminar programa------");
            System.out.println("---Seleccione una opcion----");
            System.out.println("----------------------------");
            
            int opcion = sc.nextInt();
            switch(opcion){
                //case 1 tareas por agregar
                case 1:
                    System.out.println("Ingrese el id de la tarea");
                    int id=sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Ingrese la descripcion de la tarea");
                    String descripcion = sc.nextLine();
                    
                    System.out.println("Ingrese la prioridad de 1-5");
                    int prioridad = sc.nextInt();
                    
                   //Creacion del objeto y llenar la informacion 
                   Tarea nuevaTarea = new Tarea(id,descripcion,prioridad); 
                   //Almacenar en la contenedora
                   misTareas.add(nuevaTarea);
                   System.out.println("Tarea agregada satisfactoriamente ");
                   
                    break;
                    // case 2 para ver tareas registradas
                case 2:
                    System.out.println("TAREAS REGISTRADAS");
                    //for para recorrer el array y muestre las tareas 
                    for (Tarea t: misTareas) {
                        System.out.println("id: " + "" + t.getIdTarea() );
                        System.out.println("descripcion: " + "" + t.getDescripcion());
                        System.out.println("prioridad: " + "" + t.getPrioridad());
                    }
                    break;
                    
                    // case 3 ordernar de manera descendente 
                case 3:
                    // ordenar las tareas por prioridad descendentemente
                      Collections.sort(misTareas, (tarea1, tarea2) -> tarea2.getPrioridad() - tarea1.getPrioridad());
                    // mostrar las tareas ordenadas por prioridad descendentemente
                     System.out.println("Tareas ordenadas por prioridad de forma descendente:");
                     for (Tarea tarea : misTareas) {
                      System.out.println("id: " + tarea.getIdTarea());
                      System.out.println("descripcion:" + tarea.getDescripcion());
                      System.out.println("prioridad: " + tarea.getPrioridad());
                     }
             break;

                case 4:
                     //cerrar programa
                    activo = false; System.out.println("Programa Terminado");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    
            }
            
        }while(activo);
    }

    
}
