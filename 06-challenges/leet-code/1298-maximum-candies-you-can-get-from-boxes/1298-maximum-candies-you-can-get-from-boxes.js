// https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/

var maxCandies = function(status, candies, keys, containedBoxes, initialBoxes) {
    const possessed=new Set(),opened=new Set(),q=[];
    for(const b of initialBoxes){possessed.add(b);if(status[b])q.push(b);}
    let total=0;
    while(q.length){
        const b=q.shift();total+=candies[b];
        for(const k of keys[b]){opened.add(k);if(possessed.has(k))q.push(k);}
        for(const cb of containedBoxes[b]){possessed.add(cb);if(status[cb]||opened.has(cb))q.push(cb);}
    }
    return total;
};
