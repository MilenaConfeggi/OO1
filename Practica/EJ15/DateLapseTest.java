package ar.edu.unlp.info.oo1.objetos_uno.testsPropios.ej15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.objetos_uno.ejercicio15.*;

public class DateLapseTest {
	private DateLapse date1;
	private DateLapse date2;
	private DateLapse date3;
	
	@BeforeEach
	public void setup() {
		this.date1 = new DateLapse(LocalDate.of(2023, 3, 10), LocalDate.of(2023, 3, 30));
		this.date2 = new DateLapse(LocalDate.of(2023, 3, 10), LocalDate.of(2023, 3, 10));
		this.date3 = new DateLapse(LocalDate.of(2020, 3, 10), LocalDate.of(2020, 3, 9));
	}
	
	@Test
	public void testSizeInDays() {
		assertEquals(21, this.date1.sizeInDays());
		assertEquals(1, this.date2.sizeInDays());

	}
	
	@Test
	public void testIncludesDate() {
		assertEquals(true, this.date1.includesDate(LocalDate.of(2023, 3, 10)));
		assertEquals(false, this.date1.includesDate(LocalDate.of(2023, 2, 10)));
	}
	
	@Test
	public void testOverlaps() {
		assertEquals(true, this.date1.overlaps(date2));
		assertEquals(false, this.date1.overlaps(date3));
	}
	
	@Test
	public void testLaterFrom() {
		assertEquals(false, this.date1.laterFrom());
		//pruebo con fecha actual como to
		DateLapse date4 = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 13));
		assertEquals(false, date4.laterFrom());
	}
}
