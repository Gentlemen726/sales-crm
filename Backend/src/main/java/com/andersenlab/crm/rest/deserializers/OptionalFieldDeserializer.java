package com.andersenlab.crm.rest.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.trim;

/**
 *
 * Removes leading, trailing whitespaces,
 * replaces series of spaces in between with single space
 *
 * @see com.fasterxml.jackson.databind.JsonDeserializer
 *
 */
@Log4j2
public class OptionalFieldDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctxt) {
        try {
            return trim(jp.getValueAsString()
                    .replaceAll(" +", " "));
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }
}
