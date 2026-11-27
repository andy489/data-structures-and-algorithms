// https://leetcode.com/problems/jewels-and-stones/

var numJewelsInStones = function(jewels, stones) {
    const jewel = new Set(jewels);
    let count = 0;
    for (const s of stones) {
        if (jewel.has(s)) {
            count++;
        }
    }
    return count;
};
