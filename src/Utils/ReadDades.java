package Utils;

import Dades.DadesParticipants;
import java.util.Scanner;

/**
 *
 * @author Grup a4.U5_14
 */
public class ReadDades {
    /**
    * Pide datos hasta que tiene un string (sin valores nulos)
    * @return Un String
    * @author Grup a4.U5_14
    */
    public String readString(){
        Scanner lector = new Scanner(System.in);
        String cadena = null;
        boolean cadenaOK = false;
        while (!cadenaOK){
            cadena = lector.nextLine();
            if (cadena != null){
                cadenaOK = true;
            } else {
                System.out.println("El valor introduït no pot ser nul.");
            }
        }
        return cadena;
    }
    /**
    * Pide datos hasta que tiene un int, entre 1 y el número de elementos que
    * tiene un menú.
    * @param menuItems es la cantidad de items que tiene el menú (int)
    * @return Un int
    * @author Grup a4.U5_14
    */
    public int ReadIntMenu(int menuItems){
        Scanner lector = new Scanner (System.in);
        int valor = 0;
        boolean intOK = false;
        System.out.println("Introduïu l'opció del menú desitjada i premeu enter:");
        while (!intOK){
            if (lector.hasNextInt()){
                valor = lector.nextInt();
                if (valor>=0 && valor<=menuItems){
                    //Si el valor está en el rango 1 - número de items, ¡OK!
                    intOK = true;
                } else {
                    System.out.println("L'opció ha d'estar entre 1 i " + menuItems);
                }
            }
        }
        return valor;    
    }
    /**
    * Pide datos hasta que tiene un int, entre 1 y el número de concursantes,
    * que en nuestro caso es DadesParticipants.N_CONCURSANTES.
    * @return Un int
    * @author Grup a4.U5_14
    */
    public int ReadId(){
        Scanner lector = new Scanner (System.in);
        int valor = 0;
        boolean intOK = false;
        System.out.println("Introduïu la id de concursant i premeu enter:");
        while (!intOK){
            if (lector.hasNextInt()){
                valor = lector.nextInt();
                if (valor>=1 && valor<=DadesParticipants.N_CONCURSANTES){
                    //Si el valor está en el rango 1 - 15, ¡OK!
                    intOK = true;
                } else {
                    System.out.println("L'opció ha d'estar entre 1 i "
                            + DadesParticipants.N_CONCURSANTES);
                }
            }
        }
        return (valor-1);    
    }
    /**
    * Pide datos hasta que tiene un int, entre 0 y 3,
    * @return Un int
    * @author Grup a4.U5_14
    */
    public int ReadPuntos(){
        Scanner lector = new Scanner (System.in);
        int valor = 0;
        boolean intOK = false;

        while (!intOK){
            if (lector.hasNextInt()){
                valor = lector.nextInt();
                if (valor>=0 && valor<=3){
                    //Si el valor está en el rango 1 - 3, ¡OK!
                    intOK = true;
                } else {
                    System.out.println("L'opció ha d'estar entre 0 i 3");
                }
            }
        }
        return (valor);    
    }

}
