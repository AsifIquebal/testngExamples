package dataSupplier.withZeroCell;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.github.sskorol.data.TestDataReader.use;

public class TestClass1 {

    @Test(dataProvider = "getDataFromExcel")
    public void test_01(TestDataPojo testData){
        System.out.println(testData);
    }

    @Test(dataProvider = "getDataFromExcel")
    public void test_02(TestDataPojo testData){
        System.out.println(testData);
    }

    @Test(dataProvider = "getDataFromExcel")
    public void test_03(TestDataPojo testData){
        System.out.println(testData);
    }

    @Test(dataProvider = "getDataFromExcel")
    public void test_04(TestDataPojo testData){
        System.out.println(testData);
    }

    @Test(dataProvider = "getDataFromExcel")
    public void test_05(TestDataPojo testData){
        System.out.println(testData);
    }

    @DataSupplier
    public StreamEx<TestDataPojo> getDataFromExcel(Method method){
        return use(XlsxReader.class)
                .withTarget(TestDataPojo.class)
                .withSource("TestData.xlsx")
                .read()
                // multiple testcase by single data-supplier
                .filter(testData->testData.getTestIdentifier().equalsIgnoreCase(method.getName()));
    }

}
