class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 각 배열의 전체 최대공약수 구하기
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int answerA = check(gcdA, arrayB) ? gcdA : 0;
        int answerB = check(gcdB, arrayA) ? gcdB : 0;

        return Math.max(answerA, answerB);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private boolean check(int divisor, int[] array) {
        for (int number : array) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}