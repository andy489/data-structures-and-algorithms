// https://leetcode.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/

var getProbability = function(balls) {
    const k=balls.length, half=balls.reduce((s,x)=>s+x,0)/2;
    let favorable=0, total=0;
    function comb(n,r){let res=1;for(let i=0;i<r;i++){res*=(n-i);res/=(i+1);}return res;}
    function dfs(idx,b1,b2,d1,d2,ways){
        if(b1>half||b2>half)return;
        if(idx===k){if(b1===half){total+=ways;if(d1===d2)favorable+=ways;}return;}
        for(let i=0;i<=balls[idx];i++)
            dfs(idx+1,b1+i,b2+balls[idx]-i,d1+(i>0?1:0),d2+(balls[idx]-i>0?1:0),ways*comb(balls[idx],i));
    }
    dfs(0,0,0,0,0,1);
    return favorable/total;
};
