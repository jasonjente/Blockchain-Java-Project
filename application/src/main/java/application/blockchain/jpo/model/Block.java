package application.blockchain.jpo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BLOCK")
@SequenceGenerator(name = "BLOCK_SEQ_GEN", sequenceName = "BLOCK_SEQ", initialValue = 1, allocationSize = 10)
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BLOCK_ID", nullable = false)
    private Long blockId;

    @Column(name = "BLOCK_CURRENT_HASH", unique = true, nullable = false, updatable = false)
    private String currentHash;

    @Column(name = "BLOCK_PREV_HASH", nullable = false, updatable = false)
    private String prevHash;

    @Column(name = "BLOCK_NONCE")
    private String nonce;

    @OneToMany()
    private Set<Transaction> blockTransactions = new HashSet<>();

    public String getCurrentHash() {
        return currentHash;
    }

    public void setCurrentHash(String currentHash) {
        this.currentHash = currentHash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public Set<Transaction> getBlockTransactions() {
        return blockTransactions;
    }

    public void setBlockTransactions(Set<Transaction> blockTransactions) {
        this.blockTransactions = blockTransactions;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getBlockId() {
        return blockId;
    }

}
