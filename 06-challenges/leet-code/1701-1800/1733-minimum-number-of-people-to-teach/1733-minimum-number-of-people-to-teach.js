// https://leetcode.com/problems/minimum-number-of-people-to-teach/

var minimumTeachings = function(n, languages, friendships) {
    const m = languages.length;
    const langSets = languages.map(arr => new Set(arr));
    const candidates = new Set();
    for (const [u, v] of friendships) {
        const us = langSets[u - 1], vs = langSets[v - 1];
        let canCommunicate = false;
        for (const lang of us) {
            if (vs.has(lang)) { canCommunicate = true; break; }
        }
        if (!canCommunicate) {
            candidates.add(u - 1);
            candidates.add(v - 1);
        }
    }
    if (candidates.size === 0) { return 0; }
    let minTeach = candidates.size;
    for (let lang = 1; lang <= n; lang++) {
        let cnt = 0;
        for (const user of candidates) {
            if (!langSets[user].has(lang)) { cnt++; }
        }
        minTeach = Math.min(minTeach, cnt);
    }
    return minTeach;
};
