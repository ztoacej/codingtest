class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = arr[0];

        // 가장 작은 값 찾기
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        // 가장 작은 값을 제외한 배열 생성
        int[] answer = new int[arr.length - 1];
        int index = 0;

        for (int num : arr) {
            if (num != min) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}