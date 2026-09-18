# Sistema de Gestión de Biblioteca

## ¿De qué trata este proyecto?

Este proyecto consiste en un programa de consola desarrollado en Java que simula el funcionamiento básico de una biblioteca. La idea surgió de una necesidad muy común: en una biblioteca pequeña, los encargados necesitan llevar un control de los libros que tienen, saber cuáles están disponibles, cuáles están prestados, poder devolverlos, buscar un libro por su género para recomendarlo a un lector, y hasta cambiar el orden del catálogo cuando sea necesario. Todo esto sin depender de sistemas complicados, simplemente desde la consola.

El objetivo principal fue poner en práctica el uso de estructuras de datos dinámicas, específicamente una **lista enlazada implementada desde cero**, en lugar de usar las que ya trae Java por defecto. De esta forma, el programa no solo resuelve un problema real, sino que también demuestra cómo funcionan internamente este tipo de estructuras.

---

## ¿Para qué sirve?

Este gestiona un catálogo de libros de forma sencilla y con él se puede:

- Agregar libros nuevos al catálogo, siempre y cuando cumplan con ciertas validaciones (título, autor y género solo con letras y espacios, ISBN con formato válido).
- Ver todos los libros que hay en la biblioteca, con su información completa.
- Prestar un libro, marcándolo como no disponible.
- Devolver un libro, marcándolo como disponible nuevamente.
- Recomendar un libro según el género que el usuario indique, mostrando el primero que esté disponible.
- Invertir el orden del catálogo, útil por ejemplo si se quiere ver los libros desde el último que se agregó hasta el primero.


---

## ¿Cómo está organizado el proyecto?

El proyecto está dividido en varias clases, cada una con una responsabilidad específica. A continuación explico qué hace cada una y cómo se relacionan entre sí.

### Clase `Libro`

Esta clase representa a un libro dentro del sistema. Cada libro tiene cinco atributos: un **ISBN** (que es único para cada libro), un **título**, un **autor**, un **género** y un estado que indica si está **prestado** o no. Cuando se añade un libro, por defecto se marca como no prestado.

La clase tiene métodos para obtener cada uno de estos datos (`getIsbn`, `getTitulo`, `getAutor`, `getGenero`) y también para consultar o cambiar el estado de préstamo (`isPrestado` y `setPrestado`). Es una clase sencilla, pero fundamental porque es el objeto que se va a guardar y manipular dentro del catálogo.

### Clase `GestionBiblioteca`

Esta es la clase principal del sistema, la que contiene toda la lógica de negocio. Dentro de ella se guarda un catálogo de libros, que no es más que una lista enlazada (implementada en otra clase) que almacena objetos de tipo `Libro`.

Aquí se encuentran los métodos que el usuario puede usar:

- **`anadirLibro(Libro libro)`**: recibe un libro y lo agrega al catálogo, pero antes valida que el título, el autor y el género solo contengan letras y espacios, y que el ISBN tenga un formato válido (10 o 13 dígitos, posiblemente con guiones). Si algo falla, muestra un mensaje de error y no lo agrega.
- **`verCatalogo()`**: recorre el catálogo y muestra por pantalla todos los libros con su información.
- **`prestarLibro(String isbn)`**: busca un libro por su ISBN y, si está disponible, lo marca como prestado. Si no existe o ya está prestado, avisa al usuario.
- **`devolverLibro(String isbn)`**: hace lo contrario, busca el libro y si está prestado lo marca como disponible.
- **`recomendarLibro(String genero)`**: busca el primer libro disponible de un género específico y lo recomienda. Si no encuentra ninguno, lo indica.
- **`invertirCatalogo()`**: invierte el orden de los libros en el catálogo.
- **`buscarISBN(String isbn)`** y **`buscarGenero(String genero)`**: son métodos auxiliares que se usan internamente para localizar libros dentro del catálogo. No están pensados para que el usuario los use directamente, pero son clave para que los demás métodos funcionen.
- **`clear()`**: vacía el catálogo, útil para pruebas o para reiniciar el sistema.

Además, esta clase incluye métodos de validación (`validarNombre` y `validarISBN`) que se encargan de comprobar que los datos ingresados cumplen con el formato esperado.

### Clase `LinkedList<E>`

Esta es una implementación propia de una lista enlazada genérica. En lugar de usar `ArrayList` o `LinkedList` de Java, aquí se construyó desde cero para comprender mejor cómo funciona este tipo de estructura.

Internamente tiene un nodo inicial (`head`) y un contador de tamaño (`size`). Cada nodo guarda un dato y una referencia al siguiente nodo. Los métodos que ofrece son:

