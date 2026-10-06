# Sistema de Gestión de Estudiantes

## ¿De qué trata este proyecto?

Este proyecto consiste en un programa de consola desarrollado en Java que implementa una **lista enlazada simple desde cero** para gestionar los datos de los estudiantes de un departamento de Informática.

La idea surgió de la necesidad de **comprender a fondo** cómo funcionan las listas enlazadas, construyendo una desde cero sin usar las estructuras que ya trae Java. En lugar de usar `ArrayList` o `LinkedList` de la biblioteca estándar, aquí se construyó todo manualmente: los nodos, la lista y cada una de las operaciones. El objetivo es entender cómo funciona una lista enlazada por dentro y cómo se manipulan sus referencias para realizar operaciones como filtrar, ordenar y contar.

---

## ¿Para qué sirve?

Este programa permite gestionar un listado de estudiantes de forma interactiva y con él se puede:

- **Agregar estudiantes** con sus datos: CI, nombre, apellido, sexo, año, si es militante de la UJC y si es becado.
- **Mostrar los estudiantes que cumplen años en un mes determinado** (el mes se extrae del CI).
- **Mostrar los estudiantes militantes de la UJC ordenados por año** (de menor a mayor).
- **Mostrar la cantidad de estudiantes becados**.
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

Esta clase es la que da soporte a todas las operaciones del ejercicio. Sin ella, no se podrían guardar ni manipular los estudiantes.

### Clase `Estudiante`

Esta clase representa a un estudiante dentro del sistema. Cada estudiante tiene siete atributos: **CI**, **nombre**, **apellido**, **sexo**, **año**, **si es militante de la UJC** y **si es becado**. La clase implementa `Comparable<Estudiante>` para poder ser ordenada por año.

La clase tiene métodos para obtener cada uno de estos datos (`getCi`, `getNombre`, `getApellido`, `getSexo`, `getAnio`, `isMilitanteUJC`, `isBecado`) y el método `compareTo()` que define el criterio de ordenamiento (de menor a mayor por año).

### Clase `GestorEstudiante`

Esta es la clase principal del sistema, la que contiene toda la lógica de negocio. Dentro de ella se guarda un listado de estudiantes, que no es más que una lista enlazada (implementada en otra clase) que almacena objetos de tipo `Estudiante`.

Aquí se encuentran los métodos que el usuario puede usar:

- **`agregar(Estudiante e)`**: agrega un estudiante a la lista.
- **`pedirAgregar(Scanner in)`**: pide los datos de un estudiante al usuario y los valida antes de agregarlo.
- **`cumpleanios(String mes)`**: muestra los estudiantes que cumplen años en el mes indicado.
- **`cantMilitantes()`**: muestra los militantes de la UJC ordenados por año.
- **`cantBecados()`**: muestra la cantidad de estudiantes becados.
- **`validarOpcion(Scanner in, int min, int max)`**: valida que la opción ingresada sea un número dentro del rango.
- **`validarNombreYApellido(Scanner in, String palabra)`**: valida que el nombre o apellido solo contenga letras y espacios.

### Clase `Main`

Es el punto de entrada del programa. Muestra un menú con las operaciones disponibles y utiliza un `Scanner` para leer las opciones del usuario. Cada opción llama a un método de `GestorEstudiante` y muestra el resultado correspondiente.

También incluye una opción para ejecutar **casos de prueba** (positivos, negativos y límite) que verifican el funcionamiento de los métodos.

---

## ¿Cómo se relacionan todas las clases?

La relación entre las clases es bastante clara:

- `Estudiante` es el objeto que se va a gestionar.
- `Nodo` es la pieza básica que permite construir la lista enlazada.
- `LinkedList` utiliza `Nodo` para almacenar elementos de cualquier tipo.
- `List` define el contrato que sigue `LinkedList`.
- `GestorEstudiante` utiliza una `LinkedList` para guardar los estudiantes y ofrece métodos para interactuar con ellos.
- `Main` utiliza `GestorEstudiante` para probar todas las funcionalidades.

En resumen, `Main` llama a `GestorEstudiante`, que a su vez usa `LinkedList`, que está compuesta por `Nodo`. Y todo esto gira en torno a los objetos `Estudiante`.

---

## Estructura del proyecto

ListadoDeEstudiantes/
├── src
│ ├── Main.java
│ ├── GestorEstudiante.java
│ ├── Estudiante.java
│ ├── LinkedList.java
│ ├── Nodo.java
│ └── List.java
└── README.md


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
- **Agregar estudiantes** con datos válidos.
- **Mostrar estudiantes que cumplen años en un mes** determinado.
- **Mostrar militantes de la UJC ordenados por año**.
- **Mostrar la cantidad de estudiantes becados**.

### Casos negativos
- **Sin estudiantes registrados**: los métodos avisan que la lista está vacía.
- **Ningún estudiante cumple en el mes indicado**: `cumpleanios` avisa que no hay resultados.
- **Sin militantes**: `cantMilitantes` avisa que no hay resultados.
- **Sin becados**: `cantBecados` muestra 0.
- **Todos con la misma edad**: verifica que el ordenamiento no falla con empates.
- **Todos becados**: verifica que `cantBecados` cuenta correctamente.
- **Todos cumplen en el mismo mes**: verifica que `cumpleanios` los muestra a todos.
