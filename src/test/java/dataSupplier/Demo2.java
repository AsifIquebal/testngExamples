package dataSupplier;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class Demo2 {

    @DataSupplier(transpose = true)
    public String[] getExtractedData() {
        return (String[]) Stream.of("1","2","3","4","5").toArray();
    }

    @Test(dataProvider = "getExtractedData")
    public void test_01(String str){
        System.out.println(str);
    }


}
