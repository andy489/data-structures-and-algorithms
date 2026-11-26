// https://leetcode.com/problems/linked-list-in-binary-tree/

var isSubPath = function(head, root) {
    const match=(node,t)=>{
        if(!node) return true;
        if(!t||t.val!==node.val) return false;
        return match(node.next,t.left)||match(node.next,t.right);
    };
    if(!root) return false;
    return match(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right);
};
