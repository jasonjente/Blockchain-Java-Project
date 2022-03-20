package application.blockchain.service;

import application.blockchain.exceptions.BlockException;
import application.blockchain.jpo.dao.BlockDAO;
import application.blockchain.jpo.dao.TransactionDAO;
import application.blockchain.jpo.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public class BlockService {

    @Autowired
    private BlockDAO blockDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    public Block findBlockByBlockId(Long id) throws BlockException {
        Optional<Block> ret = blockDAO.findById(id);
        if(ret.isPresent()) {
            return ret.get();
        }else {
            String errorMessage = "Non-valid block id: "+id;
            throw new BlockException(errorMessage);
        }
    }

    public Block createBlock(Block block) throws BlockException {
        StringBuilder errorMessage = new StringBuilder();
        if(block.getPrevHash().isEmpty()){
            errorMessage.append("Previous Hash is empty.");
            //todo: find the previous hash of the block
//            throw new BlockValidationException(errorMessage);
        }

        if(block.getCurrentHash().isEmpty()){
            errorMessage.append("Current Hash is empty");
            //Todo Calculate new hash
//            throw new BlockValidationException(errorMessage);
        }

        if(block.getBlockTransactions().isEmpty()) {
            errorMessage.append("Transactions are empty");
            throw new BlockException(errorMessage.toString());
        }

        blockDAO.save(block);
        return block;
    }



}
