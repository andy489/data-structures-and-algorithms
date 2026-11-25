// https://leetcode.com/problems/moving-stones-until-consecutive-ii/

var numMovesStonesII = function(stones) {
    stones.sort((a,b)=>a-b);
    const n = stones.length;
    const maxMoves = Math.max(stones[n-1]-stones[1]-n+2, stones[n-2]-stones[0]-n+2);
    let minMoves = n, j = 0;
    for (let i = 0; i < n; i++) {
        while (j+1 < n && stones[j+1]-stones[i] < n) j++;
        const inWindow = j-i+1;
        if (inWindow === n-1 && stones[j]-stones[i] === n-2) minMoves = Math.min(minMoves, 2);
        else minMoves = Math.min(minMoves, n-inWindow);
    }
    return [minMoves, maxMoves];
};
