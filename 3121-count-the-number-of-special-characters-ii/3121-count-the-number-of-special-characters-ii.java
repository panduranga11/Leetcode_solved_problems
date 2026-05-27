class Solution {

    public int numberOfSpecialChars(String s) {

        int n = s.length();
        

        int freq[] = new int[26];
        HashSet<Character>ans=new HashSet<>();

        HashMap<Character, Integer> next = new HashMap<>();
        HashMap<Character, Integer> prev = new HashMap<>();

        
        for (char ch : s.toCharArray()) {

            if (ch >= 'A' && ch <= 'Z') {

                next.put(ch, next.getOrDefault(ch, 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {

                prev.put(c, prev.getOrDefault(c, 0) + 1);

                next.put(c, next.get(c) - 1);

            } else {

                char upper = Character.toUpperCase(c);

                if (!prev.containsKey(upper)
                        && next.getOrDefault(upper, 0) > 0
                        && freq[c - 'a'] == 0) {
ans.add(c);
                  
                }else{
                    if(ans.contains(c)&& prev.containsKey(upper)){
                       ans.remove(c);
                    }
                }

                freq[c - 'a']++;
            }
        }

        return ans.size();
    }
}