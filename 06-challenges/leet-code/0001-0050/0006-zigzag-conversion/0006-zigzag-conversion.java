// https://leetcode.com/problems/zigzag-conversion/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; ++i) {
            rows[i] = new StringBuilder();
        }

        int i = 0;
        int step = 0;

        for (char c : s.toCharArray()) {
            rows[i].append(c);

            if (i == 0) {
                step = 1;
            }
            if (i == numRows - 1) {
                step = -1;
            }

            i += step;
        }
        
        StringBuilder res = new StringBuilder();
        
        for (var word : rows) {
            res.append(word);
        }
        
        return res.toString();
    }
}
