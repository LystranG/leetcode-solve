class Solution {
    public boolean isAnagram(String s, String t) {
        
        int n1 = s.length(), n2 = t.length();

        if (n1 != n2) return false;
        
        int[] map = new int[26];
        for (int i = 0;i < n1;i++) {
            map[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0;i < n1;i++) {
            if (--map[t.charAt(i) - 'a'] < 0) return false;
        }
        
        return true;
    }

}