// https://leetcode.com/problems/time-needed-to-inform-all-employees/

var numOfMinutes = function(n, headID, manager, informTime) {
    const ch=Array.from({length:n},()=>[]);
    for(let i=0;i<n;i++) if(manager[i]!==-1) ch[manager[i]].push(i);
    const dfs=e=>informTime[e]+Math.max(0,...ch[e].map(dfs));
    return dfs(headID);
};
