// https://leetcode.com/problems/k-items-with-the-maximum-sum/
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ones = Math.min(k, numOnes);
        k -= ones;
        int zeros = Math.min(k, numZeros);
        k -= zeros;
        return ones - k;
    }
}
