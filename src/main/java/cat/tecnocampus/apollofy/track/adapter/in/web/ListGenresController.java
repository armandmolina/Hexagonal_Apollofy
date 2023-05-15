package cat.tecnocampus.apollofy.track.adapter.in.web;


import cat.tecnocampus.apollofy.track.application.port.in.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListGenresController {
        private final ListGenres listGenres;

        ListGenresController (ListGenres listGenres) {
            this.listGenres = listGenres;
        }

        @GetMapping("/genres")  //OK
        public List<GenreListing> getAllGenres() {
            return listGenres.getAllGenres();
        }

        @GetMapping("/genres/{id}") //OK
        public GenreListing getGenresById(@PathVariable Long id) {
            return listGenres.getGenreById(id);
        }

        @DeleteMapping("/genres/{id}")  //OK
        public void deleteGenre(@PathVariable Long id) {
            listGenres.deleteGenre(id);
        }

        @GetMapping("/top/genres")  //OK
        List<PopularGenreListing> getTopGenres(@RequestParam(defaultValue = "5") int size) {
            return listGenres.getTopGenresAsInTracks(size);
        }




}
