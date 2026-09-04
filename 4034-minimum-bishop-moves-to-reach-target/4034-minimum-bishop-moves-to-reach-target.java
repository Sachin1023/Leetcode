class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        //need to find source is black for white 
        //check if target it black or white;

        int tr=target[0],tc=target[1];
        int sr=source[0], sc=source[1];      
        
        // // If row + col is even → white, else black
        // int s = ((source[0] + source[1]) % 2 == 0) ? 1 : 0;
        // int t = ((target[0] + target[1]) % 2 == 0) ? 1 : 0;
        if((sr+sc) % 2  != (tr+tc) %2) return -1;

        //right  \  diagonal are r+c 
        //left / diagonals are r-c
        if (Math.abs(sr-tr) == Math.abs(sc-tc) ) return 1; // they are on same diagonal
        return 2; //it can reach on any other block on 2 steps.
    }
}