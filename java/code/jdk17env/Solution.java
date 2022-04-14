import java.io.IOException;

class Solution {
    public static void main(String... argv) throws IOException {
        System.out.println("1110".chars().filter(c -> c == '1').count());
    }
}