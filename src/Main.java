
import Interface.MenusPrograma;
import Dades.Participants;

/**
 * La clase principal controla toda la aplicación.
 * @author Grup a4.U5_14
 */
public class Main {
    MenusPrograma misMenus = new MenusPrograma();    
    Participants misParticipants = new Participants();
    public static void main(String[] args) {
        Main programa = new Main();
        programa.inicio();
    }
    /**
     * Entrada del programa, muestra el menú principal
     */
    public void inicio(){
        boolean programaOK = true;
        // Mientras que el concurso no termine
        while (programaOK){
            int opcion = 0;
            while (opcion!=3){
                opcion = misMenus.mostrarMenu("mPrincipal");
                switch (opcion){
                    case 1:
                        concursants();
                        break;
                    case 2:
                        concurs();
                        break;
                    case 3:
                        programaOK = false;
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                }
            }
        }
        System.out.println("Això ha estat tot, moltes gràcies!");
    }
    /**
     * Menú concursantes: contiene todo lo necesario para gestionar
     * a los concursantes
     * @author Grup a4.U5_14
     */
    public void concursants(){
        int opcion = 0;
        while (opcion!=6){
            opcion = misMenus.mostrarMenu("mParticipants");
            switch (opcion){
                case 1:
                    // Crea un nuevo participante
                    misParticipants.nouPartipant();
                    break;
                case 2:
                    // Edita un participante
                    misParticipants.editConcursante();
                    break;
                case 3:
                    // Muestra la lista de participantes
                    llistats();
                    break;
                case 4:
                    // Borra un participante
                    misParticipants.esborraParticipant();
                    break;
                case 5:
                    // Borra todos los participantes
                    borrarTodos();
                    break;
                case 6:
                    break;
                case 7:
                    // Carga datos de ejemplo
                    misParticipants.cargarDatosEjemplo();
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }
        }
    }
    
    /**
     * Menú llistats, que pregunta qué listado queremos mostrar
     * @author Grup a4.U5_14
     */
    public void llistats(){
        int opcion=misMenus.mostrarMenu("mInfo");
        switch (opcion){
            case 1:
                misParticipants.infoLocalizacion();
                break;
            case 2:
                misParticipants.infoTwitter();
            default:
                System.out.println("Opció no vàlida");
        }
    }
    
    /**
     * Menú borrarTodos, que pide confirmación para borrar a todos los concursantes.
     * @author Grup a4.U5_14
     */
    public void borrarTodos(){
        System.out.println("S'esborraran tots els participants");
        if (misMenus.mostrarMenu("mConfirmacio")==1){
            misParticipants.esborraTots();
            System.out.println("Esborrat completat");
        } else {
            System.out.println("No s'han esborrat els concursants");
        }
    }
       
    /**
     * Menú concurso
     * @author Grup a4.U5_14
     */
    public void concurs(){
        int opcion = 0;
        while (opcion!=6){
            opcion=misMenus.mostrarMenu("mConcurs");
            switch(opcion){
                case 1:
                    // Inicia el concurso
                    resetConcurso();
                    break;
                case 2:
                    // Puntúa una ronda
                    misParticipants.puntuarActivos();
                    break;
                case 3:
                    // Lista la clasificación
                    misParticipants.infoClasificacio();
                    break;
                case 4:
                    // Finaliza la ronda
                    misParticipants.finalizarRonda();
                    break;
                case 5:
                    // Lista la clasificación para twitter
                    menuTwitter();
                    break;
                default:
                    System.out.println("Opció no vàlida");
            }
        }
    }
    
    /**
     * Pide confirmación para resetear el concurso
     * @author Grup a4.U5_14
     */
    public void resetConcurso(){
        System.out.println("Si hi ha un concurs en curs es reiniciarà... segur?");
        if (misMenus.mostrarMenu("mConfirmacio")==1){
           misParticipants.iniciarConcurs();
        }
    }
    
    /**
     * Menú para mostrar las clasificaciones y descalificados por twitter
     * @author Grup a4.U5_14
     */
    public void menuTwitter(){        
        int opcion = misMenus.mostrarMenu("mTwitter");
        switch(opcion){
            case 1:
                misParticipants.twEliminados();
                break;
            case 2:
                misParticipants.twClasificados();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}