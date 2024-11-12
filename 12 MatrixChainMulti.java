public class MatrixChainMultiplication {
    // Function to compute the minimum number of scalar multiplications
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1; // Number of matrices
        int[][] dp = new int[n][n];

        // dp[i][j] stores the minimum number of scalar multiplications needed
        // to multiply matrices from i to j

        // Initialize the main diagonal of the dp array to 0 because a single matrix has
        // no cost to multiply
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Chain length varies from 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE; // Initialize with a large number

                // Try placing parentheses at different positions between i and j
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];

                    // Update dp[i][j] with the minimum cost
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        // The minimum cost to multiply the chain from matrix 0 to n-1 is stored in
        // dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] dimensions = { 10, 20, 30, 40, 30 }; // Example matrix dimensions
        // Matrices: A1 (10x20), A2 (20x30), A3 (30x40), A4 (40x30)
        System.out.println("Minimum number of multiplications is " + matrixChainOrder(dimensions));
    }
}
