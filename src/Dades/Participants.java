/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dades;

import Utils.ReadDades;
import Utils.VerificarDNI;
import Utils.VerificarTLF;

/**
 *
 * @author Grup a4.U5_14
 */
public class Participants {

    DadesParticipants dada = new DadesParticipants();
    ReadDades read = new ReadDades();
    DadesRonda miRonda = new DadesRonda();
    VerificarDNI okDNI = new VerificarDNI();
    VerificarTLF okTLF = new VerificarTLF();

/*MÉTODOS USADOS ANTES DE QUE COMIENCE EL CONCURSO----------------------------*/        
    
    /**
     * Graba un nuevo partipante
     *
     * @author Grup a4.U5_14
     */
    public void nouPartipant() {        
        int posicion = posLibre();
        if (posicion!=-1){
            editarNom(posicion);
            editarCognoms(posicion);
            editarDNI(posicion);
            editarTLF(posicion);
        } else {
            System.out.println("No caben más concursantes");
        }
    }
    
    /**
     * Busca posición libre en el array
     * @return devuelve un entero, la primera posición libre que encuentra, si
     * no hay ninguna, devuelve -1.
     * @author Grup a4.U5_14
     */
    public int posLibre(){
        int posicion = 0;
        // Mientras que no encontramos una posicion libre, buscamos
        while (posicion<dada.estado.length){
            if (dada.dadesPersonals[posicion][0]==null){
                return posicion;
            } else {
                posicion++;
            }
        }
        // Si hemos terminado de buscar en el array, devolvemos -1
        return -1;
    }

    /**
     * Graba el nombre del concursante id
     *
     * @param id Id del concursante
     * @author Grup a4.U5_14
     */
    public void editarNom(int id) {
        System.out.print("Nom: ");
        String txt = read.readString();
        dada.setNom(id,txt);
    }

    /**
     * Graba el nombre del concursante id
     *
     * @param id Id del concursante
     * @author Grup a4.U5_14
     */
    public void editarCognoms(int id) {
        System.out.print("Cognoms: ");
        String txt = read.readString();
        dada.setCognoms(id,txt);
    }

    /**
     * Graba el DNI del concursante id
     *
     * @param id Id del concursante
     * @author Grup a4.U5_14
     */
    public void editarDNI(int id) {
        String txt;
        do {
            System.out.print("DNI: ");
            txt = read.readString();
        } while (!okDNI.verificarDNI(txt));
        dada.setDNI(id,txt);
    }

    /**
     * Graba el teléfono del concursante id
     *
     * @param id Id del concursante
     * @author Grup a4.U5_14
     */
    public void editarTLF(int id) {
        String txt;
        do {
            System.out.print("TELÈFON: ");
            txt = read.readString();
        } while (!okTLF.verificarTLF(txt));
        dada.setTLF(id,txt);
    }
    
    /**
     * Edita todos los datos de un concursante
     * @author Grup a4.U5_14
     *
     */
    public void editConcursante(){
        int id = read.ReadId();
        int opcion = 0;
        while (opcion!=5){
            System.out.println("Menú edición:");
            System.out.println("1- Nom :" + dada.getNom(id));
            System.out.println("2- Cognoms: " + dada.getCognoms(id));
            System.out.println("3- DNI: " + dada.getDNI(id));
            System.out.println("4- Telèfon: "+ dada.getTLF(id));
            System.out.println("5- Acabar.");
            opcion = read.ReadIntMenu(5);
            switch (opcion){
                case 1:
                    editarNom(id);
                    break;
                case 2:
                    editarCognoms(id);
                    break;
                case 3:
                    editarDNI(id);                
                    break;
                case 4:                    
                    editarTLF(id);
                    break;
                default:
                    System.out.println("No ha seleccionado opción");
            }
        }
    }

    /**
     * Borra los datos de un participante
     * @author Grup a4.U5_14
     */
    public void esborraParticipant() {
        int id = read.ReadId();
        dada.setNom(id, null);
        dada.setCognoms(id, null);
        dada.setDNI(id, null);
        dada.setTLF(id, null);
        dada.resetPuntos(id);
    }

    /**
     * Borra todos los datos de todos los concursantes
     * @author Grup a4.U5_14
     */
    public void esborraTots() {
        DadesParticipants dada = new DadesParticipants();
    }
    
