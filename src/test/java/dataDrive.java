import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class dataDrive {
   /*                                 Steps
   ## identify testcases column by scanning the entire 1st row.
    ## once column is identified then scan entire test cases column to identify purchase testcase row.
    ## after you grab purchase test case row, pull all data of that row and feed into test*/
    public static void main(String[] args) throws Exception {
        //file inputstream argument

        FileInputStream fis = new FileInputStream("C:\\Users\\demir\\ExcelDriven\\demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheetNum = workbook.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("sheet1")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
//identify testcases column by scanning the entire 1st row.
                Iterator<Row> rows = sheet.iterator();//sheet is collection of rows
                Row firstrow =rows.next();
                Iterator<Cell> ce =firstrow.cellIterator();//row is collection of cells
                int k=0;
                int column=0;
                while(ce.hasNext()){
                    Cell value =ce.next();
                 if(value.getStringCellValue().equalsIgnoreCase("TestCases")){
                        //desired column
                     column = k;
                    }
                 k++;
                }
                System.out.println(column);
            }
        }
    }
}