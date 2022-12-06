package API_Tests.Zippopotamus;

import Testbase.API_Connections.BookstoreConnection;
import Testbase.API_Connections.ZippopotamusConnection;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GET_Zip_Test extends ZippopotamusConnection {

    // API get request using response object from Rest Assured library.
    // Performing a manual test first in Postman, copying the Json response and creating a .json file under resources
    // Creating a .csv file with all the Json paths and their values
    // Then creating a Parameterized test using the .csv file and passing the Json path values as variables in the arguments of the test method
    // Using a Json Path object I retrieve the String values of all Path values within the Json response Object
    // Using assertThat method from Hamcrest matchers I validate that the values retrieved in the payload match the values in the .csv file
    // I also validate the response code using an assertion from junit

    @ParameterizedTest(name = "iteration {index}")
    @CsvFileSource(resources = "/ZipJsonValidation.csv", numLinesToSkip = 1)
    public void testingApiGet(String postCode, String country, String countryAbbreviation, String placeName,
                              String longitude, String state, String stateAbbreviation, String latitude){

        System.out.println("post code "+postCode);
        System.out.println("country "+country);
        System.out.println("country abbreviation "+countryAbbreviation);
        System.out.println("place name "+placeName);
        System.out.println("longitude "+longitude);
        System.out.println("state "+state);
        System.out.println("state abbreviation "+stateAbbreviation);
        System.out.println("latitude "+latitude);

        Response response = given().accept(ContentType.JSON)
                .pathParam("zipcode",22033).
                when()
                        .get("/{zipcode}");

       assertEquals(response.statusCode(),200);

        JsonPath jp = response.jsonPath();

        System.out.println("post code = " + jp.getString("'post code'"));

        assertThat(jp.getString("'post code'"),is(postCode));

        System.out.println("country = " + jp.getString("'country'"));

        assertThat(jp.getString("'country'"),is(country));

       System.out.println("country abbreviation = " +jp.getString("'country abbreviation'"));

        assertThat(jp.getString("'country abbreviation'"),is(countryAbbreviation));

        System.out.println("place name = "+jp.getString("places.'place name'"));

        assertThat(jp.getString("places.'place name'"),is(placeName));

        System.out.println("longitude = "+jp.getString("places.'longitude'"));

        assertThat(jp.getString("places.'longitude'"),is(longitude));

        System.out.println("state = "+jp.getString("places.'state'"));

        assertThat(jp.getString("places.'state'"),is(state));

        System.out.println("state abbreviation = "+jp.getString("places.'state abbreviation'"));

        assertThat(jp.getString("places.'state abbreviation'"),is(stateAbbreviation));

        System.out.println("latitude = "+jp.getString("places.'latitude'"));

        assertThat(jp.getString("places.'latitude'"),is(latitude));









    }


}
