// https://leetcode.com/problems/find-the-winner-of-an-array-game/

var getWinner = function(arr, k) {
    let current = arr[0];
    let wins = 0;
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] > current) {
            current = arr[i];
            wins = 1;
        } else {
            wins++;
        }
        if (wins >= k) return current;
    }
    return current;
};
