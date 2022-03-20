package application.blockchain.jpo.model;

import application.blockchain.model.TransactionDTO;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Map;

@Entity(name="Account")
@SequenceGenerator(name = "ACCOUNT_SEQ_GEN", sequenceName = "ACCOUNT_SEQ", initialValue = 1, allocationSize = 10)
@Table(name="ACCOUNT")
public class Account {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ACCOUNT_ID")
    @Id
    Long accountId;

    @Column(name = "FUNDS")
    BigInteger funds;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigInteger getFunds() {
        return funds;
    }

    public void setFunds(BigInteger funds) {
        this.funds = funds;
    }
}