    /**
     * Muestra la lista de participantes y sus datos
     * @author Grup a4.U5_14
     */ 
    public void infoLocalizacion(){
        System.out.println("\nLLISTA DE DADES DELS CONCURSANTS");
        System.out.println(String.format("%-6s%-20s%-25s%-19s%-12s","ID","NOM",
                "COGNOMS","DNI","TELÈFON"));
        for (int i=0;i<dada.N_CONCURSANTES;i++){
            if (dada.getNom(i)!=null){
                String dades = String.format("%-6s%-20s%-25s%-19s%-12s",(i+1),
                        dada.getNom(i),dada.getCognoms(i),dada.getDNI(i),dada.getTLF(i));
                System.out.print(dades+"\n");
            }
        }
    }
    /**
     * Este método publica un listado de concursantes para Twitter
     * @author Grup a4.U5_14
     */
    public void infoTwitter(){
        System.out.println("\nLLISTA DE DADES DELS CONCURSANTS");
        System.out.println(String.format("%-20s%-25s","NOM","COGNOMS"));
        for (int i=0;i<dada.N_CONCURSANTES;i++){
            if (dada.getNom(i)!=null){
                String dades = String.format("%-20s%-25s",dada.getNom(i),dada.getCognoms(i));
                System.out.print(dades+"\n");
            }
        }
    }        

    /**
     * Este método carga datos de ejemplo para poder testear la aplicación
     * @author Grup a4.U5_14
     */
    public void cargarDatosEjemplo(){
        dada.setNom(0, "Jane");
        dada.setCognoms(0, "Goodall");
        dada.setDNI(0,"00000001A");
        dada.setTLF(0,"600123123");
        dada.sumPuntos(0, 10);
        dada.setEstado(0, 0);
        
        dada.setNom(1, "Sophie");
        dada.setCognoms(1, "Germain");
        dada.setDNI(1, "00000002B");
        dada.setTLF(1, "666123122");
        dada.sumPuntos(1, 20);
        dada.setEstado(1, 2);
        
        dada.setNom(2, "Emmy");
        dada.setCognoms(2, "Noether");
        dada.setDNI(2,"00000003C");
        dada.setTLF(2, "666123120");
        dada.sumPuntos(2, 15);
        dada.setEstado(2, 0);
    }

/*MÉTODOS USADOS UNA VEZ HA COMENZADO EL CONCURSO-----------------------------*/    

    /**
     * Pone a 0 las puntuaciones de los inscritos y activa a los concursantes
     * @author Grup a4.U5_14
     */
    public void iniciarConcurs(){
        for (int i=0;i<dada.N_CONCURSANTES;i++){
            if (dada.getNom(i)!=null){
                dada.setEstado(i,2);
                dada.resetPuntos(i);
            }
        }
        // Reseteo las rondas:
        miRonda.resetRondas();
    }

    /**
     * Finaliza la ronda: pasa a inacitvo los concursantes eliminados, y abre el
     * semáforo para introducir nuevas puntuaciones.
     * @author Grup a4.U5_14
     */
    public void finalizarRonda(){
        actualizarEstados(); // Pasamos a inactivos a todos los descalificados
        hayGanador(); // Comprobamos si hay un ganador
        miRonda.rondaNueva(); // Empezamos una nueva ronda
    }
    
    /**
     * Todos los concursantes que no tienen la máxima puntuación son eliminados
     * @author Grup a4.U5_14
     */
    public void descalificarConcursantes(){
        for (int i=0;i<dada.N_CONCURSANTES;i++){
            if (dada.getPuntos(i)<dada.puntuacionMax()){
                dada.setEstado(i,1);
            }
        }
    }
    
    /**
     * Los concursantes descalificados en la ronda anterior pasan a estar
     * eliminados (se pasa a los que están en estado 1: recién eliminados al
     * estado 0: eliminados)
     * @author Grup a4.U5_14
     */
    public void actualizarEstados(){
        for (int i=0; i<dada.N_CONCURSANTES; i++){
            if (dada.getEstado(i)==1){
                dada.setEstado(i,0);
            }
        }
    }
    
    /**
     * Contar cuantos concursantes hay activos. Si hay menos de dos, es que hay
     * un ganador.
     */
    public void hayGanador(){
        int contador=0;
        int ganador = 0;
        for (int i=0;i<dada.N_CONCURSANTES;i++){
            if (dada.getEstado(i)==2){
                contador++;
                ganador = i; // Guardamos el id del posible ganador
            }
        }
        if (contador<2){
            System.out.println("Hay un ganador!");
            System.out.println("Se trata de " + dada.getNom(ganador)+ " " +
                    dada.getCognoms(ganador)+"!!!");
        }
    }

