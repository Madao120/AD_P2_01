package org.example;

import java.sql.Date;

// Es el punto de entrada del programa y ejecuta el CRUD en orden.
public class Main {

    public static void main(String[] args) {

        // Creamos el objeto que permite realizar las operaciones CRUD.
        AnimeDAO dao = new AnimeDAO();

        // Creamos el anime que vamos a insertar.
        Anime anime = new Anime(
                "Naruto",
                "Un ninja que quiere convertirse en Hokage",
                Date.valueOf("2002-10-03"),
                90
        );

        // 1. INSERT
        dao.insertar(anime);

        // 2. READ - todos
        dao.listarTodos();

        // 3. UPDATE
        dao.actualizar("Naruto", 99);

        // 4. READ - actualizado
        dao.buscarPorNome("Naruto");

        // 5. DELETE
        dao.eliminar("Naruto");

        // 6. READ - todos
        dao.listarTodos();
    }
}
