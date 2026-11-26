// https://leetcode.com/problems/two-out-of-three/

// Solution: Set Union — O(n1+n2+n3) time, O(n) space
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] arr : new int[][]{nums1, nums2, nums3}) {
            for (int x : new HashSet<>(arrToList(arr))) { count.merge(x, 1, Integer::sum); }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() >= 2) { res.add(e.getKey()); }
        }
        return res;
    }
    private List<Integer> arrToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) { list.add(x); }
        return list;
    }
}
