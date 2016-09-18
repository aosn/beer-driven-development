package io.github.aosn.camp2016.ui.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;

public class JsonSerializer {
    private static ObjectMapper MAPPER = new ObjectMapper();

    public static Optional<String> serialize(Object o) {
        try {
            return Optional.of(MAPPER.writeValueAsString(o));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static <T> Optional<T> deserialize(String json, Class<T> dto) {
        try {
            return Optional.of(MAPPER.readValue(json, dto));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private JsonSerializer() {
    }
}
