package com.wickedwitch.blockchain;

public class Miner {

    private double minerReward;

    public void mine(Block block, Blockchain blockchain){

        while (notGoldenHash(block)){
            block.generateHash();
            block.incrementNonce();
        }

        System.out.println("Block mined: " + block);
        System.out.println("Hash: " + block.getHash());

        blockchain.addBlock(block);
        minerReward += Constants.MINER_REWARD;

    }



    public boolean notGoldenHash(Block block){
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
        return !block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
    }

    public double getReward(){
        return minerReward;
    }

}
