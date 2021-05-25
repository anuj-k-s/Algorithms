package com.aks.algorithm.array;

import java.util.Arrays;

/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
  The number of elements initialized in nums1 and nums2 are m and n respectively.
  You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.*/
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        mergesortedArrays(nums1,m,nums2,n);
    }

    private static void mergesortedArrays(int[] nums1, int m, int[] nums2, int n) {
       /* 122300
        122350
        122356*/
        if(m==0){
            nums1 = nums2;
        }
        for (int i = m+n -1; i > 0 ; i--) {

            if(n-1 == -1 || m-1 == -1){
                break;
            }
            if(nums1[m-1] > nums2[n-1]){
                nums1[i] = nums1[m-1];
                m--;
            }else{
                nums1[i] = nums2[n-1];
                n--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
