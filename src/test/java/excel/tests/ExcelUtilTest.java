package excel.tests;

import com.crm.qa.util.Xls_Reader;

public class ExcelUtilTest {
	
	public static void main(String args[])
	{
	Xls_Reader reader=new Xls_Reader("C:\\Users\\febin\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\util\\TestData.xlsx");
	String sheetName="newcontact";
	
	String data=reader.getCellData(sheetName, 0, 2);
	System.out.println(data);
	int totalRows=reader.getRowCount(sheetName);
	System.out.println(totalRows);
	
	}

}
