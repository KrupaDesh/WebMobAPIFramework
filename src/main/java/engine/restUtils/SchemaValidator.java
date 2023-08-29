package engine.restUtils;

import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class SchemaValidator {

    public static JsonSchemaValidator validateSchema(String schemaFilePath)
    {
    return JsonSchemaValidator.matchesJsonSchema(new File(schemaFilePath));
    }
}
