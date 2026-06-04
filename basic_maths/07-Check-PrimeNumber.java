class CheckPrimeNumber {
    //tc : O(num) sc : O(1)
    public static boolean bruteForce(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                cnt++;
        }
        return cnt == 2;
    }
    //tc : O(sqrt(num)) sc : O(1)
    public static boolean optimalApproach(int num) {
        int cnt = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                cnt++;
                if(i!=num/i)
                    cnt++;
            }
        }
        return cnt==2;
    }
    public static void main(String[] args) {
        System.out.println(bruteForce(36));
        System.out.println(optimalApproach(36));
        System.out.println(optimalApproach(3));
    }
}
