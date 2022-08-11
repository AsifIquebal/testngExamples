package multipleCasesSingleDataProvider;

import lombok.Data;

@Data
public class DataObject {
public String userName;
public String passWord;

    public DataObject(String user1, String s) {
        this.userName = user1;
        this.passWord = s;
    }
}
