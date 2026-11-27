// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

var longestZigZag = function(root) {
    let ans=0;
    const dfs=(node,goLeft,len)=>{
        if(!node) return;
        ans=Math.max(ans,len);
        if(goLeft){dfs(node.left,false,len+1);dfs(node.right,true,1);}
        else{dfs(node.right,true,len+1);dfs(node.left,false,1);}
    };
    dfs(root,true,0); dfs(root,false,0);
    return ans;
};
