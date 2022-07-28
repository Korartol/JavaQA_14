import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();  // создаем репозиторий
    ProductManager manager =  new ProductManager(repo);  // создаем менеджера


    // добавленые продукты
    Product product1 = new Book(1, "bookk", 100, "title1", "author1");
    Product product2 = new Book(2,"book2", 200, "title2", "author2");
    Product product3 = new Book(3, "bookk", 300, "title3", "author4");
    Product product4 = new Book(4, "book4", 400, "title4", "author4");
    Product product5 = new Smartphone(5, "smartphone1", 500, "pro max", "apple");

    @BeforeEach  // чтобы метод ниже выполнялся перед каждым тестом
    public void setup() {

        // добавляем продукт в менеджер
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test
    public void shouldAllProduct() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = manager.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchProductYes() {

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("book4");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductYes2() {

        Product[] expected = {product1, product3};
        Product[] actual = manager.searchBy("bookk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductNo() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("book44");

        Assertions.assertArrayEquals(expected, actual);
    }
}