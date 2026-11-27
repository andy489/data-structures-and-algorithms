// https://leetcode.com/problems/check-array-formation-through-concatenation/

var canFormArray = function(arr, pieces) {
    const byFirst = new Map(pieces.map(p => [p[0], p]));
    let i = 0;
    while (i < arr.length) {
        const piece = byFirst.get(arr[i]);
        if (!piece) {
            return false;
        }
        for (const v of piece) {
            if (arr[i++] !== v) {
                return false;
            }
        }
    }
    return true;
};
