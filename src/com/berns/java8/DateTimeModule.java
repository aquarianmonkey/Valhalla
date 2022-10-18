package com.berns.java8;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.berns.utils.Print;

public class DateTimeModule {

	public static void main(String[] args)
	{
		
		//instant();
		//clockAndZoneId();
		//localTime();
		//localDate();
		List<? super Object> ll = new ArrayList<>();
		
		Number[] n = { Integer.valueOf(1), Double.valueOf(2.2)};
		Number[] n2 = new Number[]{1,2.2f};
		

		int ss = 3%4 ;
		
		Print.out(".>" + ss);
		
		
		
	}

	private static void localDate()
	{
		
		LocalDate dueDate = LocalDate.of(1950, 11, 18);
		
		int dayOfWeek = dueDate.get(ChronoField.DAY_OF_WEEK);
		Print.out("day of week = " + DayOfWeek.of(dayOfWeek));
		
		Print.out("zone dt = " + ZonedDateTime.now());
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter mmddyyyyFormatter = DateTimeFormatter.ofPattern("MMM--dd--yyyy");
        Print.out(">>> DT formatted = " + mmddyyyyFormatter.format(now));
        
		Print.out(">>>" + LocalDate.parse("2016-12-25", DateTimeFormatter.ISO_DATE));
		
	}


	private static void instant()
	{
		Instant bdayInstant = Instant.now();
		System.out.println("Default time is UTC+0" + bdayInstant);

		//convert a java.util.Date into an Instant
		bdayInstant = Instant.ofEpochMilli(new Date().getTime());
		System.out.println("Parsed from old java Date's millis -> " + bdayInstant);
		
		// Create from a string
		bdayInstant = Instant.parse("2016-01-25T01:00:00Z");
		System.out.println("Birthday parsed from str= " + bdayInstant);
		Print.out("Plus 2 days= " + bdayInstant.plus(Duration.ofDays(2)));
		Print.out("Minus 3 days= " + bdayInstant.minus(3, ChronoUnit.DAYS));
		
		//instant.minus(Duration.ofDays(5));
		
		Instant bdayKen = bdayInstant.minus(Duration.ofDays(240));
		Print.out("Ken's days " + bdayKen);
		
		Print.out("Hours from ken to my bday = " + bdayKen.until(bdayInstant, ChronoUnit.HOURS));
		
		Print.out("Hours between ken and my bday = " + ChronoUnit.HOURS.between(bdayKen, bdayInstant));
		
	}
	
	
	private static void localTime()
	{
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		
	}


	public static void clockAndZoneId()
	{
			
		Clock clock = Clock.systemUTC();
		long millis = clock.millis();

		Print.out("All zone ids ;" + ZoneId.getAvailableZoneIds());

		ZoneId brazilZID = ZoneId.of("Brazil/East");
		
		Print.out(brazilZID.getRules());
		
//		Print.out("Today is %s and %d", today.toString(), 1);
		
		
	}
	
	
}
