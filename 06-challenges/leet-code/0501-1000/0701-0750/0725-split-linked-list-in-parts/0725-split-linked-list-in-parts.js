// https://leetcode.com/problems/split-linked-list-in-parts/

var splitListToParts = function(head, k) {
    let n = 0, curr = head;
    while (curr) { n++; curr = curr.next; }
    const base = Math.floor(n / k), extra = n % k;
    const result = new Array(k).fill(null);
    curr = head;
    for (let i = 0; i < k && curr; i++) {
        result[i] = curr;
        const size = base + (i < extra ? 1 : 0);
        for (let j = 1; j < size; j++) curr = curr.next;
        const next = curr.next;
        curr.next = null;
        curr = next;
    }
    return result;
};
