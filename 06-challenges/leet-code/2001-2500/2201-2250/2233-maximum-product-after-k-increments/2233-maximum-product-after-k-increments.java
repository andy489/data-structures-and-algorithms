// https://leetcode.com/problems/maximum-product-after-k-increments/

class Solution {
    public int maximumProduct(int[] nums, int k) {
        int MOD = 1_000_000_007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer(x);
        }
        for (int i = 0; i < k; i++) {
            pq.offer(pq.poll() + 1);
        }
        long product = 1;
        while (!pq.isEmpty()) {
            product = (product * pq.poll()) % MOD;
        }
        return (int) product;
    }
}
