// https://leetcode.com/problems/count-good-triplets/

var countGoodTriplets = function(arr, a, b, c) {
    const n = arr.length;
    let count = 0;
    for (let i = 0; i < n - 2; i++) {
        for (let j = i + 1; j < n - 1; j++) {
            if (Math.abs(arr[i] - arr[j]) <= a) {
                for (let k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
    }
    return count;
};
