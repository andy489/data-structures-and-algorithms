// https://leetcode.com/problems/reduce-array-size-to-the-half/

var minSetSize = function(arr) {
    const freq = new Map();
    for (const v of arr) freq.set(v,(freq.get(v)||0)+1);
    const counts = [...freq.values()].sort((a,b)=>b-a);
    const half = arr.length>>1;
    let removed=0, size=0;
    for (const c of counts) {
        removed+=c; size++;
        if (removed>=half) return size;
    }
    return size;
};
