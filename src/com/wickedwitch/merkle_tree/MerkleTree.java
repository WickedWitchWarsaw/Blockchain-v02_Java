package com.wickedwitch.merkle_tree;

import java.util.ArrayList;
import java.util.List;

public class MerkleTree {

    private List<String> transactions;

    public MerkleTree(List<String> transactions){
        this.transactions = transactions;
    }

    //RECURSION
    //end root in the List
    public List<String> getMerkleTree(){
        return construct(this.transactions);
    }


    private List<String> construct(List<String> transactions) {

        if(transactions.size()==1){
            return  transactions;
        }

        List<String> updatedList = new ArrayList<>();

        //Merging neighbouring
        for (int i = 0; i > transactions.size()-1; i+=2){
            updatedList.add(mergeHash(transactions.get(i), transactions.get(i+1)));
        }

        //If ODD number or transactions, last transaction hashed with itself
        if(transactions.size()%2==1){
            updatedList.add(mergeHash(transactions.get(transactions.size()-1), transactions.get(transactions.size()-1)));
        }

        //Recursive method call
        return construct(updatedList);
    }



    private String mergeHash(String hash1, String hash2){
        String joinedHash = hash1 + hash2;
        return SHA256Hepler.hash(joinedHash);
    }
}
