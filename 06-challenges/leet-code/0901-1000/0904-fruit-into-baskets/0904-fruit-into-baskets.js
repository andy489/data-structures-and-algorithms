// https://leetcode.com/problems/fruit-into-baskets/

var totalFruit = function(fruits) {
    const count = new Map();
    let left = 0, result = 0;
    for (let right = 0; right < fruits.length; right++) {
        count.set(fruits[right], (count.get(fruits[right]) || 0) + 1);
        while (count.size > 2) {
            const lf = fruits[left++];
            count.set(lf, count.get(lf) - 1);
            if (count.get(lf) === 0) {
                count.delete(lf);
            }
        }
        result = Math.max(result, right - left + 1);
    }
    return result;
};
