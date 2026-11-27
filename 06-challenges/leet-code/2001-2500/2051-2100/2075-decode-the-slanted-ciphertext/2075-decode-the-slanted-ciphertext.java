// https://leetcode.com/problems/decode-the-slanted-ciphertext/

// Solution: Matrix Diagonal — O(n) time, O(n) space
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) { return encodedText; }
        int n = encodedText.length(), cols = n / rows;
        StringBuilder res = new StringBuilder();
        for (int col = 0; col < cols; col++) {
            for (int r = 0, c = col; r < rows && c < cols; r++, c++) {
                res.append(encodedText.charAt(r * cols + c));
            }
        }
        int end = res.length();
        while (end > 0 && res.charAt(end - 1) == ' ') { end--; }
        return res.substring(0, end);
    }
}
