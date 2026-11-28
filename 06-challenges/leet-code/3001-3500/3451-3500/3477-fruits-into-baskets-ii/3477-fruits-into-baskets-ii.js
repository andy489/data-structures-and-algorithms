// https://leetcode.com/problems/fruits-into-baskets-ii/

var numOfUnplacedFruits = function(fruits, baskets) {
    const n = fruits.length;
    const used = new Array(n).fill(false);
    let unplaced = 0;
    for (const f of fruits) {
        let placed = false;
        for (let j = 0; j < n; j++) {
            if (!used[j] && baskets[j] >= f) {
                used[j] = true;
                placed = true;
                break;
            }
        }
        if (!placed) unplaced++;
    }
    return unplaced;
};
