package application.blockchain.resource.rest;

import application.blockchain.jpo.dao.BlockDAO;
import application.blockchain.jpo.dao.TransactionDAO;
import application.blockchain.jpo.dataservice.DataService;
import application.blockchain.jpo.model.Block;
import application.blockchain.jpo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RestController
@RequestMapping(path = "/blockchain")
public class BlockChainResource {

    private BlockDAO blockDAO;
    private TransactionDAO transactionDAO;
    private DataService dataService;

    @GetMapping(path = "/ping")
    public String getStatus(){
        return "STATUS: OK";
    }

    @GetMapping(path = "/populateBlock")
    public String populateBlocks(){
        Block block = new Block();

        return"OK";
    }

    @GetMapping(path = "/populateTransactions")
    public String populateTransactions(){
        List<Transaction> transactionList = new ArrayList<>();

        for(Integer i =0; i< 10; i++){
            Transaction transaction = new Transaction();
            transaction.setAmount((double)i);
            transaction.setTimestamp(i.longValue());
            transaction.setMessage("Transaction " + i);
            transaction.setAccountNumber((long)i*10);
            transactionList.add(transaction);
        }

        transactionDAO.saveAll(transactionList);
        return "OK";
    }

    @GetMapping()
    public ResponseEntity<List<Transaction>> findAll(){
        return ResponseEntity.ok(transactionDAO.findAll());

    }

    @Autowired
    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Autowired
    public void setBlockDAO(BlockDAO blockDAO) {
        this.blockDAO = blockDAO;
    }
}
