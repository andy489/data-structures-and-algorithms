// https://leetcode.com/problems/linked-list-components/

var numComponents = function(head, nums) {
    const s = new Set(nums);
    let count = 0, inComponent = false;
    for (let cur = head; cur; cur = cur.next) {
        if (s.has(cur.val)) {
            if (!inComponent) { count++; inComponent = true; }
        } else {
            inComponent = false;
        }
    }
    return count;
};
