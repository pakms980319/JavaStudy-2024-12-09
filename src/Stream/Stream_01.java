package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_01 {
    public static void main(String[] args) {
        /*
         * 스트림 (Stream)
         * 다양한 데이터 소스를 표쥰화된 방법으로 다루기 위한 것
         *  - 흘러가는 시냇물 (데이터의 연속적인 흐름)
         *  - 다양한 데이터 소스 : 컬렉션, 배열 ...
         *  - 똑같은 방식으로 작업을 처리할 수 있다. ( 중간 연산(n번), 최종 연산(1번) )
         *  - Stream<T> Collection stream()
         *
         * 스트림 수행 과정 ( 3 단계 )
         *  1. 스트림 만들기
         *  2. 중간 연산 ( 0 ~ n 번 )
         *  3. 최종 연산 ( 결과, 0 ~ 1번 )
         *
         * 예시
         * stream().distinct().limit(5).sorted().forEach(System.out::println)
         * 
         * distinct() : 중복 제거
         * limit(5) : 5개로 짜르기
         * sorted() : 정렬
         * forEach() : 반복문
         *
         * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
         * Stream<Integer> intStream = list.stream();  // 컬렉션
         * Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});  // 배열
         * Stream<Integer> evenStream = Stream.iterate(0, n->n+2);  // 0, 2, 4, 6 ...
         * Stream<Double> randomStream = Stream.generate(Math::random);  // 람다식
         * IntStream intStream2 = new Random().ints(5);  // 난수 스트림 (크기가 5)
         *
         * String[] strArr = {"dd", "aaa", "CC", "cc", b} ;
         * Stream<String> stream = Stream.of(strArr);  // 문자열 배열이 소스인 스트림
         * Stream<String> filteredStream = stream.filter();  // 걸러내기 (중간 연산)
         * Stream<String> distinctedStream = stream.distinct();  // 중복제거 (중간 연산)
         * Stream<String> sortedStream = stream.sort();  // 정렬 (중간 연산)
         * Stream<String> limitedStream = stream.limit(5);  // 스트림 자르기 (중간 연산)
         * int total = stream.count();  // 요소 개수 세기 (최종 연산)
         */
    }
}
