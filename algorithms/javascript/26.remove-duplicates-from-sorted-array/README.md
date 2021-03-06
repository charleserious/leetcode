# [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Description

Given a sorted array `nums`, remove the duplicates **in-place** such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory
.

## Example 1

```example
Given nums = [1, 1, 2];
Your function should return length = 2, with the first two element of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.
```

## Example 2

```example
Given nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
Your function should return length = 5, with the first five element of nums being modifyed to  0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.
```

## Clarification

Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by **reference**, which means modification to the input array whill be known to the caller as well.

Internally you can think of this:

```javascript
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
  print(nums[i]);
}
```

## Solution

```javascript
const removeDuplicates = nums => {
  if (!nums || !nums.length) return 0;
  if (nums.length === 1) return 1;
  // count the deleted element
  let deleted = 0;
  // loop through the array delete the elemet if hit to be duplicates by compair with the previews one
  nums.forEach((m, i, nums) => {
    if (m === nums[i - 1]) {
      delete nums[i - 1];
      deleted += 1;
    }
  });
  nums.sort((a, b) => a - b);
  // return the array length minus the delete element, that what we got.
  return nums.length - deleted;
};

const nums = [0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4];
const len = removeDuplicates(nums);
console.log(len); // 5
```
