package Stream;

public class Stream_16 {
    /*
    * 스트림의 그룹화 - groupingBy()
    * groupingBy() 는 스트림을 n 분할한다.
     * Collector groupingBy(Function classifier)
     * Collector groupingBy(Function classifier, Collector downstream)
     * Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
     *
     * Map<Integer, List<Student>> stuByBan = stuStream
     *               .collect(Collectors.groupingBy(Student::getBan, toList()));  // toList() 생략 가능, default 값
     *
     * Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = stuStream
     *               .collect(Collectors.groupingBy(Student::getHak,
     *                       Collectors.groupingBy(Student::getBan)
     *               ));
     *
     * Map<Integer, Map<Integer, Set<Student.Level>>> stuByHakAndBan = stuStream
     *               .collect(Collectors.groupingBy(Student::getHak, Collectors.groupingBy(Student::getBan,
     *                       Collectors.mapping(s -> {
     *                           if (s.getScore() >= 200) return Student.Level.HIGH;
     *                           else if (s.getScore() >= 100) return Student.Level.MID;
     *                           else return Student.Level.LOW;
     *                           }, toSet())
     *                   ))
     *   );
    * */

    public static void main(String[] args) {

    }
}

class Student3 {
    String name;
    boolean isMale;  // 성별
    int hak;  // 학년
    int ban;  // 반
    int score;

    public Student3(String name, boolean isMale, int hak, int ban, int score) {
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