- **`add(E e)`**: agrega un elemento al final de la lista.
- **`add(E e, int index)`**: agrega un elemento en una posición específica.
- **`remove(int index)`**: elimina el elemento en la posición indicada y lo devuelve.
- **`get(int index)`**: devuelve el elemento en la posición indicada.
- **`invertir()`**: invierte el orden de los nodos, cambiando las referencias para que el último pase a ser el primero.
- **`size()`**: devuelve el número de elementos.
- **`clear()`**: vacía la lista.
- **`isEmpty()`**: indica si la lista está vacía.

Esta clase es la que da soporte al catálogo de la biblioteca. Sin ella, no se podrían guardar ni manipular los libros.

### Clase `Nodo<E>`

Es una clase auxiliar que representa un nodo de la lista enlazada. Cada nodo tiene dos atributos: el **dato** que almacena (en este caso, un objeto de tipo `Libro`) y una referencia al **siguiente** nodo. Tiene métodos para obtener y establecer tanto el dato como el siguiente nodo. Es la pieza básica sobre la que se construye la lista enlazada.

### Interfaz `List<E>`

Define el contrato que debe cumplir cualquier implementación de lista. Especifica los métodos que una lista debe tener: agregar, eliminar, obtener, consultar tamaño, vaciar y verificar si está vacía. Gracias a esta interfaz, la clase `LinkedList` puede ser reemplazada por otra implementación sin que el resto del código se vea afectado.

### Clase `Main`

Es el punto de entrada del programa. Aquí se crean los objetos necesarios y se ejecutan una serie de pruebas para demostrar que todo funciona correctamente. Estas pruebas están divididas en dos grupos:

- **Pruebas positivas**: se agregan libros válidos, se prestan, se devuelven, se invierte el catálogo y se recomiendan libros. Todo debería funcionar sin errores.
- **Pruebas negativas**: se intentan agregar libros con datos inválidos (título vacío, autor con números, ISBN incorrecto, etc.), prestar libros que no existen, devolver libros que ya están disponibles, recomendar con género nulo o vacío, y otras situaciones similares. En todos estos casos, el sistema debe mostrar mensajes de error claros y no romperse.

El `Main` no forma parte de la lógica del sistema, sino que es una forma de comprobar que todo funciona como se espera.

---

## ¿Cómo se relacionan todas las clases?

La relación entre las clases es bastante clara:

- `Libro` es el objeto que se va a gestionar.
- `Nodo` es la pieza básica que permite construir la lista enlazada.
- `LinkedList` utiliza `Nodo` para almacenar elementos de cualquier tipo.
- `List` define el contrato que sigue `LinkedList`.
- `GestionBiblioteca` utiliza una `LinkedList` para guardar los libros y ofrece métodos para interactuar con ellos.
- `Main` utiliza `GestionBiblioteca` para probar todas las funcionalidades.

En resumen, `Main` llama a `GestionBiblioteca`, que a su vez usa `LinkedList`, que está compuesta por `Nodo`. Y todo esto gira en torno a los objetos `Libro`.

---

## Estructura del proyecto

```
 Sist Gestión de Biblioteca/
├──src
|  ├── Main.java
|  ├── GestionBiblioteca.java
|  ├── Libro.java
|  ├── LinkedList.java
|  ├── Nodo.java
|  └── List.java
└── README.md
```

---

## ¿Cómo ejecutar el programa?

1. Descarga o clona el repositorio.
2. Abre el proyecto en tu IDE favorito (Visual Studio, Eclipse, IntelliJ, NetBeans, etc.).
3. Compila todas las clases.
4. Ejecuta la clase `Main`.
5. Verás en la consola los resultados de todas las pruebas, tanto positivas como negativas.

---

## Casos de prueba incluidos

El programa incluye una batería de pruebas que cubren los escenarios más importantes:

### Pruebas positivas
- Agregar libros válidos al catálogo.
- Ver el catálogo completo.
- Prestar libros disponibles.
- Devolver libros prestados.
- Invertir el catálogo.
- Recomendar un libro de un género disponible.

### Pruebas negativas
- Agregar libros con título vacío, nulo o con números.
- Agregar libros con autor vacío, nulo o con números.
- Agregar libros con género vacío, nulo o con números.
- Agregar libros con ISBN vacío, nulo, con letras o con longitud incorrecta.
- Prestar un libro con el catálogo vacío.
- Prestar un libro que no existe.
- Prestar un libro que ya está prestado.
- Prestar con ISBN nulo.
- Devolver un libro con el catálogo vacío.
- Devolver un libro que no existe.
- Devolver un libro que ya está disponible.
- Devolver con ISBN nulo.
- Ver el catálogo vacío.
- Invertir el catálogo vacío.
- Recomendar con el catálogo vacío.
- Recomendar con género nulo o vacío.
- Recomendar un género que no existe.
- Recomendar cuando todos los libros del género están prestados.

Todas estas pruebas están diseñadas para garantizar que el sistema sea robusto y que maneje correctamente tanto los casos exitosos como los errores.
