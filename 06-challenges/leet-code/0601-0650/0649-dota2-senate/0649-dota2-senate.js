// https://leetcode.com/problems/dota2-senate/

var predictPartyVictory = function(senate) {
    const n = senate.length;
    const radiant = [], dire = [];
    for (let i = 0; i < n; i++) {
        if (senate[i] === 'R') radiant.push(i);
        else dire.push(i);
    }
    while (radiant.length > 0 && dire.length > 0) {
        const rIdx = radiant.shift();
        const dIdx = dire.shift();
        if (rIdx < dIdx) radiant.push(rIdx + n);
        else dire.push(dIdx + n);
    }
    return radiant.length === 0 ? "Dire" : "Radiant";
};
