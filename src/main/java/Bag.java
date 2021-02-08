import java.util.ArrayList;

public class Bag<T> {
    ArrayList<T> items;

    public Bag() {}

    public Bag(ArrayList<T> items) {
        this.items = items;
    }

    public void addItem(T t) {
        this.items.add(t);
    }

    public void removeItem(T t) {
        this.items.remove(t);
    }

    public void clearItems() {
        this.items.clear();
    }
}
