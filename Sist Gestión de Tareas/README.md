# Sistema de Gestión de Tareas Pendientes

## ¿De qué trata este proyecto?

Este proyecto consiste en un programa de consola desarrollado en Java que simula un gestor de tareas pendientes, como los que usamos en el día a día para organizarnos. La idea nació de una necesidad muy común: cuando tenemos muchas cosas por hacer, necesitamos una herramienta que nos permita registrar tareas, saber cuáles son más urgentes, ver cuántas tenemos pendientes por prioridad y, sobre todo, poder ir completándolas en orden para no perder el hilo de lo que debemos hacer.

El objetivo principal fue poner en práctica el uso de estructuras de datos dinámicas, específicamente una **lista implementada desde cero basada en un arreglo que se expande automáticamente**, en lugar de usar las que ya trae Java por defecto. De esta forma, el programa no solo resuelve un problema real, sino que también demuestra cómo funcionan internamente este tipo de estructuras.

---

## ¿Para qué sirve?

Sirve para gestionar una lista de tareas de forma sencilla y con él se puede:

- Agregar tareas nuevas, siempre y cuando cumplan con ciertas validaciones (título solo con letras y espacios, tiempo estimado mayor a cero y prioridad válida).
- Ver todas las tareas pendientes, con su información completa.
- Contar cuántas tareas hay de cada prioridad (alta, media y baja), para tener una idea rápida del estado de la lista.
- Priorizar las tareas urgentes, moviendo todas las de prioridad alta al principio de la lista.
- Completar la siguiente tarea, eliminándola de la lista y devolviéndola para saber cuál se completó.

---

## ¿Cómo está organizado el proyecto?

El proyecto está dividido en varias clases, cada una con una responsabilidad específica. A continuación explico qué hace cada una y cómo se relacionan entre sí.

### Clase `Tarea`

Esta clase representa a una tarea dentro del sistema. Cada tarea tiene tres atributos: un **título**, un **tiempo estimado** (en minutos) y una **prioridad**. La prioridad no es un texto cualquiera, sino un valor de tipo `Prioridad`, que es una enumeración con tres opciones posibles: `ALTA`, `MEDIA` y `BAJA`.

La clase tiene métodos para obtener cada uno de estos datos (`getTitulo`, `getTiempoEstimado`, `getPrioridad`). Es una clase sencilla, pero fundamental porque es el objeto que se va a guardar y manipular dentro de la lista de tareas.

### Clase `Prioridad`

Es una enumeración (`enum`) que define los tres valores posibles que puede tener la prioridad de una tarea: `ALTA`, `MEDIA` y `BAJA`. Usar un `enum` en lugar de un texto libre es una decisión de diseño importante, porque garantiza que no se puedan ingresar valores inválidos como `"URGENTE"` o `"alta"`. El compilador se encarga de que solo se puedan usar los valores definidos.

### Clase `GestorTareas`

Esta es la clase principal del sistema, la que contiene toda la lógica de negocio. Dentro de ella se guarda una lista de tareas, que es una lista implementada desde cero (en otra clase) que almacena objetos de tipo `Tarea`.

Aquí se encuentran los métodos que el usuario puede usar:

- **`anadirTarea(Tarea tarea)`**: recibe una tarea y la agrega a la lista, pero antes valida que el título solo contenga letras y espacios, que el tiempo estimado sea mayor a cero y que la prioridad no sea nula. Si algo falla, muestra un mensaje de error y no la agrega.
- **`mostrarTareas()`**: recorre la lista y muestra por pantalla todas las tareas con su información.
- **`contarTareasPorPrioridad()`**: recorre la lista y cuenta cuántas tareas hay de cada prioridad, mostrando un resumen.
- **`priorizarTareas()`**: reorganiza la lista para que todas las tareas de prioridad alta queden al principio, respetando el orden relativo entre ellas, y dejando el resto atrás sin alterar su orden relativo.
- **`completarTareaSig()`**: elimina la primera tarea de la lista (la que está al principio) y la devuelve. Si la lista está vacía, devuelve `null` y muestra un mensaje.
- **`clear()`**: vacía la lista, útil para pruebas o para reiniciar el sistema.

Además, esta clase incluye el método de validación `validarNombre`, que se encarga de comprobar que el título de la tarea cumpla con el formato esperado.

### Clase `ArrayList<E>`

