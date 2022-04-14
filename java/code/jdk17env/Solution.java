import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(c -> Arrays.stream(c).sum()).max(Comparator.naturalOrder()).orElse(0);
    }
}