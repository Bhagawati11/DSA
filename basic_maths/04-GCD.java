class gcd {
    //tc : O(min(num1,num2)) sc : O(1)
    public static int bruteForce(int num1, int num2) {
        int gcdn = 1;
        for (int i = 1; i < Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcdn = i;
            }
        }
        return gcdn;
    }
    //tc : O(min(num1,num2)) sc : O(1)
    //better than brute force as we are iterating from min(num1,num2) to 1
    public static int betterApproach(int num1, int num2) {
        for (int i = Math.min(num1, num2); i > 0; i--) {
            if (num1 % i == 0 && num2 % i == 0)
                return i;
        }
        return 1;
    }

    //tc : O(log(min(num1,num2))) sc : O(1)
    public static int optimalApproach(int num1, int num2) {
        while (num1 > 0 && num2 > 0) {
            if (num1 > num2) {
                num1 -= num2;
            }
            else {
                num2 -= num1;
            }
            if (num1 == 0)
                return num2;

        }
        return num1;
    }
    public static void main(String[] args) {
        System.out.println(betterApproach(20, 15));
        System.out.println(optimalApproach(20, 15));
    }
}
