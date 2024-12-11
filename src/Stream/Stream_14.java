package Stream;

public class Stream_14 {
    /*
    * collect() 와 Collectors
    * collect() 는 Collector 를 매개변수로 하는 스트림의 최종연산
    * Object collect(Collector collector)  // Collector 를 구현한 클래스의 객체를 배개변수로
    * Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)  // 잘 쓰이지 않는다
    * 
    * reduce() 와 collect() 의 차이점
    * reduce() 는 그룹 전체 리듀싱이 가능하다.
    * collect() 는 그룹 별 리듀싱이 가능하다.
    * 
    * Collector 는 수집(collect)에 필요한 메서드를 정의해 놓은 인터페이스
    * public Interface Collector<T, A, R> {  // T(요소) 를 A 에 누적한 다음, 결과를 R 로 변환해서 반환
    * }
    * 
    * Collectors 클래스는 다양한 기능의 컬렉터(Collector 를 구현한 클래스) 를 제공한다.
    * 변환 - mapping(), toList(), toSet(), toMap(), toCollection(), ...
    * 통계 - counting(), summingInt(), averagingInt(), maxBy(), minBy(), summarizingInt(), ...
    * 문자열 결합 - joining()
    * 리듀싱 - reducing()
    * 그룹화와 분할 - groupingBy(), partitioningBy(), collectingAndThen()
    * 
    * collect() : Collector 를 매개변수로 하는 스트림의 최종 연산
    * Collector : collect() 에 필요한 메서드를 정의해 놓은 인터페이스
    * Collectors : Collector 인터페이스 구현체
    *
    * 스트림을 컬렉션, 배열로 변환
    * 스트림을 컬렉션으로 변환 - toList(), toSet(), toMap(), toCollection()
    *
    * List<String> names = stuStream.map(Student::getName)         // Stream<Student> -> Stream<String>
    *                           .collect(Collectors.toList());     // Stream<String> -> List<String>
    * ArrayList<String> list = names.stream()
    *                           .collect(Collectors.toCollection(ArrayList::new));  // Stream<String> -> ArrayList<String>
    * Map<String, Person> map = personStream
    *                               .collect(Collectors.toMap(p->p.getRegId(), p->p);  // Stream<Person> -> Map<String, Person>
    *
    * 스트림을 배열로 변환 - toArray()
    * Student[] stuNames = studentStream.toArray(Student[]::new)
    * Object[] stuNames = studentStream.toArray();  // toArray() 에 매개변수가 없다면 자동으로 Object[] 를 반환한다.
    * Student[] stuNames = studentStream.toArray();  // 자동으로 반환되는 값은 Object[] 이므로 에러가 발생한다.
    *
    * 스트림의 통계 - counting(), summingInt()
    * 스트림의 통계정보 제공 - counting(), summingInt(), maxBy(), minBy() ...
    *
    * long count = stuStream.count();
    * long count = stuStream.collect(Collectors.counting());  // count() 는 전체 카운팅, counting() 은 그룹별 카운팅이 가능하다.
    *
    * long totalScore = stuStream.mapToInt(Student::getTotalScore).sum()  // IntStream 의 sum()
    * long totalScore = stuStream.collect(Collectors.summingInt(Student::getTotalScore));
    *
    * OptionalInt topScore = studentStream.mapToInt(Student::getTotalScore).max();  // stream 이 빈 객체일 수도 있으므로 Optional 사용
    * Optional<Student> topStudent = stuStream
    *                                   .max(Comparator.comparingInt(Student::getTotalScore));
    * Optional<Student> topStudent = stuStream
    *                                   .collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
    *
    * 스트림을 리듀싱 - reducing() : 그룹 별 리듀싱이 가능하다.
    * Collector reducing(BinaryOperator<T> op)
    * Collector reducing(T identity, BinaryOperator<T> op)
    * Collector reducing(U identity, Function<T, U> mapper, BinaryOperator<U> op)  // map + reduce ( 리듀싱 하기 전 T 를 U 로 변환 작업 )
    *
    * IntStream intStream = new Random().ints(1, 46).distinct().limit(6);
    * OptionalInt max = intStream.reduce(Integer::max);
    * Optional<Integer> max = intStream.boxed().collect(Collectors.reducing(Integer::max));  // reducing 은 그룹 별 리듀싱이 가능하다.
    *  - boxed() 는 기본형 스트림을 참조형 스트림으로 변환하는 작업을 한다.
    *
    * long sum = intStream.reduce(0, (a, b) -> a + b);
    * long sum = intStream.boxed().collect(Collectors.reducing(0, (a, b) -> a + b));
    *
    * int grandTotal = stuStream.map(Student::getTotalScore).reduce(0, Integer::sum);
    * int grandTotal = stuStream.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
    *
    * 문자열 스트림의 요소를 모두 연결 - joining()
    * String studentNames = stuStream.map(Student::getName).collect(Collectors.joining());
    * String studentNames = stuStream.map(Student::getName).collect(Collectors.joining(","));  // 구분자 추가
    * String studentNames = stuStream.map(Student::getName).collect(Collectors.joining(",", "[", "]");  // 앞, 뒤로 붙일 문자열 추가
    * String studentInfo = stuStream.collect(Collectors.joining(","));  // Student 의 toString() 으로 결합된다.
    * */

    public static void main(String[] args) {

    }
}
