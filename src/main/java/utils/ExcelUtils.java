package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private final Workbook workbook;
    private final Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {

        try {
            FileInputStream fileInputStream =
                    new FileInputStream(new File(filePath));

            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read Excel file: " + filePath,
                    e
            );
        }
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getCellData(int row, int column) {

        Cell cell =
                sheet.getRow(row).getCell(column);

        DataFormatter formatter =
                new DataFormatter();

        return formatter.formatCellValue(cell);
    }

    public void close() {

        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to close Excel workbook",
                    e
            );
        }
    }
}