// https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/

var maxNumberOfApples = function(weight) {
    weight.sort((a,b)=>a-b);
    let total = 0;
    for (let i = 0; i < weight.length; i++) {
        total += weight[i];
        if (total > 5000) return i;
    }
    return weight.length;
};
