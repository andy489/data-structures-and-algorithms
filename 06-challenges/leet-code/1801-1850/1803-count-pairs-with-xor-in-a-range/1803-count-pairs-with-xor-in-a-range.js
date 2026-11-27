// https://leetcode.com/problems/count-pairs-with-xor-in-a-range/

var countPairs = function(nums, low, high) {
    const trie = [null, null, 0]; // [left, right, count]

    function insert(num) {
        let node = trie;
        for (let i = 14; i >= 0; i--) {
            const bit = (num >> i) & 1;
            if (!node[bit]) {
                node[bit] = [null, null, 0];
            }
            node = node[bit];
            node[2]++;
        }
    }

    function countLess(num, limit) {
        let node = trie, res = 0;
        for (let i = 14; i >= 0; i--) {
            const nb = (num >> i) & 1;
            const lb = (limit >> i) & 1;
            if (lb === 1) {
                if (node[nb]) {
                    res += node[nb][2];
                }
                node = node[nb ^ 1];
            } else {
                node = node[nb];
            }
            if (!node) {
                break;
            }
        }
        return res;
    }

    let ans = 0;
    for (const num of nums) {
        ans += countLess(num, high + 1) - countLess(num, low);
        insert(num);
    }
    return ans;
};
