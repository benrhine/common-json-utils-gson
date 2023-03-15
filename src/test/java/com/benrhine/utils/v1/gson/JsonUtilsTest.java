package com.benrhine.utils.v1.gson;

import static com.benrhine.utils.v1.gson.JsonUtils.jsonArrayToStream;
import static com.benrhine.utils.v1.gson.JsonUtils.safeGetJsonValue;
import static com.benrhine.utils.v1.util.TestConstants.SIMPLE_JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/** --------------------------------------------------------------------------------------------------------------------
 * JsonUtilsTest: Unit Tests.
 * ------------------------------------------------------------------------------------------------------------------ */
@ExtendWith(MockitoExtension.class)
final class JsonUtilsTest {
    @Test
    void testJsonArrayToStream() {
        // Given
        final JsonParser parser = new JsonParser();
        final JsonElement jsonElement = parser.parse(SIMPLE_JSON);
        // When
        final Stream<JsonElement> stream = jsonArrayToStream(jsonElement, "id");
        // Then
        assertNotNull(stream);
    }

    @Test
    void testSafeGetJsonValueForObject() {
        // Given
        final JsonParser parser = new JsonParser();
        final JsonElement jsonElement = parser.parse(SIMPLE_JSON);
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        // When
        final String result = safeGetJsonValue(jsonObject, "id", JsonElement::getAsString);
        // Then
        assertNotNull(result);
        assertEquals("1", result);
    }

    @Test
    void testSafeGetJsonValueForElement() {
        // Given
        final JsonParser parser = new JsonParser();
        final JsonElement jsonElement = parser.parse(SIMPLE_JSON);
        // When
        final String result = safeGetJsonValue(jsonElement, "id", JsonElement::getAsString);
        // Then
        assertNotNull(result);
        assertEquals("1", result);
    }
}