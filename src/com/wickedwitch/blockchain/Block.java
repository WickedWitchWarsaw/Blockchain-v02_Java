package com.wickedwitch.blockchain;

import java.util.Date;

public class Block {

    private int id;
    private int nonce;
    private Long timestamp;
    private String hash;
    private String previousHash;
    private String transaction;


    public Block(int id, String previousHash, String transaction) {
        this.id = id;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.timestamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = Integer.toString(id)+Integer.toString(nonce)+Long.toString(timestamp)+previousHash+transaction;
        String hashValue = SHA256Helper.generateHash(dataToHash);
        this.hash = hashValue;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }


    public void incrementNonce(){
        this.nonce++;
    }

    @Override
    public String toString() {
        return this.id+"-"+this.transaction+"-"+this.hash+"-"+this.previousHash;
    }
}
