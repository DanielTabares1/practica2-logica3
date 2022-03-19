import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class AutomataPila {

    String[] simbolosEntrada;
    String[] simbolosEnPila;
    String[] estados;
    String estadoInicial;
    String[] confInitPila;
    String[][][] tablasDeTransiciones;

    Stack<String> pila;

    public AutomataPila(String[] simbolosEntrada, String[] simbolosEnPila, String[] estados) {
        this.simbolosEntrada = simbolosEntrada;
        this.simbolosEnPila = simbolosEnPila;
        this.estados = estados;
        tablasDeTransiciones = new String[estados.length][simbolosEnPila.length][simbolosEntrada.length];
        pila = new Stack<>();
    }

    public String setEstadoInicial(String s) {
        for (int i = 0; i < estados.length; i++) {
            if (estados[i].equals(s)) {
                estadoInicial = s;
                return estadoInicial;
            }
        }
        return null;
    }

    public void setConfInitPila(String s) {
        String[] aux = s.split(" ");
        confInitPila = aux;
        for (int i = 0; i < aux.length; i++) {
            pila.push(aux[i]);
        }
    }

    public void setTransiciones(String estado, String[][] tabla) {
        int i = indiceEstado(estado);
        tablasDeTransiciones[i] = tabla;
    }

    public int indiceEstado(String estado) {
        for (int i = 0; i < estados.length; i++) {
            if (estado.equals(estados[i])) {
                return i;
            }
        }
        return -1;
    }

    public void crearTablas() {
        for (int i = 0; i < estados.length; i++) {
            consola.titulo("Creación de tabla de transiciones para el estado " + estados[i]);
            tablasDeTransiciones[i] = crearTabla();
        }
    }

    private String[][] crearTabla() {
        String[][] nuevaTabla = new String[simbolosEnPila.length][simbolosEntrada.length];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < simbolosEnPila.length; i++) {
            consola.subtitulo("Para el símbolo en la pila " + simbolosEnPila[i] + ": ");
            for (int j = 0; j < simbolosEntrada.length; j++) {
                consola.parrafo("Con símbolo de entrada " + simbolosEntrada[j] + ": ");
                nuevaTabla[i][j] = s.nextLine();
            }
        }
        return nuevaTabla;
    }

    public void imprimirAutomata() {
        consola.titulo("Símbolos de entrada: " + Arrays.toString(simbolosEntrada));
        consola.titulo("Símbolos en la pila: " + Arrays.toString(simbolosEnPila));
        consola.titulo("Estados: " + Arrays.toString(estados));
        consola.titulo("Estado inicial: " + estadoInicial);
        consola.titulo("Configuración inicial de la pila " + Arrays.toString(confInitPila));
        consola.titulo("Transiciones:");
        for (int i = 0; i < tablasDeTransiciones.length; i++) {
            consola.subtitulo(estados[i]);
            consola.parrafo(tablaToString(i) + "\n");
        }
    }

    public String tablaToString(int i) {
        return Arrays.deepToString(tablasDeTransiciones[i]);
    }


}
