import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Archivo {
    static String encriptar(int clave, String file) {
        String cadenaEncriptada = Recorredor.recorrerCadena(clave, file);
        try (FileWriter archivoCreado = new FileWriter("textoEncriptado.txt");){
            archivoCreado.write(cadenaEncriptada);
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo");
        }
        System.out.println(cadenaEncriptada);
        return cadenaEncriptada;
    }
    static void desencriptar(String fileName){
        int clave = Recorredor.buscarClave(fileName);
        if (clave != 0){
            String desencriptado = Recorredor.recorrerCadena(-clave,fileName);
            System.out.println("\n" + desencriptado);
            System.out.println("La clave para desencriptar fue: "+ clave);
            Archivo.crear(desencriptado, "textoDesencriptado.txt");
        }
        else {
            System.out.println("Imposible Desencriptar");
        }
    }
    static void crear(String str, String nombre) {

            try (FileWriter archivoCreado = new FileWriter(nombre);){
                archivoCreado.write(str);
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo");
            }
        }
    static String leer(String file) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            System.out.println("No se encontro el archivo");
        }
        return content;
    }
}
