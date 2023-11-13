package View;

public class OutputView {
	private static final String OUTPUT_START_EVENT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
	private static final String OUTPUT_ORDER_MENU = "<주문 메뉴>";
	private static final String OUTPUT_WOO_EVENT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기! \n";
	private static final String OUTPUT_SALE_BEFORE = "<할인 전 총주문 금액>";

	public static void openingtMent() {
		System.out.println(OUTPUT_START_EVENT);

	}

	public static void eventBenefit(int day) {
	
		System.out.printf(OUTPUT_WOO_EVENT, day);
		System.out.println();
		
	}

	public static void orderMenu() {
		System.out.println(OUTPUT_ORDER_MENU);
	}
	
	
	public static void PrintNoSale() {
		System.out.println(OUTPUT_SALE_BEFORE);
	}

}
