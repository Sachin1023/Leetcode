class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String word : strs) 
        {
            // int count[]  = new int [26]; // 26 lower case alphabets;
            // for(char c : word.toCharArray())
            // {
            //     count[ c-'a']++;
            // }
            char[] c=word.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            // map.computeIfAbsent(1, k -> new ArrayList<>()).add("Hello");

            // map.putIfAbsent(count, new ArrayList<>());
            // map.get(count).add(word);
        }
        // ans.addAll(map.values());
        // return ans;
        return new ArrayList<>(map.values());
    }
}