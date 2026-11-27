// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

var maxEvents = function(events) {
    events.sort((a,b)=>a[0]-b[0]);
    // Min-heap via sorted array (simple for JS)
    const MinHeap = class {
        constructor(){this.h=[];}
        push(v){this.h.push(v);this.h.sort((a,b)=>a-b);}
        pop(){return this.h.shift();}
        peek(){return this.h[0];}
        isEmpty(){return this.h.length===0;}
    };
    const pq=new MinHeap();
    let count=0, i=0, n=events.length;
    for(let day=1;day<=100000;day++){
        while(i<n&&events[i][0]===day) pq.push(events[i++][1]);
        while(!pq.isEmpty()&&pq.peek()<day) pq.pop();
        if(!pq.isEmpty()){pq.pop();count++;}
        if(pq.isEmpty()&&i===n) break;
    }
    return count;
};
