// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

var maxSumBST = function(root) {
    let ans=0;
    const INF=Infinity;
    const dfs=node=>{
        if(!node) return [1,INF,-INF,0];
        const [lb,lmin,lmax,lsum]=dfs(node.left);
        const [rb,rmin,rmax,rsum]=dfs(node.right);
        if(lb&&rb&&node.val>lmax&&node.val<rmin){
            const s=node.val+lsum+rsum;
            ans=Math.max(ans,s);
            return [1,Math.min(lmin,node.val),Math.max(rmax,node.val),s];
        }
        return [0,0,0,0];
    };
    dfs(root);
    return ans;
};
