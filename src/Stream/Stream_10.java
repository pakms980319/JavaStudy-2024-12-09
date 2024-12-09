package Stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Stream_10 {
    public static void main(String[] args) {
        /*
        * 스트림의 중간연산
        *
        * 스트림 자르기 - skip(), limit()
        * Stream<T> skip(long n)  // 앞에서부터 n개 건너뛰기
        * Stream<T> limit(long maxSize)  // maxSize 이후의 요소는 잘라냄
        *
        * IntStream intStream = IntStream.rangeClosed(1, 10);  // 12345678910
        * intStream.skip(3).limit(5).forEach(System.out::print);  // 45678
        *
        * 스트림 요소 걸러내기 - filter(), distinct()
        * Stream<T> filter(Predicate<? super T> predicate)  // 조건에 맞지 않는 요소 제거
        * Stream<T> distinct()
        *
        * IntStream intStream = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
        * intStream.distinct().forEach(System.out::print);  // 123456
        *
        * IntStream intStream = IntStream.rangeClosed(1, 10);  // 12345678910
        * intStream.filter(i->i%2==0).forEach(System.out::print); // 246810
        *
        * intStream.filter(i->i%2!=0 && i%3 !=0).forEach(System.out::print);
        * intStream.filter(i->i%2!=0).filter(i->i%3!=0).forEach(System.out::print);
        * filter 는 중간 연산이므로 여러번 사용할 수 있다.
        * 조건문을 논리 연산자로 이어 작성할 수 있다.
        * 
        * 스트림 정렬하기 - sorted()
        * Stream<T> sorted()  // 스트림 요소의 기본 정렬(Comparable)로 정렬
        * Stream<T> sorted(Comparator<? super T> comparator)  // 지정된 Comparator 로 정렬
        * 
        * 문자열 스트림 정렬 방법, 출력 결과
        * strStream.sorted()  // 기본 정렬
        * strStream.sorted(Comparator.naturalOrder())  // 기본 정렬
        * strStream.sorted((s1, s2) -> s1.compareTo(s2));  // 람다식도 가능
        * strStream.sorted(String::compareTo);  // 위 문장과 동일
        * 출력 결과 : CCaaabccdd
        * 
        * strStream.sorted(Comparator.reverseOrder())  // 기본 정렬의 역순
        * strStream.sorted(Comparator.<String>naturalOrder().reversed())
        * 출력 결과 : ddccbaaaCC
        * 
        * strStream.sorted(String.CASE_INSENSITIVE_ORDER);  // 대소문자 구문안함
        * 출력 결과 : aaabCCccdd
        * 
        * strStream.sorted(String.CASE_INSENSITIVE_ORDER.reversed())  // 대소문자 구분안함 & 역순
        * 출력 결과 : ddCCccbaaa
        * 
        * strStream.sorted(Comparator.comparing(String::length))  // 길이 순 정렬
        * strStream.sorted(Comparator.comparingInt(String::length))  // no 오토박싱
        * 출력 결과 : bddCCccaaa
        * 
        * strStream.sorted(Comparator.comparing(String::length).reversed))  // 길이 순 정렬 역순
        * 출력 결과 : aaaddCCccb
        *
        *
        * Comparator 의 comparing() 으로 정렬 기준을 제공
        *  comparing(Function<T, U> keyExtractor)
        *  comparing(Function<T, U> keyExtractor, Comparator<U> keyComparator)
        *
        * studentStream.sorted(Comparator.comparing(Student::getBan))  // 반별로 정렬
        *              .forEach(System.out.println);
        *
        * 추가 정렬 기준을 제공할 때는 thenComparing() 을 사용
        *  thenComparing(Comparator<T> other)
        *  thenComparing(Function<T, U> keyExtractor)
        *  thenComparing(Function<T, U> keyExtractor, Comparator<U> keyComp)
        *
        * studentStream.sorted(Comparator.comparing(Student::getBan)  // 반 별로 정렬
        *                                .thenComparing(Student::getTotalScore)  // 총점별로 정렬
        *                                .thenComparing(Student::getName))  // 이름별로 정렬
        *               .forEach(System.out.println);
        * */

        Stream<Student> studentStream = Stream.of(
                    new Student("이자바", 3, 300),
                    new Student("김자바", 1, 200),
                    new Student("안자바", 2, 100),
                    new Student("박자바", 2, 150),
                    new Student("소자바", 1, 200),
                    new Student("나자바", 3, 290),
                    new Student("감자바", 3, 100)
                );
//        studentStream.sorted(Comparator.comparing(Student::getBan)  // 반별 정렬
          studentStream.sorted(Comparator.comparing((Student s) -> s.getBan())  // 람다식
                .thenComparing(Comparator.naturalOrder()))  // 기본 정렬
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    // 총점 내림차순을 기본 정렬로 한다.
    @Override
    public int compareTo(Student o) {
        return o.totalScore - this.totalScore;
    }
}
