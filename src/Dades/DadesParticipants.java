/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dades;

/**
 *
 * @author Grup a4.U5_14
 */
public class DadesParticipants {
    public static int N_CONCURSANTES = 15;
    /**
     * Datos de inscripción:
     * Posición 0: DNI
     * Posición 1: Cognoms
     * Posición 2: Noms
     * Posición 3: Telèfon
     */
    public String[][] dadesPersonals = new String[N_CONCURSANTES][4];
    //Puntuaciones obtenidas por los concursantes
    public int[] puntuacions = new int[N_CONCURSANTES];
    /**
     * Estado de los concursantes:
     * 0: Inactivo
     * 1: Eliminado esta ronda
     * 2: Activo
     */
    public int[] estado = new int[N_CONCURSANTES];
    // Índice para ordenar a los concursantes por puntuación
    public int[] clasificacion = new int[N_CONCURSANTES];
    public int[][] indexos = new int[3][N_CONCURSANTES]; 
    
    /**
     * Participantes
     * @Devuelve la cantidad de posiciones de los array de participantes
     * @author Grup a4.U5_14
     */
    public int lengthParticipants(){
        return dadesPersonals.length;
    }
    
    /**
     * Coge el nombre del concursante i
     * @param i
     * @return el nombre
     * @author Grup a4.U5_14
     */
    public String getNom(int i){
        return dadesPersonals[i][2];
    }
    
    /**
     * Cambia el nombre de un concursante
     * @param i número de concursante
     * @param nom nombre del concursante
     * @author Grup a4.U5_14
     */
    public void setNom(int i, String nom){
        dadesPersonals[i][2]=nom;
    }
    
    /**
     * Coge los apellidos del concursante i
     * @param i número de concursante
     * @return los apellidos
     * @author Grup a4.U5_14
     */
    public String getCognoms(int i){
        return dadesPersonals[i][1];
    }
    
    /**
     * Cambia los apellidos de un concursante
     * @param i número de concursante
     * @param cognoms  apellidos del concursante
     * @author Grup a4.U5_14
     */
    public void setCognoms(int i, String cognoms){
        dadesPersonals[i][1]=cognoms;
    }    
    
    /**
     * Coge el DNI del concursante i
     * @param i número de concursante
     * @return el dni
     * @author Grup a4.U5_14
     */
    public String getDNI(int i){
        return dadesPersonals[i][0];
    }
    
    /**
     * Cambia el DNI de un concursante
     * @param i número de concursante
     * @param dni  nuevo dni
     * @author Grup a4.U5_14
     */
    public void setDNI(int i, String dni){
        dadesPersonals[i][0]=dni;
    }
    
    /**
     * Coge el teléfono del concursante i
     * @param i número de concursante
     * @return el teléfono
     */
    public String getTLF(int i){
        return dadesPersonals[i][3];
    }    
    
    /**
     * Cambia el teléfono de un concursante
     * @param i número de concursante
     * @param tlf nuevo teléfono
     * @author Grup a4.U5_14
     */
    public void setTLF(int i, String tlf){
        dadesPersonals[i][3]=tlf;
    }    
    
    /**
     * Coge el estado del concursante i
     * @param i número de concursante
     * @return estado
     * @author Grup a4.U5_14
     */
    public int getEstado(int i){
        return estado[i];
    }
    
    /**
     * Cambia el estado del concursante i
     * @param i número de concursante
     * @param nuevoEstado nuevo estado
     * @author Grup a4.U5_14
     */
    public void setEstado(int i, int nuevoEstado){
        estado[i]=nuevoEstado;
    }
    
    /**
     * Coge la puntuación del concursante i
     * @param i
     * @return puntuación
     * @author Grup a4.U5_14
     */
    public int getPuntos(int i){
        return puntuacions[i];
    }
    
    /**
     * Resetea la puntuación de un concursante
     * @param i concursante
     * @author Grup a4.U5_14
     */
    public void resetPuntos(int i){
        puntuacions[i]=0;
    }        
    
    /**
     * Suma puntos a la puntuación de un concursante
     * @param i el concursante
     * @param puntos los puntos a añadir
     * @author Grup a4.U5_14
     */
    public void sumPuntos(int i, int puntos){
        puntuacions[i]=puntuacions[i]+puntos;
    }    
    
    /**
     * Devuelve la clasificación de un concursante
     * @param i número de concursante
     * @return la clasificación
     * @author Grup a4.U5_14
     */
    public int getClasificacion(int i){
        return clasificacion[i];
    }
    
    /**
     * Define la clasifación de un conrsante
     * @param i número de concursante
     * @param nuevaClasificacion nueva clasificación
     * @author Grup a4.U5_14
     */
    public void setClasificacion(int i, int nuevaClasificacion){
        clasificacion[i]=nuevaClasificacion;
    }
    
    /**
     * Resetea las clasificaciones
     * @author Grup a4.U5_14
     */
    public void resetClasificaciones(){
        for (int i=0;i<N_CONCURSANTES;i++){
            setClasificacion(i,0);
        }
    }
    
    public int puntuacionMax(){
        int puntuacionMax=0;
        for (int i=0;i<N_CONCURSANTES;i++){
            if (getPuntos(i)>puntuacionMax){
                puntuacionMax=getPuntos(i);
            }
        }
        return puntuacionMax;
    }    
}