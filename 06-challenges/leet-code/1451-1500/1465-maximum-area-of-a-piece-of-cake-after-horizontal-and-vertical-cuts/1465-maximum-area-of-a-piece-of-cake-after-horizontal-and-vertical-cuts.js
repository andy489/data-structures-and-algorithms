// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

var maxArea = function(h, w, horizontalCuts, verticalCuts) {
    const MOD = 1000000007n;
    const maxGap = (cuts, total) => {
        cuts.sort((a,b)=>a-b);
        let m = Math.max(cuts[0], total-cuts[cuts.length-1]);
        for (let i=1;i<cuts.length;i++) m=Math.max(m,cuts[i]-cuts[i-1]);
        return BigInt(m);
    };
    return Number(maxGap(horizontalCuts,h)*maxGap(verticalCuts,w)%MOD);
};
