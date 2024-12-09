package Stream;

import java.util.Random;
import java.util.stream.IntStream;

public class Stream_05 {
    public static void main(String[] args) {
        /*
        * 스트림 만들기 - 임의의 수
        *  - 난수를 요소로 갖는 스트림 생성하기
        * IntStream intStream = new Random().ints();  // 무한 스트림
        * intStream.limit(5).forEach(System.out::println);  // 5개의 요소만 출력한다.
        * IntStream intStream = new Random().ints(5);  // 킈가 5인 난수 스트림을 반환
        *
        * Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE
        * Long.MIN_VALUE <= longs() <= Long.MAX_VALUE
        * 0.0 <= doubles() < 1.0
        *
        *  - 지정된 범위의 난수를 요소로 갖는 스트림을 생성하는 메서드(Random 클래스)
        * 무한 스트림
        * IntStream ints(int begin, int end)
        * LongStream longs(long begin, long end)
        * DoubleStream doubles(double begin, double end)
        *
        * 유한 스트림
        * IntStream ints(long streamSize, int begin, int end)
        * LongStream longs(long streamSize, long begin, long end)
        * DoubleStream doubles(long streamSize, double begin, double end)
        * */

//        IntStream intStream = new Random().ints();  // 무한 난수 스트림
//        intStream
//                .limit(5)
//                .forEach(System.out::println);  // limit 를 설정해주지 않는다면 무한 반복한다.

//        IntStream intStream1 = new Random().ints(5);  // 개수 지정
//        intStream1.forEach(System.out::println);

//        IntStream intStream2 = new Random().ints(5, 10); // 5 ~ 10 범위 지정
//        intStream2
//                .limit(10)
//                .forEach(System.out::println);

        IntStream intStream3 = new Random().ints(10, 5, 10);  // 10개의 난수, 5 ~ 10 사이
        intStream3
                .limit(10)
                .forEach(System.out::println);
    }
}
