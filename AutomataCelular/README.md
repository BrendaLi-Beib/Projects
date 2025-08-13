autómata celular es un ecosistema de seres vivos con reglas independientes y ejecución concurrente.

- Los objetos dentro del Tablero (SeresVivos) son instancias que se ejecutan como hilos
Cada uno con su ciclo de vida, decisiones o interacciones.
Cada “ser” tiene su propio conjunto de reglas de comportamiento.
El tablero permite la convivencia y la competencia de los SeresVivos.
Usamos synchronized, locks y semáforos para evitar que dos seres accedan a la misma celda a la vez

La evolución del tablero es manejado por un reloj global.
Cada segundo los SeresVivos interactuan con sus celdas vecinas.

Si un hilo esta vivo ejecuta vivir(), y evalua si el hilo:
Si es animal puede moverse, interactuar con otro hilo o morir.
Si es una planta puede interactuar con otro hilo o morir.

Una planta muere si un animal se la come.
Un animal muere si su vida es igual a 0.
Un animal interactua con otro ser vivo:
if es planta se la come, pero hay varios tipos de plantas, la Cicuta quita vida, el kiki da energía y la manzanilla da vida.
if es animal puede, pelearse o apariarse

🧬 Elementos esenciales.
Aquí te dejo una lluvia organizada de componentes que podrían formar parte de tu ecosistema:
🧠 Lógica y Estructura
- Tablero: Orquestador de posiciones e interacciones.
- Coordenada: Encapsula ubicación y movimientos válidos.
- MotorDeSimulacion o CicloDeVida: Controla los ticks/iteraciones del sistema.
🧍 Entidades
- SerVivo (abstracto): Tiene vida, energía, posición. Define interacción.
- Animal: Movimiento aleatorio.
- Mima, Mimo, Mime: Cada uno con interacciones distintas.
- Planta: No se mueve. Tiene efectos sobre quien la toca.
- Kiki, Cicuta, Manzanilla, etc.
🔄 Interacciones
- Reproducción: Solo entre Mima y Mimo → nace un Mime.
- Combate: Entre iguales (Mima vs Mima, Mimo vs Mimo).
- Fusión: Solo entre Mime vs Mime.
- Consumo vegetal: Animales que se cruzan con plantas activan efectos.
⚙️ Comportamientos autónomos
- Movimiento aleatorio en cada tick.
- Evaluación de vida/energía luego de interacción.
- Muerte por energía o salud → el Tablero elimina entidad.
🧪 Posibles expansiones
- Mutaciones en Mime: ¿serán híbridos? ¿tienen memoria?
- Registro de generaciones o genética.
- Zonas tóxicas, biomas, clima...
- Eventos aleatorios que afectan el tablero (plaga, eclipse, tormenta…)



