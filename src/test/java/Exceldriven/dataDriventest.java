package Exceldriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dataDriventest {

    public static void main(String[] args) {

        Xls_Reader reader = new Xls_Reader("C:\\Users\\demir\\ExcelDriven\\ebay.xlsx");
        String firstname = reader.getCellData("RegTestData","firstname",2);
        String lastname = reader.getCellData("RegTestData","lastname",2);
        String email = reader.getCellData("RegTestData","email",2);
        String password = reader.getCellData("RegTestData","password",2);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(password);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ppaFormSbtBtn']")));
        driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).click();


    }
}
