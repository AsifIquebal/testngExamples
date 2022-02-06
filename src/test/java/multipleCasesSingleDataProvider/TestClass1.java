package multipleCasesSingleDataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

public class TestClass1 {

    @Test(dataProvider = "getData")
    public void test_01(String tc, String str) {
        System.out.println(str);
    }

    @Test(dataProviderClass = Data.class, dataProvider = "getData")
    public void test_02(String tc, String str) {
        System.out.println(str);
    }

    @Test(dataProviderClass = Data.class, dataProvider = "getData")
    public void test_03(String tc, String str) {
        System.out.println(str);
    }

    @Test(dataProviderClass = Data.class, dataProvider = "getData")
    public void test_04(String tc, String str) {
        System.out.println(str);
    }

    @Test(dataProviderClass = Data.class, dataProvider = "getData")
    public void test_05(String tc, String str) {
        System.out.println(str);
    }

    @DataProvider(name = "getData")
    public Object[][] getData(Method method) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("TestData1.xlsx")).getFile());
        System.out.println(file.getAbsolutePath());

        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        wb.close();
        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        Object[][] obj = new Object[1][2];// this is the catch
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell.getStringCellValue().equalsIgnoreCase(method.getName())) {
                for (int j = 0; j < lastCellNum; j++) {
                    obj[0][j] = row.getCell(j).getStringCellValue();
                }
            }
        }
        return obj;
    }
}
