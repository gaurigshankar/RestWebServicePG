package com.gauri.rest.utils;



import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class JsonUtils {
   

    public static final TypeReference<Map<String, Object>> MAP = new TypeReference<Map<String, Object>>() { };
    public static final TypeReference<List<Map<String, Object>>> LIST_OF_MAPS =
            new TypeReference<List<Map<String, Object>>>() { };

    private static ObjectMapper objectMapper;
    /*
     * This config enables mapping even if the json annotated name is not
     * same as model attribute name
     */
    static {
        objectMapper = new ObjectMapper();
        
        objectMapper.setAnnotationIntrospector(AnnotationIntrospector.pair(new JaxbAnnotationIntrospector(), new JacksonAnnotationIntrospector()));
        objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
    }

    public static String serialize(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException except) {
            
        }

        return null;
    }

    public static <T> T deserialize(String json, TypeReference<T> type) {
        return deserialize(json, TypeFactory.defaultInstance().constructType(type));
    }

    public static <T> T deserialize(String json, JavaType type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException except) {
           
        }

        return null;
    }

    public static Object deserialize(String json) {
        return deserialize(json, new TypeReference<Object>() { });
    }

    private JsonUtils() {
        // Exists only to prevent instantiation
    }
}
