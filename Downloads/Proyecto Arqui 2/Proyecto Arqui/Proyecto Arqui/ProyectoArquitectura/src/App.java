import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Solicitar números al usuario
        System.out.print("Ingrese el primer numero (a): ");
        int a = scanner.nextInt();

        System.out.print("Ingrese el segundo numero (b): ");
        int b = scanner.nextInt();

        int[] comandos = {0, 1, 2, 3, 4, 5, 6, 7, 8}; 

        // Crear instancia de Cache y ProgramCounter
        Cache cache = new Cache(4, 1024); // Caché de tamaño 4 y memoria de tamaño 1024
        ProgramCounter programCounter = new ProgramCounter(comandos, cache);

        // Mostrar direcciones y ejecutar comandos
        programCounter.mostrarDirecciones();
        programCounter.ejecutarComandos(a, b);

        cache.mostrarContenidoCache();
        scanner.close();
    }
}
