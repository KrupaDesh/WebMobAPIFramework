package engine.restUtils;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

import static engine.constants.Paths.SCHEMAFILE_API_ROOT_PATH;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestAPIUtil {

    //@Step("Get request without authentication")
    public static Response performGetWithoutSchema(String endpoint, Map<String,String> headers){
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint)
                .headers(headers).log().all()
                .get()
                .then().log().all().extract().response();
    }
    //@Step("Get request with authentication")
    public static Response performGet(String endpoint, Map<String,String> headers,String schemaFilePath){
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint)
                .headers(headers).log().all()
                .get()
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }

    //@Step("Get request with authentication")

    public static Response performGetWithQueryParam(String endpoint, Map<String,String> headers,Map<String,Object> queryParam,String schemaFilePath){
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint)
                .headers(headers).log().all()
                .queryParams(queryParam)
                .get()
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }
    public static Response performGetWithQueryParamWithoutSchema(String endpoint, Map<String,String> headers,Map<String,Object> queryParam){
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint)
                .headers(headers).log().all()
                .queryParams(queryParam)
                .get()
                .then().log().all().extract().response();
    }
    //@Step("Get request with authentication")
    public static Map<String,Object> performGetWithAuthRetrunMap(String endpoint, Map<String,String> headers)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint)
                .headers(headers)
                .get()
                .then().extract().body()
                .as(new TypeRef<Map<String,Object>>() {});
    }

    //@Step("Post request without response")
/*    public static Response performPostWithoutAuthAndResponse(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload)
    {

        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .post()
                .then().log().all().extract().response();
    }*/

    //Post request with authentication
    public static Response performPost(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload,String schemaFilePath)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .post()
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }
    //@Step("Post request with authentication and without response")
    public static Response performPostWithoutSchema(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .post()
                .then().log().all().extract().response();
    }
    //Post request with authentication
    public static Response performPostWithQueryParam(String endpoint, Map<String,String> headers,Map<String,Object> queryParam,Map<String,Object> reqPayload,String schemaFilePath)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .queryParams(queryParam)
                .body(reqPayload).log().all()
                .post()
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }
    public static Response performPostWithQueryParamWithoutScehma(String endpoint, Map<String,String> headers,Map<String,Object> queryParam,Map<String,Object> reqPayload)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .queryParams(queryParam)
                .body(reqPayload).log().all()
                .post()
                .then().log().all().extract().response();
    }

    //@Step("Post request without authentication and body request")
    public static Response performPostWithoutBody(String endpoint, Map<String,String> headers,String schemaFilePath)
    {

        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers).log().all()
                .when().post()
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }
    public static Response performPostWithoutBodyAndSchema(String endpoint, Map<String,String> headers)
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setUrlEncodingEnabled(false);
        RequestSpecification requestSpecification = requestSpecBuilder.build();
        return RestAssured
                .given().spec(requestSpecification).filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers).log().all()
                .when().post()
                .then().log().all().extract().response();
    }
    public static Response performPostWithURLEncodedData(String endpoint, Map<String,String> formParam)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .config(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .formParams(formParam).log().all()
                .when()
                .post(endpoint).then().contentType(ContentType.HTML).log().all().extract().response();
    }
    //@Step("Put request with authentication with Put string")
    public static Response performPut(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload,String putString, String schemaFilePath)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .put(putString)
                .then().log().all()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }
    //@Step("Put request with authentication without Put string")
    public static Response performPut(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload, String schemaFilePath)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .put()
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }
    public static Response performPutWithoutSchema(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .put()
                .then().log().all().extract().response();
    }

    //@Step("Patch request with authentication")
    public static Response performPatch(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload, String schemaFilePath)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .patch()
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(SCHEMAFILE_API_ROOT_PATH + schemaFilePath))).log().all().extract().response();
    }
    public static Response performPatchWithoutSchema(String endpoint, Map<String,String> headers,Map<String,Object> reqPayload)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers)
                .body(reqPayload).log().all()
                .patch()
                .then().log().all().extract().response();
    }
    //@Step("Delete request with authentication")
    public static Response performDelWithAuth(String endpoint, Map<String,String> headers,String delString)
    {
        return RestAssured
                .given().filter(new AllureRestAssured())
                .baseUri(endpoint.toString())
                .headers(headers).log().all()
                .delete(delString)
                .then().log().all().extract().response();
    }




}
