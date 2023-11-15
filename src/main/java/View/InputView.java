package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_VISIT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
	private static final String INPUT_ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

	public static String inputMenuNumber() {
		System.out.println(INPUT_ORDER_MENU);
		return Console.readLine();

	}

	public static int readDate() {
	    System.out.println(INPUT_VISIT_DAY);
	    String input = Console.readLine();

	    try {
	        int day = Integer.parseInt(input);
	        if (day < 1 || day > 31) {
	            throw new IllegalArgumentException();
	        }
	        return day;
	    } catch (IllegalArgumentException e) {
	        throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
	    }
	}

	public static boolean isNumeric(String str) {
	    return str.matches("\\d+");
	}
}
