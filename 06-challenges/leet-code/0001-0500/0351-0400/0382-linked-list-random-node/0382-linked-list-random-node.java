// https://leetcode.com/problems/linked-list-random-node/

// Solution: Reservoir Sampling — O(n) time, O(1) space
class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int result = head.val;
        ListNode cur = head.next;
        int k = 2;

        while (cur != null) {
            if (rand.nextInt(k) == 0) {
                result = cur.val;
            }
            cur = cur.next;
            k++;
        }

        return result;
    }
}
