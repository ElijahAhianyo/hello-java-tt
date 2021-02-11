public class Trade {
    private String id;
    private String symbol;
    private int quantity;
    private float price;

    Trade() {
    }

    Trade(String id, String symbol, int qty, float price) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = qty;
        this.price = price >= 0 ? price : 0;
    }

    Trade(String id, String symbol, int qty, MallonExchange mallonExchange) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = qty;
        this.price = (float) mallonExchange.getPrice(symbol, quantity);
    }

    public String toString() {
        return "Trade{id: " + this.id + ", Symbol: " + this.symbol + ", Qty: " + this.quantity + ", Price: " + this.price
                + "}";
    }

    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public double getWorth() {
        return this.price * this.quantity;
    }

}
