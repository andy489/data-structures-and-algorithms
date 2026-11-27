// https://leetcode.com/problems/rabbits-in-forest/

var numRabbits = function(answers) {
    const freq = new Map();
    for (const a of answers) {
        freq.set(a, (freq.get(a) || 0) + 1);
    }
    let total = 0;
    for (const [k, cnt] of freq) {
        const groupSize = k + 1;
        const groups = Math.ceil(cnt / groupSize);
        total += groups * groupSize;
    }
    return total;
};
