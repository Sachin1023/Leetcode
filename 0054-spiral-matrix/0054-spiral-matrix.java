class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length-1;
        int m=matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        int startrow=0, startcol=0, endrow=n,endcol=m;
        while(startrow<=endrow && startcol<=endcol)
        {
            //move right 
            for(int k=startcol;k<=endcol;k++)
            {
                ans.add(matrix[startrow][k]);
            }
            startrow++; //1
            //move down 
            for(int k=startrow;k<=endrow;k++)
            {
                ans.add(matrix[k][endcol]);
            }
            endcol--; //1
            //move left
            if(startrow<=endrow) //impt
            {
                for(int k=endcol;k>=startcol;k--)
                {
                    ans.add(matrix[endrow][k]);
                }
                endrow--;//1
            }
            //move up
            if(startcol<=endcol)
            {
                for(int k=endrow;k>=startrow;k--)
                {
                    ans.add(matrix[k][startcol]);

                }
                startcol++; 
            }
        }   
        return ans;
    }
}