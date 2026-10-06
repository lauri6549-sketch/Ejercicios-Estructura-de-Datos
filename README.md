# Ejercicios Estructuras de Datos en Java

## ¿De qué trata este repositorio?

Este repositorio reúne **cinco ejercicios prácticos** desarrollados en Java con un objetivo común: comprender cómo funcionan internamente las **estructuras de datos dinámicas**, implementándolas desde cero en lugar de usar las que ya vienen incluidas en el lenguaje.

Cada ejercicio resuelve un problema real (la gestión de una biblioteca, la gestión de tareas pendientes, las operaciones con listas enlazadas, la gestión de profesores y la gestión de estudiantes), pero lo importante no es solo el resultado final, sino el **camino recorrido**: entender cómo se guardan, ordenan, buscan y modifican los datos por dentro.

Los cinco ejercicios son independientes entre sí, pero comparten el mismo objetivo.

---

## Ejercicio 1: Sistema de Gestión de Biblioteca

Este ejercicio simula el funcionamiento básico de una biblioteca. Permite agregar libros, prestarlos, devolverlos, ver el catálogo completo, recomendar un libro por género e invertir el orden del catálogo.

La particularidad de este ejercicio es que no se usó `ArrayList` ni `LinkedList` de Java, sino que se implementó una lista enlazada desde cero (con nodos que se apuntan entre sí). Esto obliga a pensar en cómo se conectan los elementos y cómo se recorre la estructura, en lugar de simplemente llamar a métodos ya existentes.

Además, el sistema incluye validaciones para asegurarse de que los datos ingresados (título, autor, género e ISBN) cumplan con un formato correcto, y una serie de pruebas que comprueban que el programa responde bien tanto a los casos exitosos como a los errores.

---

## Ejercicio 2: Sistema de Gestión de Tareas Pendientes

Este ejercicio simula un gestor de tareas, como los que usamos en el día a día. Permite agregar tareas con prioridad (alta, media, baja), verlas, contarlas por prioridad, priorizar las urgentes y completarlas en orden.

La particularidad de este ejercicio es que no se usó `ArrayList` de Java, sino que se implementó una lista basada en un arreglo que se expande automáticamente cuando se llena. Esto permite entender cómo funcionan las listas dinámicas por dentro: cómo crecen, cómo se desplazan los elementos y cómo se gestiona la memoria.

Además, el sistema usa un `enum` para las prioridades, lo que garantiza que solo se puedan usar valores válidos (`ALTA`, `MEDIA` o `BAJA`), y también incluye validaciones y una batería de pruebas que cubren casos exitosos y errores.

---

## Ejercicio 3: Operaciones con Listas Enlazadas

Este ejercicio implementa una **lista enlazada simple desde cero** y permite realizar sobre ella tres operaciones fundamentales: **eliminar elementos repetidos**, **rotar los elementos una posición a la derecha** y **concatenar dos listas**.

La particularidad de este ejercicio es que **no se usó ninguna estructura de Java**, sino que se construyó todo manualmente: los nodos, la lista y cada una de las operaciones. El objetivo es entender cómo se manipulan las referencias dentro de una lista enlazada para realizar operaciones que, con arreglos, serían más directas pero menos ilustrativas.

Además, el sistema incluye un menú interactivo que permite al usuario crear listas, probar las operaciones y ver los resultados en pantalla, con validaciones para asegurarse de que los datos ingresados sean correctos.

---

## Ejercicio 4: Sistema de Gestión de Profesores

Este ejercicio simula el control de los datos de los profesores de un departamento de Informática. Permite agregar profesores, mostrar los instructores próximos a cambio de categoría, mostrar la lista de profesores ordenada por edad de mayor a menor y contar la cantidad de profesores por categoría docente.

La particularidad de este ejercicio es que se implementó una lista enlazada desde cero para almacenar los profesores, y se utilizó el algoritmo **Merge Sort** para ordenarlos por edad. Esto obliga a pensar en cómo se dividen y fusionan los nodos de una lista enlazada, en lugar de simplemente llamar a un método de ordenamiento ya existente.

