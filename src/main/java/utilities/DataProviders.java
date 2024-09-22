package utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    // provider to get data using data provider and external data file
    @DataProvider(name = "login_data")
    public String[][] login_data() throws IOException, InvalidFormatException {
        Read_Data rd= new Read_Data();
        return rd.read_data("loginData");
    }

    // provider to get data using data provider and external data file
    @DataProvider(name = "course_name")
    public String[][] course_name() throws IOException, InvalidFormatException {
        Read_Data rd= new Read_Data();
        return rd.read_data("courseName");
    }
}
