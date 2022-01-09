
package agenda;


public class Agenda {
    

    private Contacto contactos[];

    // establecemos un tamaño por defecto de 10 contactos

    public Agenda() {

         contactos = new Contacto[10];

    }
    
    public Agenda(int tamanio){

        contactos = new Contacto[tamanio];

    }
//Creamos el metodo para salir contactos a la agenda
    public void anadirContacto(Contacto contacto){
        if(comprobarSiExisteContacto(contacto)){
            System.out.println("\nYa existe un contacto con ese nombre ,por favor ");
       }
       else if (comprobarAgendaLlena()){
            System.out.println("\nLa agenda esta Llena");
      }  
       else{
            boolean registrado = false;
            for (int i =0;i<contactos.length && !registrado; i ++){
                   if(contactos[i]==null){
                        contactos[i]= contacto;
                        registrado = true;      
                }
           } 
           if (registrado == true){
                 System.out.println("\nEl contacto se ha registrado con exito !! "); 
           }else{
                 System.out.println("\nNO se ha podido registrar el contacto ");
           }       
      }
  
    }

//creamos el metodo para comprobar contactos con el mismo nombre

    public boolean comprobarSiExisteContacto(Contacto contacto){
        for (int i = 0 ; i < contactos.length; i++){
             if(contactos[i] != null && contactos[i].equals(contacto)){
                   return true; 
               
            }
        }
        return false; 
   }

// comprobar agenda llena

public boolean comprobarAgendaLlena(){
    for(int i = 0 ; i < contactos.length; i ++){
        if(contactos[i] == null){
             return false;  
        }

   }
   return true;
}
public void listarCotactos(){
    if(comprobarSiHayHuecosLibres()== contactos.length){
        System.out.println("\nNO hay contactos en la lista");
        System.out.println("");
}
 else{
      for(int i = 0; i<contactos.length; i++){
          if(contactos[i] != null){
              System.out.println("\nNombre : " + contactos[i].getNombre());
              System.out.println("\nTelefono : " + contactos[i].getTelefono());
}
}
}
}

public int comprobarSiHayHuecosLibres(){
      int contadorVacios = 0;
      for(int i = 0; i < contactos.length; i ++){
          if (contactos[i] == null){
           contadorVacios ++;
          }
    }
    return contadorVacios;
  }
    public void buscarContacto (String nombre){
        boolean encontrado = false;
        for (int i = 0; i<contactos.length && !encontrado; i++){
        if(contactos[i] !=null && contactos[i].getNombre().trim().equalsIgnoreCase(nombre.trim())){
            System.out.println("\nContacto encontrado ,su Número es :" + contactos [i].getTelefono());
            encontrado = true;
       }

       }

       if (!encontrado){
            System.out.println("\nNo se ha encontrado el contacto");
    }

    }

    public void eliminarContacto( Contacto contacto){
        boolean eliminado = false;
        for (int i = 0 ; i < contactos.length && !eliminado; i++){

        if(contactos[i] != null && contactos[i].getNombre().equals(contacto)){
              contactos[i]= null;
              eliminado = true;
        }

    }
     if (eliminado == true){
         System.out.println("\nEl contacto se ha elinado");
}else{
         System.out.println("\nEl contacto no se ha eliminado");
}
    }

}