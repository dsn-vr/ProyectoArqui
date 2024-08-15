import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<Integer, Integer> cache;
    private int[] memoria;
    private int cacheSize;
    private int memoriaSize;

    public Cache(int cacheSize, int memoriaSize) {
        this.cacheSize = cacheSize;
        this.memoriaSize = memoriaSize;
        this.cache = new HashMap<>(cacheSize);
        this.memoria = new int[memoriaSize];
    }

    // Método para mapear direcciones negativas a positivas
    private int mapaDireccion(int direccion) {
        return direccion < 0 ? direccion + memoriaSize : direccion;
    }

    public int cargarDesdeMemoria(int direccion) {
        direccion = mapaDireccion(direccion); // Mapear direccion negativa a positiva
        if (cache.containsKey(direccion)) {
            System.out.println("Cargando desde cache: Direccion " + direccion + " Valor: " + cache.get(direccion));
            return cache.get(direccion);
        } else {
            int dato = memoria[direccion];
            cache.put(direccion, dato); // Cargar en la cache
            if (cache.size() > cacheSize) {
                cache.remove(cache.keySet().iterator().next()); // Política FIFO para mapeo directo
            }
            System.out.println("Cargando desde memoria: Direccion " + direccion + " Valor: " + dato);
            return dato;
        }
    }

    public void guardarEnCache(int direccion, int dato) {
        direccion = mapaDireccion(direccion); // Mapear direccion negativa a positiva
        cache.put(direccion, dato);
        memoria[direccion] = dato; // Actualizar en memoria
        if (cache.size() > cacheSize) {
            cache.remove(cache.keySet().iterator().next()); // Política FIFO para mapeo directo
        }
        System.out.println("Almacenando en cache: Direccion " + direccion + " Valor: " + dato);
    }

    public void mostrarContenidoCache() {
        System.out.println("\nContenido de la cache:");
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            System.out.println("Direccion: " + entry.getKey() + " Dato: " + entry.getValue());
        }
    }
}

// import java.util.HashMap;
// import java.util.Map;

// class Cache {
//     private Map<Integer, Integer> cachedato;
//     private int[] memoria;

//     public Cache(int memoriaSize) {
//         this.cachedato = new HashMap<>();
//         this.memoria = new int[memoriaSize];
//     }

//     public int read(int direccion) {
//         if (cachedato.containsKey(direccion)) {
//             return cachedato.get(direccion);
//         } else {
//             int dato = memoria[direccion];
//             cachedato.put(direccion, dato);
//             return dato;
//         }
//     }

//     public void write(int direccion, int dato) {
//         cachedato.put(direccion, dato);
//         memoria[direccion] = dato;
//     }

//     public void updatememoria() {
//         for (Map.Entry<Integer, Integer> entry : cachedato.entrySet()) {
//             memoria[entry.getKey()] = entry.getValue();
//         }
//     }
// }