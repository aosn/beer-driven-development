package io.github.aosn.camp2016.ui.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.aosn.util.tryable.Try;

public class JsonSerializer {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Try<String> serialize(Object o) {
        return Try.to(() -> MAPPER.writeValueAsString(o));
    }

    public static <T> Try<T> deserialize(String json, Class<T> dto) {
        return Try.to(() -> MAPPER.readValue(json, dto));
    }

    private JsonSerializer() {
    }
}
