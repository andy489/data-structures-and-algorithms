// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

var hasGroupsSizeX = function(deck) {
    const count = new Map();
    for (const c of deck) count.set(c, (count.get(c) || 0) + 1);
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    let g = 0;
    for (const v of count.values()) g = gcd(g, v);
    return g >= 2;
};
