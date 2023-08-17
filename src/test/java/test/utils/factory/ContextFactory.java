package test.utils.factory;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import lombok.Data;

import java.util.Properties;

@Data
public class ContextFactory {

    Boolean MobileTest;

    Response lastResponse;

    String contactId;

    DataTable contextTestData;

    Properties contextMultipleTestData = new Properties();

}
