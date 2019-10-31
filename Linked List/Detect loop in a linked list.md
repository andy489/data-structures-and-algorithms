Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.

**Floyd’s Cycle-Finding Algorithm**
Traverse linked list using two pointers. Move one pointer (slow) by one and another pointer (fast) by two. If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop
