package Excel;

import Excel.dataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
    public static void main(String[] args) throws IOException {
        dataDriven d = new dataDriven();
       ArrayList<String> data = d.getData("Add Profile");
        System.out.println( data.get(0));
        System.out.println( data.get(1));
        System.out.println( data.get(2));
        System.out.println( data.get(3));
    }
}
