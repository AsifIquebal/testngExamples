package multipleCasesSingleDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass2 {

    @Test(dataProvider = "pojoProvider")
    public void getData(DataObject dataObj) {
        System.out.println(dataObj.getUserName());
        System.out.println(dataObj.getPassWord());
    }

    @DataProvider(name = "pojoProvider")
    public Object[][] createPojoData() {
        return new Object[][] {
                { new DataObject("User1", "****") },
                { new DataObject("User2", "****") },
        };
    }

}
