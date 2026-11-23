// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
var findRestaurant = function(list1, list2) {
    const indexInList1 = new Map();
    list1.forEach((s, i) => indexInList1.set(s, i));
    let result = [];
    let minSum = Infinity;
    list2.forEach((s, j) => {
        if (indexInList1.has(s)) {
            const idxSum = indexInList1.get(s) + j;
            if (idxSum < minSum) {
                minSum = idxSum;
                result = [s];
            } else if (idxSum === minSum) {
                result.push(s);
            }
        }
    });
    return result;
};
