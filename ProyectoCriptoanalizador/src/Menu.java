import java.util.*;

public class Menu {
    private String doc = "texto.txt";
    private String enc = "textoEncriptado.txt";

    public void menuInicio (){
        Scanner s = new Scanner(System.in);
        boolean salir = true;
        do {
            System.out.println("¿Qué deseas hacer? \n1.- Encriptar\n2.-Desencriptar\n3.-Salir\n");
            System.out.println("Elige una opcion: ");

            int opcion = s.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.print("Eligio encriptar\nElija clave: ");
                    int clave = s.nextInt();
                    System.out.println("\nSe encriptara el siguiente archivo: " + doc);
                    Archivo.encriptar(clave, doc);
                    System.out.println("Archivo encriptado con exito \n Tu clave fue: " + clave);
                    break;}
                case 2: {
                    System.out.println("Elegiste Desencriptar");
                    Archivo.desencriptar(enc);
                    break;}
                case 3:
                    System.out.println("Elegiste Salir");
                    salir = false;
                    break;
                default:
                    System.out.println("Esa opcion no es correcta");

            }
        } while (salir);
    }

}
