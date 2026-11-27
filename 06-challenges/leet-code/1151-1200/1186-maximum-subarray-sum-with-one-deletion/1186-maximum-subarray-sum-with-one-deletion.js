// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

// Solution: DP with Two States — O(n) time, O(1) space
var maximumSum = function(arr) {
    let noDelete = arr[0];
    let oneDelete = 0;
    let ans = arr[0];
    for (let i = 1; i < arr.length; i++) {
        oneDelete = Math.max(noDelete, oneDelete + arr[i]);
        noDelete = Math.max(arr[i], noDelete + arr[i]);
        ans = Math.max(ans, noDelete, oneDelete);
    }
    return ans;
};
