public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] getProducts() {
        Product[] all = repo.getProduct();
        // если нужно выдавать первым последний добавленны элемент
//        Product[] reversed = new Product[all.length];
//        for (int i = 0; i < reversed.length; i++) {
//            reversed[i] = all[all.length - 1 - i];
//        }
//        return reversed;
        return all;
    }

    // МЕТОД ПОИСКА
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.getProduct()) {   // в ДЗ указано repository.findAll()
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                //  System.arraycopy(result, 0, tmp, 0, result.length);  //
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}