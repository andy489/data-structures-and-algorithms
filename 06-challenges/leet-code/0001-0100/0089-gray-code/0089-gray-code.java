// https://leetcode.com/problems/gray-code/

// Solution: Bit Formula — O(2^n) time, O(1) space
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}

// Solution 2: Recursive Reflection — O(2^n) time, O(2^n) space
class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<>();
        code.add(0);
        code.add(1);
        for (int bit = 1; bit < n; bit++) {
            int size = code.size();
            for (int i = size - 1; i >= 0; i--) {
                code.add((1 << bit) | code.get(i));
            }
        }
        return code;
    }
}
