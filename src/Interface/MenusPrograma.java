/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Utils.ReadDades;

/**
 *
 * @author Grup a4.U5_14
 */
public class MenusPrograma {
   
    
    /**
    * Muestra un menú y solicita una opción al usuario
    * @author Grup a4.U5_14
    * @param menu es un String que indica qué menú debe mostrarse cada vez
    * @return opcion es un Int que indica qué opción ha seleccionado el usuario
    */
    public int mostrarMenu(String menu){
        ReadDades misReadDades = new ReadDades();
        String elementos[]=menuEscogido(menu);
        imprimirMenu(elementos);
        int opcion = misReadDades.ReadIntMenu(elementos.length);        
        return opcion;
    }
    
    /**
     * Este método devuelve el menú solicitado por el programa
     * @param menu
     * @return un array de Strings correspondiente al menú escogido
     * @author Grup a4.U5_14
     */
    public String[] menuEscogido(String menu){
        String elementos[]=null;
        switch (menu){
            case "mPrincipal":
                System.out.println("\nMenú Principal");
                elementos=getMenuPrincipal();
                break;
            case "mParticipants":
                System.out.println("\nMenú participants");
                elementos=getMenuParticipants();
                break;
            case "mConcurs":
                System.out.println("\nMenú Concurs");
                elementos=getMenuConcurs();
                break;
            case "mConfirmacio":
                System.out.println("\nConfirmació");
                elementos=getMenuConfirmacio();
                break;
            case "mTwitter":
                System.out.println("\nLlistats per Twitter");
                elementos=getMenuTwitter();
                break;
            case "mInfo":
                System.out.println("\nLlistats");
                elementos=getMenuInfo();
                break;
            default:
                System.out.println("\nNo s'ha triat menú.");
        }
        return elementos;
    }

    /**
     * Este método imprime los elementos de un menú
     * @param menu 
     * @author Grup a4.U5_14
     */
    public void imprimirMenu(String[] menu){
        for (int i = 0; i<menu.length; i++){
            System.out.println((i+1)+": "+menu[i]);
        }
    }
    
    /**
     * Elementos del menú pricipal
     * @return elementos del menú principal
     * @author Grup a4.U5_14
     */
    public String[] getMenuPrincipal(){
        String menuPrincipal[]={
            "Gestiona els participants del concurs",
            "Començar el concurs!",
            "Sortir"
        };
        return menuPrincipal;
    }
    
    /**
     * Elementos del menú participantes
     * @return elementos del menú participantes
     * @author Grup a4.U5_14
     */
    public String[] getMenuParticipants(){
        String menuParticipants[]={
            "Nou participant",
            "Editar participant (per conèixer la id del concursant a editar consulteu la llista usant l'opció 3)",
            "Llista de participants",
            "Borrar uno (per conèixer la id del concursant a borrar consulteu la llista usant l'opció 3)",
            "Borrar tots",
            "Tornar al menú principal",
            "DESENVOLUPAMENT: Carregar dades d'exemple"
        };
        return menuParticipants;
    }
    
    /**
     * Elementos del menú Concurs
     * @return elementos del menú Concurs
     * @author Grup a4.U5_14
     */
    public String[] getMenuConcurs(){
        String menuConcurs[]={
            "Iniciar el Concurs",
            "Puntuar una ronda",
            "Llistar qualificacions ronda",
            "Finalitzar ronda",
            "Llistar qualificacions pel twiter",
            "Tornar al menú principal"
        };
        return menuConcurs;        
    }
    
    /**
     * Elementos del menú confirmación
     * @return elementos del menú confirmación
     * @author Grup a4.U5_14
     */
    public String[] getMenuConfirmacio(){
        String menuConfirmacio[]={
            "Sí",
            "No"
        };
        return menuConfirmacio;
    }
    
    /**
     * Elementos del menú Twitter
     * @return elementos del menú twitter
     * @author Grup a4.U5_14
     */
    public String[] getMenuTwitter(){
        String menuTwitter[]={
            "Concursants Eliminats",
            "Concursants Classificats"
        };
        return menuTwitter;
    }    
    
    /**
     * Elementos del menú info
     * @return elementos del menú info
     * @author Grup a4.U5_14
     */
    public String[] getMenuInfo(){
        String menuInfo[]={
            "Llistat de localització",
            "Llistat de Twitter"
        };
        return menuInfo;
    }

    /**
     * Elementos del menú edit
     * @param nom nombre de concursante
     * @param cognom apellido de concursante
     * @param DNI dni de concursante
     * @param TLF teléfono de concursante
     * @return elementos del menú edit
     * @author Grup a4.U5_14
     */
    public String[] getMenuEdit(String nom, String cognom, String DNI, String TLF){
        String menuEdit[]={nom,cognom,DNI,TLF};
        return menuEdit;
    }    
}
