## Funcionalidades

- **Encriptación de texto**: Permite encriptar texto utilizando una clave numérica
- **Desencriptación de texto**: Permite desencriptar texto previamente encriptado
- **Manejo de archivos**: Lectura y escritura de archivos de texto

## Métodos principales

### Archivo.encriptar(int clave, String file)
- Encripta el archivo por texto.txt con clave proporcionada por el usuario
- Guarda el resultado en "textoEncriptado.txt"
- Retorna el texto encriptado para que el usuario la vea

### Archivo.desencriptar(String fileName)
- Desencripta el contenido "textoEncriptado.txt"
- Detecta automáticamente la clave de encriptación
- Guarda el resultado en "textoDesencriptado.txt"
- Muestra la clave utilizada por pantalla

### Archivo.crear(String str, String nombre)
- Crea un nuevo archivo con el contenido especificado

### leerArchivo(String file)
- Lee el contenido de un archivo y lo retorna como String

## Requisitos

- Java 8 o superior
- Permisos de lectura/escritura en el directorio de ejecución

## Uso

1. Para encriptar un archivo:
