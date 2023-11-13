package View;

public class OutputView {
	private static final String OUTPUT_START_EVENT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
	private static final String OUTPUT_ORDER_MENU = "<주문 메뉴>";
	private static final String OUTPUT_WOO_EVENT = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

	public static void openingtMent() {
		System.out.println(OUTPUT_START_EVENT);

	}

	public static void eventBenefit() {
		System.out.println(OUTPUT_WOO_EVENT);
	}

	public static void orderMenu() {
		System.out.println(OUTPUT_ORDER_MENU);
	}

}
