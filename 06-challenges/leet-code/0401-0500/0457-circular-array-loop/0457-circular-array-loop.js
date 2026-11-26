// https://leetcode.com/problems/circular-array-loop/

var circularArrayLoop = function(nums) {
    const n = nums.length;
    const nxt = (i) => ((i + nums[i]) % n + n) % n;

    for (let i = 0; i < n; i++) {
        if (nums[i] === 0) {
            continue;
        }
        let slow = i, fast = nxt(i);
        while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[nxt(fast)] > 0) {
            if (slow === fast) {
                if (slow === nxt(slow)) {
                    break;
                }
                return true;
            }
            slow = nxt(slow);
            fast = nxt(nxt(fast));
        }
        let j = i;
        while (nums[j] * nums[nxt(j)] > 0) {
            const tmp = nxt(j);
            nums[j] = 0;
            j = tmp;
        }
    }
    return false;
};
