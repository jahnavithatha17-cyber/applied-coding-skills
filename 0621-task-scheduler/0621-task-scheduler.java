class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Number of tasks having the maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        /*
         * Arrange the most frequent tasks first.
         *
         * Example:
         * A A A, n = 2
         *
         * A _ _ A _ _ A
         *
         * There are (maxFreq - 1) gaps,
         * each having n + 1 positions.
         */
        int result = (maxFreq - 1) * (n + 1) + maxCount;

        // We don't need idle time if there are enough other tasks.
        return Math.max(result, tasks.length);
    }
}
