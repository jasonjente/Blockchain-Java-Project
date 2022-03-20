package application.blockchain.model;

import java.util.ArrayList;
import java.util.List;

public class BlockDTO {
    private String previousHash;
    private List<TransactionDTO> transactionDTOS;
    private int nonce;
    private String hash;

    public BlockDTO(String previousHash, List<TransactionDTO> transactionDTOS){
        this.previousHash = previousHash;
        this.transactionDTOS = transactionDTOS;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getTransactions() {
        return transactionDTOS.toString();
    }

    public void setTransactions(List<TransactionDTO> transactionDTOS) {
        this.transactionDTOS = transactionDTOS;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    public Long getFirstTimestamp() {
        return transactionDTOS.get(0).getTimestamp();
    }

    public Long getLastTimestamp() {
        return transactionDTOS.get(transactionDTOS.size()-1).getTimestamp();
    }

    public Integer getFirstId() {
        return transactionDTOS.get(0).getId();
    }

    public TransactionDTO getFirstTransaction() {
        return transactionDTOS.get(0);
    }

    public void addTransactionToList(TransactionDTO transactionDTO) {
        if (this.hash != null) throw new RuntimeException("Cannot add a transaction to a mined block");
        transactionDTOS.add(transactionDTO);
    }

    public List<TransactionDTO> extractTransactions() {
        return new ArrayList<>(this.transactionDTOS);
    }

    public String transactionIds() {
        StringBuilder sb = new StringBuilder();
        for (TransactionDTO t : transactionDTOS) {
            sb.append(t.getId() + " ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Block{" +
                "previousHash='" + previousHash + '\'' +
                ", transactions=" + transactionDTOS +
                ", nonce=" + nonce +
                ", hash='" + hash + '\'' +
                '}';
    }
}
