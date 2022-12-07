import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.MovieManager;
import ru.netology.Movie;
import ru.netology.MovieRepository;

import static org.mockito.Mockito.*;

public class MovieAndManagerTest {
    Movie film1 = new Movie(1, 10, "Бладшот", "боевик", 225);
    Movie film2 = new Movie(2, 22, "Вперёд", "мультфильм", 199);
    Movie film3 = new Movie(3, 64, "Отель 'Белград'", "комедия", 249);
    Movie film4 = new Movie(4, 77, "Джентельмены", "боевик", 219);
    Movie film5 = new Movie(5, 175, "Человек-невидимка", "ужасы", 249);
    Movie film6 = new Movie(6, 41, "Тролли. Мировой тур", "мультфильм", 299);
    Movie film7 = new Movie(7, 93, "Номер один", "комедия", 220);

    @Test
    public void findLast7() {
        MovieRepository ser = new MovieRepository(7);
        MovieManager manager = new MovieManager(ser);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);

        Movie[] expected = {film7, film6, film5, film4, film3, film2, film1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLast7Mockito() {
        MovieRepository ser = Mockito.mock(MovieRepository.class);
        MovieManager manager = new MovieManager(ser);

        Movie[] films = {};
        doReturn(films).when(ser).removeAll();

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);

        Movie[] expected = {};
        Movie[] actual = manager.removeManager();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        MovieRepository ser = new MovieRepository(6);
        MovieManager manager = new MovieManager(ser);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);
        manager.removeManager(film7.getId());

        Movie[] expected = {film6, film5, film4, film3, film2, film1};
        Movie[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findId() {
        MovieRepository ser = new MovieRepository();
        MovieManager manager = new MovieManager(ser);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);

        Movie[] expected = {film7};
        Movie[] actual = manager.findManager(film7.getId());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAll() {
        MovieRepository ser = new MovieRepository();
        MovieManager manager = new MovieManager(ser);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);

        Movie[] expected = {};
        Movie[] actual = manager.removeManager();

        Assertions.assertArrayEquals(expected, actual);
    }

}
