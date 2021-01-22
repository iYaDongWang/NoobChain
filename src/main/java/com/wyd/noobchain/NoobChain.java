package com.wyd.noobchain;

import com.google.gson.GsonBuilder;
import com.wyd.noobchain.entity.Block;
import java.util.ArrayList;


/**
 * @author 王亚东
 * @date 2021/1/21 14:25
 */
public class NoobChain {
    public static ArrayList<Block> blockChain = new ArrayList<>();
    public static int difficulty = 5;

    public static void main(String[] args) {
        blockChain.add(new Block("Hi im the first Block","0" ));
        System.out.println("Tring to mine block 1 ...");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("Yo im the second block", blockChain.get(blockChain.size()-1).getHash()));
        System.out.println("Tring to mine block 2 ...");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("Yo im the third block", blockChain.get(blockChain.size()-1).getHash()));
        System.out.println("Tring to mine block 3 ...");
        blockChain.get(2).mineBlock(difficulty);

        System.out.println("BlockChain is valid : " + isValidChain());

        String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println("The Block Chain is :");
        System.out.println(blockChainJson);
    }

    public static boolean isValidChain() {
        Block currentBlock;
        Block previousBlock;
        String targetHash = new String(new char[difficulty]).replace("\0", "0");
        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current block is invalid");
                return false;
            }
            if (!previousBlock.getHash().equals(previousBlock.calculateHash())) {
                System.out.println("Previous block is invalid");
                return false;
            }
            if (!targetHash.equals(currentBlock.getHash().substring(0, difficulty))) {
                System.out.println("This block has not bean mined.");
                return false;
            }
        }
        return true;
    }
}
