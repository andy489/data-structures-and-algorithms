// https://leetcode.com/problems/rank-teams-by-votes/

var rankTeams = function(votes) {
    const m=votes[0].length;
    const cnt={};
    for(const c of votes[0]) cnt[c]=new Array(m).fill(0);
    for(const vote of votes) for(let i=0;i<m;i++) cnt[vote[i]][i]++;
    return Object.keys(cnt).sort((a,b)=>{
        for(let i=0;i<m;i++) if(cnt[a][i]!==cnt[b][i]) return cnt[b][i]-cnt[a][i];
        return a<b?-1:1;
    }).join('');
};
