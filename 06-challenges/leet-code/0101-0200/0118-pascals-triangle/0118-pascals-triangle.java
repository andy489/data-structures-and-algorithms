// https://leetcode.com/problems/pascals-triangle/

// Solution 1: Iterative Row Construction — O(numRows²) time, O(numRows²) space
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}

// Solution 2: Binomial Coefficient — O(numRows²) time, O(numRows²) space
class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j <= i; j++) {
                row.add(row.get(j - 1) * (i - j + 1) / j);
            }
            result.add(row);
        }
        return result;
    }
}
