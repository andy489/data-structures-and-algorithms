// https://leetcode.com/problems/make-sum-divisible-by-p/

var minSubarray = function(nums, p) {
    const totalMod = nums.reduce((a, b) => (a + b) % p, 0);
    if (totalMod === 0) return 0;
    const lastSeen = new Map([[0, -1]]);
    let prefMod = 0, minLen = nums.length;
    for (let i = 0; i < nums.length; i++) {
        prefMod = (prefMod + nums[i]) % p;
        const need = (prefMod - totalMod + p) % p;
        if (lastSeen.has(need)) {
            minLen = Math.min(minLen, i - lastSeen.get(need));
        }
        lastSeen.set(prefMod, i);
    }
    return minLen === nums.length ? -1 : minLen;
};
