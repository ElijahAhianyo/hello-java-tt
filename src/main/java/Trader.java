public class Trader {
    private String name;
    private Account account;

    Trader() {
        this.name = "Anonymous Trader - " + (int)(Math.random() * 100) + 1;
        this.account = new Account();
    }

    Trader(String name) {
        this.name = name;
        this.account = new Account();
    }

    public void addTrade(Trade t) {
        this.account.setValue(this.account.getValue() + t.getWorth());
    }

    public double getAccountValue() {
        return this.account.getValue();
    }
}
