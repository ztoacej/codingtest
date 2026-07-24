class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] scores = new int[26];

        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);

            if (choices[i] < 4) {
                scores[disagree - 'A'] += 4 - choices[i];
            } else if (choices[i] > 4) {
                scores[agree - 'A'] += choices[i] - 4;
            }
        }

        StringBuilder answer = new StringBuilder();

        answer.append(
                scores['R' - 'A'] >= scores['T' - 'A'] ? 'R' : 'T'
        );
        answer.append(
                scores['C' - 'A'] >= scores['F' - 'A'] ? 'C' : 'F'
        );
        answer.append(
                scores['J' - 'A'] >= scores['M' - 'A'] ? 'J' : 'M'
        );
        answer.append(
                scores['A' - 'A'] >= scores['N' - 'A'] ? 'A' : 'N'
        );

        return answer.toString();
    }
}