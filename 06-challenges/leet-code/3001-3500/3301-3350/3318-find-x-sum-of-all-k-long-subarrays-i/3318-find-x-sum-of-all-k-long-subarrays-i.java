// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.merge(nums[j], 1, Integer::sum);
            }
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
            entries.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue();
                }
                return b.getKey() - a.getKey();
            });
            long sum = 0;
            for (int t = 0; t < Math.min(x, entries.size()); t++) {
                Map.Entry<Integer, Integer> e = entries.get(t);
                sum += (long) e.getKey() * e.getValue();
            }
            answer[i] = (int) sum;
        }
        return answer;
    }
}
