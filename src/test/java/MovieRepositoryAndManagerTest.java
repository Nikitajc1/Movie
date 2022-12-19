import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.MovieManager;
import ru.netology.MovieRepository;

public class MovieRepositoryAndManagerTest {

    MovieManager service = new MovieManager();

    MovieRepository film1 = new MovieRepository(1, 10, "Бладшот", "боевик", 225);
    MovieRepository film2 = new MovieRepository(2, 22, "Вперёд", "мультфильм", 199);
    MovieRepository film3 = new MovieRepository(3, 64, "Отель 'Белград'", "комедия", 249);
    MovieRepository film4 = new MovieRepository(4, 77, "Джентельмены", "боевик", 219);
    MovieRepository film5 = new MovieRepository(5, 175, "Человек-невидимка", "ужасы", 249);
    MovieRepository film6 = new MovieRepository(6, 41, "Тролли. Мировой тур", "мультфильм", 299);
    MovieRepository film7 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film8 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film9 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film10 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film11 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film12 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film13 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film14 = new MovieRepository(7, 93, "Номер один", "комедия", 220);
    MovieRepository film15 = new MovieRepository(6, 41, "Тролли. Мировой тур", "мультфильм", 299);

    @Test
    public void findAll() {

        service.addNew(film1);
        service.addNew(film2);
        service.addNew(film3);
        service.addNew(film4);
        service.addNew(film5);
        service.addNew(film6);
        service.addNew(film7);

        MovieRepository[] expected = {film1, film2, film3, film4, film5, film6, film7};
        MovieRepository[] actual = service.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLast7() {

        MovieManager manager = new MovieManager(7);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);

        MovieRepository[] expected = {film7, film6, film5, film4, film3, film2, film1};
        MovieRepository[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastDefault10() {

        service.addNew(film1);
        service.addNew(film2);
        service.addNew(film3);
        service.addNew(film4);
        service.addNew(film5);
        service.addNew(film6);
        service.addNew(film7);
        service.addNew(film8);
        service.addNew(film9);
        service.addNew(film10);

        MovieRepository[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        MovieRepository[] actual = service.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLast15() {

        MovieManager manager = new MovieManager(15);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);
        manager.addNew(film8);
        manager.addNew(film9);
        manager.addNew(film10);
        manager.addNew(film11);
        manager.addNew(film12);
        manager.addNew(film13);
        manager.addNew(film14);
        manager.addNew(film15);

        MovieRepository[] expected = {
                film15, film14, film13, film12, film11, film10, film9, film8, film7, film6, film5, film4, film3, film2, film1
        };
        MovieRepository[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLast7With10Limit() {

        MovieManager manager = new MovieManager(10);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);

        MovieRepository[] expected = {film7, film6, film5, film4, film3, film2, film1};
        MovieRepository[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLast7With5Limit() {

        MovieManager manager = new MovieManager(5);

        manager.addNew(film1);
        manager.addNew(film2);
        manager.addNew(film3);
        manager.addNew(film4);
        manager.addNew(film5);
        manager.addNew(film6);
        manager.addNew(film7);

        MovieRepository[] expected = {film7, film6, film5, film4, film3};
        MovieRepository[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
