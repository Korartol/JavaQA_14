public class Smartphone extends Product {
    private String title;
    private String manufacturer;

    public Smartphone(int id, String name, int price, String title, String manufacturer) {
        super(id, name, price);
        this.title = title;
        this.manufacturer = manufacturer;
    }
}