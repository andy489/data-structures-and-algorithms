// https://leetcode.com/problems/frog-position-after-t-seconds/

var frogPosition = function(n, edges, t, target) {
    const adj=Array.from({length:n+1},()=>[]);
    for(const[u,v]of edges){adj[u].push(v);adj[v].push(u);}
    const prob=new Array(n+1).fill(0); prob[1]=1;
    const visited=new Set([1]), q=[1];
    for(let s=0;s<t&&q.length;s++){
        const sz=q.length;
        for(let i=0;i<sz;i++){
            const cur=q.shift();
            const unv=adj[cur].filter(nb=>!visited.has(nb));
            if(!unv.length) continue;
            for(const nb of unv){visited.add(nb);prob[nb]=prob[cur]/unv.length;q.push(nb);}
            prob[cur]=0;
        }
    }
    return prob[target];
};
