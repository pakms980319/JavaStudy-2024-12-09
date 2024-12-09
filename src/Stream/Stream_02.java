package Stream;

public class Stream_02 {
    public static void main(String[] args) {
        /*
        * 스트림(Stream)의 특징
        *   - 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않는다. (원본 변경 X)
        * 
        * List<Integer> list = Arrays.asList(3, 1, 5, 4, 2);
        * List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());  // 새로운 List 에 저장
        * System.out.println(list);  // [3, 1, 5, 4, 2] 원본의 변경이 없다.
        * System.out.println(sortedList);  // [1, 2, 3, 4, 5]
        *
        *   - 스트림은 Iterator 처럼 일회용이다. (필요하면 다시 스트림을 생성해야 한다)
        * strStream.forEach(System.out::println);  // 모든 요소 화면에 출력 (최종 연산)
        * int numOfStr = strStream.count();  // 에러, 스트림이 이미 닫혔다. (스트림을 다시 만들어야 한다)
        *
        *   - 스트림은 최종 연산 전까지 중간연산이 수행되지 않는다. - 지연된 연산
        * IntStream intStream = new Random().ints(1, 46);  // 1~45 범위의 무한 스트림 ( 반대는 유한 스트림이 있다 )
        * intStream.distinct().limit(6).sorted()  // 중간 연산 ( 무한 스트림이라도 중복 제거를 실행할 수 있다, 최종 연산 전 까지는 중간 연산이 수행되지 않기 때문이다. - 지연된 연산 )
        * .forEach(i -> System.out.print(i + ", ");  // 최종 연산
        *
        *   - 스트림은 작업을 내부 반복으로 처리한다. - 코드가 간결해진다.
        * for(String str : strList)
        *   System.out.println(str);
        * =>
        * strList.stream().forEach(System.out.println);
        *
        *   - 스트림의 작업을 병렬로 처리 - 병렬 스트림 (멀티 쓰레드)
        * Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
        * int sum = strStream.parallel()  // 병렬 스트림으로 전환 (속성만 변경)
        *                   .mapToInt(s -> s.length()).sum();  // 모든 문자열 길이의 합
        * 
        *   - 기본형 스트림 - IntStream, LongStream, DoubleStream ...
        * 오토박싱&언박싱의 비효율이 제거됨(Stream<Integer> 대신 IntStream 사용)
        * 숫자와 관련된 유용한 메서드를 Stream<T> 보다 더 많이 제공 ( sum, count, average ... )
        * int[] arr = {1, 2, 3}; => new Integer ... 오토박싱, 언박싱 과정
        * 데이터 소스가 기본형일 때 사용할 수 있다.
        * */
    }
}
