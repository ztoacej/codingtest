class Solution {
    public int[] solution(String s) {
        int convertCount = 0;
        int removedZero = 0;

        while (!s.equals("1")) {
            int oneCount = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                } else {
                    removedZero++;
                }
            }

            s = Integer.toBinaryString(oneCount);
            convertCount++;
        }

        return new int[]{convertCount, removedZero};
    }
}