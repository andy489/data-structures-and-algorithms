// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/

var minimumSwap = function(s1, s2) {
    let xy = 0, yx = 0;
    for (let i = 0; i < s1.length; i++) {
        if (s1[i]==='x' && s2[i]==='y') xy++;
        else if (s1[i]==='y' && s2[i]==='x') yx++;
    }
    if ((xy + yx) % 2) return -1;
    return xy >> 1 + yx >> 1 + (xy & 1) * 2;
};
