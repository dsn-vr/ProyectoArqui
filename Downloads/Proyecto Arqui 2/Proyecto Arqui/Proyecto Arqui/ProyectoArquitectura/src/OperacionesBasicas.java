public class OperacionesBasicas {
    // Método para sumar dos números y devolver el resultado en binario
    public static String sumarYConvertirABinario(int a, int b) {
        int resultado = a + b;
        return Binarios.convertirABinario(resultado);
    }

    // Método para restar dos números y devolver el resultado en binario
    public static String restarYConvertirABinario(int a, int b) {
        int resultado = a - b;
        return Binarios.convertirABinario(resultado);
    }
}