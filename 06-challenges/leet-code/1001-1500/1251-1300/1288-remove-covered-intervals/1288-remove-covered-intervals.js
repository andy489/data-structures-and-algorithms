// https://leetcode.com/problems/remove-covered-intervals/

var removeCoveredIntervals = function(intervals) {
    intervals.sort((a,b) => a[0]!==b[0] ? a[0]-b[0] : b[1]-a[1]);
    let count=0, maxRight=0;
    for(const[l,r] of intervals) if(r>maxRight){count++;maxRight=r;}
    return count;
};
