import java.util.Arrays;
import java.util.Scanner;

public class Transicion {

    /*
    true        pide cadena a imprimir
     */
    boolean tieneOut;

    /*
        0: ninguna
        1: apilar       pide símbolo a apilar
        2: desapilar
        3: replace      pide cadena a apilar
     */
    int idOpPila;

    /*
    0: permanecer
    1: cambiar de estado    pide estado siguiente
     */
    int idOpEstado;

    /*
    0: retenga
    1: avance
     */
    int idOpEntrada;

    String out;
    String apilar;
    String[] replace;
    String estadoSiguiente;

    public Transicion(boolean tieneOut, int idOpPila, int idOpEstado, int idOpEntrada) {
        this.tieneOut = tieneOut;
        this.idOpPila = idOpPila;
        this.idOpEstado = idOpEstado;
        this.idOpEntrada = idOpEntrada;
        if (tieneOut) {
            out = pedirOut();
        }
        if (idOpPila == 1) {
            apilar = pedirSimboloApilar();
        } else if (idOpPila == 3) {
            replace = pedirSimboloReplace();
        }
        if (idOpEstado == 1) {
            estadoSiguiente = pedirEstadoSiguiente();
        }
    }

    private String pedirOut() {
        Scanner s = new Scanner(System.in);
        consola.parrafo("Digite la salida (operación out) que tendrá la transicion: ");
        return (s.nextLine());
    }

    private String pedirSimboloApilar() {
        Scanner s = new Scanner(System.in);
        consola.parrafo("Digite el símbolo a apilar en la transicion: ");
        return s.nextLine();
    }

    private String[] pedirSimboloReplace() {
        Scanner s = new Scanner(System.in);
        consola.parrafo("Digite la cadena a reemplazar en la transicion: ");
        return s.nextLine().split(" ");
    }

    private String pedirEstadoSiguiente() {
        Scanner s = new Scanner(System.in);
        consola.parrafo("Digite el estado al cual avanzar con la transicion: ");
        return (s.nextLine());
    }

    @Override
    public String toString() {
        String s = "";
        if (tieneOut) {
            s += "out(" + out + "), ";
        }
        if (idOpPila == 1) {
            s += "apile(" + apilar + "), ";
        } else if (idOpPila == 2) {
            s += "desapile, ";
        } else if (idOpPila == 3) {
            s += "replace(" + replace.toString() + "), ";
        }
        if (idOpEstado == 0) {
            s += "permanezca en el estado, ";
        } else if (idOpEstado == 1) {
            s += "Cambie al estado " + estadoSiguiente + ", ";
        }
        if (idOpEntrada == 0) {
            s += "retenga";
        } else if (idOpEntrada == 1) {
            s += "avance";
        }
        return s;
    }


}
