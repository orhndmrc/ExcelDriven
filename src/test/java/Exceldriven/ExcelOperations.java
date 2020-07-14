package Exceldriven;

public class ExcelOperations {
    public static void main(String[] args) {
        Xls_Reader reader = new Xls_Reader("C:\\Users\\demir\\ExcelDriven\\ebay.xlsx");
        reader.addSheet("HomePage");
        if(reader.isSheetExist("HomePage")){
            reader.addSheet("HomePage");
        }
        int colCount = reader.getColumnCount("RegTestData");
        System.out.println("Total columns present in RegTestData sheet:====="+colCount);
    }

}
