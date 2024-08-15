public class Ejecuciones {
    private int[] comandos;
    private int acumulador1;
    private int acumulador2;
    private Cache cache;

    public Ejecuciones(int[] comandos, Cache cache) {
        this.comandos = comandos;
        this.acumulador1 = 0;
        this.acumulador2 = 0;
        this.cache = cache;
    }

    public void ejecutar(int a, int b) {
        
        for (int i = 0; i < comandos.length; i++) {
            System.out.println("\nEjecutando instruccion en direccion " + comandos[i] + ":");
            switch (comandos[i]) {
                case 0:
                    acumulador1 = a;
                    cache.guardarEnCache(0, acumulador1);
                    System.out.println("Acumulador 1 cargado desde memoria: " + acumulador1);
                    break;
                case 1:
                    acumulador2 = b;
                    cache.guardarEnCache(0, acumulador2);
                    System.out.println("Acumulador 2 cargado desde memoria: " + acumulador2);
                    break;
                case 2:
                    acumulador1 = cache.cargarDesdeMemoria(0)+ cache.cargarDesdeMemoria(1);
                    System.out.println("Acumulador 1 (a + b): " + acumulador1);
                    break;
                case 3:
                    acumulador2 = cache.cargarDesdeMemoria(0) * 2;
                    System.out.println("Acumulador 2 (a * 2): " + acumulador2);
                    break;
                case 4:
                    acumulador1 = cache.cargarDesdeMemoria(0)-cache.cargarDesdeMemoria(1);
                    System.out.println("Acumulador 1 (Acumulador1 - Acumulador2): " + acumulador1);
                    break;
                case 5:
                    acumulador1 = cache.cargarDesdeMemoria(0) + cache.cargarDesdeMemoria(1);
                    System.out.println("Acumulador 1 (Acumulador1 + Acumulador2): " + acumulador1);
                    break;
                case 6:
                    acumulador1 = cache.cargarDesdeMemoria(0) * cache.cargarDesdeMemoria(1);
                    System.out.println("Acumulador 1 (Acumulador1 * Acumulador2): " + acumulador1);
                    break;
                case 7:
                    System.out.println("Imprimir Acumulador 1: " + acumulador1);
                    break;
                case 8: // Branch if equal (BEQ)
                    if (cache.cargarDesdeMemoria(0) == cache.cargarDesdeMemoria(1)) {
                        System.out.println("Branch if Equal (BEQ) - Los acumuladores son iguales, saltando a la direccion: " + comandos[i]);
                    } else {
                        System.out.println("Branch if Equal (BEQ) - Los acumuladores no son iguales, continuando ejecucion.");
                    }
                    break;
                default:
                    System.out.println("Instruccion desconocida: " + comandos[i]);
                    break;
            }
            System.out.println("Estado actual: Acumulador1 = " + acumulador1 + ", Acumulador2 = " + acumulador2);
        }

        System.out.println("\nContenido de la cache:");
        cache.mostrarContenidoCache();
    }
}

