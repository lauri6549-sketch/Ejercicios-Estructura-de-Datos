
#  Operaciones con Listas Enlazadas

## ¿De qué trata este proyecto?

Este proyecto consiste en un programa de consola desarrollado en Java que implementa una **lista enlazada simple desde cero** y permite realizar sobre ella tres operaciones fundamentales: **eliminar elementos repetidos**, **rotar los elementos una posición a la derecha** y **concatenar dos listas**.

La idea surgió de un ejercicio de clase que pedía trabajar con listas enlazadas sin usar las estructuras que ya trae Java. En lugar de usar `ArrayList` o `LinkedList` de la biblioteca estándar, aquí se construyó todo manualmente: los nodos, la lista y cada una de las operaciones. El objetivo es entender cómo funciona una lista enlazada por dentro y cómo se manipulan sus referencias para realizar operaciones que, con arreglos, serían más directas pero menos ilustrativas.

---

## ¿Para qué sirve?

Este programa permite manipular listas enlazadas de forma interactiva y con él se puede:

- **Crear una lista** ingresando la cantidad de elementos que se desee y luego cada elemento uno por uno.
- **Ver la lista** actual en pantalla.
- **Eliminar los elementos repetidos**, dejando solo una ocurrencia de cada uno.
- **Rotar la lista una posición a la derecha**, moviendo el último elemento al principio.
- **Concatenar otra lista** a la lista actual, uniendo ambas en una sola.
- **Salir del programa** cuando se termine.

---

## ¿Cómo está organizado el proyecto?

El proyecto está dividido en varias clases, cada una con una responsabilidad específica. A continuación explico qué hace cada una y cómo se relacionan entre sí.

### Interfaz `List<E>`

Define el contrato que debe cumplir cualquier implementación de lista. Especifica los métodos que una lista debe tener: agregar, eliminar, obtener, consultar tamaño, vaciar y verificar si está vacía. Gracias a esta interfaz, la clase `LinkedList` puede ser reemplazada por otra implementación sin que el resto del código se vea afectado.

### Clase `Nodo<E>`

Es una clase auxiliar que representa un nodo de la lista enlazada. Cada nodo tiene dos atributos: el **dato** que almacena y una referencia al **siguiente** nodo. Tiene métodos para obtener y establecer tanto el dato como el siguiente nodo. Es la pieza básica sobre la que se construye la lista enlazada.

### Clase `LinkedList<E>`

Esta es una implementación propia de una lista enlazada genérica. En lugar de usar `ArrayList` o `LinkedList` de Java, aquí se construyó desde cero para comprender mejor cómo funciona este tipo de estructura.

Internamente tiene un nodo inicial (`head`) y un contador de tamaño (`size`). Cada nodo guarda un dato y una referencia al siguiente nodo. Los métodos que ofrece son:

- **`add(E e)`**: agrega un elemento al final de la lista.
- **`remove(int index)`**: elimina el elemento en la posición indicada y lo devuelve.
- **`get(int index)`**: devuelve el elemento en la posición indicada.
- **`size()`**: devuelve el número de elementos.
- **`clear()`**: vacía la lista.
- **`isEmpty()`**: indica si la lista está vacía.

Además, incluye los métodos específicos del ejercicio:

- **`eliminarRepetidos()`**: recorre la lista y elimina los elementos duplicados, dejando solo una ocurrencia de cada uno. Si no encuentra repetidos, lo indica.
- **`rotarDerecha()`**: mueve el último elemento al principio de la lista. Si la lista está vacía o tiene un solo elemento, avisa que no se puede rotar.
- **`concatenar(LinkedList<E> otra)`**: une otra lista al final de la actual, sumando sus tamaños.
- **`mostrar()`**: recorre la lista y muestra sus elementos separados por guiones.

Esta clase es la que da soporte a todas las operaciones del ejercicio. Sin ella, no se podrían guardar ni manipular los elementos.

### Clase `Main`

Es el punto de entrada del programa. Muestra un menú con las operaciones disponibles y utiliza un `Scanner` para leer las opciones del usuario. Cada opción llama a un método de `LinkedList` y muestra el resultado correspondiente. También valida que las opciones ingresadas sean correctas y que los datos introducidos por el usuario cumplan con el formato esperado (solo letras, cantidad mayor a cero, etc.).

---

## ¿Cómo se relacionan todas las clases?

La relación entre las clases es bastante clara:

- `Nodo` es la pieza básica que permite construir la lista enlazada.
- `LinkedList` utiliza `Nodo` para almacenar elementos de cualquier tipo.
- `List` define el contrato que sigue `LinkedList`.
- `Main` utiliza `LinkedList` para probar todas las operaciones desde un menú interactivo.

En resumen, `Main` llama a `LinkedList`, que está compuesta por `Nodo`, y todo esto respeta el contrato definido por `List`.

---

## Estructura del proyecto

```
 OperacionesListasEnlazadas/
|── src
|    ├── Main.java
|    ├── LinkedList.java
|    ├── Nodo.java
|    └── List.java
└── README.md
```

---

## ¿Cómo ejecutar el programa?

1. Descarga o clona el repositorio.
2. Abre el proyecto en tu IDE favorito (Visual Studio, Eclipse, IntelliJ, NetBeans, etc.).
3. Compila todas las clases.
4. Ejecuta la clase `Main`.
5. Sigue las instrucciones del menú para probar las operaciones.

---

## Casos de prueba incluidos

El programa permite probar todas las operaciones desde el menú. A continuación se describen los casos que se pueden probar:

### Operaciones básicas
- **Crear una lista** con varios elementos.
- **Mostrar la lista** para verificar que los elementos se agregaron correctamente.
- **Eliminar repetidos** en una lista que tenga duplicados.
- **Eliminar repetidos** en una lista que no tenga duplicados.
- **Rotar la lista** una posición a la derecha.
- **Concatenar dos listas** y ver el resultado.

### Casos especiales
- **Lista vacía**: al intentar eliminar repetidos, rotar o mostrar, el programa avisa que la lista está vacía.
- **Lista con un solo elemento**: al intentar rotar, el programa avisa que no se puede.
- **Cantidad inválida**: si el usuario ingresa letras o un número negativo en la cantidad de elementos, el programa lo rechaza y pide de nuevo.
- **Elemento inválido**: si el usuario ingresa un elemento vacío o con caracteres que no son letras, el programa lo rechaza y pide de nuevo.
- **Opción inválida en el menú**: si el usuario ingresa un número fuera del rango o letras, el programa lo rechaza y pide de nuevo.
