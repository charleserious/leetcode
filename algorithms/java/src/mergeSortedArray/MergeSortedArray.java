// Source: https://leetcode.com/problems/merge-sorted-array/

/************************************************************
 *
 * Given two sorted integer arrays *num1* and *nums2* into *nums1* as one sorted array.
 *
 * Note:
 * - The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.
 * - You may assume that *nums1* has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Given: nums1 = [1, 2, 3, 0, 0, 0], m = 3; nums1 = [2, 5, 6], n = 3
 * Should return [1, 2, 2, 4, 5, 6]
 ***********************************************************/
package mergeSortedArray;

class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1; // index of the last element of the merged array
    while (i >= 0 && j >= 0) {
      nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
    }

    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}
