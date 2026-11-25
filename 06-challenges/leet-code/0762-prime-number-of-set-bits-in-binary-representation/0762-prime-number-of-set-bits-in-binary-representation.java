// https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

// Solution: Bit Count + Prime Check — O(n) time, O(1) space
class Solution {
    private static final Set<Integer> PRIMES = new HashSet<>(
        Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int n = left; n <= right; n++) {
            if (PRIMES.contains(Integer.bitCount(n))) {
                count++;
            }
        }
        return count;
    }
}
