// https://leetcode.com/problems/intersection-of-multiple-arrays/

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        for (int[] arr : nums) {
            for (int v : arr) {
                count[v]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (count[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }
}
