package Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stream11 {
    /*
    * 스트림의 중간연산(2)
    * map()
    * Stream<R> map(Function<? super T, ? extends R> mapper)
    *
    * 예시
    * Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.bak"), new File("Ex2.java", new File("Ex1.txt"));
    *
    * 1)
    * Stream<String> filenameStream = fileStream.map(File::getName);
    * filenameStream.forEach(System.out.println);  // 스트림의 모든 파일의 이름을 출력
    *
    * 2)
    * fileStream.map(File::getName)
    *           .filter(s->s.indexOf('.') != 1)         // 확장자가 없는 것은 제외
    *           .map(s->s.substring(s.indexOf('.'))+1))
    *           .map(String::toUpperCase)
    *           .distinct()                             // 중복 제거
    *           .forEach(System.out::print)             // JAVABAKTXT
    *
    * peek()
    * Stream<T> peek(Consumer<? super T> action)        // 중간 연산 (스트림을 소비하지 않는다)
    * void forEach(Consumer<? super T> action)          // 최종 연산 (스트림을 소비한다)
    *
    * 중간 작업결과 확인, 디버깅, 로깅
    *
    * 예시)
     * fileStream.map(File::getName)
     *           .filter(s->s.indexOf('.') != 1)
     *           .peek(s->System.out.printf("filename=%s\n", s))  // 파일명 출력
     *           .map(s->s.substring(s.indexOf('.'))+1))
     *           .peek(s->System.out.printf("extension=%s\n", s)) // 확장자를 출력
     *           .forEach(System.out::print
     *
     * flatMap()
     * 스트림의 스트림을 스트림으로 변환
     * Stream<String []> strArrstrm = Stream.of(new String[] {"abc", "def", "ghi"}, new String[] {"ABC", "GHI", "JKLMN"});
     * Stream<Stream<String>> strStrStrm = strArrStrm.map(Arrays::stream);
     * Stream<String> strStrStrm = strArrStrm.flatMap(Arrays::stream);  // 하나의 배열로 변환
    * */

    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
          new String[] {"abc", "def", "jkl"},
          new String[] {"ABC", "GHI", "JKL"}
        );

//        Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
          "Believe or not It is true",
          "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))  // 하나 이상의 공백
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
