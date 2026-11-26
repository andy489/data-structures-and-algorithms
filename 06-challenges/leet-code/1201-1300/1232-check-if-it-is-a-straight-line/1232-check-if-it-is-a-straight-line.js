// https://leetcode.com/problems/check-if-it-is-a-straight-line/

var checkStraightLine = function(c) {
    const dx = c[1][0]-c[0][0], dy = c[1][1]-c[0][1];
    for (let i = 2; i < c.length; i++) {
        if ((c[i][0]-c[0][0])*dy !== (c[i][1]-c[0][1])*dx) return false;
    }
    return true;
};
