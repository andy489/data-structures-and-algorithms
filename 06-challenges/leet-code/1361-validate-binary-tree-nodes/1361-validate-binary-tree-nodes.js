// https://leetcode.com/problems/validate-binary-tree-nodes/

var validateBinaryTreeNodes = function(n, leftChild, rightChild) {
    const parent=new Array(n).fill(-1);
    for(let i=0;i<n;i++) for(const c of [leftChild[i],rightChild[i]]){
        if(c===-1) continue;
        if(parent[c]!==-1) return false;
        parent[c]=i;
    }
    const roots=Array.from({length:n},(_,i)=>i).filter(i=>parent[i]===-1);
    if(roots.length!==1) return false;
    const visited=new Set([roots[0]]), q=[roots[0]];
    while(q.length){
        const node=q.shift();
        for(const c of [leftChild[node],rightChild[node]]){
            if(c!==-1){if(visited.has(c)) return false; visited.add(c); q.push(c);}
        }
    }
    return visited.size===n;
};
