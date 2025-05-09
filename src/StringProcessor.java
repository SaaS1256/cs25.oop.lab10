import java.util.*;
import java.util.function.*;

public class StringProcessor {
    public static void processStrings(List<String> strings,
                                      Predicate<String> filter,
                                      Function<String, String> transformer,
                                      Consumer<String> printer) {
        for (String s : strings) {
            if (filter.test(s)) {
                String transformed = transformer.apply(s);
                printer.accept(transformed);
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Програмчлал", "Код");

        Predicate<String> filter = word -> word.length() > 5;
        Function<String, String> transformer = word -> new StringBuilder(word).reverse().toString();
        Consumer<String> printer = word -> System.out.println("ГАРШИЛ: " + word);

        processStrings(words, filter, transformer, printer);
    }
}
