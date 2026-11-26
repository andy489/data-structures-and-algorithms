// https://leetcode.com/problems/jump-game-v/

var maxJumps = function(arr, d) {
    const n=arr.length, memo=new Array(n).fill(0);
    const dp = i => {
        if (memo[i]) return memo[i];
        let res=1;
        for (const dir of [1,-1]) {
            for (let k=1;k<=d;k++) {
                const j=i+dir*k;
                if (j<0||j>=n||arr[j]>=arr[i]) break;
                res=Math.max(res,1+dp(j));
            }
        }
        return memo[i]=res;
    };
    return Math.max(...Array.from({length:n},(_,i)=>dp(i)));
};
