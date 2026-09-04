class Solution {
    public String[] largestString(int[] nums) {
        int n= nums.length;
        String [] res= new String[n];

        for(int i=0;i<n;i++)
        {
            String temp = transform(nums[i]);
            res[i]=temp;
        }
        return res;
    }

    public String transform(int x)
    {
        StringBuilder sb = new StringBuilder();

        // Check powers of 2 from high to low (up to 2^25 for 'z')
        for (int j = 25; j >= 0; j--) {
            int power = 1 << j; // 2^j
            if (x >= power) {
                int count = x / power; // how many times this letter appears
                for (int k = 0; k < count; k++) {
                    sb.append((char)('a' + j));
                }
                x %= power; // reduce x
            }
        }
        return sb.toString();
    }

}