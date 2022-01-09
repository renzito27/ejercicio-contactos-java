package agenda;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;

public class Registro {

 
    public static void main(String[] args) {

         Scanner teclado = new Scanner(System.in) ;       
         int opcion;
         int telefono;
         String nombre;
         Contacto contacto;
         int tamanioAgenda;
         
         tamanioAgenda = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el numero de contactos para su agenda"));
         Agenda agendaTelefonica = new Agenda(tamanioAgenda);

        do{
            System.out.println("\nBIENVENIDO A LA AGENDA");
            System.out.println("1 . Añadir contacto");
            System.out.println("2 . Listar contactos");
            System.out.println("3 . Buscar contacto");
            System.out.println("4 . Comprobar si existe contacto");
            System.out.println("5 . Eliminar contacto");
            System.out.println("6 . Comprobar contactos disponibles");
            System.out.println("7 . Comprobar si la agenda esta llena");
            System.out.println("8 . salir");
            opcion = teclado.nextInt();

            switch(opcion){
            // + contacto
            case 1:
                System.out.println("\nDigite su nombre: ");
                nombre = teclado.next();
               
                System.out.println("\nDigite su telefono: "); 
                telefono = teclado.nextInt();

                contacto = new Contacto(nombre ,telefono);
                agendaTelefonica.anadirContacto(contacto);
                System.out.println("");
                break;
            // list contacto
            case 2:
                agendaTelefonica.listarCotactos();
                System.out.println("");
               break; 
            
            case 3:
         
               System.out.println("\nDigite un nombre");
               nombre = teclado.next();

               agendaTelefonica.buscarContacto(nombre);
                System.out.println("");
               break;
           
            case 4:
               System.out.println("\nDigite su nombre : ");
               nombre = teclado.next();
               contacto = new Contacto(nombre);
               if(agendaTelefonica.comprobarSiExisteContacto(contacto)){
                   System.out.println("\nEl contacto ya existe"); 
              }
                else{
                   System.out.println("\nEl contacto no existe");
              }
                   System.out.println("");
               break;                          
        
            case 5:
               System.out.println("\nDigite su nombre");
               nombre = teclado.next();

               contacto = new Contacto(nombre);
               agendaTelefonica.eliminarContacto(contacto);
               System.out.println("");
               break;

            case 6:
               System.out.println("\nHay" + agendaTelefonica.comprobarSiHayHuecosLibres() + "contactos");
               break;   
           
            case 7:
               if(agendaTelefonica.comprobarAgendaLlena()){
                   System.out.println("\nLa agenda esta llena");
               }else{
                   System.out.println("\nAun puedes ingresar contactos");
               }
               System.out.println("");
               break;  

            case 8:
                System.out.println("\n Gracias");
                opcion = 8;
               break;          
 
            default:
                System.out.println("\nPor Favor digite una opcion válida");
                System.out.println("");
                
               break;
}

     }while( opcion != 8);
         
    }
    
}
