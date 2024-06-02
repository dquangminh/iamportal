package dev.prototype.iamportal.shared.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.TimeZone;

@Slf4j
public class JsonUtil {
    private JsonUtil() {}

    private static final ObjectMapper DEFAULT_MAPPER = createDefaultObjectMapper();

    private static ObjectMapper createDefaultObjectMapper() {
        return JsonMapper.builder()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
                .configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
                .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .build()
                .setTimeZone(TimeZone.getDefault())
                .registerModule(new JavaTimeModule());
    }

    public static ObjectMapper mapper() {
        return DEFAULT_MAPPER;
    }

    public static <T> T treeToValue(JsonNode node, Class<T> clazz) {
        if (node == null) return null;
        try {
            return DEFAULT_MAPPER.treeToValue(node, clazz);
        } catch (JsonProcessingException e) {
            log.warn("Failed to convert JsonNode {} to Object", node, e);

            return null;
        }
    }

    public static <T> JsonNode valueToTree(Map<String, T> map) {
        return DEFAULT_MAPPER.valueToTree(map);
    }

    public static JsonNode stringToTree(String jsonAsString) {
        if (jsonAsString == null) return null;

        try {
            return DEFAULT_MAPPER.readTree(jsonAsString);
        } catch (JsonProcessingException e) {
            log.warn("Failed to convert String {} to JsonNode", jsonAsString, e);

            return null;
        }
    }

    public static JsonNode objectToTree(Object object) {
        if (object == null) return null;
        if (object instanceof JsonNode jn) return jn;
        return DEFAULT_MAPPER.valueToTree(object);
    }

    public static <T> T toObject(String jsonAsString, Class<T> clazz) {
        if (jsonAsString == null) return null;
        try {
            return DEFAULT_MAPPER.readValue(jsonAsString, clazz);
        } catch (JsonProcessingException e) {
            log.warn("Failed to convert String {} to Object", jsonAsString, e);

            return null;
        }
    }
}
