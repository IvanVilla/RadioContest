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
public class VerificarTLF {
    /**
    * Verifica un número de teléfono
    * @param tlf es un candidato a número de teléfono, debe tener 9 cifras y
    * ser numérico para ser considerado teléfono.
    * @return true si es válido, false si no
    * @author Grup a4.U5_14
    */
    public boolean verificarTLF (String tlf){     
        return esNumero(procesarTLF(tlf))&&(procesarTLF(tlf).length()==9);
    }
    
    /**
     * Este método devuelve el número de teléfono quitando guiones, puntos
     * y espacios.
     * @param tlf
     * @return 
     */    
    public String procesarTLF (String tlf){
        String numeroTLF = "";
        for (int i=0;i<tlf.length();i++){
            switch (tlf.charAt(i)){
                // En los casos -, . y espacio, no hago nada
                case '-':
                    break;
                case '.':
                    break;
                case ' ':
                    break;
                default:
                    // En cualquier otro caso lo añado
                    numeroTLF = numeroTLF + tlf.charAt(i);
                    break;
            }
        }        
        // Devuelvo el número
        return numeroTLF;
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
