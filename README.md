# common-json-utils-gson

[![Full CI Build](https://github.com/benrhine/common-json-utils-gson/actions/workflows/ci.yml/badge.svg)](https://github.com/benrhine/common-json-utils-gson/actions/workflows/ci.yml)

This library contains a number of common functions for parsing JSON using the gson library. It also supports
inheriting the gson library via
```groovy
api "com.google.code.gson:gson:2.10.1"
```

#### Available JSON Methods
All the following are static methods and can be declared anywhere in your code.

- Stream<JsonElement> jsonArrayToStream(final JsonElement json, final String field)
- static <T> T safeGetJsonValue(final JsonObject json, final String field, final Function<JsonElement, T> getter)
- <T> T safeGetJsonValue(final JsonElement json, final String field, final Function<JsonElement, T> getter)

Currently, all of the above are capable of returning a RuntimeException with a custom message.