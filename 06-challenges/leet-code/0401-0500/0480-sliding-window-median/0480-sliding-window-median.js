// https://leetcode.com/problems/sliding-window-median/

var medianSlidingWindow = function(nums, k) {
    // Use sorted array approach (simple but O(N*k))
    const result = [];
    const window = nums.slice(0, k).sort((a, b) => a - b);

    const getMedian = () => {
        if (k % 2 === 1) return window[Math.floor(k / 2)];
        return (window[k / 2 - 1] + window[k / 2]) / 2;
    };

    result.push(getMedian());

    for (let i = k; i < nums.length; i++) {
        const outgoing = nums[i - k];
        const incoming = nums[i];

        // remove outgoing
        const removeIdx = window.findIndex(x => x === outgoing);
        window.splice(removeIdx, 1);

        // insert incoming in sorted position
        let lo = 0, hi = window.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (window[mid] <= incoming) lo = mid + 1;
            else hi = mid;
        }
        window.splice(lo, 0, incoming);

        result.push(getMedian());
    }
    return result;
};
