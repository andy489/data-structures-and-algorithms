## Conversion from Infix to Postfix

Infix: A + B * C ⇒ A + (B * C) ⇒ A + (BC * ) ⇒ A(BC * ) + ⇒ ABC * + : Postifx
|-

We have seen how we can do this [manually](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Stack/Evaluation%20of%20Prefix%20and%20Postfix%20expressions.md). To convert an infix expression to postfix, we apply operator precedence, and associativity rules. We can use this logic in a program also, but it will not be very efficient and the implementation will be also somewhat complex.

Is there an simple and efficient algorithm in which we can parse the infix expression only once from left to right and create the postfix expression? If you can see in infix to postfix conversion, the positions of operands and operators may change but the order in which operands occur from left to right will not change. *The order of operators may change*. This is an important observation. The both infix and postfix forms in the above example, the order of operands as we go from left to right is first we have A, then we have B and then we have C. But the order of operators is different. In infix, first we have addition and then multiplication. In postfix, first we have multiplication and then we have addition. *In postfix form we will always have the operators in the same order, in which they should be executed*. We are going to perform the above conversion once again but this time we are going to use a different logic. What we will do is, we will parse the infix expression from left to right. So, we will go from left to right, looking at each token that will either be an operand or an operator. In the expression we will start at A. A is an operand. If it's an operand we can simply append it in the postfix string or expression that we are trying to create. At least for A it should be very clear that there is nothing that can come before A. So, the first rule is that if it's an operand, we can simply put it in the postfix expression. Moving on, next we have an operator. We cannot put the operator in the postfix expression, because we have not seen it's right operand yet. While parsing we have seen only it's right operand yet. While parsing we have seen only it's left operand. We can place it only after it's right operand is also placed. So, what we are going to do is to keep this operator in a separate list or collection and place it later in the postfix expression when it can be placed and the structure that we are going to use for storage is stack. A stack is only a special kind of list in which whatever comes in last goes out first. Insertion and deletion happens from the same end. Moving on, next we have B, which is an operand. As we mentioned operand can simply be appended. There is nothing that can come before this operand. The operator on the stack is anyway waiting for the operand to come. Now at this stage, can we place the addition operator to the postfix string? Actually, what's after B also matters. In the above case, we have the multiplication operator after B, which has higher precedence and so the actual operand for addition is this whole expression B * C. We cannot perform the addition until multiplication is finished. So while parsing, when we are at B and we have not seen what's ahead of B, we cannot decide the fate of the operator in the stack. So let's just move on. after that, we have a multiplication operator. We want to make the above expression further complex to explain things better. So, we are adding something at tail in the above expression:

Infix: A + B * C - D * E
|-

Now, we want to convert the upper expression to postfix form (we have just expanded it). We re not having any parantheses here. We will see how we can deal with prntheses later. Let's look at an expression where parantheses does not override operator precedence. Right now in the above expression while parsing from left to righr, we are at the first multiplication operator. The multiplication operator itself cannot go into the postfix expression because we have not seen his right operand yet. And, until it's right operand is placed in the postfix expression, we cannot place it. The operator that we would be looking at while parsing, that operator itself cannot be placed right away. But looking at that operator, we can decide whether something from the collection, something from the stack can be placed into the postfix expression that we are constructing or not. Any operator in the stack having higher precedence than the operator that we are looking at, can be popped and placed into the postfix expression. Let's just follow this as rule for now and we will explain it later. There is only one operator in the stack and it is not having higher precedence than multiplication so we will not pop it and place it in the postfix expression. Multiplication itself will be pushed. *If an element in the stack has something on top of it, that something will always be of higher precedence*. So, let's move on in the above expression now. Now, we are at C, which is an operand, so it can simply go. Next, we have an operator subtraction. Subtraction itself cannot go but as we had said if there is anything on the stack having higher precedence than the operator that we are looking at, it should be popped out and it should god the question is why? We are putting these operators on the stack, we are not plasing them in the postfix expression because we are not sure whether we are done with their right operand ot not. But after the current operator, as soon as we are getting an operator of lower precedence, that marks the boundary of the right operand. For the first multiplication in the above example, C is our right operand. It's the simple variable C. For addition, B * C is our right operand because subtraction has lower precedence. Anything on or after that cannot be part of our right operand. Subtraction, w should say has lower priority because of the associativity tule. If we remember the order of operation, addition and subtraction have same precedence but tha one that would occur in left would be given preference. So, the idea is anytime for an operator, *if we are getting an operator of lower priority, we can pop it from the stack and place it in the expression*. Here, we will first pop multiplication and place it and then we can pop addition and now we will push subtraction onto the stack. Let's move on now. D is an operand. So, it will simply go. Next we have multiplication. There is nothing in the stack having higher precedence than multiplication. So, we will pop nothing. Multiplication will go onto the stack. Next, we have an operand. It will simply go. Now, there are two ways in which we can find the end of the right operand for an operator. The first is if we get an operator of lesser precedence, and the second if we reach the end of the expression. Now that we have reached end of expression, we can simply pop and place these operators. So first multiplication will go and then subtractin will go. Let's quickly write pseudo code for whatever we write so far and then we can analyze the logic with some more examples.

We will write a function that will take a string exp (from expression) as an argument, and for the sake of simplisity we will assume that each operand ot operator will be of one character only. In an actual implementation we can assume them to be tokens of multiple characters.

```cpp
InfixToPostfix(exp)
{
      Create a Stack S
      res <- empty string
      for i <- 0 to length(exp)-1
      {
            if exp[i] is operand
                  res <- res + exp[i];
            else if exp[i] is operator
            {
                  while (!s.empty() && HasHigherPrecedence(s.top(). exp[i]))
                  {
                        res <- res + S.top()
                        S.pop()
                  }
                  S.push(exp[i])
            }      
       }
       while (!S.empty())
       {
            res <- res + S.top()
            S.pop()
       }
       return res
}
```
