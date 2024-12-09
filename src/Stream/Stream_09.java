package Stream;

public class Stream_09 {
    public static void main(String[] args) {
        /*
        * 스트림의 연산
        * 스트림이 제공하는 기능 - 중간 연산과 최종 연산
        *  - 중간 연산 : 연산결과가 스트림인 연산. 반복적으로 적용가능
        *  - 최종 연산 : 연산결과가 스트림이 아닌 연산. 단 한번만 적용가능 ( 스트림의 요소를 소모 )
        *
        * 스트림의 연산 - 중간 연산 ( 반환형 Stream<T> )
        *  Stream<T> distinct() : 중복을 제거
        *  Stream<T> filter(Predicate<T> predicate) : 조건에 안 맞는 요소 제외
        *  Stream<T> limit(long maxSize) : 스트림의 일부를 잘라낸다. (maxSize 만큼 짤라내기)
        *  Stream<T> skip(long n) : 스트림의 일부를 건너뛴다. (n개 건너뛰기)
        *  Stream<T> peek(Consumer<T> action) : 스트림의 요소에 작업수행
        *  Stream<T> sorted()
        *  Stream<T> sorted(Comparator<T> comparator - 정렬기준) : 스트림의 요소를 정렬한다.
        *  Stream<R> DoubleStream, IntStream, LongStream    Stream<R> DoubleStream, IntStream, LongStream - 스트림의 요소를 변환한다.
        *  map(Function<T, R> mapper)
        *  mapToDouble(ToDoubleFunction<T> mapper)
        *  mapToInt(ToIntFunction<T> mapper)
        *  mapToLong(ToLongFunction<T> mapper)
        *
        *  flatMap(Function<T, Stream<R>> mapper)
        *  flatMapToDouble(Function <T, DoubleStream> m)
        *  flatMapToInt(Function <T, IntStream> m)
        *  flatMapToLong(Function <T, LongStream> m)
        * 
        * 스트림의 연산 - 최종 연산
        *  void forEach(Consumer<? super T> action)
        *  void forEachOrdered(Consumer<? super T> action) (병렬 스트림의 순서 유지를 위해 사용하는 메서드) : 각 요소에 지정된 작업을 수행한다.
        *  long count() : 스트림 요소의 개수 반환
        *  Optional<T> max(Comparator<? super T> comparator)
        *  Optional<T> min(Comparator<? super T> comparator) : 스트림의 최대값/최소값을 반환
        *  Optional<T> findAny() : 스트림의 요소 하나를 반환 (아무거나), 주로 filter 와 함께 쓰인다.
        *  Optional<T> findFirst() : 스트림의 요소 하나를 반환 (첫 번째 요소)
        *  boolean allMatch(Predicate<T> p) : 주어진 조건을 모든 요소가 만족하는지 확인
        *  boolean anyMatch(Predicate<T> p) : 주어진 조건을 하나라도 만족하는지 확인
        *  boolean noneMatch(Predicate<T> p) : 주어진 조건을 모두 만족하지 않는지 확인
        *  Object[] toArray()
        *  A[] toArray(IntFunction<A[]> generator) : 스트림의 모든 요소를 배열로 반환
        *  Optional<T> reduce(BinaryOperator<T> accumulator)
        *  T reduce(T identity, BinaryOperator<T> accumulator)
        *  U reduce(U identity, BiFunction<U, T, U> accumulator, BinaryOperator<U> combiner) : 스트림의 요소를 하나씩 줄여가면서(리듀싱) 계산한다.
        *  R collect(Collector<T, A, R> collector)
        *  R collect(Supplier<R> supplier, BiConsumer<R, T> accumulator, BiConsumer<R, R> combiner) : 스트림의 요소를 수집한다. 주로 요소를 그룹화하거나 분할한 결과를 컬렉션에 담아 반환하는데 사용된다.
        * */
    }
}
