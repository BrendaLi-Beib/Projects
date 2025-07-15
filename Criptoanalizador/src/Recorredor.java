import java.util.*;

public class Recorredor {
    static final private List<String> palabrasSpanish = Arrays.asList("universo", " no ");

    public static String recorrerCadena(int clave, String fileName){
        String archivo = Archivo.leer(fileName);
        StringBuilder unirCadena = new StringBuilder();
        for (int i = 0; i<archivo.length(); i++){
            char letraArchivo = archivo.charAt(i);
            if (letraArchivo == ' ' || letraArchivo == ',' || letraArchivo == '.' || letraArchivo == '\n'){
                unirCadena.append(letraArchivo);
            }
            else {
                char letraEncriptada = (char) (letraArchivo + clave);
                unirCadena.append(letraEncriptada);
            }
        }
        return unirCadena.toString();
    }
    static int buscarClave (String file) {
        int clave = 0;
        boolean encontroPalabra = false;
        for (int i= 1; i<=1000; i++){
            String posibleCadena = recorrerCadena(-i, file);
           for (String str: palabrasSpanish){
             encontroPalabra = posibleCadena.contains(str);
           }
           if (encontroPalabra){
               clave = i;
           }
        }
        return clave;
    }
}
