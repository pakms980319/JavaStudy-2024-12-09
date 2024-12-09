package Stream;

import java.util.stream.Stream;

public class Stream_07 {
    public static void main(String[] args) {
        /*
        * 스트림 만들기 - 람다식 iterate(), generate() 무한 스트림 (limit 로 짤라 줘야 한다)
        *  - 람다식을 소스로 하는 스트림 생성하기
        * static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)  // 이전 요소에 종속적, seed 는 초기값
        * static <T> Stream<T> generate(Supplier<T> s)  // 이전 요소에 독립적
        *
        *  - iterate() 는 이전 요소를 seed 로 해서 다음 요소를 계산한다.
        * Stream(Integer) evenStream = Stream.iterate(0, n->n+2);  // 0, 2, 4, 6 ...
        *
        *  - generate() 는 seed 를 사용하지 않는다.
        * Stream<Double> randomStream = Stream.generate(Math::random);
        * Stream<Integer> oneStream = Stream.generate(()->1);
        *
        * iterate(T seed, UnaryOperator f) UnaryOperator : 단항 연산자
        * generate(Supplier s) : 주기만 하는 것, 입력 X 출력 O
        * */

//        Stream<Integer> intStream = Stream.iterate(0, n -> n + 2);
//        intStream.limit(10).forEach(System.out::println);  // 짝수 스트림
//
//        intStream = Stream.iterate(1, n -> n + 2);
//        intStream.limit(10).forEach(System.out::println);  // 홀수 스트림

        Stream<Integer> oneStream = Stream.generate(() -> 1);
        oneStream.limit(10).forEach(System.out::println);
    }
}
