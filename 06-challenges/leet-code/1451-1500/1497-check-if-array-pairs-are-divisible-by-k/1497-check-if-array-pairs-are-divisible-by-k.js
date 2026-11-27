// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

var canArrange = function(arr, k) {
    const freq=new Array(k).fill(0);
    for(const v of arr)freq[((v%k)+k)%k]++;
    if(freq[0]%2!==0)return false;
    for(let r=1;r<=Math.floor(k/2);r++){
        if(r===k-r){if(freq[r]%2!==0)return false;}
        else if(freq[r]!==freq[k-r])return false;
    }
    return true;
};
