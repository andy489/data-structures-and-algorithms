// https://leetcode.com/problems/replace-all-digits-with-characters/

var replaceDigits = function(s) {
    const arr = s.split('');
    for (let i = 1; i < arr.length; i += 2) {
        arr[i] = String.fromCharCode(arr[i - 1].charCodeAt(0) + Number(arr[i]));
    }
    return arr.join('');
};
