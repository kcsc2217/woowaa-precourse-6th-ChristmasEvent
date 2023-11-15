package View;

public class OutputView {
	private static final String OUTPUT_START_EVENT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
	private static final String OUTPUT_ORDER_MENU = "<주문 메뉴>";
	private static final String OUTPUT_WOO_EVENT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기! \n";
	private static final String OUTPUT_SALE_BEFORE = "<할인 전 총주문 금액>";
	private static final String OUTPUT_SALE_CONTENT = "<혜택 내역>";
	private static final String OUTPUT_PRESENTATION_EVENT = "<증정 메뉴>";
	private static final String OUTPUT_EVENT_AMOUNT = "<총혜택 금액>";
	private static final String OUTPUT_SALE_AFTER = "<할인 후 예상 결제 금액>";
	private static final String OUTPUT_EVENT_BADGE = "<12월 이벤트 배지>";
	

	public static void openingtMent() {
		System.out.println(OUTPUT_START_EVENT);

	}
	
	public static void printEventAmount() {
		System.out.println(OUTPUT_EVENT_AMOUNT);
	}
	
	public static void printPresentation() {
		System.out.println(OUTPUT_PRESENTATION_EVENT);
	}

	public static void eventBenefit(int day) {
	
		System.out.printf(OUTPUT_WOO_EVENT, day);
		System.out.println();
		
	}
	
	public static void salePrint() {
		System.out.println(OUTPUT_SALE_CONTENT);
	}

	public static void orderMenu() {
		System.out.println(OUTPUT_ORDER_MENU);
	}
	
	
	public static void printNoSale() {
		System.out.println(OUTPUT_SALE_BEFORE);
	}
	
	public static void printSale() {
		System.out.println(OUTPUT_SALE_AFTER);
	}
	
	public static void printBadge() {
		System.out.println(OUTPUT_EVENT_BADGE);
	}

}
