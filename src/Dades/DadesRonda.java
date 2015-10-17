/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dades;

/**
 * Esta case guarda los datos de la ronda en curso
 * @author Grup a4.U5_14
 */
public class DadesRonda {
    // Numero de ronda actual
    int ronda = 1;
    // Ronda puntuada?
    boolean rondaPuntuada = false;
    
    /**
     * Este método crea una nueva ronda
     */
    public void rondaNueva(){
        ronda++;
        rondaPuntuada = false;
    }
    
    /**
     * Este método resetea la clase
     */
    public void resetRondas(){
        ronda = 1;
        rondaPuntuada = false;
    }
    
    /**
     * Ronda en la que estamos
     * @return la ronda en la que estamos
     */
    public int getRonda(){
        return ronda;
    }
}