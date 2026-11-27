// https://leetcode.com/problems/construct-target-array-with-multiple-sums/

var isPossible = function(target) {
    // Simple simulation with sorted approach
    let total = target.reduce((a,b)=>a+b,0);
    target = [...target].sort((a,b)=>b-a);
    while(true){
        const max=target[0], rest=total-max;
        if(max===1||rest===1) return true;
        if(rest===0||max<rest) return false;
        const prev=max%rest||rest;
        total=rest+prev;
        target[0]=prev;
        // re-sort (O(n) for this small approach)
        target.sort((a,b)=>b-a);
    }
};
