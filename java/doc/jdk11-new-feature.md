# jdk 11 新特性

## String

`String`类中新增了部分方法：`isBlank`、`lines`、`strip`、
`stripLeading`、`stripTrailing`和`repeat`。

```java
"Hello World".replace(" ", "\r\n").lines().forEach(System.out::println);
System.out.println("Hello World, ".repeat(3));
```
## 文件操作

`Files`中新增了读写`String`数据的方法：`writeString`和`readString`。

```java
Path filePath = Files.writeString(Files.createTempFile("jdk11", ".log"), "Hello World");
System.out.println(Files.readString(filePath));
```

## Collection

`Collection`接口增加了一个默认的`toArray`方法，该方法接收一个`IntFunction`类型的入参。

```java
List<String> list =Arrays.asList("Hello", "World");
list.toArray(String[]::new);
```

## Predicate增强

`Predicate`中增加了静态的`not`方法，用于排除特定条件的数据。

```java
Stream.of("Hello", " ", "World", "!").filter(Predicate.not(String::isBlank)).forEach(System.out::println);
```

## lambda表达式增加本地变量

在lambda表达式中，支持使用关键字`var`指定变量类型。

```java
Stream.of("Hello", "World").map((var s) -> s.toUpperCase()).collect(Collectors.joining(","));
```

## HttpClient

全新增加了`java.net.http.HttpClient`类。

```java
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
```

## nestmate

增加了判断两个类是否属于同一类的内嵌类的相关方法。

```java
public class NestedFeature {
    static class MainClass {
        static class NestedClass {

        }
    }

    public static void main(String[] args) {
        System.out.println(NestedFeature.class.getNestHost().getName());
        System.out.println(MainClass.class.getNestHost().getName());
        System.out.println(MainClass.NestedClass.class.getNestHost().getName());
        System.out.println(MainClass.class.isNestmateOf(MainClass.NestedClass.class));
    }
}
```

## 直接运行Java文件

jdk 11版本之后，可以直接使用命令`java HelloWorld.java`运行java源代码了。


 
