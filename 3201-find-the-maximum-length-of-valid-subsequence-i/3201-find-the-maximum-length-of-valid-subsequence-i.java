class Solution {
    public int maximumLength(int[] nums) {
        int evens = 0;
        int odds = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }

        int parity = nums[0] % 2;
        int alternating = 1;
        for (int i = 1; i < n; i++) {
            int currParity = nums[i] % 2;
            if (parity != currParity) {
                alternating++;
                parity = currParity;
            }

        }

        return Math.max(Math.max(evens,odds),alternating);
    }
}