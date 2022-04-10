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
