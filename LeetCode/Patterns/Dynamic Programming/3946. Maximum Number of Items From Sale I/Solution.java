
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }

        // Calculate value of each item
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            int freeCount = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    freeCount++;
                }
            }

            value[i] = 1 + freeCount;
        }

        // 0/1 Knapsack
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];

            for (int c = budget; c >= price; c--) {
                dp[c] = Math.max(
                    dp[c],
                    dp[c - price] + value[i]
                );
            }
        }

        // Calculate maximum total items
        int ans = 0;

        for (int c = 0; c <= budget; c++) {
            ans = Math.max(
                ans,
                dp[c] + (budget - c) / minPrice
            );
        }

        return ans;
    }
}
