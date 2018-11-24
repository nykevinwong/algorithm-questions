package test;

public class MaxDiffOddEven {

    // max difference between old - even
    public static void main(String[] args) {
        int[] nums = new int[] {5,2,26,7,9,4,1,13,22,15,24,3};

        // assume minvalue and maxvalue don't exist in nums array
        int minEven = Integer.MAX_VALUE; int maxDiff = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0) // if it's an even number
                minEven = Math.min(nums[i], minEven);
            else
            {
                int oddNum = nums[i];
                int curDiff = oddNum - minEven;
                maxDiff = Math.max(curDiff, maxDiff);
            }
        }


        System.out.printf("The max difference between odd(j) and even(i) where odd > even and j > i: %d", maxDiff);
    }
}
