public class Main {
    public static void main(String[] args) {
        GestionBiblioteca gestion = new GestionBiblioteca();

                System.out.println("\n--- PRUEBAS POSITIVAS --- ");

                System.out.println("\n1. Añadir libros válidos: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));
                gestion.anadirLibro(new Libro("9788492912345", "Arsène Lupin caballero ladrón", "Maurice Leblanc", "Aventura"));
                gestion.anadirLibro(new Libro("9780156012195", "El Principito", "Antoine de Saint Exupéry", "Infantil"));
                gestion.anadirLibro(new Libro("9786073812345", "Hija de humo y hueso", "Laini Taylor", "Romance"));

                System.out.println("\nVer catálogo");
                gestion.verCatalogo();

                System.out.println("\n3. Prestar libro disponible: ");
                gestion.prestarLibro("9788492912345");
                gestion.prestarLibro("9786073812345");
                System.out.println(" ");
                gestion.verCatalogo();

                System.out.println("\n5. Devolver libro prestado: ");
                gestion.devolverLibro("9788492912345");
                gestion.devolverLibro("9786073812345");
                System.out.println(" ");
                gestion.verCatalogo();

                System.out.println("\n6. Invertir catálogo: ");
                gestion.invertirCatalogo();
                System.out.println(" ");
                gestion.verCatalogo();

                System.out.println("\n8. Recomendar libro de género disponible: ");
                gestion.recomendarLibro("Misterio");

                System.out.println("\n--- PRUEBAS NEGATIVAS --- ");

                System.out.println("\nAñadir libro: ");

                System.out.println("1. Título vacío: ");
                gestion.anadirLibro(new Libro("978-062-73488", "", "Agatha Christie", "Misterio"));

                System.out.println("2. Título con números: ");
                gestion.anadirLibro(new Libro("9780062073488", "1984", "Agatha Christie", "Misterio"));

                System.out.println("3. Título null: ");
                gestion.anadirLibro(new Libro("9780062073488", null, "Agatha Christie", "Misterio"));

                System.out.println("4. Autor vacío: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "", "Misterio"));

                System.out.println("5. Autor con números: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha123", "Misterio"));

                System.out.println("6. Autor null: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", null, "Misterio"));

                System.out.println("7. Género vacío: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha Christie", ""));

                System.out.println("8. Género con números: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha Christie", "Misterio123"));

                System.out.println("9. Género null: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha Christie", null));

                System.out.println("10. ISBN vacío: ");
                gestion.anadirLibro(new Libro("", "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));

                System.out.println("11. ISBN con letras:");
                gestion.anadirLibro(new Libro("978006207348A", "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));

                System.out.println("12. ISBN null: ");
                gestion.anadirLibro(new Libro(null, "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));

                System.out.println("13. ISBN con longitud incorrecta: ");
                gestion.anadirLibro(new Libro("12345", "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));

                System.out.println("\nPrestar libro: ");

                System.out.println("1. Prestar con catálogo vacío:");
                gestion.clear();
                gestion.prestarLibro("9780062073488");

                System.out.println("2. Prestar ISBN no existente: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));
                gestion.prestarLibro("0000000000000");

                System.out.println("3. Prestar libro ya prestado: ");
                gestion.prestarLibro("9780062073488");
                gestion.prestarLibro("9780062073488");

                System.out.println("4. Prestar con ISBN null: ");
                gestion.prestarLibro(null);

                System.out.println("\nDevolver Libro: ");

                System.out.println("1. Devolver con catálogo vacío: ");
                gestion.clear();
                gestion.devolverLibro("9780062073488");

                System.out.println("2. Devolver ISBN no existente: ");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));
                gestion.devolverLibro("0000000000000");

                System.out.println("3. Devolver libro ya disponible: ");
                gestion.devolverLibro("9780062073488");

                System.out.println("4. Devolver con ISBN null: ");
                gestion.devolverLibro(null);

                System.out.println("\nVer catálogo: ");
                System.out.println("1. Vacío:");
                gestion.clear();
                gestion.verCatalogo();

                System.out.println("\nÍnvertir catálogo: ");

                System.out.println("1. Vacío: ");
                gestion.invertirCatalogo();

                System.out.println("\nRecomndar libro: ");

                System.out.println("1. Recomendar con catálogo vacío: ");
                gestion.clear();
                gestion.recomendarLibro("Misterio");

                System.out.println("2. Recomendar con género null:");
                gestion.anadirLibro(new Libro("9780062073488", "Asesinato en el Orient Express", "Agatha Christie", "Misterio"));
                gestion.recomendarLibro(null);

                System.out.println("3. Recomendar con género vacío:");
                gestion.recomendarLibro("");

                System.out.println("4. Recomendar género no existente");
                gestion.recomendarLibro("Terror");

                System.out.println("5. Recomendar con todos prestados: ");
                gestion.prestarLibro("9780062073488");
                gestion.recomendarLibro("Misterio");


    }
}
