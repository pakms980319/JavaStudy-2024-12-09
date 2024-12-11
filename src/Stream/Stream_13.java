package Stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_13 {
    /*
    * 스트림의 최종연산
    *
    * 중간 연산: n번, Stream 반환 ( limit(), skip(), filter(), distinct(), map(), flatMap(), peek() )
    * 최종 연산: 1번, int, boolean, Optional ... 등 반환 ( forEach(), allMatch(), anyMatch(), noneMatch(), reduce(), findFirst(), findAny(), collect() )
    *   - 스트림이 닫힌다.
    *   - 스트림 요소 소모
    *
    * forEach()
    * void forEach(Consumer<? super T> action)  // 병렬스트림인 경우 순서가 보장되지 않음
    * void forEachOrdered(Consumer<? super T> action)  // 병렬스트림인 경우에도 순서가 보장됨
    *
    * 병렬 : 여러 쓰레드가 나눠사 작업
    *
    * IntStream.range(1, 10).sequential().forEach(System.out::print);  // 123456789
    * IntStream.range(1, 10).sequential().forEachOrdered(System.out:print);  // 123456789
    *
    * IntStream.range(1, 10).sequential().forEach(System.out::print);  // 683295714
    * IntStream.range(1, 10).sequential().forEachOrdered(System.out.print);  // 123456789
    *
    * 조건 검사 - allMatch(), anyMatch(), noneMatch()
    * boolean allMatch(Predicate<? super T> predicate)  // 모든 요소가 조건을 만족시키면 true
    * boolean anyMatch(Predicate<? super T> predicate)  // 한 요소라도 조건을 만족 시키면 true
    * boolean noneMatch(Predicate<? super T> predicate)  // 모든 요소가 조건을 만족시키지 않으면 true
    *
    * boolean hasFailedStu = stuStream.anyMatch(s->s.getTotalScore() <= 100);  // 낙제자가 있는지?
    *
    * 조건에 일치하는 요소 찾기 - findFirst(), findAny()
    * Optional<T> filterFirst()  // 첫 번째 요소를 반환, 순차 스트림에 사용
    * Optional<T> findAny()  // 아무거나 하나를 반환. 병렬 스트림에 사용
    *  - 결과가 null 일 수 있어서 Optional<T> 를 반환형으로 사용
    *
    * Optional<Student> result = stuStream.filter(s->s.getTotalScore() <= 100).findFirst();
    * Optional<Student> result = parallelStream.filter(s->s.getTotalScore() <= 100).findAny();
    *
    * reduce()
    * 스트림의 요소를 하나씩 줄여가며 누적연산 수행 (누적연산 : accumulator)
    * Optional<T> recude(BinaryOperator<T> accumulator)
    * T reduce(T identity, BinaryOperator<T> accumulator)
    * U reduce(U identity, BiFunction<U, T, U> accumulator, BinaryOperator<U> combiner)
    *
    * identity - 초기값
    * accumulator - 이전 연산결과와 스트림의 요소에 수행할 연산
    * combiner - 병렬처리된 결과를 합치는데 사용할 연산(병렬 스트림)
    *
    * 초기값이 없을때 스트림이 빈 경우 null 이므로 반환값이 Optional<T> 이다.
    *
    * int count = intStream.reduce(0, (a,b) -> a + 1);
    * int sum = intStream.reduce(0, (a,b) -> a + b);
    * int max = intStream.reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b)
    * int min = intStream.reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b)
    * */

    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .forEach(System.out::println);  // 배열 순서대로 출력된다.
        Stream.of(strArr)
                .parallel()
                .forEach(System.out::println);  // 배열 순서대로 출력되지 않는다. (병렬)
        Stream.of(strArr)
                .parallel()
                .forEachOrdered(System.out::println);  // 배열 순서대로 출력된다. (병렬)

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
        Optional<String> sWord = Stream.of(strArr).filter(s->s.charAt(0)=='s').findFirst();
        sWord = Stream.of(strArr).parallel().filter(s->s.charAt(0)=='s').findAny();

        System.out.println("noEmptyStr="+noEmptyStr);
        System.out.println("sWord="+sWord.get());

        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);  // mapToInt 는 Stream<T> -> IntStream 으로 변환한다.
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a + 1);
        int sum = intStream2.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("count="+count);
        System.out.println("sum="+sum);
        System.out.println("max="+max);
        System.out.println("min="+min);
    }
}
