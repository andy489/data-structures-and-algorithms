// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

var numOfSubarrays = function(arr, k, threshold) {
    let sum=arr.slice(0,k).reduce((a,b)=>a+b,0), cnt=0, limit=k*threshold;
    if(sum>=limit) cnt++;
    for(let i=k;i<arr.length;i++){sum+=arr[i]-arr[i-k];if(sum>=limit)cnt++;}
    return cnt;
};