Esta es una implementación propia de una lista basada en un arreglo que se expande automáticamente. En lugar de usar `ArrayList` de Java, aquí se construyó desde cero para comprender mejor cómo funciona este tipo de estructura.

Internamente tiene un arreglo de objetos (`items`), un contador de tamaño (`size`) y una capacidad (`capacity`). Cuando el arreglo se llena, se expande automáticamente en 10 posiciones más. Los métodos que ofrece son:

- **`add(E e)`**: agrega un elemento al final de la lista, expandiendo la capacidad si es necesario.
- **`addAll(List<E> otraLista)`**: agrega todos los elementos de otra lista al final de la actual.
- **`removeFirst()`**: elimina el primer elemento de la lista y lo devuelve, desplazando todos los demás hacia la izquierda.
- **`get(int index)`**: devuelve el elemento en la posición indicada.
- **`size()`**: devuelve el número de elementos.
- **`clear()`**: vacía la lista, reiniciando la capacidad a 10.
- **`isEmpty()`**: indica si la lista está vacía.

Esta clase es la que da soporte a la lista de tareas del gestor. Sin ella, no se podrían guardar ni manipular las tareas.

### Interfaz `List<E>`

Define el contrato que debe cumplir cualquier implementación de lista. Especifica los métodos que una lista debe tener: agregar, agregar todos, eliminar el primero, obtener, consultar tamaño, vaciar y verificar si está vacía. Gracias a esta interfaz, la clase `ArrayList` puede ser reemplazada por otra implementación sin que el resto del código se vea afectado.

### Clase `Main`

Es el punto de entrada del programa. Aquí se crean los objetos necesarios y se ejecutan una serie de pruebas para demostrar que todo funciona correctamente. Estas pruebas están divididas en dos grupos:

- **Pruebas positivas**: se agregan tareas válidas, se muestran, se cuentan por prioridad, se priorizan, se completan y se vuelve a mostrar la lista actualizada. Todo debería funcionar sin errores.
- **Pruebas negativas**: se intentan agregar tareas con datos inválidos (título con números, título con solo espacios, título nulo, tiempo negativo, tiempo cero, prioridad nula), completar tareas con la lista vacía, mostrar y contar con la lista vacía, y priorizar con la lista vacía o sin tareas de prioridad alta. En todos estos casos, el sistema debe mostrar mensajes de error claros y no romperse.

El `Main` no forma parte de la lógica del sistema, sino que es una forma de comprobar que todo funciona como se espera.

---

## ¿Cómo se relacionan todas las clases?

La relación entre las clases es bastante clara:

- `Tarea` es el objeto que se va a gestionar.
- `Prioridad` define los valores válidos que puede tener la prioridad de una tarea.
- `ArrayList` es la estructura de datos que almacena las tareas.
- `List` define el contrato que sigue `ArrayList`.
- `GestorTareas` utiliza un `ArrayList` para guardar las tareas y ofrece métodos para interactuar con ellas.
- `Main` utiliza `GestorTareas` para probar todas las funcionalidades.

En resumen, `Main` llama a `GestorTareas`, que a su vez usa `ArrayList`. Y todo esto gira en torno a los objetos `Tarea` y sus valores de `Prioridad`.

---

## Estructura del proyecto

```
Sist Gestión de Tareas/
├──src
|  ├── Main.java
|  ├── GestorTareas.java
|  ├── Tarea.java
|  ├── Prioridad.java
|  ├── ArrayList.java
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
- Agregar tareas válidas a la lista.
- Mostrar todas las tareas pendientes.
- Contar tareas por prioridad (alta, media, baja).
- Priorizar las tareas urgentes (mover las de prioridad alta al principio).
- Completar la siguiente tarea (eliminar la primera de la lista).
- Ver la lista actualizada después de cada operación.

### Pruebas negativas
- Agregar tareas con título que contenga números.
- Agregar tareas con título que solo tenga espacios.
- Agregar tareas con título nulo.
- Agregar tareas con tiempo estimado negativo.
- Agregar tareas con tiempo estimado cero.
- Agregar tareas con prioridad nula.
- Completar una tarea con la lista vacía.
- Completar tareas hasta que la lista quede vacía.
- Mostrar tareas con la lista vacía.
- Contar tareas por prioridad con la lista vacía.
- Priorizar tareas con la lista vacía.
- Priorizar tareas cuando no hay ninguna de prioridad alta.

Todas estas pruebas están diseñadas para garantizar que el sistema sea robusto y que maneje correctamente tanto los casos exitosos como los errores.
