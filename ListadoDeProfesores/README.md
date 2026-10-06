# Sistema de Gestión de Profesores

## ¿De qué trata este proyecto?

Este proyecto consiste en un programa de consola desarrollado en Java que implementa una **lista enlazada simple desde cero** para gestionar los datos de los profesores de un departamento de Informática.

La idea surgió de la necesidad de **comprender a fondo** cómo funcionan las listas enlazadas, construyendo una desde cero sin usar las estructuras que ya trae Java. En lugar de usar `ArrayList` o `LinkedList` de la biblioteca estándar, aquí se construyó todo manualmente: los nodos, la lista y cada una de las operaciones. El objetivo es entender cómo funciona una lista enlazada por dentro y cómo se manipulan sus referencias para realizar operaciones como filtrar, ordenar y contar.

---

## ¿Para qué sirve?

Este programa permite gestionar un listado de profesores de forma interactiva y con él se puede:

- **Agregar profesores** con sus datos: nombre, edad y categoría docente (Instructor, Asistente, Auxiliar o Titular).
- **Mostrar los profesores próximos a cambio de categoría** (instructores con más de 26 años).
- **Mostrar la lista de profesores ordenada por edad** (de mayor a menor).
- **Mostrar la cantidad de profesores por categoría docente**.
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
- **`add(E e, int index)`**: agrega un elemento en una posición específica.
- **`remove(int index)`**: elimina el elemento en la posición indicada y lo devuelve.
- **`get(int index)`**: devuelve el elemento en la posición indicada.
- **`size()`**: devuelve el número de elementos.
- **`clear()`**: vacía la lista.
- **`isEmpty()`**: indica si la lista está vacía.
- **`mergeSort()`**: ordena la lista usando el algoritmo Merge Sort.

Esta clase es la que da soporte a todas las operaciones del ejercicio. Sin ella, no se podrían guardar ni manipular los profesores.

### Clase `Profesor`

Esta clase representa a un profesor dentro del sistema. Cada profesor tiene tres atributos: **nombre**, **edad** y **categoría docente**. La clase implementa `Comparable<Profesor>` para poder ser ordenada por edad.

La clase tiene métodos para obtener cada uno de estos datos (`getNombre`, `getEdad`, `getCatDoc`) y el método `compareTo()` que define el criterio de ordenamiento (de mayor a menor por edad).

### Clase `GestorProfesores`

Esta es la clase principal del sistema, la que contiene toda la lógica de negocio. Dentro de ella se guarda un listado de profesores, que no es más que una lista enlazada (implementada en otra clase) que almacena objetos de tipo `Profesor`.

Aquí se encuentran los métodos que el usuario puede usar:

- **`agregar(Profesor p)`**: agrega un profesor a la lista.
- **`pedirAgregar(Scanner in)`**: pide los datos de un profesor al usuario y los valida antes de agregarlo.
- **`proxCambio()`**: muestra los instructores con más de 26 años.
- **`mostrarLista()`**: ordena y muestra todos los profesores por edad (de mayor a menor).
- **`cantProfesores()`**: devuelve un `String` con la cantidad de profesores por categoría.
- **`validarOpcion(Scanner in, int min, int max)`**: valida que la opción ingresada sea un número dentro del rango.

### Clase `Main`

Es el punto de entrada del programa. Muestra un menú con las operaciones disponibles y utiliza un `Scanner` para leer las opciones del usuario. Cada opción llama a un método de `GestorProfesores` y muestra el resultado correspondiente.

También incluye una opción para ejecutar **casos de prueba** (positivos y negativos) que verifican el funcionamiento de los métodos.

---

## ¿Cómo se relacionan todas las clases?

La relación entre las clases es bastante clara:

- `Profesor` es el objeto que se va a gestionar.
- `Nodo` es la pieza básica que permite construir la lista enlazada.
- `LinkedList` utiliza `Nodo` para almacenar elementos de cualquier tipo.
- `List` define el contrato que sigue `LinkedList`.
- `GestorProfesores` utiliza una `LinkedList` para guardar los profesores y ofrece métodos para interactuar con ellos.
- `Main` utiliza `GestorProfesores` para probar todas las funcionalidades.

En resumen, `Main` llama a `GestorProfesores`, que a su vez usa `LinkedList`, que está compuesta por `Nodo`. Y todo esto gira en torno a los objetos `Profesor`.

---

## Estructura del proyecto

```
Listado de Profesores/
├── src
│   ├── Main.java
│   ├── GestorProfesores.java
│   ├── Profesor.java
│   ├── LinkedList.java
│   ├── Nodo.java
│   └── List.java
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

### Casos positivos
- **Agregar profesores** con datos válidos.
- **Mostrar profesores próximos a cambio** (instructores con más de 26 años).
- **Mostrar la lista ordenada por edad** (de mayor a menor).
- **Mostrar la cantidad de profesores por categoría**.

### Casos negativos
- **Sin profesores registrados**: los métodos avisan que la lista está vacía.
- **Sin instructores con más de 26 años**: `proxCambio` avisa que no hay resultados.
- **Instructor de exactamente 26 años**: no debe aparecer en `proxCambio`.
- **Todos con la misma edad**: verifica que el ordenamiento no falla con empates.
- **Solo una categoría**: verifica que `cantProfesores` muestra 0 en las demás.
