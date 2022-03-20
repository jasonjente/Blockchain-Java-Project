package application.blockchain.jpo.dataservice;

import application.blockchain.jpo.model.Block;
import application.blockchain.model.BlockDTO;

import java.util.List;

public interface DataService {
    List<Block> retrieveAllBlocks();
    Block findBlockById();
    Block createBlock(Block block);
    Block createBlockFromDTO(BlockDTO blockDTO);
}