     /**
     * Introduce una puntuación para los concursantes activos
     * @author Grup a4.U5_14
     */
    public void puntuarActivos(){       
        if (!miRonda.rondaPuntuada){
            // Se informa de la ronda actual
            System.out.println("Comienza la ronda " + miRonda.getRonda()+"!!!");
            for (int i=0;i<dada.N_CONCURSANTES;i++){
                // Puntúa a los concursantes activos
                if (dada.estado[i]==2){
                    System.out.println("Introduzca la puntuación obtenida por " +
                            dada.getNom(i) + " " + dada.getCognoms(i));
                    int puntos = read.ReadPuntos();
                    dada.sumPuntos(i,puntos);
                }
            }
            // Indicamos que hemos acabado la ronda
            miRonda.rondaPuntuada=true;
             // Descalificamos a los concursantes que no tienen la puntuación máxima
            descalificarConcursantes();
        } else {
            System.out.println("Aquesta ronda ja ha estat puntuada, iniciï una nova per continuar.");
        }
    }  

    /**
     * Ordena el vector de concursants de forma decreixent segons la puntuació
     * @author Grup a4.U5_14
     */
    public void ordenarPerPunts() {
        /*Una clasificación realmente lo que indica es la cantidad de gente que
        tiene más puntos que el participante que estemos mirando, por tanto para
        cada participante miraremos cuantos tienen más puntos que él. El caso
        del empate queda sobradamente contemplado*/
        // Lo primero que hacemos es resetar la clasificación
        dada.resetClasificaciones();
        // Para cada concursante             
        for (int i=0;i<dada.N_CONCURSANTES;i++){
            // Compruebo cuantos hay con más puntos que él
            int clasificacion = 0;
            for (int j=0;j<dada.N_CONCURSANTES;j++){
                // Obviamente, sin contar con los que no existen
                if(dada.getNom(i)!=null && dada.getNom(j)!=null){
                    if (dada.getPuntos(i)<dada.getPuntos(j)){
                        // Por cada concursante que le supere, su puesto sube
                        clasificacion++;
                    }
                }
                dada.setClasificacion(i,clasificacion);
            }
        }
    }        
    
    /**
     * Muestra la lista de clasificación
     * @author Grup a4.U5_14
     */
    public void infoClasificacio() {
        // Creo el índice de la clasificación
        ordenarPerPunts();        
        System.out.println(String.format("%-6s%-20s%-25s%-6s","ID","NOM",
                "COGNOMS","PUNTOS"));
        for (int i=0;i<dada.N_CONCURSANTES;i++){
            for (int j=0;j<dada.N_CONCURSANTES;j++){
                if (dada.getClasificacion(j)==i){
                    if (dada.getNom(j)!=null && dada.getEstado(j)!=0){
                        System.out.println(String.format("%-6s%-20s%-25s%-6s",
                                (j+1),dada.getNom(j),dada.getCognoms(j),dada.getPuntos(j)));
                    }
                }
            }
        }
    }
    
    /**
     * Publica los concursantes eliminados por Twitter. No funciona antes de que
     * hayamos puntuado la ronda actual
     * @author Grup a4.U5_14
     */
    public void twEliminados(){
        ordenarPerPunts();
        if (miRonda.rondaPuntuada){
            System.out.println("CONCURSANTS ELIMINATS");
            System.out.println(String.format("%-20s%-25s%-6s","NOM","COGNOMS","PUNTOS"));
            for (int i=0;i<dada.N_CONCURSANTES;i++){
                for (int j=0;j<dada.N_CONCURSANTES;j++){
                    if (dada.getClasificacion(j)==i){
                        if (dada.getNom(j)!=null && dada.getPuntos(i)<dada.puntuacionMax()){
                            System.out.println(String.format("%-20s%-25s%-6s",
                                    dada.getNom(j),dada.getCognoms(j),dada.getPuntos(j)));
                        }
                    }
                }
            }            
        } else {
            System.out.println("Assigneu puntuacions anets!");
        }
    }
    
    /**
     * Publica los concursantes eliminados por Twitter. No funciona antes de que
     * hayamos puntuado la ronda actual
     * @author Grup a4.U5_14
     */
    public void twClasificados(){
        ordenarPerPunts();
        if (miRonda.rondaPuntuada){
            System.out.println("CONCURSANTS CLASSIFICATS");
            System.out.println(String.format("%-20s%-25s%-6s","NOM","COGNOMS","PUNTOS"));
            for (int i=0;i<dada.N_CONCURSANTES;i++){
                for (int j=0;j<dada.N_CONCURSANTES;j++){
                    if (dada.getClasificacion(j)==i){
                        if (dada.getNom(j)!=null && dada.getPuntos(i)==dada.puntuacionMax()){
                            System.out.println(String.format("%-20s%-25s%-6s",
                                    dada.getNom(j),dada.getCognoms(j),dada.getPuntos(j)));
                        }
                    }
                }
            }            
        } else {
            System.out.println("Assigneu puntuacions anets!");
        }
    }
}