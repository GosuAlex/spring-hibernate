package no.rad.springdemo.entity;


public class Payment {

    private int id;

    private int amount;

    private String debtor;

    private String creditor;


    public Payment() {
    }

    public Payment(int id, int amount, String debtor, String creditor) {
        this.id = id;
        this.amount = amount;
        this.debtor = debtor;
        this.creditor = creditor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }
}
