public class ProgramCounter {
    private int pc;  // Contador de programa
    private int[] comandos;
    private int[] direcciones;
    private Cache cache;

    public ProgramCounter(int[] comandos, Cache cache) {
        this.pc = 100;  // Inicializar el contador de programa en 100
        this.comandos = comandos;
        this.direcciones = new int[comandos.length];
        this.cache = cache;

        // Asignar direcciones a los comandos
        for (int i = 0; i < comandos.length; i++) {
            direcciones[i] = pc + i + 1;
        }
    }

    public void mostrarDirecciones() {
        System.out.println("Direcciones de comandos:");
        for (int i = 0; i < comandos.length; i++) {
            System.out.println(direcciones[i] + " [" + comandos[i] + "]");
        }
    }

    public void ejecutarComandos(int a, int b) {
        // Pre-cargar valores en la caché
        cache.guardarEnCache(a, a);
        cache.guardarEnCache(b, b);

        // Ejecutar comandos
        int acumulador1 = 0;
        int acumulador2 = 0;

        for (int i = 0; i < comandos.length; i++) {
            System.out.println("\nEjecutando instruccion en direccion " + direcciones[i] + ":");
            switch (comandos[i]) {
                case 0:
                    acumulador1 = cache.cargarDesdeMemoria(a);
                    System.out.println("Instruccion 0: Cargar acumulador 1 desde direccion " + a + " (Valor: " + acumulador1 + ")");
                    break;
                case 1:
                    acumulador2 = cache.cargarDesdeMemoria(b);
                    System.out.println("Instruccion 1: Cargar acumulador 2 desde direccion " + b + " (Valor: " + acumulador2 + ")");
                    break;
                case 2:
                    acumulador1 = acumulador1 + acumulador2;
                    System.out.println("Instruccion 2: Sumar acumuladores (Resultado: " + acumulador1 + ")");
                    break;
                case 3:
                    acumulador2 = acumulador1 * 2;
                    System.out.println("Instruccion 3: Duplicar acumulador 1 y almacenar en acumulador 2 (Resultado: " + acumulador2 + ")");
                    break;
                case 4:
                    acumulador1 = acumulador1 - acumulador2;
                    System.out.println("Instruccion 4: Restar acumulador 2 de acumulador 1 (Resultado: " + acumulador1 + ")");
                    break;
                case 5:
                    acumulador1 = acumulador1 + acumulador2;
                    System.out.println("Instruccion 5: Sumar acumuladores nuevamente (Resultado: " + acumulador1 + ")");
                    break;
                case 6:
                    acumulador1 = acumulador1 * acumulador2;
                    System.out.println("Instruccion 6: Multiplicar acumuladores (Resultado: " + acumulador1 + ")");
                    break;
                case 7:
                    System.out.println("Instruccion 7: Imprimir Acumulador 1 (Valor: " + acumulador1 + ")");
                    break;
                case 8: // Branch if equal (BEQ)
                    if (acumulador1 == acumulador2) {
                        System.out.println("Instruccion 8: BEQ - Acumulador1 igual a Acumulador2, saltando a la direccion: " + direcciones[i]);
                    } else {
                        System.out.println("Instruccion 8: BEQ - Acumulador1 y Acumulador2 no son iguales, continuando ejecución.");
                    }
                    break;
                default:
                    System.out.println("Instruccion desconocida: " + comandos[i]);
                    break;
            }
            System.out.println("Estado actual: Acumulador1 = " + acumulador1 + ", Acumulador2 = " + acumulador2);
        }
    }
}
