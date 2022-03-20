package application.blockchain.model;


public class TransactionDTO {
    private int id;
    private Long timestamp;
    private int accountNumber;
    private double amount;

    public TransactionDTO(int id, Long timestamp, int accountNumber, double amount){
        super();
        this.id = id;
        this.timestamp = timestamp;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                '}';
    }
}
