// https://leetcode.com/problems/escape-the-ghosts/

var escapeGhosts = function(ghosts, target) {
    const myDist = Math.abs(target[0]) + Math.abs(target[1]);
    return ghosts.every(([gx, gy]) => Math.abs(gx - target[0]) + Math.abs(gy - target[1]) > myDist);
};
