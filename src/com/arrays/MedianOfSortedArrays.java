package com.arrays;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 5, 8 };
        int[] arr2 = { 2, 6, 7, 9 };

        System.out.println(findMedian(arr1, arr2));

        // 1 3 4 5 8
        // 2 6 7 9
    }

    private static double findMedian(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n)
            return findMedian(nums2, nums1);

        int low = 0;
        int high = m;

        while (low <= high) {
            int pIdx1 = (low + high) / 2; // parition of nums1
            int pIdx2 = ((m + n + 1) / 2) - pIdx1; // partition of nums2

            int maxLeft1 = pIdx1 == 0 ? Integer.MIN_VALUE : nums1[pIdx1 - 1];
            int maxLeft2 = pIdx2 == 0 ? Integer.MIN_VALUE : nums2[pIdx2 - 1];
            int minRight1 = pIdx1 == m ? Integer.MAX_VALUE : nums1[pIdx1];
            int minRight2 = pIdx2 == n ? Integer.MAX_VALUE : nums2[pIdx2];

            if ((maxLeft1 <= minRight2) && (maxLeft2 <= minRight1)) {
                if (((m + n) % 2) == 0)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                else
                    return (double) Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                high = pIdx1 - 1;
            } else {
                low = pIdx1 + 1;
            }
        }

        return 0.0;
    }
}
