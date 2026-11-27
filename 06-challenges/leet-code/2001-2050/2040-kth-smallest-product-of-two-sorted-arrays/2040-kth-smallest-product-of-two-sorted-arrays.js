// https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/

// Solution: Binary Search on Answer — O((m+n) log MaxVal) time, O(1) space
var kthSmallestProduct = function(nums1, nums2, k) {
    const bs = (arr, v) => { let lo=0, hi=arr.length; while(lo<hi){const m=(lo+hi)>>1; arr[m]<=v?lo=m+1:hi=m;} return lo; };
    const bsl = (arr, v) => { let lo=0, hi=arr.length; while(lo<hi){const m=(lo+hi)>>1; arr[m]<v?lo=m+1:hi=m;} return lo; };
    const count = (v) => {
        let res = 0;
        const m = nums2.length;
        for (const x of nums1) {
            if (x === 0) { if (v >= 0) res += m; }
            else if (x > 0) { res += bs(nums2, Math.floor(v >= 0 ? v/x : (v - x + 1)/x)); }
            else {
                let q = Math.ceil(v / x);
                res += m - bsl(nums2, q);
            }
        }
        return res;
    };
    let lo = -1e10, hi = 1e10;
    while (lo < hi) {
        const mid = Math.floor((lo + hi) / 2);
        if (count(mid) >= k) hi = mid;
        else lo = mid + 1;
    }
    return lo;
};
