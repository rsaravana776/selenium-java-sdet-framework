package data;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;
import utils.JsonUtils;

import java.util.List;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "excelLoginData")
    public Object[][] excelLoginData() {

        String filePath =
                "src/test/resources/testdata/LoginData.xlsx";

        ExcelUtils excelUtils =
                new ExcelUtils(filePath, "Login");

        int rowCount =
                excelUtils.getRowCount();

        int columnCount =
                excelUtils.getColumnCount();

        Object[][] data =
                new Object[rowCount - 1][columnCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {

                data[i - 1][j] =
                        excelUtils.getCellData(i, j);
            }
        }

        excelUtils.close();

        return data;
    }

    @DataProvider(name = "jsonLoginData")
    public Object[][] jsonLoginData() {

        String filePath =
                "src/test/resources/testdata/loginData.json";

        List<Map<String, String>> users =
                JsonUtils.readJsonFile(filePath);

        Object[][] data =
                new Object[users.size()][2];

        for (int i = 0; i < users.size(); i++) {

            data[i][0] =
                    users.get(i).get("username");

            data[i][1] =
                    users.get(i).get("password");
        }

        return data;
    }
}