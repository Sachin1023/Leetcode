class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // rows are empty we need to skip add count 2 for those rows.
       
        Map<Integer,Set<Integer>> reservedSeatMap = new HashMap<>();

        //adding seats in map 
        for(int blockedSeat[] : reservedSeats)
        {   
            int row =blockedSeat[0];
            int seat=blockedSeat[1];
            reservedSeatMap.computeIfAbsent(row, key -> new HashSet<>()).add(seat);
        }
        //rows that have no reserved seat .
        int count = 2*(n - reservedSeatMap.size());

        for(Map.Entry<Integer, Set<Integer>> entry : reservedSeatMap.entrySet() )
        {
            int row = entry.getKey();
            Set<Integer> set = entry.getValue();
            boolean left = !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5) ;
            boolean middle=!set.contains(6) && !set.contains(7) && !set.contains(4) && !set.contains(5) ;
            boolean right =!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9);

            if( left && right) count+=2;
            else if( left || middle || right) count+=1;
            else count+=0;

        }
        return count;
    }

}