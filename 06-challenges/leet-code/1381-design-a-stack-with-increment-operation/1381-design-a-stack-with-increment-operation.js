// https://leetcode.com/problems/design-a-stack-with-increment-operation/

class CustomStack {
    constructor(maxSize){this.stack=[];this.inc=[];this.max=maxSize;}
    push(x){if(this.stack.length<this.max){this.stack.push(x);this.inc.push(0);}}
    pop(){
        if(!this.stack.length) return -1;
        const val=this.stack.pop()+this.inc.pop();
        if(this.inc.length) this.inc[this.inc.length-1]+=0; // carry handled in pop
        return val;
    }
    increment(k,val){if(this.inc.length) this.inc[Math.min(k,this.inc.length)-1]+=val;}
}
