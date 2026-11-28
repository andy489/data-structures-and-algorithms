// https://leetcode.com/problems/maximum-strong-pair-xor-ii/

var maximumStrongPairXor = function(nums) {
    const BITS = 20;
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const maxNodes = n * (BITS + 1) + 5;
    const left = new Int32Array(maxNodes);
    const right = new Int32Array(maxNodes);
    const cnt = new Int32Array(maxNodes);
    let trieSize = 1;

    function update(num, delta) {
        let node = 0;
        for (let i = BITS - 1; i >= 0; i--) {
            const bit = (num >> i) & 1;
            if (bit === 0) {
                if (left[node] === 0) left[node] = trieSize++;
                node = left[node];
            } else {
                if (right[node] === 0) right[node] = trieSize++;
                node = right[node];
            }
            cnt[node] += delta;
        }
    }

    function query(num) {
        let node = 0;
        let result = 0;
        for (let i = BITS - 1; i >= 0; i--) {
            const bit = (num >> i) & 1;
            const want = 1 - bit;
            const wantNode = want === 0 ? left[node] : right[node];
            if (wantNode !== 0 && cnt[wantNode] > 0) {
                result |= (1 << i);
                node = wantNode;
            } else {
                node = bit === 0 ? left[node] : right[node];
            }
        }
        return result;
    }

    let ans = 0;
    let l = 0;
    for (let r = 0; r < n; r++) {
        update(nums[r], 1);
        while (nums[l] * 2 < nums[r]) {
            update(nums[l], -1);
            l++;
        }
        ans = Math.max(ans, query(nums[r]));
    }
    return ans;
};
