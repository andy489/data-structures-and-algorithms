// https://leetcode.com/problems/number-of-squareful-arrays/

var numSquarefulPerms = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const used = new Array(n).fill(false);
    const isSquare = (x) => { const s = Math.round(Math.sqrt(x)); return s*s === x; };
    let ans = 0;
    const bt = (path) => {
        if (path.length === n) { ans++; return; }
        for (let i = 0; i < n; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] === nums[i-1] && !used[i-1]) continue;
            if (path.length && !isSquare(path[path.length-1] + nums[i])) continue;
            used[i] = true; path.push(nums[i]);
            bt(path);
            path.pop(); used[i] = false;
        }
    };
    bt([]);
    return ans;
};
