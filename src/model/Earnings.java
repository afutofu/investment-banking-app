package model;

import java.time.LocalDate;
import java.util.Calendar;

public class Earnings {

	private static long totalEarnings;
	private static int currentYear;
	private static int currentMonth;
	private static long monthEarnings;
	private static long yearEarnings;
	
	public Earnings() {
		
		Calendar c = Calendar.getInstance();
		currentYear = c.get(Calendar.YEAR);
		currentMonth = c.get(Calendar.MONTH) + 1;
	}
	
	public long calcDebtorFeeAmount(long amount) {
		
		return (long) (amount * calcDebtorFeeMultiplier(amount));
	}
	
	public float getFeePercentage(long amount) {
		return 100 * calcDebtorFeeMultiplier(amount);
	}

	public float calcDebtorFeeMultiplier(long amount) {

		if (amount <= 500000) {
			return (float) 0.0102;
			
		} else if (amount <= 1000000) {

			return (float) 0.0128;
		} else if (amount <= 2500000) {

			return (float) 0.016;
		} else if (amount <= 5000000) {
			
			return (float) 0.02;
		} else if (amount <= 10000000) {

			return (float) 0.025;
		}

		return 0;
	}

	public void addEarnings(long earnings, LocalDate time) {
		this.totalEarnings += earnings;
		
		if (time.getMonthValue() == currentMonth) {
			this.monthEarnings += earnings;
		}
		
		if (time.getYear() == currentYear) {
			this.yearEarnings += earnings;
		}
	}
	
	public void resetEarnings() {
		this.totalEarnings = 0;
		this.monthEarnings = 0;
		this.yearEarnings = 0;
	}

	public long getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(long totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public long getMonthEarnings() {
		return monthEarnings;
	}

	public void setMonthEarnings(long monthEarnings) {
		this.monthEarnings = monthEarnings;
	}

	public long getYearEarnings() {
		return yearEarnings;
	}

	public void setYearEarnings(long yearEarnings) {
		this.yearEarnings = yearEarnings;
	}

}
