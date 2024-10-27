public class Component {
    String name;
    double quantity;
    double price;

    public Component(String name, double quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Component{" +
               "name='" + name + '\'' +
               ", quantity=" + quantity +
               ", price=" + price +
               '}';
    }
}
