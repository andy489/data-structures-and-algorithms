// https://leetcode.com/problems/roman-to-integer/
// Time: O(n)

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> T = new HashMap<Character, Integer>() {{
            this.put('I', 1);
            this.put('V', 5);
            this.put('X', 10);
            this.put('L', 50);
            this.put('C', 100);
            this.put('D', 500);
            this.put('M', 1000);
        }};
        int SIZE = s.length(), res = T.get(s.charAt(SIZE - 1));
        for (int i = SIZE - 2; i >= 0; --i)
            if (T.get(s.charAt(i)) < T.get(s.charAt(i + 1))) res -= T.get(s.charAt(i));
            else res += T.get(s.charAt(i));
        return res;
    }
}
