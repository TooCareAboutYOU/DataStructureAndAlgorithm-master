package com.datastructureandalgorithm.main;

/**
 *
 */
public class Solution {


    public static void main(String[] args) {
        int[] num= new int[]{3,2,3};
        twoSum(num,6);
    }

    public static int[] twoSum(int[] nums, int target) {

        int len=nums.length;
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    System.out.println("返回：pos1：" + i + "\t\tpos2：" + (j));
                    System.out.println("返回：" + nums[i] + "\t\t" + nums[j]);
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
