public class StringNewFeature {
    public static void main(String... argv) {
        "Hello World".replace(" ", "\r\n").lines().forEach(System.out::println);
        System.out.println("Hello World, ".repeat(3));
    }
}
