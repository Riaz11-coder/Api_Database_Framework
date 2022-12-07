package Testbase.API_Connections;

import Utility.ConfigurationReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;

public class BookstoreConnection {



    @BeforeAll

    public static void setUpAPI(){

        baseURI = ConfigurationReader.getProperty("baseURIBooks");
        basePath = ConfigurationReader.getProperty("basePathBooks");
    }


}
