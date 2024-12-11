package Stream;

import java.sql.SQLOutput;
import java.util.Optional;
import java.util.OptionalInt;

public class Stream_12 {
    /*
    * Optional<T>
    * T 타입 객체의 래퍼클래스 - Optional<T>
    *  - 래퍼클래스 : Integer, Long 타입 같은 것 들을 포함하는 클래스
    *  - 모든 종류의 객체를 저장할 수 있다. (null 포함)
    *  - null 을 직접 다루는건 위험하기에 Optional 을 사용한다. (NullPointerException)
    *  - null 체크를 할 수 있다.
    *
    * Optional<T> 객체 생성하기
    * Optional<T> 객체를 생성하는 다양한 방법
    *
    * String str = "abc";
    * Optional<String> optVal = Optional.of(str);
    * Optional<String> optVal = Optional.of("abc");
    *
    * Optional<String> optVal = Optional.of(null);  // NullPointerException 발생
    * =>
    * Optional<String> optVal = Optional.ofNullable(null);  // OK
    * 
    * null 대신 빈 Optional<T> 객체를 사용하자
    * Optional<String> optVal = null;  // null 로 초기화, 가능은 하지만 바람직하지 않다.
    * Optional<String> optVal = Optional.<String>empty();  // 빈 객체로 초기화
    *
    * Optional<T> 객체의 값 가져오기
    * Optional 객체의 값 가져오기 - get(), orElse(), orElseGet(), orElseThrow()
    *
    * Optional<String> optVal = Optional.of("abc");
    * String str1 = optVal.get();       // optVal 에 저장된 값을 반환, null 이면 예외 발생 : 잘 사용하지 않는다
    * String str2 = optVal.orElse("");  // optVal 에 저장된 값이 null 일 때는, ""(기본값) 를 반환, 비어있지 않다면 저장된 값 반환
    * 기본값은 항상 계산되므로 null 이 아니라도 내부 값은 계산 되거나 메서드가 호출된다.
    * String str3 = optVal.orElseGet(String::new);  // 람다식 사용 가능 () -> new String()
    * 기본값이 필요하지 않을 경우, 계산되거나 호출되지 않는다.
    * String str4 = optVal.orElseThrow(NullPointerException::new);  // null 이면 예외 발생, 예외 종류를 지정해 줄 수 있다.
    *
    * isPresent() - Optional 객체의 값이 null 이면 false, 아니면 true 를 반환
    *  - 혹은 null 이 아닐때만 작업을 수행
    *
    * if (Optional.ofNullable(str).isPresent()) { System.out.println(str) }
    * Optional.ofNullable(str).ifPresent(System.out::println);
    * Optional.ofNullable(str).ifPresent((v)->System.out.println(v));
    *
    * 간결하면서도 알아보기 쉬운 코드 작성이 가능 : (성능은 좀 더 필요해짐)
    *
    * OptionalInt, OptionalLong, OptionalDouble
    * 기본형 값을 감싸는 래퍼클래스 (성능이 Optional<T> 보다 좋다)
    * 
    * 값 가져오기
    * Optional 클래스 / 값을 반환하는 메서드
    * Optional<T> / T get()
    * OptionalInt / int getAsInt()
    * OptionalLong / long getAsLong()
    * OptionalDouble / double getAsDouble()
    * 
    * 빈 Optional 객체와의 비교
    * OptionalInt opt = OptionalInt.of(0);  // OptionalInt 에 0 을 저장
    * OptionalInt opt2 = OptionalInt.empty();  // OptionalInt 에 0 을 저장
    *
    * 하지만,
    * System.out.println(opt.isPresent()); // ture
    * System.out.println(opt2.isPresent()); // false
    * System.out.println(opt.equals(opt2)); // false
    * */

    public static void main(String[] args) {
//        int[] arr = null NullPointerException 발생
        int[] arr = {};
        System.out.println("arr.length="+arr.length);

        // Optional<String> opt = null 에러는 발생하지 않지만 바람직하지 않다
        Optional<String> opt = Optional.empty();
        System.out.println(opt);  // Optional.empty
        // System.out.println(opt.get()); // 에러 발생, null 이라서
        System.out.println(opt.orElse("EMPTY"));
        System.out.println(opt.orElseGet(()->"EMPTY"));
        System.out.println(opt.orElseGet(String::new));

        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
//        Optional<Integer> optInt = optStr.map(s->s.length()); 람다식 표현
        System.out.println("optStr=" + optStr.get());  // optStr=abcde
        System.out.println("optInt=" + optInt.get());  // optInt=5

        int result1 = Optional.of("123")
                .filter(x->x.length() > 0)
                .map(Integer::parseInt).get();
        int result2 = Optional.of("")
                .filter(x->x.length() > 0)
                .map(Integer::parseInt).orElse(-1);
        System.out.println("result1="+result1);  // result1=123
        System.out.println("result2="+result2);  // result2=-1

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x-> System.out.printf("result3=%d\n", x));  // result3=456

        OptionalInt optInt1 = OptionalInt.of(0);  // 0 을 저장
        OptionalInt optInt2 = OptionalInt.empty();  // 빈 객체를 생성

        System.out.println("optInt1.isPresent(): " + optInt1.isPresent());  // optInt1.isPresent(): true
        System.out.println("optInt2.isPresent(): " + optInt2.isPresent());  // optInt2.isPresent(): false

        System.out.println("optInt1.getAsInt(): " + optInt1.getAsInt());  // optInt1.getAsInt(): 0
//        System.out.println("optInt2.getAsInt(): " + optInt2.getAsInt());  // NoSuchElementException

        System.out.println("optInt1=" + optInt1);  // optInt1=OptionalInt[0]
        System.out.println("optInt2=" + optInt2);  // optInt2=OptionalInt.empty

        System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2));  // optInt1.equals(optInt2)?false

    }
}
