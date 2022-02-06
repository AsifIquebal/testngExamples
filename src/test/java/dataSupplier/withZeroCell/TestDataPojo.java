package dataSupplier.withZeroCell;

import com.creditdatamw.zerocell.annotation.Column;
import io.github.sskorol.data.Sheet;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Sheet(name = "Sheet1")
public class TestDataPojo {

    @Column(name = "testIdentifier", index = 0)
    private String testIdentifier;

    @Column(name = "dataName", index = 1)
    private String dataName;
}
