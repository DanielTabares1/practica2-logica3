import javax.swing.*;
import java.util.*;

public class AutomataPila {

    String[] simbolosEntrada;
    String[] simbolosEnPila;
    String[] estados;
    String estadoInicial;
    String[] confInitPila;
    String[][][] tablasDeTransiciones;
    List<String> transiciones = new ArrayList<>();
    Transicion[] transicionesPasos;

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
            JOptionPane.showMessageDialog(null, "Creación de tabla de transiciones para el estado " + estados[i]);
            //consola.titulo("Creación de tabla de transiciones para el estado " + estados[i]);
            tablasDeTransiciones[i] = crearTabla();
        }
        crearTransiciones();
    }

    private String[][] crearTabla() {
        String[][] nuevaTabla = new String[simbolosEnPila.length][simbolosEntrada.length];
        //Scanner s = new Scanner(System.in);
        for (int i = 0; i < simbolosEnPila.length; i++) {
            //consola.subtitulo("Para el símbolo en la pila " + simbolosEnPila[i] + ": ");
            for (int j = 0; j < simbolosEntrada.length; j++) {
                //consola.parrafo("Con símbolo de entrada " + simbolosEntrada[j] + ": ");
                nuevaTabla[i][j] = JOptionPane.showInputDialog("" +
                        "Para el símbolo en la pila " + simbolosEnPila[i] + ": \n" +
                        "Con símbolo de entrada " + simbolosEntrada[j] + ": ");
                if (!nuevaTabla[i][j].equals("R") && !nuevaTabla[i][j].equals("A") && !transiciones.contains(nuevaTabla[i][j])) {
                    transiciones.add(nuevaTabla[i][j]);
                }
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
        consola.titulo("Tablas de transiciones:");
        for (int i = 0; i < tablasDeTransiciones.length; i++) {
            consola.subtitulo(estados[i]);
            consola.parrafo(tablaToString(i) + "\n");
        }
        consola.titulo("Transiciones: ");
        for (int i = 0; i < transicionesPasos.length; i++) {
            consola.parrafo(transiciones.get(i) + ": " + transicionesPasos[i].toString() + "\n");
        }
    }

    public String tablaToString(int i) {
        return Arrays.deepToString(tablasDeTransiciones[i]);
    }

    public void crearTransiciones() {
        transicionesPasos = new Transicion[transiciones.size()];
        for (int i = 0; i < transicionesPasos.length; i++) {
            consola.titulo("Cración de la transición " + transiciones.get(i));
            boolean out = false;
            int opPila = 0;
            int opEstado = 0;
            int opEntrada = 0;
            //Scanner s = new Scanner(System.in);
            //consola.parrafo("Digite 1 si su operación tiene alguna impresión: ");
            String x = JOptionPane.showInputDialog("Cración de la transición " + transiciones.get(i) + "\n" +
                    "Digite 1 si su operación tiene alguna impresión: ");
            if (x.equals("1")) {
                out = true;
            }
            //consola.parrafo("Operaciones en la pila: 0 ninguna, 1 apilar, 2 desapilar, 3 replace: ");
            opPila = Integer.parseInt(JOptionPane.showInputDialog("Cración de la transición " + transiciones.get(i) + "\n" +
                    "Operaciones en la pila: \n0. ninguna\n1. apilar\n2. desapilar\n3. replace: "));
            //consola.parrafo("Operación de estado: 0 permanece, 1 cambia de estado: ");
            opEstado = Integer.parseInt(JOptionPane.showInputDialog("Cración de la transición " + transiciones.get(i) + "\n" +
                    "Operación de estado: \n0. permanece\n1. cambia de estado: "));
            //consola.parrafo("Operaciones de entrada: 0 retenga, 1 avance: ");
            opEntrada = Integer.parseInt(JOptionPane.showInputDialog("Cración de la transición " + transiciones.get(i) + "\n" +
                    "Operaciones de entrada: \n0. retenga\n1. avance: "));
            Transicion t = new Transicion(out, opPila, opEstado, opEntrada);
            transicionesPasos[i] = t;
        }
    }
}
