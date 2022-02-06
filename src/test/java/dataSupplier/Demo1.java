package dataSupplier;

import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo1 {

    //region normal DataProvider
    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][1];
        data[0][0] = 1;
        data[1][0] = 2;
        data[2][0] = 3;
        return data;
    }

    @Test(dataProvider = "getData")
    public void testDemo(int a) {
        System.out.println(a);
    }

    //endregion

    //region Parallel
    @DataSupplier(runInParallel = true)
    public Stream<Integer> getData1() {
        return Stream.of(1, 2, 3);
    }

    @Test(dataProvider = "getData1")
    public void test01(int a) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(a);
    }

    //endregion
    //region Indices
    @DataSupplier(indices = {0,4})
    public Stream<Integer> getData2() {
        return Stream.of(1, 2, 3, 4, 5);
    }

    @Test(dataProvider = "getData2")
    public void test02(int a) {
        System.out.println(a);
    }

    //endregion
    //region Indices
    //endregion
    //region Indices
    //endregion
    //region Indices
    //endregion
    //region StreamX
    @DataSupplier(transpose = true)
    public List<User> getExtractedData() {
        return StreamEx.of(
                        new User("user1", "password1"),
                        new User("user2", "password2"))
                .toList();
    }

    @Test(dataProvider = "getExtractedData")
    public void shouldSupplyExtractedListData(final User... users) {
        //System.out.println(users);
        //System.out.println(users[0].getUsername() + " " + users[0].getPassword());
        Arrays.stream(users).forEach(System.out::println);
    }

    //endregion

    // DataSupplier supports the following args: name, transpose, flatMap, runInParallel and indices.


}
