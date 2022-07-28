public class ProductRepository {
    private Product[] products = new Product[0];

    // метод предназначенный для поиска товара по его id
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    // метод добавления c проверкой по ID
    public void save(Product product) {
        if (findById(product.id) != product) {
            Product[] tmp = new Product[products.length + 1];
            for (int i = 0; i < products.length; i++) {
                tmp[i] = products[i];
            }
            tmp[tmp.length - 1] = product;
            products = tmp;
        } else {
            throw new AlreadyExistsException(
                    "Element with id: " + product.id + " уже есть"
            );
        }
    }


//    // метод добавления
//    public void save(Product product) {
//        Product[] tmp = new Product[products.length + 1];  // создаем временный массив на 1 больше прежнего
//
//        for (int i = 0; i < products.length; i++) {
//            tmp[i] = products[i];
//        }
//        tmp[tmp.length - 1] = product;
//        products = tmp;
//    }


    // метод удаления
    public void removeById(int id) {
        if (findById(id) != null) {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;  // обновляем products
        } else {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
    }

//    // метод удаления без провеверки на наличие такого id
//    public void removeById(int id) {
//        Product[] tmp = new Product[products.length - 1];  // создаем временный массив на 1 меньше прежнего
//        int copyToIndex = 0; // заводим переменную которая будет записывать индекс элемента в массиве
//        for (Product product : products) {
//            if (product.getId() != id) {  // если id продукта не равен id которое хотим удалить, то копирум в tmp
//                tmp[copyToIndex] = product;
//                copyToIndex++;
//            }
//        }
//        products = tmp;  // обновляем products
//    }

    // метод вывода всего массива
    public Product[] getProduct() {
        return products;  // возвращаем массив
    }
}