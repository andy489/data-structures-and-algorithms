// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/

var findBestValue = function(arr, target) {
    arr.sort((a,b)=>a-b);
    let lo=0, hi=arr[arr.length-1], best=0, bestDiff=Infinity;
    while(lo<=hi){
        const mid=(lo+hi)>>1;
        const s=arr.reduce((a,x)=>a+Math.min(x,mid),0);
        const diff=Math.abs(s-target);
        if(diff<bestDiff||(diff===bestDiff&&mid<best)){bestDiff=diff;best=mid;}
        if(s<target)lo=mid+1;else hi=mid-1;
    }
    return best;
};
