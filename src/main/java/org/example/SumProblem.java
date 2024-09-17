package org.example;

import java.util.*;

public class SumProblem {

    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                result.add(List.of(complement, i));
            map.put(nums[i], i);
        }
        return result;
    }

    public List<Integer> twoSum2p(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return List.of(nums[left], nums[right]);
            else if (sum < target)
                left++;
            else
                right--;
        }
        return Collections.emptyList();
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        // Sort the array to make it easier to avoid duplicates and apply the two-pointer technique
        Arrays.sort(nums);

        // Result list to store all unique triplets
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through the array, fixing one number at a time (nums[i])
        for (int i = 0; i < nums.length; i++) {
            // If the current number is greater than the target, no point in continuing (since the array is sorted)
            if (nums[i] > target)
                break;

            // Skip duplicate values for nums[i] to avoid adding the same triplet multiple times
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Two-pointer approach: left starts after i, right starts at the end of the array
            int left = i + 1;
            int right = nums.length - 1;

            // Use the two-pointer technique to find pairs that, with nums[i], sum up to the target
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If we find a valid triplet, add it to the result list
                if (sum == target) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // Move both pointers inward to find the next potential triplet
                    left++;
                    right--;

                    // Skip duplicate values for the left pointer to avoid repeating the same triplet
                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    // Skip duplicate values for the right pointer to avoid repeating the same triplet
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }
                // If the sum is less than the target, move the left pointer to increase the sum
                else if (sum < target) {
                    left++;
                }
                // If the sum is greater than the target, move the right pointer to decrease the sum
                else {
                    right--;
                }
            }
        }
        // Return the list of unique triplets
        return result;
    }


    public List<Integer> threeSum3p(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == target)
                    return List.of(nums[left], nums[mid], nums[right]);
                else if (sum > target)
                    right--;
                else
                    left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SumProblem sum = new SumProblem();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(sum.twoSum(new int[]{2, 1, 8, 3, 1, 10, 4}, 12));
        System.out.println(sum.twoSum(new int[]{7, 0, 1, 2, -1, -4, 6}, 3));
        System.out.println(sum.twoSum(new int[]{2, 9, 1, 8, 3, 1, 10, 4}, 12));
        System.out.println(sum.twoSum2p(nums, 0));

        System.out.println(sum.threeSum3p(new int[]{2, 9, 1, 8, 3, 1, 10, 4}, 12));
        System.out.println(sum.threeSum(new int[]{2, 9, 1, 8, 3, 1, 10, 4}, 12));
        System.out.println(sum.threeSum(new int[]{-3, -3, -2, -1, 0, 1, 2, 2, 3}, 0));
    }
}
