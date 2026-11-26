// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

var findMaximumXOR = function(nums) {
    const BITS = 31;
    const root = [null, null];

    function insert(num) {
        let node = root;
        for (let bit = BITS; bit >= 0; bit--) {
            const b = (num >> bit) & 1;
            if (!node[b]) {
                node[b] = [null, null];
            }
            node = node[b];
        }
    }

    function maxXorWith(num) {
        let node = root;
        let result = 0;
        for (let bit = BITS; bit >= 0; bit--) {
            const b = (num >> bit) & 1;
            const want = 1 - b;
            if (node[want]) {
                result |= (1 << bit);
                node = node[want];
            } else {
                node = node[b];
            }
        }
        return result;
    }

    for (const num of nums) {
        insert(num);
    }

    let maxXor = 0;
    for (const num of nums) {
        maxXor = Math.max(maxXor, maxXorWith(num));
    }
    return maxXor;
};
