public class LongestSubarrayAfterDeletingOneElement {
    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ++count;
            }
        }

        if (count == n) {
            return count - 1;
        }

        int max = Integer.MIN_VALUE;
        int prev_count = 0;
        int curr_count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, curr_count);
                curr_count -= prev_count;
                prev_count = curr_count;

                if (curr_count == 0) {
                    curr_count = prev_count = 0;
                }
            } else {
                ++curr_count;
            }
        }

        max = Math.max(max, curr_count);
        return max;
    }
}