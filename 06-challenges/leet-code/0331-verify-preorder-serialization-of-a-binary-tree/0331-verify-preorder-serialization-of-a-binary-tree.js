// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

// Solution: Slot Counting — O(n) time, O(1) space
var isValidSerialization = function(preorder) {
    let slots = 1;
    for (const token of preorder.split(',')) {
        slots--;
        if (slots < 0) return false;
        if (token !== '#') slots += 2;
    }
    return slots === 0;
};
