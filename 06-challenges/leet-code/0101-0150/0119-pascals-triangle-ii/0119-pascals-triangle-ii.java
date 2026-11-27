// https://leetcode.com/problems/pascals-triangle-ii/

// Solution 1: In-Place Update (Right to Left) — O(rowIndex²) time, O(rowIndex) space
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}

// Solution 2: Binomial Coefficient — O(rowIndex) time, O(rowIndex) space
class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int j = 1; j <= rowIndex; j++) {
            row.add((int) ((long) row.get(j - 1) * (rowIndex - j + 1) / j));
        }
        return row;
    }
}
