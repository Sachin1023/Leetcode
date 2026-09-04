class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
       
        Map<String,List<String>> map = new HashMap<>();

        for(String word : strs) 
        {
            int count[]  = new int [26]; // 26 lower case alphabets;
            for(char c : word.toCharArray())
            {
                int ind = c-'a';
                count[ind]++;
            }
             String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        ans.addAll(map.values());
        return ans;
    }
    // for( String s : strs)
    //     {   
    //         int [] count = new int [26];

    //         for(char c : s.toCharArray())
    //         {
    //             count[c - 'a']++;
    //         }

    //         String key = Arrays.toString(count);

    //         map.putIfAbsent(key, new ArrayList<>());
    //         map.get(key).add(s);
        
    //     }
    //     return new ArrayList<>(map.values());
    
}