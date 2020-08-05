package com.Utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * @author lyj
 * @date 2018/3/30 jackson Utils
 */
public class ObjectMapperUtil {
    private static final Log log = LogFactory.getLog(ObjectMapperUtil.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T fromString(String content, Class<T> valueType) throws IOException {
        return MAPPER.readValue(content, valueType);
    }

    public static String toString(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
