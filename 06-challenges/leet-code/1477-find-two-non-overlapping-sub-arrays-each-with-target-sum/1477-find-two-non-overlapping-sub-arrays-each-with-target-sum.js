// https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

var minSumOfLengths = function(arr, target) {
    const INF=1e9, n=arr.length;
    const minLeft=new Array(n).fill(INF);
    let left=0,s=0,best=INF,ans=INF;
    for(let r=0;r<n;r++){
        s+=arr[r];
        while(s>target)s-=arr[left++];
        if(s===target){
            const len=r-left+1;
            best=Math.min(best,len);
            if(left>0&&minLeft[left-1]<INF)ans=Math.min(ans,minLeft[left-1]+len);
        }
        minLeft[r]=best;
    }
    return ans>=INF?-1:ans;
};
