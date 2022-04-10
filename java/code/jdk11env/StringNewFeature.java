import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringNewFeature {
    public static void main(String... argv) throws IOException, InterruptedException {
        "Hello World".replace(" ", "\r\n").lines().forEach(System.out::println);
        System.out.println("Hello World, ".repeat(3));

        Path filePath = Files.writeString(Files.createTempFile("jdk11", ".log"), "Hello World");
        System.out.println(Files.readString(filePath));

        List<String> list =Arrays.asList("Hello", "World");
        list.toArray(String[]::new);

        Stream.of("Hello", " ", "World", "!").filter(Predicate.not(String::isBlank)).forEach(System.out::println);

        Stream.of("Hello", "World").map((var s) -> s.toUpperCase()).collect(Collectors.joining(","));


        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.baidu.com"))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}
