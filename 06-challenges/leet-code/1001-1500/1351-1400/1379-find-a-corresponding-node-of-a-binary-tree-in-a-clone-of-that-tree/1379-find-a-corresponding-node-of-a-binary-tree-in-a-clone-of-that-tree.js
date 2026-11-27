// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

var getTargetCopy = function(original, cloned, target) {
    if(!original) return null;
    if(original===target) return cloned;
    return getTargetCopy(original.left,cloned.left,target)||
           getTargetCopy(original.right,cloned.right,target);
};
