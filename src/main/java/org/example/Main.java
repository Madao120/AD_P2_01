package org.example;

import java.sql.Date;

// Es el punto de entrada del programa y ejecuta el CRUD en orden.
public class Main {

    public static void main(String[] args) {

        // Creamos el objeto que permite realizar las operaciones CRUD.
        AnimeDAO dao = new AnimeDAO();

        // Creamos el anime que vamos a insertar.
        Anime anime = new Anime(
                "Kagurabachi",
                "Un espadachín recuperando las espadas forjadas por su padre",
                Date.valueOf("2027-12-04"),
                90
        );

        // 1. INSERT
        dao.insertar(anime);

        // 2. READ - todos
        dao.listarTodos();

        // 3. UPDATE
        dao.actualizar("Kagurabachi", 95);

        // 4. READ - actualizado
        dao.buscarPorNome("Kagurabachi");

        // 5. DELETE
        dao.eliminar("Kagurabachi");

        // 6. READ - todos
        dao.listarTodos();
    }
}
