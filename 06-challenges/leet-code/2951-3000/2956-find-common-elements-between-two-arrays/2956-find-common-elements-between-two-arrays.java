// https://leetcode.com/problems/find-common-elements-between-two-arrays/
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            set2.add(x);
        }
        int answer1 = 0;
        int answer2 = 0;
        for (int x : nums1) {
            if (set2.contains(x)) {
                answer1++;
            }
        }
        for (int x : nums2) {
            if (set1.contains(x)) {
                answer2++;
            }
        }
        return new int[]{answer1, answer2};
    }
}
