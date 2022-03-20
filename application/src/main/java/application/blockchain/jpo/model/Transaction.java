package application.blockchain.jpo.model;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACTION")
@SequenceGenerator(name = "TRANSACTION_SEQ_GEN", sequenceName = "TRANSACTION_SEQ", initialValue = 1, allocationSize = 10)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TRANSACTION_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "TIMESTAMP", updatable = false, nullable = false)
    private Long timestamp;

    @Column(name = "TRANSACTION_ACCOUNT_NUMBER", updatable = false, nullable = false)
    private Long accountNumber;

    @Column(name = "TRANSACTION_AMOUNT", updatable = false, nullable = false)
    private Double amount;

    @Column(name = "TRANSACTION_MESSAGE", updatable = false, nullable = false,length = 2048)
    private String message;

//    public Transaction toTransaction(){
//        return new Transaction(this.id.intValue(),this.timestamp, this.accountNumber.intValue(), this.amount.doubleValue());
//    }

    public Long getId() {
        return id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

