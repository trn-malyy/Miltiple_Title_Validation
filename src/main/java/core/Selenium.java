package core;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Selenium {
	public static void main(String[] args) {
		
		if (args.length == 0){
			System.err.println("No Arguments passsed in !");
			System.exit(1);
			
		}
		 
		WebDriver driver = new FirefoxDriver();    // Version 1.1 :: Firefox
	
		for (int i = 0; i < args.length; i++) {
		
		String text_case_id = "TC-001.0" + i;
		
		String param[] = args[i].split("\\|");
		
		String url = param[0];
		String title_expected =	param[1];
		
		//String url = "http://www.learn2test.net";
		//String title_expected = "yahoo.com";
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();

		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
	}
		driver.quit();
	}


}
