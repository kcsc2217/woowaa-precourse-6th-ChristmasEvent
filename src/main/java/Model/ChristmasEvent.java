package Model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ChristmasEvent {

	private final int START_EVENT_AMOUNT = 1000;
	private final int MONTH_DECEMBER = 12;
	private final int YEAR_2023 = 2023;

	LocalDate startDay, endDay;
	LocalDate userDay;
	Menu menu;

	public ChristmasEvent(LocalDate startDay, LocalDate endDay, LocalDate userDay) {
		this.startDay = startDay;
		this.endDay = endDay;
		this.userDay = userDay;

	}

	public int calculateChristMasDiscount() {
		

		long dayBetween = ChronoUnit.DAYS.between(startDay, userDay);
		int disCount = 100;
		int appliedDiscount = START_EVENT_AMOUNT + (int) (dayBetween * disCount);

		if (appliedDiscount < START_EVENT_AMOUNT) {
			appliedDiscount = START_EVENT_AMOUNT;
		}

		return appliedDiscount;

	}

	public int calculateDiscount(OrderItem orderItem) {
		Menu menu = orderItem.getMenu();
		int quantity = orderItem.getQuantity();
		int discount = 0;

		if (isWeekend(userDay.getDayOfWeek())) {
			if (menu.idMaindish()) {
				discount = 2023 * quantity;
			}
		} else {
			if (menu.isDessert()) {
				discount = 2023 * quantity;
			}
		}

		return discount;
	}

	public boolean isWeekend(DayOfWeek dayOfWeek) {
		return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;

	}
	
	public boolean nonEventDate() {
		if (userDay.isBefore(startDay) || userDay.isAfter(endDay)) {
			return true;
		}
		return false;
	}

}



