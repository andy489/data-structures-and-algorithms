// https://leetcode.com/problems/largest-time-for-given-digits/

var largestTimeFromDigits = function(arr) {
    let best = -1;
    for (let i=0;i<4;i++) for (let j=0;j<4;j++) { if(j===i) continue;
        for (let k=0;k<4;k++) { if(k===i||k===j) continue;
            const l=6-i-j-k, h=arr[i]*10+arr[j], m=arr[k]*10+arr[l];
            if(h<24&&m<60) best=Math.max(best,h*60+m);
        }
    }
    if(best===-1) return '';
    return String(Math.floor(best/60)).padStart(2,'0')+':'+String(best%60).padStart(2,'0');
};
