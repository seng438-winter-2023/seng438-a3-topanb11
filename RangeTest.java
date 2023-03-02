package org.jfree.data;


import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.*;

public class RangeTest {
	Range testRangeDifferent;
	Range testRangeEqual;
	Range testRangeEqualScaledUp;
	Range testRangeExpandExpectedBLB;
	Range testRangeExpandExpectedAUB;
	Range testLowerNotEqual;
	Range testUpperNotEqual;
	Range testEqualExpected;
	Range normalRangeOne;
	Range normalRangeTwo;
	Range combinedRange;
	
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setupExpectedRanges() throws Exception { 
    	testRangeDifferent = new Range(-5, 5);
    	testRangeEqual = new Range(5, 5);
    	testRangeEqualScaledUp = new Range(10, 10);
    	testRangeExpandExpectedBLB = new Range(-6, 5);
    	testRangeExpandExpectedAUB = new Range(-5, 6);
    	testLowerNotEqual = new Range (-6, 5);
    	testUpperNotEqual = new Range(-5, 6);
    	testEqualExpected = new Range(-5 ,5);
    	normalRangeOne = new Range(5, 10);
    	normalRangeTwo = new Range(-10, 5);
    	combinedRange = new Range(-10, 10);
    }
    
    @Test (expected = IllegalArgumentException.class) 
    /**
     * 
     */
    public void constructorTest() {
    	Range range = new Range(10, 5);
    }
   
	@Test
	/**
	 * getLengthTestDifferentValues tests the getLength() method to see if returns the correct length of the range when lower != upper
	 */
    public void getLengthTestDifferentValues(){
    	assertEquals("Expected length is 10.0", 10.0, testRangeDifferent.getLength(), 0.00000000d);
    }
	
