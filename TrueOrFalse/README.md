=======
>>>>>>> ----------------->[ TRUE OR FALSE ]<------------------
>
> True or false:
> Aplicación Java que accede directamente a una base de datos para extraer preguntas almacenadas(sin Spring Boot).


# 🚀 Objetivos del Proyecto
- Ejercicio práctico de acceso a una base de datos sin Spring Boot (JDBC puro).
- Consolidar buenas prácticas en testing con JUnit y Mockito.
- Aprender a integrar PostgreSQL en contenedores Docker.
- Diseñar un sistema simple pero extensible para preguntas aleatorias.

# 🧩 Arquitectura del Sistema
| Componente | Descripción |

| Question | La clase Question modela una pregunta dentro del sistema. Encapsula el enunciado de la pregunta (question) y la respuesta correcta (answer), permitiendo verificar si una respuesta dada por el usuario es correcta
|Player | Representa al jugador actual
|ConsoleInputProvider | Maneja las entradas desde la consola
|QuestionBank | Fuente de preguntas (Conectada a la base de datos)
Game | Orquestador del flujo del juego
| Main | 🎮 Punto de entrada: ejecuta el juego. Se encarga de inicializar los componentes principales del juego y lanzar la ejecución.

| Dockerfile / docker-compose.yml | Configuración para levantar PostgreSQL en contenedor. |

# 🧪 Testing
- JUnit 5: Pruebas unitarias para los módulos de lógica y acceso a datos.
- Mockito: Mocking de dependencias para aislar comportamientos.
- Se testean casos como:
- Conexión exitosa a la base de datos.
- Extracción de preguntas válidas.
- Comportamiento ante base de datos vacía o errores de conexión.

# 🐘 Base de Datos
- PostgreSQL levantado en contenedor Docker.
- Script Question.sql para poblar la tabla con preguntas iniciales.
- Estructura simple: tabla questions con campos id, text, answer.

# 📦 Cómo Ejecuta
Bash :
1. Levantar PostgreSQL con Docker: docker-compose up -d
2. Ejecutar el script de población: questions -h localhost -U postgres -d questions_db -f Question.sql
3. Ejecutar el programa Java: java -jar extractor-preguntas.jar

# 🌱 Próximos Pasos
- Agregar interfaz gráfica o CLI interactiva.
- Permitir categorías o niveles de dificultad.
- Persistir resultados de usuario para análisis posterior.






