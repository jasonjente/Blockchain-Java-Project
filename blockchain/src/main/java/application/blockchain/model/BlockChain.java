package application.blockchain.model;

import application.blockchain.utils.BlockChainUtils;

import java.util.LinkedList;

public class BlockChain {

    private LinkedList<BlockDTO> blocks;

    public BlockChain(){
        blocks = new LinkedList<>();
    }

    public void addBlock(BlockDTO block) throws BlockValidationException{
        String lastHash = "0";
        if(blocks.size()>0){
            lastHash = blocks.getLast().getHash();
        }
        //todo: check if last hash can ever be null
        if(!lastHash.equals(block.getPreviousHash())){
            String errorMessage = "NON-MATCHING HASHES";
            System.out.println(errorMessage);
            throw new BlockValidationException(errorMessage);
        }
        if(! BlockChainUtils.validateBlock(block)){
            String errorMessage = "NOT ABLE TO VALIDATE";
            System.out.println(errorMessage);
            throw new BlockValidationException(errorMessage);
        }

        blocks.add(block);

    }
    public String getLastHash() {
        if (blocks.size() > 0)
            return blocks.getLast().getHash();
        return "0";
    }
    public void printAndValidate() {
        String lastHash = "0";
        for (BlockDTO block : blocks) {
            System.out.println("application.blockchain.model.Block with trans starting at " + block.getFirstId() + " ");
            System.out.println(block.getTransactions());
            System.out.println("Hash " + block.getHash());
            System.out.println("Lash Hash " + block.getPreviousHash());

            if (block.getPreviousHash().equals(lastHash)) {
                System.out.print("Last hash matches ");
            } else {
                System.out.print("Last hash doesn't match ");
            }
            try {
                if (BlockChainUtils.validateBlock(block)) {
                    System.out.println("and hash is valid");
                }
            }catch (BlockValidationException exception){

            }finally {
                System.out.println("and hash is invalid");
            }
            lastHash = block.getHash();

        }
    }
    public int getSize() {
        return blocks.size();
    }
}
