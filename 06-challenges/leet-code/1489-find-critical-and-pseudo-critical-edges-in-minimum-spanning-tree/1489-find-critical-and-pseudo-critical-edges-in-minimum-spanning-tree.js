// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

var findCriticalAndPseudoCriticalEdges = function(n, edges) {
    const m=edges.length;
    const idx=[...Array(m).keys()].sort((a,b)=>edges[a][2]-edges[b][2]);
    const se=idx.map(i=>edges[i]);
    const kruskal=(skip,force)=>{
        const p=[...Array(n).keys()];
        const find=x=>{while(p[x]!==x){p[x]=p[p[x]];x=p[x];}return x;};
        let w=0,cnt=0;
        if(force>=0){p[find(se[force][0])]=find(se[force][1]);w+=se[force][2];cnt++;}
        for(let i=0;i<m;i++){if(i===skip)continue;const[u,v,wt]=se[i];const ru=find(u),rv=find(v);if(ru!==rv){p[ru]=rv;w+=wt;cnt++;}}
        return cnt===n-1?w:Infinity;
    };
    const base=kruskal(-1,-1);
    const crit=[],pseudo=[];
    for(let i=0;i<m;i++){
        if(kruskal(i,-1)>base)crit.push(idx[i]);
        else if(kruskal(-1,i)===base)pseudo.push(idx[i]);
    }
    return[crit,pseudo];
};
