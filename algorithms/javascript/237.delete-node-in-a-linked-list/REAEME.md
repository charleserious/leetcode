# [237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## Description

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked lsit --head = [4, 5, 1, 9], which looks like following:

`[4] --> [5] --> [1] --> [9]`

## Example 1

```example
Input: head = [4, 5, 1, 9], node = 5
Output: [4, 1, 9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```

## Example 2

```example
Input: head = [4, 5, 1, 9], node = 1
Output: [4, 5, 9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

## Note

- The linked list will have at least two elements.
- All of the nodes' values will be unique.
- The given node will not be the tail and it will always be a valid node of the linked list.
- Do not return anything from your function.

## Solution

```javascript
function ListNode (val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} node
 * @return {undefined} Do not return anything, modify node in-place instead.
 */
const deleteNode = (node) => {
  node.val = node.next.val;
  node.next = node.next.next;
}
```
