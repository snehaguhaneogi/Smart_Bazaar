package utilitis;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class Excel_Reader {
    public static Object[][] getData(String filePath, String sheetName) {
        try (
                FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fis);
        ) {
            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows][cols];

            for (int i = 1; i <= rows ; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i-1][j] = row.getCell(j).toString().trim();
                }
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Excel read failed", e);
        }
    }
}
