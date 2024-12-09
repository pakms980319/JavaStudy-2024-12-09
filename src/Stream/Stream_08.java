package Stream;

public class Stream_08 {
    public static void main(String[] args) {
        /*
        * 스트림 만들기 - 파일과 빈 스트림
        *  - 파일을 소스로 하는 스트림 생성하기
        * Stream<Path> Files.list(Path dir)  // Path 는 파일 또는 디렉토리
        * 
        * Stream<String> Files.lines(Path path)  // line 단위로 읽어 Stream<String> 으로 만든다
        * Stream<String> Files.lines(Path path, Charset cs)
        * Stream<String> lines()  // BufferedReader 클래스의 메서드
        *
        * 비어있는 스트림 생성하기
        * Stream emptyStream = Stream.empty();  // empty() 는 빈 스트림을 생성해서 반환한다.
        * long count = emptyStream.count();  // count 의 값은 0
        * */
    }
}
