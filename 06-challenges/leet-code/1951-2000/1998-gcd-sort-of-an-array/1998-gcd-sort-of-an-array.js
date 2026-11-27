// https://leetcode.com/problems/gcd-sort-of-an-array/
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var gcdSort = function(nums) {
    const maxVal = Math.max(...nums);
    const parent = Array.from({length: maxVal + 1}, (_, i) => i);

    function find(x) {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    function union(a, b) {
        const ra = find(a), rb = find(b);
        if (ra !== rb) {
            parent[ra] = rb;
        }
    }

    for (const x of nums) {
        let temp = x;
        for (let p = 2; p * p <= temp; p++) {
            if (temp % p === 0) {
                union(x, p);
                while (temp % p === 0) {
                    temp = Math.floor(temp / p);
                }
            }
        }
        if (temp > 1) {
            union(x, temp);
        }
    }

    const sorted = [...nums].sort((a, b) => a - b);
    for (let i = 0; i < nums.length; i++) {
        if (find(nums[i]) !== find(sorted[i])) {
            return false;
        }
    }
    return true;
};
