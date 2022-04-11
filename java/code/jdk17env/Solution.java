public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 1;
        int remain = 10;
        while (n-- != 0) {
            result *= remain;
        }
        return result + 1;
    }
}