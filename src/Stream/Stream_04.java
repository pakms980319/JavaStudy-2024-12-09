package Stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_04 {
    public static void main(String[] args) {
        /*
        * 스트림 만들기 - 배열
        *  - 객체 배열로부터 스트림 생성하기
        * Stream<T> Stream.of(T... values)  // 가변 인자
        * Stream<T> Stream.of(T[])  // 배열
        * Stream<T> Arrays.stream(T[])  // 배열
        * Stream<T> Arrays.stream(T[] arrays, int startInclusive, int endExclusive)  // 배열의 일부만 스트림으로 생성 (마지막 end 는 안들어간다 start ~ end-1)
        *
        * 예시
        * Stream<String> strStream = Stream.of("a", "b", "c");  // 가변 인자
        * Stream<String> strStream = Stream.of(new String[]{"a", "b", "c"});  // 배열
        * Stream<String> strStream = Arrays.stream(new String[]{"a", "b", "c"});
        * Stream<String> strStream = Arrays.stream(new String[]{"a", "b", "c"}, 0, 3);
        *
        * 기본형 배열로부터 스트림 생성하기
        * IntStream IntStream.of(int... values)
        * IntStream IntStream.of(int[])
        * IntStream Arrays.stream(int[])
        * IntStream Arrays.stream(int[] array, int startInclusive, int endExclusive)
        * */

        Stream<String> strStream = Stream.of("a", "b", "c");
        Stream<String> strStream2 = Stream.of(new String[]{"a", "b", "c"});
        Stream<String> strStream3 = Arrays.stream(new String[] {"a", "b", "c"});
        strStream3.forEach(System.out::println);

//        int[] intArr = {1, 2, 3, 4, 5};
//        IntStream intStream = Arrays.stream(intArr);
//        intStream.forEach(System.out::println);
//
//        intStream = Arrays.stream(intArr);
//        System.out.println("sum=" + intStream.sum());
//
//        intStream = Arrays.stream(intArr);
//        System.out.println("average=" + intStream.average());

        Integer[] intArr = {1, 2, 3, 4, 5};
        Stream<Integer> intStream = Arrays.stream(intArr);  // 오토박싱
        intStream.forEach(System.out::println);

        intStream = Arrays.stream(intArr);
        System.out.println("count=" + intStream.count());
    }
}
