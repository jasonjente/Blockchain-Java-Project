package application.blockchain.utils;

import application.blockchain.model.BlockDTO;
import application.blockchain.model.BlockValidationException;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BlockChainUtils {

    public static String calculateHash(String data) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] rawHash = digest.digest(data.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < rawHash.length; i++) {
                String hex = Integer.toHexString(0xff & rawHash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return "0";
        }
    }

    public static boolean validateBlock(BlockDTO block) throws BlockValidationException {
        if (block==null){
            throw new BlockValidationException("NULL BLOCK");
        }
        String dataToEncode = block.getPreviousHash() + block.getFirstTimestamp() +
                block.getNonce() + block.getTransactions();
        String checkHash = calculateHash(dataToEncode);
        return (checkHash.equals(block.getHash()));
    }
}
