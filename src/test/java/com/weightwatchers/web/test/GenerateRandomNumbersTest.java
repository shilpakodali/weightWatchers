package com.weightwatchers.web.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.weightwatchers.web.util.Helper;

/**
 * 
 * @author shilpakodali
 *
 */
public class GenerateRandomNumbersTest {

	public static final Logger LOGGER = Logger.getLogger(GenerateRandomNumbersTest.class.getName());
	private ArrayList<Integer> fiveHundredRandomNumbers = new ArrayList<Integer>();

	public ArrayList<Integer> getFiveHundredRandomGeneratedNumbers() {
		return fiveHundredRandomNumbers;
	}

	@Test()
	public void generateRandomNumbersAndPrintSmallNumber() {
		Helper.printLine();
		LOGGER.info("Test : Generate Random Numbers");
		Random random = new Random();
		LOGGER.info("Generating 500 random numbers");
		for (int i = 0; i <= 500; i++) {
			int number = random.nextInt(10000);
			fiveHundredRandomNumbers.add(number);
		}
		LOGGER.info("Sorting 500 numbers in ascending order");
		Collections.sort(this.getFiveHundredRandomGeneratedNumbers());
		Helper.printBold("Smallest number in the generated random numbers is: "
				+ this.getFiveHundredRandomGeneratedNumbers().get(0));
		Helper.printLine();

	}

}
