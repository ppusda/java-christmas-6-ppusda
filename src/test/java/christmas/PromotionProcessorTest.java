package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PromotionProcessorTest extends NsTest {

    @Test
    @DisplayName("전체 게임 문구 출력 확인")
    void run() {
        assertSimpleTest(() -> {
            run("3", "해산물파스타-2,레드와인-1,초코케이크-1");
            assertThat(output()).contains(
                    "<주문 메뉴>",
                    "해산물파스타 2개",
                    "레드와인 1개",
                    "초코케이크 1개",
                    "<할인 전 총주문 금액>",
                    "145,000원",
                    "<증정 메뉴>",
                    "샴페인 1개",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -1,200원",
                    "평일 할인: -2,023원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원",
                    "<총혜택 금액>",
                    "-29,223원",
                    "<할인 후 예상 결제 금액>",
                    "115,777원",
                    "<12월 이벤트 배지>",
                    "산타"
            );
        });
    }

    @Test
    @DisplayName("에러를 포함한 전체 게임 문구 출력 확인")
    void runWithError() {
        assertSimpleTest(() -> {
            run("test", "3", "해산물파스타-2,레드와인-1,해산물파스타-1",
                    "해산물파스타-2,레드와인-1,초코케이크-1");
            assertThat(output()).contains(
                    "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.",
                    "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.",
                    "<주문 메뉴>",
                    "해산물파스타 2개",
                    "레드와인 1개",
                    "초코케이크 1개",
                    "<할인 전 총주문 금액>",
                    "145,000원",
                    "<증정 메뉴>",
                    "샴페인 1개",
                    "<혜택 내역>",
                    "크리스마스 디데이 할인: -1,200원",
                    "평일 할인: -2,023원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원",
                    "<총혜택 금액>",
                    "-29,223원",
                    "<할인 후 예상 결제 금액>",
                    "115,777원",
                    "<12월 이벤트 배지>",
                    "산타"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}