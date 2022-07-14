package pl.atos.model;

public class Kalkulator {

    private String currency;
    private float rates;

    public Kalkulator(String currency, float rates) {
        this.currency = currency;
        this.rates = rates;
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
}
