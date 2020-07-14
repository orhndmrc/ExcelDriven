package Exceldriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParameterizeTest {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

        Xls_Reader reader = new Xls_Reader("C:\\Users\\demir\\ExcelDriven\\ebay.xlsx");
        int rows = reader.getRowCount("RegTestData");

        reader.addColumn("RegTestData","Status");

        for (int rowNum = 2; rowNum<=rows ; rowNum++) {
           String firstname = reader.getCellData("RegTestData","firstname",rowNum);
            System.out.println(firstname);
            String lastname = reader.getCellData("RegTestData","lastname",rowNum);
            System.out.println(lastname);
            String email = reader.getCellData("RegTestData","email",rowNum);
            System.out.println(email);
            String password = reader.getCellData("RegTestData","password",rowNum);
            System.out.println(password);

            driver.findElement(By.xpath("//input[@id='firstname']")).clear();
            driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);

            driver.findElement(By.xpath("//input[@id='lastname']")).clear();
            driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);

            driver.findElement(By.xpath("//input[@id='email']")).clear();
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);

            driver.findElement(By.xpath("//input[@id='PASSWORD']")).clear();
            driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys(password);
//            WebDriverWait wait = new WebDriverWait(driver,10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ppaFormSbtBtn']")));
            driver.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).click();

            reader.setCellData("RegTestData","Status",rowNum,"Pass");//writing the data into a cell
        }
    }

}
