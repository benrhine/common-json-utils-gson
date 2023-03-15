package com.benrhine.utils.v1.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/** --------------------------------------------------------------------------------------------------------------------
 * JsonHelpers: Helper class containing methods that do different conversions to and from JsonElement using Google GSON.
 * ------------------------------------------------------------------------------------------------------------------ */
public final class JsonUtils {

    private JsonUtils() {
        /* LEAVE BLANK */
    }

    public static Stream<JsonElement> jsonArrayToStream(final JsonElement json, final String field) {
        return Optional.ofNullable(json)
                .filter(JsonElement::isJsonObject)
                .map(JsonElement::getAsJsonObject)
                .map(j -> j.get(field))
                .filter(JsonElement::isJsonArray)
                .map(j -> StreamSupport.stream(j.getAsJsonArray().spliterator(), false))
                .orElseGet(Stream::empty);
    }

    public static <T> T safeGetJsonValue(final JsonObject json, final String field, final Function<JsonElement, T> getter) {
        return Optional.ofNullable(json)
                .map(j -> j.get(field))
                .map(getter)
                .orElse(null);
    }

    public static <T> T safeGetJsonValue(final JsonElement json, final String field, final Function<JsonElement, T> getter) {
        return Optional.ofNullable(json)
                .filter(JsonElement::isJsonObject)
                .map(JsonElement::getAsJsonObject)
                .map(j -> safeGetJsonValue(j, field, getter))
                .orElse(null);
    }
}
