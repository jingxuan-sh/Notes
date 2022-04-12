class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[]{0, 0};
        for (int i=0; i<s.length(); i++) {
            int occupySize = widths[s.charAt(i) - 'a'];
            if (result[1] + occupySize > 100) {
                result[0]++;
                result[1] = occupySize;
                continue;
            }

            result[1] += occupySize;
        }

        if (result[1] != 0) {
            result[0]++;
        }

        return result;
    }
}