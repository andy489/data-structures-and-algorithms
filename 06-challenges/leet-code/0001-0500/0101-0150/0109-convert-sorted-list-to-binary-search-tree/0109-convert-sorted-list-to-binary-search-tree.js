// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

var sortedListToBST = function(head) {
    if (!head) return null;
    if (!head.next) return new TreeNode(head.val);
    const prevMid = findPrevMid(head);
    const mid = prevMid.next;
    prevMid.next = null;
    const root = new TreeNode(mid.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(mid.next);
    return root;
};

function findPrevMid(head) {
    let prev = null, slow = head, fast = head;
    while (fast && fast.next) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    return prev;
}

var sortedListToBST2 = function(head) {
    const nums = [];
    for (let cur = head; cur; cur = cur.next) nums.push(cur.val);

    function build(lo, hi) {
        if (lo > hi) return null;
        const mid = lo + ((hi - lo) >> 1);
        const root = new TreeNode(nums[mid]);
        root.left = build(lo, mid - 1);
        root.right = build(mid + 1, hi);
        return root;
    }

    return build(0, nums.length - 1);
};

var sortedListToBST3 = function(head) {
    let n = 0;
    for (let c = head; c; c = c.next) n++;
    let cur = head;

    function build(lo, hi) {
        if (lo > hi) return null;
        const mid = lo + ((hi - lo) >> 1);
        const left = build(lo, mid - 1);
        const node = new TreeNode(cur.val);
        cur = cur.next;
        node.left = left;
        node.right = build(mid + 1, hi);
        return node;
    }

    return build(0, n - 1);
};
