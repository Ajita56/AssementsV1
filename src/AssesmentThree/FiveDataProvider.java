package AssesmentThree;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FiveDataProvider {
	
	@DataProvider(name="UserData")
	public String[][] getData() throws Exception {
		String furl="C:\\Users\\ajita_t\\Documents\\details.xlsx";
		File excelFile= new File(furl);

		System.out.println(excelFile.exists());

		FileInputStream Fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(Fis);
		XSSFSheet sheet=workbook.getSheet("UserDetails");
		int numrows=sheet.getPhysicalNumberOfRows();
		int numcols=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[numrows-1][numcols];
		for(int i =0;i<numrows-1;i++)
		{
			for(int j=0;j<numcols;j++)
			{
				DataFormatter df=new DataFormatter();
				String celldata=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				data[i][j]=celldata;
			}
		}
		
		workbook.close();
		Fis.close();
		return data;

	}


}
