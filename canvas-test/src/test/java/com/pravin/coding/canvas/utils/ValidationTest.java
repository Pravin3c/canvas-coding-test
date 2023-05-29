package com.pravin.coding.canvas.utils;

import org.junit.Test;

import com.pravin.coding.canvas.coordinates.Coordinates;

public class ValidationTest {

	@Test
	public void validateInsideSuccess() {
		Validation.validateInside(new Coordinates(1, 1), new Coordinates(2, 3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateInsideBorder() {
		Validation.validateInside(new Coordinates(1, 3), new Coordinates(2, 3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateInsideNegative() {
		Validation.validateInside(new Coordinates(-1, 2), new Coordinates(2, 3));
	}

	@Test
	public void validateNonNegative() {
		Validation.validateNonNegative(new Coordinates(1, 1));
		Validation.validateNonNegative(new Coordinates(0, 0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateNonNegativeFail() {
		Validation.validateNonNegative(new Coordinates(-1, 1));
	}

	@Test
	public void validatePositive() {
		Validation.validatePositive(new Coordinates(1, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void validatePositiveFail() {
		Validation.validatePositive(new Coordinates(0, 0));
	}

}
