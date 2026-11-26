// https://leetcode.com/problems/linked-list-random-node/

// Solution: Reservoir Sampling — O(n) time, O(1) space
class Solution {
    constructor(head) {
        this.head = head;
    }

    getRandom() {
        let result = this.head.val;
        let cur = this.head.next;
        let k = 2;

        while (cur !== null) {
            if (Math.floor(Math.random() * k) === 0) {
                result = cur.val;
            }
            cur = cur.next;
            k++;
        }

        return result;
    }
}
