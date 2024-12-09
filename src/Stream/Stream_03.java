package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream_03 {
    public static void main(String[] args) {
        /*
        * 스트림 만들기 - 컬렉션
        *  - Collection 인터페이스의 stream() 으로 컬렉션을 스트림으로 변환
        *   Stream<E> stream()  // Collection 인터페이스의 메서드
        *
        *   List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        *   Stream<Integer> intStream = list.stream();  // list 를 스트림으로 변환
        *
        *   // 스트림의 모든 요소를 출력
        *   intStream.forEach(System.out::print);  // 12345
        *   intStream.forEach(System.out::print);  // 에러, 이미 스트림이 닫혔다.
        *   stream 은 1회용, stream 에 대해 최종 연산을 수행하면 stream 이 닫힌다.
        * */

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();

        intStream.forEach(System.out::print);  // forEach() 최종연산
        // intStream.forEach(System.out::print);  // 에러, 이미 스트림이 닫혔다.
        intStream = list.stream();
        intStream.forEach(System.out::print);
    }
}
