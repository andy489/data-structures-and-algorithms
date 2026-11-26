// https://leetcode.com/problems/find-in-mountain-array/

var findInMountainArray = function(target, mountainArr) {
    const n = mountainArr.length();
    let lo = 0, hi = n - 1;
    while (lo < hi) {
        const mid = (lo+hi)>>1;
        if (mountainArr.get(mid) < mountainArr.get(mid+1)) lo = mid+1;
        else hi = mid;
    }
    const peak = lo;
    lo = 0; hi = peak;
    while (lo <= hi) {
        const mid = (lo+hi)>>1, val = mountainArr.get(mid);
        if (val === target) return mid;
        else if (val < target) lo = mid+1;
        else hi = mid-1;
    }
    lo = peak+1; hi = n-1;
    while (lo <= hi) {
        const mid = (lo+hi)>>1, val = mountainArr.get(mid);
        if (val === target) return mid;
        else if (val > target) lo = mid+1;
        else hi = mid-1;
    }
    return -1;
};
