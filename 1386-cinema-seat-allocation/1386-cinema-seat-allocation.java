class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // rows are empty we need to skip add count 2 for those rows.
       int group1 = 0b0000111100;
       int group2 = 0b0011110000;
       int group3 = 0b1111000000;
        Map<Integer,Integer> reservedSeatMap = new HashMap<>();

        //adding seats in map 
        for(int blockedSeat[] : reservedSeats)
        {   
            int row =blockedSeat[0];
            int seat=blockedSeat[1];
            reservedSeatMap.put(row, reservedSeatMap.getOrDefault(row,0) | (1<<seat));
        }
        //rows that have no reserved seat .
        int count = 2*(n - reservedSeatMap.size());

        for(Map.Entry<Integer, Integer> entry : reservedSeatMap.entrySet() )
        {
            int row = entry.getKey();
            int bitmask = entry.getValue();

            boolean left = (bitmask & group1) ==0 ;
            boolean middle = (bitmask & group2) ==0 ;
            boolean right = (bitmask & group3) ==0 ;

            if( left && right) count+=2;
            else if( left || middle || right) count+=1;
            else count+=0;

        }
        return count;
    }

}