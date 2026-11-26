// https://leetcode.com/problems/max-value-of-equation/

var findMaxValueOfEquation = function(points, k) {
    const dq=[];
    let ans=-Infinity;
    for(const[x,y]of points){
        while(dq.length&&x-dq[0][0]>k)dq.shift();
        if(dq.length)ans=Math.max(ans,y+x+dq[0][1]-dq[0][0]);
        while(dq.length&&dq[dq.length-1][1]-dq[dq.length-1][0]<=y-x)dq.pop();
        dq.push([x,y]);
    }
    return ans;
};
