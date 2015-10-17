/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Grup a4.U5_14
 */
public class VerificarDNI {
    
    /**
    * Verifica un DNI
    * @param dni es un DNI
    * @return true si es válido, false si no
    * @author Grup a4.U5_14
    */
    public boolean verificarDNI (String dni){
        // No es un buen DNI si ocurre algo de lo que se señala
        boolean dniOk = !(// Si no tiene 9 dígitos
                dni.length()!=9 ||
                // Si alguno de primeros ocho no son números
                !esNumero(dni.substring(0,8)) ||
                // Si la letra no con la que tiene que tener
                !(letraDNI(dni).toUpperCase()).equals(LetraCalcDNI(numeroDNI(dni)))); 
        if (!dniOk){
            System.out.println("El DNI és incorrecte.");
        }
        return dniOk;
    }
    
    /**
     * Extrae el número de un DNI
     * @param dni
     * @return la parte numérica del dni
     */
    public int numeroDNI(String dni){
        if (esNumero(dni.substring(0,8))){
            return Integer.parseInt(dni.substring(0,8));
        }else{
            return 0;
        }
    }
       
    /**
     * Extrae la letra de un dni
     * @param dni
     * @return la letra del dni
     */
    public String letraDNI (String dni){
        return dni.substring(8);
    }
    
    /**
     * Calcula la letra que debe tener un DNI
     * @param dni
     * @return 
     */
    public String LetraCalcDNI(int dni){
        // Este método me dice que la letra que debe tener un DNI por su número
        String letrasDNI[]={"T","R","W","A","G","M","Y","F","P","D","X","N","J",
            "Z","S","Q","V","H","L","C","K","E"};
        return letrasDNI[dni%23];
    }    
    
    /**
     * Saber si un String es numérico
     * @param cadena
     * @return 
     */
    public static boolean esNumero(String cadena){
        if (cadena == null || cadena.isEmpty()){
            // Si no tengo nada en la cadena, no es numérico
            return false;
        }        
        for (int i=0; i<cadena.length();i++){
            // Si tengo algo que no sea un dígito, no es numérico
            if (!Character.isDigit(cadena.charAt(i))){
                return false;
            }
        }        
        // En cualquier otro caso es numérico
        return true;
    }         
}
