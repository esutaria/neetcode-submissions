class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int streak = 0;
        int max = 0;
        for (int i:nums) {
            if (i==1) {
                streak += 1;
            }
            else {
                if (streak > max) {
                    max = streak;
                }
                streak = 0;
            }
        }
        return Math.max(max, streak);
        
    }
}