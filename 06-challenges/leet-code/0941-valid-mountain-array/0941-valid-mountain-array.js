// https://leetcode.com/problems/valid-mountain-array/

var validMountainArray = function(arr) {
    const n = arr.length;
    let l = 0, r = n - 1;
    while (l < n - 1 && arr[l] < arr[l+1]) l++;
    while (r > 0 && arr[r] < arr[r-1]) r--;
    return l === r && l !== 0 && r !== n - 1;
};
