import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(2, 2, 3, 3, 5, 6, 8, 8, 1, 9);
        findMinMax(integerList.stream(), Integer::compareTo, (x, y) -> System.out.println("min " + x + "; max " + y));
        findEvenCount(integerList);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).toList(); //Идея предложила collect(Collectors.toList()) заменить на просто .toList()
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        }
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }

    public static void findEvenCount(List<Integer> list) {
        System.out.println(list.stream()
                .filter(x -> x % 2 == 0)
                .count());
    }

}