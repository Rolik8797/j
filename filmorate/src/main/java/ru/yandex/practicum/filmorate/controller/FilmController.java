package ru.yandex.practicum.filmorate.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/films")
@AllArgsConstructor

public class FilmController {
    private final FilmService filmService;

    @GetMapping
    public List<Film> getFilms() {
        List<Film> filmList = new ArrayList<>(filmService.getAllFilms().values());
        log.debug("Количество фильмов: {}", filmList.size());
        return filmList;
    }

    @PostMapping
    public Film createFilm(@Valid @RequestBody Film film) {
        if (filmService.getAllFilms().containsKey(film.getId())) {
            throw new RuntimeException("Фильм уже есть в базе");
        }
        filmService.validateReleaseDate(film, "Добавлен");
        return filmService.createFilm(film);
    }

    @PutMapping
    public Film updateFilm(@RequestBody Film film) {
        if (!filmService.getAllFilms().containsKey(film.getId())) {
            throw new RuntimeException("Фильма нет в базе");
        }
        filmService.validateReleaseDate(film, "Обновлен");
        return filmService.updateFilm(film);
    }
}
