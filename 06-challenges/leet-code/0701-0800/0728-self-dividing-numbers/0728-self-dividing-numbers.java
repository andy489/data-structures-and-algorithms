// https://leetcode.com/problems/self-dividing-numbers/

// Solution: Brute Force Check — O((R-L)·d) time, O(1) space
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int n = left; n <= right; n++) {
            if (isSelfDividing(n)) {
                result.add(n);
            }
        }
        return result;
    }

    private boolean isSelfDividing(int n) {
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || n % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}
