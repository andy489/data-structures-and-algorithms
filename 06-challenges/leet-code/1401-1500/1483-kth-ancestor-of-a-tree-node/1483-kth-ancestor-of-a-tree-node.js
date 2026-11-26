// https://leetcode.com/problems/kth-ancestor-of-a-tree-node/

class TreeAncestor {
    constructor(n, parent) {
        const LOG=16; this.dp=[parent.slice()];
        for(let j=1;j<LOG;j++){
            const prev=this.dp[j-1];
            this.dp.push(prev.map(p=>p===-1?-1:prev[p]));
        }
    }
    getKthAncestor(node,k){
        for(let j=0;j<this.dp.length&&node!==-1;j++)
            if((k>>j)&1)node=this.dp[j][node];
        return node;
    }
}
