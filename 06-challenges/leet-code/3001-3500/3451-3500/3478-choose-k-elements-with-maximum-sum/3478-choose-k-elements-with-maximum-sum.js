// https://leetcode.com/problems/choose-k-elements-with-maximum-sum/

var findMaxSum = function(nums1, nums2, k) {
    const n = nums1.length;
    const indices = Array.from({length: n}, (_, i) => i);
    indices.sort((a, b) => nums1[a] - nums1[b]);
    const answer = new Array(n).fill(0);
    // Min-heap using sorted array simulation for small k
    const heap = [];
    let sum = 0;
    const heapPush = (val) => {
        heap.push(val);
        heap.sort((a, b) => a - b);
    };
    const heapPop = () => heap.shift();
    let i = 0;
    while (i < n) {
        let j = i;
        while (j < n && nums1[indices[j]] === nums1[indices[i]]) j++;
        for (let t = i; t < j; t++) answer[indices[t]] = sum;
        for (let t = i; t < j; t++) {
            heapPush(nums2[indices[t]]);
            sum += nums2[indices[t]];
            if (heap.length > k) sum -= heapPop();
        }
        i = j;
    }
    return answer;
};
