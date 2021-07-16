package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(TestNgListnerExample.class)

public class LoginTesting extends  BaseClass {
	
	
	@Test
	@Parameters({"username","password"})
	public void LoginTest(String uname, String pass) {
		
		LoginPage LP = new LoginPage();
		LP.login(uname, pass);
		
	}
	
	@Test(enabled=false)
	public void LoginTestCase() {
		String uname = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage LP = new LoginPage();
		LP.login(uname, pass);
		
	} 
	
	
	
}