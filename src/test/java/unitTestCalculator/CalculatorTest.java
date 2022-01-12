package unitTestCalculator;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorTest {

	Calculator calc;
	
	@BeforeTest
	public void setup() {
		calc = new Calculator();
	}
	
	//definition of data provider used to test add and subtract method
	
	@DataProvider(name = "dpAdd")
	public static Object[][] add(){
		return new Object[][] {{12,20},{29,10}};
	}
	@DataProvider(name = "dpSub")
	public static Object[][] sub(){
		return new Object[][] {{20,12},{20,1}};
	}
	
  //parameterization using data provider annotation
	
	
  @Test(dataProvider = "dpAdd")
  public void addTest(int para1, int para2) {
    Assert.assertEquals(calc.add(para1, para2), para1+para2);
  }
  
  
  //parameterization using data provider annotation
  
  
  @Test(dataProvider="dpSub")
  public void subTest(int para1,int para2) {
	  Assert.assertEquals(calc.sub(para1, para2), para1-para2);
  }
  
  //parameterization done using testng.xml
  
  
  @Test
  @Parameters({"numerator","denominator"})
  public void divideTest(int numerator, int denominator) {
	  Assert.assertEquals(calc.divide(numerator, denominator), numerator/denominator);
  }

  //
  
  
  @Test
  public void productTest() {
	  Assert.assertEquals(calc.product(12, 6), 12*6);
  }
}