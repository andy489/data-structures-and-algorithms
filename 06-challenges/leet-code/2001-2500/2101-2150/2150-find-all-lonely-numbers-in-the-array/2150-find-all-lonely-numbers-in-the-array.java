// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int x : freq.keySet()) {
            if (freq.get(x) == 1 && !freq.containsKey(x - 1) && !freq.containsKey(x + 1)) {
                result.add(x);
            }
        }
        return result;
    }
}
