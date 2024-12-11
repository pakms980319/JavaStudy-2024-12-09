package Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_15 {
    /*
    * 스트림의 그룹화와 분할 (1)
    * partitioningBy() 는 스트림을 2분할한다.
    * Collector partitioningBy(Predicate predicate)
    * Collector partitioningBy(Predicate predicate, Collector downstream)
    *
    * 분할
    * Map<Boolean, List<Student>> stuBySex = stuStream
    *                                   .collect(partitioningBy(Student::isMale));  // 학생들을 성별로 분할
    * List<Student> maleStudent = stuBySex.get(true);  // Map 에서 남학생 목록을 얻는다.
    * List<Student> femaleStudent = stuBySex.get(false);  // Map 에서 여학생 목록을 얻는다.
    *
    * 분할 + 통계
    * Map<Boolean, Long> stuNumBySex = stuStream
    *                                   .collect(partitioningBy(Student::isMale, Collectors.counting()));
    * System.out.println("남학생 수 : " + stuNumBySex.get(true));
    * System.out.println("여학생 수 : " + stuNumBySex.get(false));
    *
    * Map<Boolean, Optional<Student>> topScoreBySex = stuStream
    *                                   .collect(partitioningBy(Student::isMale, Collectors.maxBy(Comparator.comparingInt(Student::getScore))));
    * System.out.println("남학생 1등 : " + topScoreBySex.get(true));
    * System.out.println("여학생 1등 : " + topScoreBySex.get(false));
    *
    * Map<Boolean, Map<Boolean, List<Student>>> failedStuBySex = stuStream
    *                                   .collect(partitioningBy(Student.isMale,
    *                                               partitioningBy(s -> s.getScore < 150)));
    * 1. 성별로 분할 (남/녀)
    * 2. 성적으로 분할 (불합격/합격)
    * List<Student> failedMaleStu = failedStuBySex.get(true).get(true);
    * List<Student> failedFemaleStu = failedStuBySex.get(false).get(true);
    *
    * groupingBy() 는 스트림을 n분할한다.
    * */

    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true, 1, 1, 300),
                new Student2("김지미", true, 1, 2, 200),
                new Student2("이자바", true, 1, 2, 100),
                new Student2("나자바", true, 1, 3, 150),
                new Student2("황지미", false, 1, 3, 50),
                new Student2("황지미", false, 2, 1, 200),
                new Student2("김지미", false, 2, 1, 250),
                new Student2("김지미", false, 2, 2, 150),
                new Student2("이자바", false, 2, 2, 100),
                new Student2("나자바", true, 2, 3, 200),
                new Student2("김지미", true, 1, 1, 300),
                new Student2("이자바", true, 1, 2, 200),
                new Student2("황지미", false, 1, 2, 50),
                new Student2("나자바", true, 1, 3, 150),
                new Student2("이자바", true, 1, 3, 100),
                new Student2("황지미", false, 2, 1, 250),
                new Student2("김지미", false, 2, 1, 200),
                new Student2("나자바", true, 2, 2, 300),
                new Student2("황지미", false, 2, 2, 150),
                new Student2("이자바", false, 2, 3, 100)
        };

        System.out.println("1. 단순분할(성별로 분할)\n");
        Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale));

        List<Student2> maleStudent = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        maleStudent.forEach(System.out::println);
        femaleStudent.forEach(System.out::println);


        System.out.println("2. 단순분할 + 통계(성별 학생수)");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale, Collectors.counting()));

        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여하생 수 : " + stuNumBySex.get(false));

        System.out.println("3. 단순분할 + 통계(성별 1등)");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale, Collectors.maxBy(Comparator.comparingInt(Student2::getScore))));
        System.out.println("남학생 1등 : " + topScoreBySex.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex.get(false));

        System.out.println("4. 단순분할 + 통계(성별 1등) non Optional");
        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student2::getScore)), Optional::get
                        )
                ));
        System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + topScoreBySex2.get(false));


        System.out.println("5. 다중분할(성별 불합격자, 100점이하)");

        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student2::isMale,
                        Collectors.partitioningBy(s->s.getScore() <= 100)));
        List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

        failedMaleStu.forEach(System.out::println);
        failedFemaleStu.forEach(System.out::println);
    }
}

class Student2 {
    String name;
    boolean isMale;  // 성별
    int hak;  // 학년
    int ban;  // 반
    int score;

    public Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반 %3d점",
                this.name, this.isMale ? "남" : "여", this.hak, this.ban, this.score);
    }

    // groupingBy() 에서 사용
    enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류
}