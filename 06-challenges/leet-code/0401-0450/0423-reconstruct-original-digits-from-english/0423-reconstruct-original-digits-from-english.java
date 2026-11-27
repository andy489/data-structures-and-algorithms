// https://leetcode.com/problems/reconstruct-original-digits-from-english/

// Solution: Letter Frequency Fingerprinting — O(n) time, O(1) space
class Solution {
    public String originalDigits(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] digitCount = new int[10];
        // Unique-letter anchors
        digitCount[0] = freq['z' - 'a'];           // zero
        digitCount[2] = freq['w' - 'a'];           // two
        digitCount[4] = freq['u' - 'a'];           // four
        digitCount[6] = freq['x' - 'a'];           // six
        digitCount[8] = freq['g' - 'a'];           // eight
        // 'o' in zero(0), two(2), four(4)
        digitCount[1] = freq['o' - 'a'] - digitCount[0] - digitCount[2] - digitCount[4]; // one
        // 'h' in eight(8)
        digitCount[3] = freq['h' - 'a'] - digitCount[8];  // three
        // 'f' in four(4)
        digitCount[5] = freq['f' - 'a'] - digitCount[4];  // five
        // 's' in six(6)
        digitCount[7] = freq['s' - 'a'] - digitCount[6];  // seven
        // 'i' in five(5), six(6), eight(8)
        digitCount[9] = freq['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8]; // nine

        StringBuilder sb = new StringBuilder();
        for (int d = 0; d <= 9; d++) {
            for (int j = 0; j < digitCount[d]; j++) {
                sb.append((char) ('0' + d));
            }
        }
        return sb.toString();
    }
}
