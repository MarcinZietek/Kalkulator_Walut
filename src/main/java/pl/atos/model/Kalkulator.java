package pl.atos.model;

public class Kalkulator {

    private static int nextId = 0;
    private int id;
    private String currency;
    private float rates;
    private float amount;

    public Kalkulator() {
    }

    public Kalkulator(String currency, float rates) {
        this.currency = currency;
        this.rates = rates;
    }

    public Kalkulator(String currency, float rates, float amount) {
        this.currency = currency;
        this.rates = rates;
        this.amount = amount;
    }

    public Kalkulator(int id, String currency, float rates) {
        this.id = id;
        this.currency = currency;
        this.rates = rates;
    }

    public Kalkulator(int id, String currency, float rates, float amount) {
        this.id = nextId;
        nextId++;
        this.currency = currency;
        this.rates = rates;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getRates() {
        return rates;
    }

    public void setRates(float rates) {
        this.rates = rates;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
