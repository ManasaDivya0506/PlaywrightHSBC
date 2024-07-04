package kpmg.qa.hsbc.excelutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;



public class GetInputDataFromExcel {
	HashMap<String, HashMap<String, Object>> dataMap = new HashMap<>();
		
/*	@DataProvider(name ="exceldata") 
		public HashMap<String, HashMap<String, Object>> excelDP() {
		
			HashMap<String, HashMap<String, Object>> arrObj = getExcelData("C:\\Playwright\\Input Excel.xlsx", "Sheet1");
			System.out.println("********************************Checking the excel and found****************************");
			return dataMap;	
		}

		/*public Object[][] getExcelData(String fileName, String sheetName) {

			Object[][] data = null;
			Workbook wb = null;
			try {
				FileInputStream fis = new FileInputStream(fileName);
				String fileExtensionName = fileName.substring(fileName.indexOf("."));
				
				if(fileExtensionName.equals(".xlsx"))
					wb = new XSSFWorkbook(fis);
				else if(fileExtensionName.equals(".xls")){		       
					wb = new HSSFWorkbook(fis);
			    } 
				Sheet sh = wb.getSheet(sheetName);
				Row row = sh.getRow(0);
				int noOfRows = sh.getPhysicalNumberOfRows();
				System.out.println("*******************Total rOWS" +noOfRows);
				int noOfCols = row.getLastCellNum();
				System.out.println("*********************Total cOLUMNS" +noOfCols);
				Cell cell;
				data = new Object[noOfRows - 1][noOfCols];
				for (int i = 1; i < noOfRows; i++) {
					for (int j = 0; j < noOfCols; j++) {
						row = sh.getRow(i);
						cell = row.getCell(j); //1,1
						
						switch (cell.getCellType()) {
	                    case STRING :
	                    	data[i - 1][j] = cell.getStringCellValue(); //1,1
	                        break;
	                    case NUMERIC:
	                    	data[i - 1][j] = (int)cell.getNumericCellValue();
	                        break;
	                    case BLANK:
	                    	data[i - 1][j] = "";
	                        break;
						default:
							data[i - 1][j] = null;
							break;
	                }
															
					}
				}
			}

			catch (Exception e) {
				System.out.println("The exception is: " + e.getMessage());
			}
			
			return data;
		}
		
	@DataProvider(name ="exceldata") 
	public Object[][] getTestData() throws IOException {
        // Read data from Excel file and store it in HashMap
        HashMap<String, String> testData = getExcelData("C:\\Playwright\\Input Excel.xlsx", "Sheet1");
        
        return new Object[][] 
        		{ { testData }} ;
        		
        		}
        
	public HashMap<String, String> getExcelData(String fileName, String sheetName) throws IOException {

		Workbook wb = null;
		 HashMap<String, String> dataMap = new HashMap<>();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			
			if(fileExtensionName.equals(".xlsx"))
				wb = new XSSFWorkbook(fis);
			else if(fileExtensionName.equals(".xls")){		       
				wb = new HSSFWorkbook(fis);
		    } 
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(0);
			int noOfRows = sh.getPhysicalNumberOfRows();
			System.out.println("*******************Total rOWS" +noOfRows);
			int noOfCols = row.getLastCellNum();
			System.out.println("*********************Total cOLUMNS" +noOfCols);
			Cell cell;
		        
		        for (int i = 0; i <= sh.getLastRowNum(); i++) {
		            row = sh.getRow(i);
		            String key = row.getCell(0).getStringCellValue();
		        	
		            String value = row.getCell(1).getStringCellValue();
		            dataMap.put(key, value);
		        	
		        }
					
		}

		catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		
		wb.close();
		System.out.println("data map" +dataMap);
        return dataMap;
        
	}
	}

	@DataProvider(name ="exceldata") 
	public Object[][] excelDP() {
	
		Object arrObj[][] = getExcelData("C:\\Playwright\\Input Excel.xlsx", "Sheet1");
		System.out.println("********************************Checking the excel and found****************************");
		 Object[][] objArray = new Object[hashMap.size()][2];

		 int index = 0;
		 for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
		     objArray[index][0] = entry.getKey();
		     objArray[index][1] = entry.getValue();
		     index++;
		 }

		 // Print the object array
		 for (Object[] obj : objArray) {
		     System.out.println(obj[0] + ": " + obj[1]);
			    
			}	}
	public HashMap<String, HashMap<String, Object>> getExcelData(String fileName, String sheetName)  {
	 File file = new File("C:\\Playwright\\Input Excel.xlsx");
     

     try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {
         Sheet sheet = workbook.getSheetAt(0);

         for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
             Row row = sheet.getRow(i);
             if (row != null) {
                 HashMap<String, Object> rowData = new HashMap<>();

                 for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                     Cell cell = row.getCell(j);
                     String key = sheet.getRow(0).getCell(j).getStringCellValue();
                     Object value = getCellValue(cell);
                     

                     rowData.put(key, value);
                 }

                 dataMap.put("Row" + i, rowData);
             }
         }

         System.out.println(dataMap);

     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
	return dataMap;
 }

 private static Object getCellValue(Cell cell) {
     DataFormatter formatter = new DataFormatter();

     switch (cell.getCellType()) {
         case NUMERIC:
             return cell.getNumericCellValue();
         case STRING:
             return cell.getStringCellValue();
         default:
             return null;
     }
 }
}
	*/
	  Object[][] dataArray = new Object[dataMap.size()][dataMap.get(0).size()];	
	
@DataProvider(name ="exceldata") 
public Object[][] excelDP() {
	Object[][] arrObj = getExcelData("C:\\ExcelData\\TestDataXLS.xls", "Sheet1");
	return arrObj;
}

public Object[][] getExcelData(String fileName, String sheetName) {

	Object[][] data = null;
	Workbook wb = null;
	try {
        FileInputStream file = new FileInputStream("C:\\Playwright\\Input Excel.xlsx");

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, Map<Integer, Object>> dataMap = new HashMap<>();

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Map<Integer, Object> rowData = new HashMap<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                //switch (cell.getCellType()) {
                  //  case Cell.CELL_TYPE_NUMERIC:
                    //    rowData.put(cell.getColumnIndex(), cell.getNumericCellValue());
                     //   break;
                        switch (cell.getCellType()) {
                        case STRING:
                        rowData.put(cell.getColumnIndex(), cell.getStringCellValue());
                        break;
                        case NUMERIC:
                        	rowData.put(cell.getColumnIndex(), cell.getNumericCellValue());
                            break;
                }
            }
            dataMap.put(row.getRowNum(), rowData);
        }

      

        for (int row = 0; row < dataArray.length; row++) {
            for (int col = 0; col < dataArray[row].length; col++) {
                if (dataMap.get(row).get(col) instanceof Double) {
                    dataArray[row][col] = (Number) dataMap.get(row).get(col);
                } else {
                    dataArray[row][col] = (String) dataMap.get(row).get(col);
                }
            } //return dataArray;
        }

        workbook.close();
        file.close();

        // Handle the 2D object array as needed
        for (Object[] row : dataArray) {
            for (Object cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
	return dataArray;
}
}