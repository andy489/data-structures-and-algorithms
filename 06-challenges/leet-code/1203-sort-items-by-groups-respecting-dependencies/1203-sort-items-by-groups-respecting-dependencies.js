// https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/

var sortItems = function(n, m, group, beforeItems) {
    for(let i=0;i<n;i++) if(group[i]===-1){group[i]=m++;}
    const iG=Array.from({length:n},()=>[]),gG=Array.from({length:m},()=>[]);
    const iD=new Array(n).fill(0),gD=new Array(m).fill(0);
    for(let i=0;i<n;i++) for(const pre of beforeItems[i]){
        iG[pre].push(i);iD[i]++;
        if(group[pre]!==group[i]){gG[group[pre]].push(group[i]);gD[group[i]]++;}
    }
    function topo(g,d,sz){
        const q=[],r=[];for(let i=0;i<sz;i++)if(d[i]===0)q.push(i);
        while(q.length){const u=q.shift();r.push(u);for(const v of g[u])if(--d[v]===0)q.push(v);}
        return r.length===sz?r:[];
    }
    const io=topo(iG,iD,n),go=topo(gG,gD,m);
    if(!io.length||!go.length)return[];
    const gi=new Map();for(const x of io){if(!gi.has(group[x]))gi.set(group[x],[]);gi.get(group[x]).push(x);}
    return go.flatMap(g=>gi.get(g)||[]);
};
