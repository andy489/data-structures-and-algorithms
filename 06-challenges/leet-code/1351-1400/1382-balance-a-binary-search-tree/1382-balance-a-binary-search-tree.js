// https://leetcode.com/problems/balance-a-binary-search-tree/

var balanceBST = function(root) {
    const nodes=[];
    const inorder=n=>{if(!n) return; inorder(n.left); nodes.push(n.val); inorder(n.right);};
    inorder(root);
    const build=(lo,hi)=>{
        if(lo>hi) return null;
        const mid=(lo+hi)>>1;
        const node=new TreeNode(nodes[mid]);
        node.left=build(lo,mid-1); node.right=build(mid+1,hi);
        return node;
    };
    return build(0,nodes.length-1);
};
