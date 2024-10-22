# Ejercicio 3: Eliminar letras repetidas de una lista ordenada
def eliminar_letras_repetidas(lista):
    resultado = []
    for letra in lista:
        if not resultado or resultado[-1] != letra:
            resultado.append(letra)
    return resultado

# Ejemplo de uso:
lista = ['A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'F', 'F', 'G', 'H', 'I', 'J', 'J', 'J', 'K', 'L', 'M', 'N', 'N', 'N', 'N', 'O', 'P', 'Q', 'Q', 'Q', 'Q', 'R', 'S', 'T', 'V', 'W', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Y', 'Z', 'Z', 'Z', 'Z', 'Z']
resultado = eliminar_letras_repetidas(lista)
print(resultado)  # ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z']


# Ejercicio 4: Extraer pares de una pila a una cola
from collections import deque

def extraer_pares_pila(pila):
    cola = deque()
    while pila:
        elemento = pila.pop()
        if elemento % 2 == 0:
            cola.append(elemento)
    return cola

# Ejemplo de uso:
pila = [1, 2, 3, 4, 5, 6, 7, 8]
cola = extraer_pares_pila(pila)
print(list(cola))  # [8, 6, 4, 2]


# Ejercicio 5: Crear cola circular con números aleatorios y extraer negativos
import random

def generar_numeros_aleatorios():
    cola = deque([random.randint(-125, 125) for _ in range(100)])
    return cola

def extraer_negativos(cola):
    cola_negativos = deque([n for n in cola if n < 0])
    return cola_negativos

# Ejemplo de uso:
cola = generar_numeros_aleatorios()
cola_negativos = extraer_negativos(cola)
print(list(cola_negativos))


# Ejercicio 6: Extraer datos iguales a X de una pila y pasarlos a una cola
def extraer_datos_iguales(pila, x):
    cola = deque()
    count = 0
    nueva_pila = []
    
    while pila:
        elemento = pila.pop()
        if elemento == x:
            cola.append(elemento)
            count += 1
        else:
            nueva_pila.append(elemento)
    
    while nueva_pila:
        pila.append(nueva_pila.pop())
    
    return cola, count, pila

# Ejemplo de uso:
pila = [3, 5, 3, 8, 3, 2, 7, 3]
x = 3
cola, count, pila = extraer_datos_iguales(pila, x)
print(f"Cola: {list(cola)}, Cantidad extraída: {count}, Pila final: {pila}")


# Ejercicio 7: Validar si una cadena es de la forma X&Y usando Pila, Cola, y Arreglo
def es_forma_XY_pila(cadena):
    pila = []
    parte1, parte2 = cadena.split('&')
    for letra in parte1:
        pila.append(letra)
    for letra in parte2:
        if not pila or pila.pop() != letra:
            return "NO PERTENECE A LA FORMA X&Y"
    return "SI PERTENECE A LA FORMA X&Y"

def es_forma_XY_cola(cadena):
    cola = deque()
    parte1, parte2 = cadena.split('&')
    for letra in parte1:
        cola.append(letra)
    for letra in parte2:
        if not cola or cola.pop() != letra:
            return "NO PERTENECE A LA FORMA X&Y"
    return "SI PERTENECE A LA FORMA X&Y"

def es_forma_XY_arreglo(cadena):
    parte1, parte2 = cadena.split('&')
    return "SI PERTENECE A LA FORMA X&Y" if parte1 == parte2[::-1] else "NO PERTENECE A LA FORMA X&Y"

# Ejemplo de uso:
cadena1 = "OSOS&OSOS"
cadena2 = "ABBDYCA&ACYDBBA"

print(es_forma_XY_pila(cadena1))  # NO PERTENECE A LA FORMA X&Y
print(es_forma_XY_pila(cadena2))  # SI PERTENECE A LA FORMA X&Y

print(es_forma_XY_cola(cadena1))  # NO PERTENECE A LA FORMA X&Y
print(es_forma_XY_cola(cadena2))  # SI PERTENECE A LA FORMA X&Y

print(es_forma_XY_arreglo(cadena1))  # NO PERTENECE A LA FORMA X&Y
print(es_forma_XY_arreglo(cadena2))  # SI PERTENECE A LA FORMA X&Y
