package webService.CalcTest;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

    import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

		private static XSSFSheet ExcelWSheet;

		private static XSSFWorkbook ExcelWBook;

		private static XSSFCell Cell;

		private static XSSFRow Row;
		
	 static String Path_TestData=System.getProperty("user.dir");
		
		private static String File_TestData=Path_TestData+"\\TestCaseFile\\TestCases.xlsx";
		private  static String sheetName="Sheet1";
		
		public static void main(String[] args) throws Exception {
			System.out.println(Path_TestData);
			System.out.println(File_TestData);
			
			System.out.println("Set excel file");
			
		//	setExcelFile(File_TestData,sheetName);
			System.out.println("Get cell value");
			System.out.println(getCellData(1, 1));
		System.out.println(Integer.parseInt(getCellData(1, 1)));	
		
	
			
		}

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(File_TestData);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

			try{
setExcelFile(File_TestData, sheetName);
  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

  		//	String CellData = Cell.getStringCellValue();
  			
  			String CellData=Cell.getRawValue();
  	
  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }

	//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

			try{

  			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

  // Constant variables Test Data path and Test Data file name

  				FileOutputStream fileOut = new FileOutputStream(File_TestData);

  				ExcelWBook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);

			}

		}

}

