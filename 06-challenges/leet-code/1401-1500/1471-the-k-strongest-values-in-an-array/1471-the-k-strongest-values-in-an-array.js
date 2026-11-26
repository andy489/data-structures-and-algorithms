// https://leetcode.com/problems/the-k-strongest-values-in-an-array/

var getStrongest = function(arr, k) {
    arr.sort((a,b)=>a-b);
    const n=arr.length, m=arr[Math.floor((n-1)/2)];
    let l=0,r=n-1;
    const res=[];
    for(let i=0;i<k;i++){
        if(arr[r]-m>=m-arr[l]) res.push(arr[r--]);
        else res.push(arr[l++]);
    }
    return res;
};
