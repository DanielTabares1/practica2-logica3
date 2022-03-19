public class consola {

    public static void titulo(String s){
        String format = ("\u001B[33m");
        String out = format + s;
        System.out.println(out);
    }

    public static void subtitulo(String s){
        String format = ("      \u001B[32m");
        String out = format + s;
        System.out.println(out);
    }

    public static void parrafo(String s){
        String format = ("          \u001B[0m");
        String out = format + s;
        System.out.print(out);
    }

}
