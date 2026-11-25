// https://leetcode.com/problems/linked-list-components/

// Solution: Hash Set + Single Pass — O(n) time, O(m) space
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int count = 0;
        boolean inComponent = false;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (set.contains(cur.val)) {
                if (!inComponent) {
                    count++;
                    inComponent = true;
                }
            } else {
                inComponent = false;
            }
        }
        return count;
    }
}
