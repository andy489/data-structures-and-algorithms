// https://leetcode.com/problems/minimum-number-of-frogs-croaking/

var minNumberOfFrogs = function(s) {
    let c=0,r=0,o=0,a=0,k=0,maxF=0;
    for (const ch of s) {
        if (ch==='c') c++;
        else if (ch==='r') { if(!c) return -1; c--; r++; }
        else if (ch==='o') { if(!r) return -1; r--; o++; }
        else if (ch==='a') { if(!o) return -1; o--; a++; }
        else if (ch==='k') { if(!a) return -1; a--; k++; }
        maxF = Math.max(maxF, c+r+o+a);
    }
    return (c||r||o||a) ? -1 : maxF;
};
