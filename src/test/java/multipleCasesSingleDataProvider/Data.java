package multipleCasesSingleDataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class Data {

    @DataProvider(name = "getData")
    public static Object[][] getData(Method method) throws IOException {
        ClassLoader classLoader = Data.class.getClassLoader();
        File file = new File(classLoader.getResource("TestData1.xlsx").getFile());
        System.out.println(file.getAbsolutePath());

        //File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\testNG\\dataProvider\\multipleCasesSingleDataProvider\\TestData.xlsx");
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
        /*for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> datamap = new HashMap<>();
            for (int j = 0; j < lastCellNum; j++) {
                datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
            }
            obj[i][0] = datamap;
        }*/
        return obj;
    }

}