	@Test
	/**
	 * getLengthTestEqualValues tests the getLength() method to see if returns the correct length of the range when lower == upper
	 */
    public void getLengthTestEqualValues(){
    	assertEquals("Expected length is 0", 0, testRangeEqual.getLength(), 0.00000000d);
    }
	
	
	@Test
	/**
	 * getUpperBoundTestDifferentValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower != upper  
	 */
	public void getUpperBoundTestDifferentValues() {
		assertEquals("Expected upper bound is 5.0", 5.0, testRangeDifferent.getUpperBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * getUpperBoundTestEqualValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower == upper
	 */
	public void getUpperBoundTestEqualValues() {
		assertEquals("Expected upper bound is 5.0", 5.0, testRangeEqual.getUpperBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * getLowerBoundTestDifferentValues tests the the getLowerBound() method to see if it returns the correct lower bound of the range
	 * when lower != upper
	 */
	public void getLowerBoundTestDifferentValues() {
		assertEquals("Expected lower bound is -5.0", -5.0, testRangeDifferent.getLowerBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * getLowerBoundTestEqualValues tests the the getUpperBound() method to see if it returns the correct upper bound of the range
	 * when lower == upper 
	 */
	public void getLowerBoundTestEqualValues() {
		assertEquals("Expected lower bound is 5.0", 5.0, testRangeEqual.getLowerBound(), 0.00000000d);
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is below the lower bound
	 */
	public void containsTestBLB() {
		assertEquals("Expected to return false", false, testRangeDifferent.contains(-7));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is at the lower bound
	 */
	public void containsTestLB() {
		assertEquals("Expected to return true", true, testRangeDifferent.contains(-5));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value is within the given range
	 */
	public void containsTestNOM() {
		assertEquals("Expected to return true", true, testRangeDifferent.contains(0));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value at the upper bound
	 */
	public void containsTestUB() {
		assertEquals("Expected to return true", true, testRangeDifferent.contains(5));
	}
	
	@Test
	/**
	 * containsTestBLB tests the constraint() method when the given value above the upper bound
	 */
	public void containsTestAUB() {
		assertEquals("Expected to return false", false, testRangeDifferent.contains(7));
	}

	 @Test
	    /**
	 * intersectionOutOfLowerBound tests the intersection value when the intersection range you are testing
	 * is outside of the lower bound of the original range.
	 * Expected value: False
	 */
	public void intersectionTestBLB() {
	    assertEquals("Expected intersection result is false", false, testRangeDifferent.intersects(-10,-8));
	}

	@Test
	/**
	 * intersectionTestAtLB tests the intersection value when the intersection range you are testing
	 * is exactly at the upper-bound. The range is half within bounds and half outside.
	 * Expected Value: True
	 */
	public void intersectionTestLB() {
	    assertEquals("Expected intersection result is true", true, testRangeDifferent.intersects(-10,0));
	}    
	 
	@Test
	/**
	 * intersectionOutOfLowerBound tests the intersection value when the intersection range you are testing
	 * is exactly within the range you are given.
	 * Expected Value: True
	 */
	public void intersectionTestNOM() {
	    assertEquals("Expected intersection result is true", true, testRangeDifferent.intersects(-1,-1));
	}
	
	@Test
	/**
	 * intersectionTestAtUB tests the intersection value when the intersection range you are testing
	 * is exactly at the upper-bound. The range is half within bounds and half outside.
	 * Expected Value: True
	 */
	public void intersectionTestUB() {
	    assertEquals("Expected intersection result is true", true, testRangeDifferent.intersects(0, 10));
	}
	
	@Test
	/**
	 * intersectionTestOutofUpperBound tests the intersection value when the intersection range you are testing
	 * is completely outside of the upper bound of the range you are testing.
	 * Expected Value: False
	 */
	public void intersectionTestAUB() {
	    assertEquals("Expected intersection result is false", false, testRangeDifferent.intersects(10, 20));
	}
	
	@Test 
	/**
	 * toStringTest()
	 */
	public void toStringTest() {
		assertEquals("Expected to return Range[-5,5]", "Range[5.0,5.0]", testRangeEqual.toString());
	}
	
	@Test (expected = IllegalArgumentException.class)
	/**
	 * 
	 */
	public void scaleTestLessZero() {
		Range.scale(testRangeEqual, -1);
	}
	
	@Test
	/**
	 * 
	 */
	public void scaleTestAboveEqualZero() {
		assertEquals("Expected to be [10,10]", testRangeEqualScaledUp, Range.scale(testRangeEqual, 2));
	}
	
	@Test
	/**
	 * 
	 */
	public void hashcodeTest() {
		assertEquals("Expcted to be -2108162048", -2108162048, testRangeEqual.hashCode());
	}
 	
	@Test
	/**
	 * Testing nominal value here
	 */
	public void expandToIncludeNullTest() {
		assertEquals("Expected range to be [5,5]", testRangeEqual, Range.expandToInclude(null, 5));
	}
	
	@Test
	/**
	 * 
	 */
	public void expandToIncludeBLBTest() {
		assertEquals("Expected range to be [-6,5]", testRangeExpandExpectedBLB, Range.expandToInclude(testRangeDifferent, -6));
	}

	@Test
	/**
	 * 
	 */
	public void expandToIncludeAUBTest() {
		assertEquals("Expected range to be [-5,6]", testRangeExpandExpectedAUB, Range.expandToInclude(testRangeDifferent, 6));
	}
	
	@Test
	/**
	 * 
	 */
	public void expandToIncludeNominalTest() {
		assertEquals("Expected range to be [-5, 5]", testRangeDifferent, Range.expandToInclude(testRangeDifferent, 0));
	}
	
	
	@Test
	/**
	 * 
	 */
	public void equalsNotRangeObjTest() {
		assertEquals("Expected to be false", false, testRangeDifferent.equals("String"));
	}
	
	@Test
	/**
	 * 
	 */
	public void equalsLowerNotEqualTest() {
		assertEquals("Expected to be false", false, testRangeDifferent.equals(testLowerNotEqual));
	}
	
	@Test
	/**
	 * 
	 */
	public void equalsUpperNotEqualTest() {
		assertEquals("Expected to be false", false, testRangeDifferent.equals(testUpperNotEqual));
	}
	
	@Test
	/**
	 * 
	 */
	public void equalsBoundsEqualTest() {
		assertEquals("Expected to be false", false, testRangeDifferent.equals(testEqualExpected));
	}
	
	@Test
	/**
	 * 
	 */
	public void combineIgnoringNaNRange1NullTest() {
		assertEquals("Expected to be [-10, 5]", normalRangeTwo, Range.combineIgnoringNaN(null, normalRangeTwo));
	}
	
	@Test
	/**
	 * 
	 */
	public void combineIgnoringNaNRange2NullTest() {
		assertEquals("Expected to be [5, 10]", normalRangeOne, Range.combineIgnoringNaN(normalRangeOne, null));
	}
	
	@Test
	/**
	 * 
	 */
	public void combineIgnoringNaNValidTest() {
		assertEquals("Expected to be [-10, 10]", combinedRange, Range.combineIgnoringNaN(normalRangeOne, normalRangeTwo));
	}
	
 	
    @After
    public void tearDown() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}