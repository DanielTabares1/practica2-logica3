public class Main {
    public static void main(String[] args) {
        AutomataPila a = new AutomataPila(new String[]{"0", "1", "¬"},new String[]{"0","|"},new String[]{"S0","S1"});
        a.setEstadoInicial("S0");
        a.setConfInitPila("|");
        a.crearTablas();
        a.imprimirAutomata();

        /*
        Todo
        modificar el autómata
        ingresar las transiciones
        reconocer una hilera de entrada
        hacer la documentación
         */

        /*
        s = 101010   10010101
        estado actual = s1

        int tabla = transiciones[indice(estadoActual)][pila.peek()][indice(simboloActual)]
        0  ninguna
        1  apilar
        2  desapilar

        0   permanecer
        1   cambiarDeEstado

        0   retener
        1   avanzar
         */
    }
}
