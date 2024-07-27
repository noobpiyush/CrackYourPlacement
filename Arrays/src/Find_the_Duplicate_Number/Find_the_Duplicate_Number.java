package Find_the_Duplicate_Number;

import java.util.Arrays;

public class Find_the_Duplicate_Number {

    public int findDuplicateBrute(int[] nums) {

        for(int i = 0;i< nums.length;i++){

            for(int j = i+1;j< nums.length;j++){

                if(nums[i] == nums[j]){
                    return nums[i];
                }

            }
        }

        return 1;
    }
    public int findDuplicate_better1(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0;i<n;i++){
            if (nums[i] == nums[i+1]){
                return nums[i];
            }
        }

        return -1;
    }

    public int findDuplicate_better2(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n+1];

        for (int i =0;i<n;i++){
            if (freq[nums[i]] == 0){
                freq[nums[i]] += 1;
            }
            else return nums[i];
        }

        return -1;
    }
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
