package Controller;

import Model.User;
import View.InputView;
import View.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.ChristmasEvent;
import Model.Menu;
import Model.OrderItem;

public class Controller {

	private final int YEAR_2023 = 2023;
	private final int MONTH_DECEMBER = 12;
	private final int ONE_DAY = 1;
	private final int LAST_DAY = 25;

	private int day;
	private int expense;
	private int totalSale;
	private int benefit;
	private User user;
	private List<OrderItem> items;
	private OrderItem oder;
	private ChristmasEvent event;

	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate userDate;

	public Controller() {
		user = new User();
		items = new ArrayList<>();

	}

	public void run() {
		start();
		MenuInput();
		OutputView.eventBenefit(day);
		OutputView.orderMenu();

		PrintItem();
		OutputView.printNoSale();
		PrintPrice();

		eventCreate();
		presentationMenu();
		printSale();
		eventAmount();
		printFinalSale();
		printBadge();

	}

	public void printSale() {

		OutputView.salePrint();

		if (isEventActive() && isExpenseAboveThreshold()) {
			applyDdaySale();
			applyDateSale();
			applySpecialDiscount();
			printPresentation();

		} else {
			printNoSaleMessage();
		}

	}
	
	public boolean isEventActive() {
		return !event.nonEventDate();
	}
	
	public boolean isExpenseAboveThreshold() {
		return expense > 10000;
	}

	public void printBadge() {
		System.out.println();
		OutputView.printBadge();
		System.out.println(event.badgeGrant(totalSale));
	}

	public void printFinalSale() {

		OutputView.printSale();
		int payment = expense - benefit;

		System.out.println(String.format("%,d원", payment));

	}

	public void eventAmount() {
		System.out.println();
		OutputView.printEventAmount();
		if (totalSale > 0) {
			String formattedExpense = String.format("-%,d원", totalSale);
			System.out.println(formattedExpense);
		}
		if (totalSale == 0) {
			String formattedExpense = String.format("%,d원", totalSale);
			System.out.println(formattedExpense);
		}
		System.out.println();
	}

	public void presentationMenu() {

		OutputView.printPresentation();
		if (!event.nonEventDate() && expense > 120000) {
			System.out.println("샴페인 1개");
			System.out.println();

		} else {
			System.out.println("없음");
			System.out.println();
		}
	}

	public void printPresentation() {
		int discount = event.getPresentationPrice(expense);
		System.out.println("증정 이벤트: -" + String.format("%,d", discount) + "원");
		totalSale = benefit + discount;
	}

	public void eventCreate() {
		startDate = LocalDate.of(YEAR_2023, MONTH_DECEMBER, ONE_DAY);
		endDate = LocalDate.of(YEAR_2023, MONTH_DECEMBER, LAST_DAY);
		userDate = LocalDate.of(YEAR_2023, MONTH_DECEMBER, day);

		event = new ChristmasEvent(startDate, endDate, userDate);
	}

	public void printNoSaleMessage() {

		System.out.println("없음");

	}

	public void applyDdaySale() {
		int daySale;

		daySale = event.calculateChristMasDiscount();

		benefit += daySale;
		System.out.println("크리스마스 디데이 할인:" + " -" + String.format("%,d", daySale) + "원");
	}

	public void applyDateSale() {
		for (OrderItem orderItem : items) {
			int itemDiscount = event.calculateDiscount(orderItem);

			if (itemDiscount > 0) {
				System.out.println(printWeek() + " -" + String.format("%,d", itemDiscount) + "원");

				benefit += itemDiscount;

			}
		}
	}

	public String printWeek() {
		return event.isWeekend(userDate.getDayOfWeek()) ? "주말 할인:" : "평일 할인:";
	}

	public void applySpecialDiscount() {
		int discount = event.calculateDiscountStar();

		benefit += discount;

		System.out.println("특별 할인: -" + String.format("%,d", discount) + "원");
	}

	public void start() {
		 OutputView.openingtMent();
		    try {
		        day = InputView.readDate();
		    } catch (IllegalArgumentException e) {
		        System.out.println(e.getMessage());
		        start(); // 유효하지 않은 입력이 있을 경우 다시 입력 받도록 재귀적으로 호출
		    }

	}

	public void PrintPrice() {
		expense = user.calculateTotalPrice(items);
		String formattedExpense = String.format("%,d원", expense);
		System.out.println(formattedExpense);
		System.out.println();
	}

	public void PrintItem() {
		for (OrderItem orderItem : items) {
			System.out.println(orderItem);
		}
		System.out.println();
	}

	public void MenuInput() {
		items = user.orderMenu();
	}

	

}
