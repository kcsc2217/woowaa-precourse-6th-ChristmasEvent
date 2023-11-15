package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }
    
    @Test
    void 유효하지_않은_메뉴_주문_테스트() {
        assertSimpleTest(() -> {
            runException("3", "비빔면-1,제로콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    
    @Test
    void 중복_주문_테스트() {
        assertSimpleTest(() -> {
            runException("3", "시저샐러드-1,시저샐러드-1");
            assertThat(output()).contains("[ERROR] 중복된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
        });
    }
    
    @Test
    void 메뉴_형식_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "시저샐러드1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    
    
    @Test
    void 음료만_주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-2,레드와인-1,샴페인-1");
            assertThat(output()).contains("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.");
        });
    }

    
    

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }
   

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
