// https://leetcode.com/problems/check-if-n-and-its-double-exist/

var checkIfExist = function(arr) {
    const seen=new Set();
    for(const v of arr){
        if(seen.has(v*2)||(v%2===0&&seen.has(v/2))) return true;
        seen.add(v);
    }
    return false;
};
