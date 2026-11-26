// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/

var beautifulIndices = function(s, a, b, k) {
    const findAll = (s, p) => {
        const res = []; let i = 0;
        while ((i = s.indexOf(p, i)) !== -1) { res.push(i); i++; }
        return res;
    };
    const listA = findAll(s, a), listB = findAll(s, b);
    const result = [];
    let j = 0;
    for (const i of listA) {
        while (j < listB.length && listB[j] < i - k) j++;
        if (j < listB.length && listB[j] <= i + k) result.push(i);
    }
    return result;
};
