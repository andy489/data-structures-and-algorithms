// https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/

var getMinSwaps = function(num, k) {
    function nextPerm(arr) {
        const n = arr.length;
        let i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i >= 0) {
            let j = n - 1;
            while (arr[j] <= arr[i]) j--;
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
        let lo = i + 1, hi = n - 1;
        while (lo < hi) {
            [arr[lo], arr[hi]] = [arr[hi], arr[lo]];
            lo++; hi--;
        }
    }

    const target = num.split('');
    for (let i = 0; i < k; i++) {
        nextPerm(target);
    }

    const curr = num.split('');
    let swaps = 0;
    for (let i = 0; i < curr.length; i++) {
        if (curr[i] !== target[i]) {
            let j = i + 1;
            while (curr[j] !== target[i]) j++;
            while (j > i) {
                [curr[j], curr[j - 1]] = [curr[j - 1], curr[j]];
                j--;
                swaps++;
            }
        }
    }
    return swaps;
};
