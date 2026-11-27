// https://leetcode.com/problems/assign-elements-to-groups-with-constraints/
var assignElements = function(groups, elements) {
    const maxG = Math.max(...groups);
    const lookup = new Array(maxG + 1).fill(-1);

    for (let j = elements.length - 1; j >= 0; j--) {
        const e = elements[j];
        if (e > maxG) continue;
        for (let multiple = e; multiple <= maxG; multiple += e) {
            lookup[multiple] = j;
        }
    }

    return groups.map(g => lookup[g]);
};
