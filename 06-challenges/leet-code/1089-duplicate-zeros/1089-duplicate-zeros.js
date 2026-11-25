// https://leetcode.com/problems/duplicate-zeros/

var duplicateZeros = function(arr) {
    let zeros = arr.filter(x => x === 0).length;
    const n = arr.length;
    let i = n-1, j = n+zeros-1;
    while (i >= 0) {
        if (arr[i] === 0) {
            if (j < n) arr[j] = 0;
            j--;
            if (j < n) arr[j] = 0;
        } else {
            if (j < n) arr[j] = arr[i];
        }
        i--; j--;
    }
};
