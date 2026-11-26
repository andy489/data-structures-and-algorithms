// https://leetcode.com/problems/interval-list-intersections/

var intervalIntersection = function(firstList, secondList) {
    const res = [];
    let i = 0, j = 0;
    while (i < firstList.length && j < secondList.length) {
        const lo = Math.max(firstList[i][0], secondList[j][0]);
        const hi = Math.min(firstList[i][1], secondList[j][1]);
        if (lo <= hi) res.push([lo, hi]);
        if (firstList[i][1] < secondList[j][1]) i++;
        else j++;
    }
    return res;
};
