public class Booth {
 // Método para multiplicar dos números utilizando el algoritmo de Booth
 public static int multiplicar(int a, int b) {
    int m = a;
    int r = b;
    int x = 0;
    int y = Integer.SIZE; // Tamaño de 32 bits para representar números enteros
    int[] Q = new int[y];
    int[] M = new int[y];
    int[] A = new int[y];
    int[] S = new int[y];

    // Llenar M y S
    for (int i = 0; i < y; i++) {
        if (i < Integer.SIZE) {
            M[i] = (m >> i) & 1;
            S[i] = (-(m) >> i) & 1;
        } else {
            M[i] = 0;
            S[i] = 0;
        }
    }

    // Llenar Q
    for (int i = 0; i < y; i++) {
        if (i < Integer.SIZE) {
            Q[i] = (r >> i) & 1;
        } else {
            Q[i] = 0;
        }
    }

    // Algoritmo de Booth
    for (int i = 0; i < Integer.SIZE; i++) {
        if (Q[0] == 1 && x == 0) {
            // Restar M
            for (int j = 0; j < y; j++) {
                A[j] = A[j] + S[j];
            }
        } else if (Q[0] == 0 && x == 1) {
            // Sumar M
            for (int j = 0; j < y; j++) {
                A[j] = A[j] + M[j];
            }
        }

        // Desplazamiento
        x = Q[0];
        for (int j = 0; j < y - 1; j++) {
            Q[j] = Q[j + 1];
        }
        Q[y - 1] = A[0];
        for (int j = 0; j < y - 1; j++) {
            A[j] = A[j + 1];
        }
        A[y - 1] = A[y - 2];
    }

    // Convertir A y Q a decimal
    int resultado = 0;
    for (int i = 0; i < y; i++) {
        resultado += Q[i] << i;
    }

    return resultado;
}

public static String multiplicarYConvertirABinario(int a, int b) {
    int resultado = Booth.multiplicar(a, b);
    return Binarios.convertirABinario(resultado);
}

// Método para elevar un número a una potencia y devolver el resultado en binario
public static String potenciarYConvertirABinario(int base, int exponente) {
    int resultado = (int) Math.pow(base, exponente);
    return Binarios.convertirABinario(resultado);
}
}

