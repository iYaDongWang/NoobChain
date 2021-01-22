package com.wyd.noobchain.entity;

import com.wyd.noobchain.utils.StringUtils;

/**
 * @author 王亚东
 * @date 2021/1/21 14:20
 */
public class Block {
    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return StringUtils.applySha256(
                previousHash +
                        Long.toString(timestamp) +
                        Integer.toString(nonce) +
                        data
        );
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace("\0","0" );
        while (!target.equals(hash.substring(0, difficulty))) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }
}
