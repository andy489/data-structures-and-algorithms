// https://leetcode.com/problems/count-the-repetitions/

var getMaxRepetitions = function(s1, n1, s2, n2) {
    const len1 = s1.length, len2 = s2.length;
    let s2Index = 0, s2Count = 0;
    const stateToRound = new Map();
    const s2CountAtRound = new Array(n1 + 1).fill(0);

    for (let round = 0; round < n1; round++) {
        for (let i = 0; i < len1; i++) {
            if (s1[i] === s2[s2Index]) {
                s2Index++;
                if (s2Index === len2) {
                    s2Index = 0;
                    s2Count++;
                }
            }
        }
        s2CountAtRound[round + 1] = s2Count;
        if (stateToRound.has(s2Index)) {
            const [prevRound, prevCount] = stateToRound.get(s2Index);
            const cycleLen = round + 1 - prevRound;
            const cycleCount = s2Count - prevCount;
            const totalInCycles = Math.floor((n1 - prevRound) / cycleLen) * cycleCount;
            const remainder = (n1 - prevRound) % cycleLen;
            const totalS2 = prevCount + totalInCycles + (s2CountAtRound[prevRound + remainder] - prevCount);
            return Math.floor(totalS2 / n2);
        }
        stateToRound.set(s2Index, [round + 1, s2Count]);
    }
    return Math.floor(s2Count / n2);
};
