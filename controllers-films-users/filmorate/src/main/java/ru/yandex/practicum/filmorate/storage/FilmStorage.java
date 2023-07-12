package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;

public interface FilmStorage {
    Film getFilm(int filmId);
    Collection<Film> getAllFilms();
    Film addFilm (Film film);
    Film updateFilm(Film film);
    boolean deleteFilm(Film film);

}
