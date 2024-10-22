import java.util.*;

// Ejercicio 3: Eliminar letras repetidas de una lista ordenada
public class Ejercicio3 {
    public static List<Character> eliminarLetrasRepetidas(List<Character> lista) {
        List<Character> resultado = new ArrayList<>();
        for (char letra : lista) {
            if (resultado.isEmpty() || resultado.get(resultado.size() - 1) != letra) {
                resultado.add(letra);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<Character> lista = Arrays.asList('A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'F', 'F', 'G', 'H', 'I', 'J', 'J', 'J', 'K', 'L', 'M', 'N', 'N', 'N', 'N', 'O', 'P', 'Q', 'Q', 'Q', 'Q', 'R', 'S', 'T', 'V', 'W', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Y', 'Z', 'Z', 'Z', 'Z', 'Z');
        List<Character> resultado = eliminarLetrasRepetidas(lista);
        System.out.println(resultado);  // [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, V, W, X, Y, Z]
    }
}

// Ejercicio 4: Extraer pares de una pila a una cola
public class Ejercicio4 {
    public static Queue<Integer> extraerParesPila(Stack<Integer> pila) {
        Queue<Integer> cola = new LinkedList<>();
        while (!pila.isEmpty()) {
            int elemento = pila.pop();
            if (elemento % 2 == 0) {
                cola.add(elemento);
            }
        }
        return cola;
    }

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        Collections.addAll(pila, 1, 2, 3, 4, 5, 6, 7, 8);
        Queue<Integer> cola = extraerParesPila(pila);
        System.out.println(cola);  // [8, 6, 4, 2]
    }
}

// Ejercicio 5: Crear cola circular con números aleatorios y extraer negativos
public class Ejercicio5 {
    public static Queue<Integer> generarNumerosAleatorios() {
        Queue<Integer> cola = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            cola.add(random.nextInt(251) - 125);
        }
        return cola;
    }

    public static Queue<Integer> extraerNegativos(Queue<Integer> cola) {
        Queue<Integer> colaNegativos = new LinkedList<>();
        for (int num : cola) {
            if (num < 0) {
                colaNegativos.add(num);
            }
        }
        return colaNegativos;
    }

    public static void main(String[] args) {
        Queue<Integer> cola = generarNumerosAleatorios();
        Queue<Integer> colaNegativos = extraerNegativos(cola);
        System.out.println(colaNegativos);
    }
}

// Ejercicio 6: Extraer datos iguales a X de una pila y pasarlos a una cola
public class Ejercicio6 {
    public static Object[] extraerDatosIguales(Stack<Integer> pila, int x) {
        Queue<Integer> cola = new LinkedList<>();
        Stack<Integer> nuevaPila = new Stack<>();
        int count = 0;
        
        while (!pila.isEmpty()) {
            int elemento = pila.pop();
            if (elemento == x) {
                cola.add(elemento);
                count++;
            } else {
                nuevaPila.push(elemento);
            }
        }
        
        while (!nuevaPila.isEmpty()) {
            pila.push(nuevaPila.pop());
        }
        
        return new Object[] {cola, count, pila};
    }

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        Collections.addAll(pila, 3, 5, 3, 8, 3, 2, 7, 3);
        int x = 3;
        Object[] result = extraerDatosIguales(pila, x);
        System.out.println("Cola: " + result[0] + ", Cantidad extraída: " + result[1] + ", Pila final: " + result[2]);
    }
}

// Ejercicio 7: Validar si una cadena es de la forma X&Y usando Pila, Cola, y Arreglo
public class Ejercicio7 {
    // Validación usando Pila
    public static String esFormaXYPila(String cadena) {
        Stack<Character> pila = new Stack<>();
        String[] partes = cadena.split("&");
        String parte1 = partes[0];
        String parte2 = partes[1];
        
        for (char letra : parte1.toCharArray()) {
            pila.push(letra);
        }
        for (char letra : parte2.toCharArray()) {
            if (pila.isEmpty() || pila.pop() != letra) {
                return "NO PERTENECE A LA FORMA X&Y";
            }
        }
        return "SI PERTENECE A LA FORMA X&Y";
    }
    
    // Validación usando Cola
    public static String esFormaXYCola(String cadena) {
        Queue<Character> cola = new LinkedList<>();
        String[] partes = cadena.split("&");
        String parte1 = partes[0];
        String parte2 = partes[1];
        
        for (char letra : parte1.toCharArray()) {
            cola.add(letra);
        }
        for (char letra : parte2.toCharArray()) {
            if (cola.isEmpty() || cola.remove() != letra) {
                return "NO PERTENECE A LA FORMA X&Y";
            }
        }
        return "SI PERTENECE A LA FORMA X&Y";
    }
    
    // Validación usando Arreglo
    public static String esFormaXYArreglo(String cadena) {
        String[] partes = cadena.split("&");
        String parte1 = partes[0];
        String parte2 = partes[1];
        
        return parte1.equals(new StringBuilder(parte2).reverse().toString()) ? 
               "SI PERTENECE A LA FORMA X&Y" : "NO PERTENECE A LA FORMA X&Y";
    }

    public static void main(String[] args) {
        String cadena1 = "OSOS&OSOS";
        String cadena2 = "ABBDYCA&ACYDBBA";

        System.out.println(esFormaXYPila(cadena1));  // NO PERTENECE A LA FORMA X&Y
        System.out.println(esFormaXYPila(cadena2));  // SI PERTENECE A LA FORMA X&Y

        System.out.println(esFormaXYCola(cadena1));  // NO PERTENECE A LA FORMA X&Y
        System.out.println(esFormaXYCola(cadena2));  // SI PERTENECE A LA FORMA X&Y

        System.out.println(esFormaXYArreglo(cadena1));  // NO PERTENECE A LA FORMA X&Y
        System.out.println(esFormaXYArreglo(cadena2));  // SI PERTENECE A LA FORMA X&Y
    }
}
