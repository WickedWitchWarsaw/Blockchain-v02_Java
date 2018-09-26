package com.wickedwitch.blockchain;

public class Main {

    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();
        Miner miner = new Miner();


        Block block0 = new Block(0, Constants.GENESIS_BLOCK_HASH, "Hash001");
        miner.mine(block0, blockchain);

        Block block1 = new Block(1, block0.getHash(), "Block 002");
        miner.mine(block1, blockchain);

        Block block2 = new Block(2, blockchain.getBlockchain().get(blockchain.blockchainSize()-1).getHash(), "Hello World Blockchain!!");
        miner.mine(block2, blockchain);

        System.out.println("\n" +
                        "BLOCKCHAIN: \n" + blockchain

        );

        System.out.println();
        System.out.println("MINERS REWARD: " + miner.getReward());


    }

}