Además, el sistema incluye validaciones para asegurarse de que los datos ingresados (nombre, edad y categoría docente) cumplan con un formato correcto, y una serie de pruebas que comprueban que el programa responde bien tanto a los casos exitosos como a los errores.

---

## Ejercicio 5: Sistema de Gestión de Estudiantes

Este ejercicio simula el control de los datos de los estudiantes de una carrera de Informática. Permite agregar estudiantes, mostrar los que cumplen años en un mes determinado, mostrar los militantes de la UJC ordenados por año y contar la cantidad de estudiantes becados.

La particularidad de este ejercicio es que el **mes de nacimiento se extrae del Carné de Identidad (CI)** del estudiante, ya que el CI cubano contiene la fecha de nacimiento en sus primeros seis dígitos (año, mes y día). Esto obliga a pensar en cómo validar y extraer información de un identificador único, en lugar de pedirla directamente al usuario.

Además, el sistema utiliza Merge Sort para ordenar a los militantes por año, incluye validaciones para asegurarse de que el CI sea correcto (11 dígitos, mes y día válidos según el año bisiesto) y una serie de pruebas que comprueban que el programa responde bien tanto a los casos exitosos como a los errores.

---

## ¿Cuál fue el objetivo de estos ejercicios?

El objetivo principal fue **entender cómo funcionan las estructuras de datos dinámicas por dentro**, implementándolas desde cero. En lugar de usar las clases ya hechas de Java, se construyeron versiones propias para:

- Comprender cómo se guardan los datos en memoria.
- Entender cómo se recorren, insertan y eliminan elementos.
- Ver por qué unas estructuras son más eficientes que otras según el caso.
- Aprender a manejar validaciones, errores y casos límite.

Además, se buscó que cada ejercicio resolviera un **problema real y útil**, para que el aprendizaje no se quedara en lo teórico, sino que se aplicara a situaciones concretas.

---

## ¿Qué comparten los cinco ejercicios?

Aunque los contextos son distintos (una biblioteca, un gestor de tareas, operaciones con listas, una gestión de profesores y una gestión de estudiantes), los cinco ejercicios comparten varios elementos:

- **Implementación propia** de una estructura de datos dinámica.
- **Uso de interfaces** para definir contratos claros.
- **Validaciones** para asegurarse de que los datos sean correctos.
- **Pruebas positivas y negativas** para comprobar el comportamiento del sistema.
- **Organización por clases**, cada una con una responsabilidad específica.

Esto demuestra que, más allá del problema concreto, hay **patrones y principios** que se repiten una y otra vez en programación.

---

## Estructura del repositorio

```
Ejercicios-Estructura-de-Datos/
├── Sist Gestión de Biblioteca/
│   ├── src
│   │   ├── Main.java
│   │   ├── GestionBiblioteca.java
│   │   ├── Libro.java
│   │   ├── LinkedList.java
│   │   ├── Nodo.java
│   │   └── List.java
│   └── README.md
│
├── Sist Gestión de Tareas/
│   ├── src
│   │   ├── Main.java
│   │   ├── GestorTareas.java
│   │   ├── Tarea.java
│   │   ├── Prioridad.java
│   │   ├── ArrayList.java
│   │   └── List.java
│   └── README.md
│
└── Operaciones con Listas Enlazadas CP2/
│   ├── src
│   │   ├── Main.java
│   │   ├── LinkedList.java
│   │   ├── Nodo.java
│   │   └── List.java
│   └── README.md
│
└── Listado de Profesores/
│   ├── src
│   │   ├── Main.java
│   │   ├── GestorProfesores.java
│   │   ├── Profesor.java
│   │   ├── LinkedList.java
│   │   ├── Nodo.java
│   │   └── List.java
│   └── README.md
│
└── Listado de Estudiantes/
    ├── src
    │  ├── Main.java
    │  ├── GestorEstudiante.java
    │  ├── Estudiante.java
    │  ├── LinkedList.java
    │  ├── Nodo.java
    │  └── List.java
    └── README.md

```

Cada carpeta contiene su propio README con la explicación detallada del ejercicio correspondiente.
