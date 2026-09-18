# Proyecto: Estructuras de Datos en Java – ArrayList y LinkedList

## ¿De qué trata este proyecto?

Este repositorio reúne **dos ejercicios prácticos** desarrollados en Java con un objetivo común: **comprender cómo funcionan internamente las estructuras de datos dinámicas**, implementándolas desde cero en lugar de usar las que ya vienen incluidas en el lenguaje.

Cada ejercicio resuelve un **problema real** (la gestión de una biblioteca y la gestión de tareas pendientes), pero lo importante no es solo el resultado final, sino el **camino recorrido**: entender cómo se guardan, ordenan, buscan y modifican los datos por dentro.

Los dos ejercicios son independientes entre sí, pero comparten el mismo objetivo.

---

## Ejercicio 1: Sistema de Gestión de Biblioteca

Este ejercicio simula el funcionamiento básico de una biblioteca. Permite **agregar libros, prestarlos, devolverlos, ver el catálogo completo, recomendar un libro por género e invertir el orden del catálogo**.

La particularidad de este ejercicio es que **no se usó `ArrayList` ni `LinkedList` de Java**, sino que se implementó una **lista enlazada desde cero** (con nodos que se apuntan entre sí). Esto obliga a pensar en cómo se conectan los elementos y cómo se recorre la estructura, en lugar de simplemente llamar a métodos ya existentes.

Además, el sistema incluye validaciones para asegurarse de que los datos ingresados (título, autor, género e ISBN) cumplan con un formato correcto, y una serie de pruebas que comprueban que el programa responde bien tanto a los casos exitosos como a los errores.

---

## Ejercicio 2: Sistema de Gestión de Tareas Pendientes

Este ejercicio simula un **gestor de tareas**, como los que usamos en el día a día. Permite **agregar tareas con prioridad (alta, media, baja), verlas, contarlas por prioridad, priorizar las urgentes y completarlas en orden**.

La particularidad de este ejercicio es que **no se usó `ArrayList` de Java**, sino que se implementó una **lista basada en un arreglo que se expande automáticamente** cuando se llena. Esto permite entender cómo funcionan las listas dinámicas por dentro: cómo crecen, cómo se desplazan los elementos y cómo se gestiona la memoria.

Además, el sistema usa un **`enum` para las prioridades**, lo que garantiza que solo se puedan usar valores válidos (`ALTA`, `MEDIA` o `BAJA`), y también incluye validaciones y una batería de pruebas que cubren casos exitosos y errores.

---

## ¿Cuál fue el objetivo de estos ejercicios?

El objetivo principal fue **entender cómo funcionan las estructuras de datos dinámicas por dentro**, implementándolas desde cero. En lugar de usar las clases ya hechas de Java, se construyeron versiones propias para:

- Comprender cómo se guardan los datos en memoria.
- Entender cómo se recorren, insertan y eliminan elementos.
- Ver por qué unas estructuras son más eficientes que otras según el caso.
- Aprender a manejar validaciones, errores y casos límite.

Además, se buscó que cada ejercicio resolviera un **problema real y útil**, para que el aprendizaje no se quedara en lo teórico, sino que se aplicara a situaciones concretas.

---

## ¿Qué comparten los dos ejercicios?

Aunque los contextos son distintos (una biblioteca y un gestor de tareas), ambos ejercicios comparten varios elementos:

- **Implementación propia** de una estructura de datos dinámica.
- **Uso de interfaces** para definir contratos claros.
- **Validaciones** para asegurarse de que los datos sean correctos.
- **Pruebas positivas y negativas** para comprobar el comportamiento del sistema.
- **Organización por clases**, cada una con una responsabilidad específica.

Esto demuestra que, más allá del problema concreto, hay **patrones y principios** que se repiten una y otra vez en programación.

---

## 📂 Estructura del repositorio

```
📁 Ejercicios-Estructura-de-Datos/
├── 📁 Sist Gestón de Biblioteca/
|   ├── src
│   |  ├── Main.java
│   |  ├── GestionBiblioteca.java
│   |  ├── Libro.java
│   |  ├── LinkedList.java
│   |  ├── Nodo.java
│   |  └── List.java
|   └── README.md
│
└── 📁 Sist Gestión de Tareas/
    ├── src
    |  ├── Main.java
    |  ├── GestorTareas.java
    |  ├── Tarea.java
    |  ├── Prioridad.java
    |  ├── ArrayList.java
    |  └── List.java
    └── README.md
```

Cada carpeta contiene su propio README con la explicación detallada del ejercicio correspondiente.
