// https://leetcode.com/problems/password-strength/
class Solution {
    public int passwordStrength(String password) {
        boolean[] seen = new boolean[128];
        int strength = 0;
        for (char c : password.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                if (c >= 'a' && c <= 'z') {
                    strength += 1;
                } else if (c >= 'A' && c <= 'Z') {
                    strength += 2;
                } else if (c >= '0' && c <= '9') {
                    strength += 3;
                } else if (c == '!' || c == '@' || c == '#' || c == '$') {
                    strength += 5;
                }
            }
        }
        return strength;
    }
}
