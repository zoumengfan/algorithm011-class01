class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        if (ss.length != tt.length) {
            return false;
        }

        for (int i = 0; i < ss.length; ++i) {
            ++count[ss[i] - 'a'];
            --count[tt[i] - 'a'];
        }

        for (int i = 0; i < 26; ++i) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}