// https://leetcode.com/problems/add-two-numbers-ii/

var addTwoNumbers = function(l1, l2) {
    const stack1 = [], stack2 = [];
    for (let node = l1; node; node = node.next) stack1.push(node.val);
    for (let node = l2; node; node = node.next) stack2.push(node.val);
    let carry = 0, head = null;
    while (stack1.length || stack2.length || carry) {
        let sum = carry;
        if (stack1.length) sum += stack1.pop();
        if (stack2.length) sum += stack2.pop();
        carry = Math.floor(sum / 10);
        const newNode = new ListNode(sum % 10);
        newNode.next = head;
        head = newNode;
    }
    return head;
};
