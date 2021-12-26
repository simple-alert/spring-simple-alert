package org.simple.alert.example.conmon;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author luke
 * @date 2021/7/10 23:21
 * @desc 雪花Id问题
 **/
public class LongToStringJacksonSerializer extends JsonSerializer<Long> {
    public static final long MAX_LONG_TO_STRING = (long) Math.pow(10, 15);

    public static final LongToStringJacksonSerializer instance = new LongToStringJacksonSerializer();

    @Override
    public void serialize(Long aLong,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException {
        if (aLong != null) {
            if (aLong > MAX_LONG_TO_STRING) {
                jsonGenerator.writeString(aLong.toString());
            } else {
                jsonGenerator.writeNumber(aLong);
            }
        }
    }
}
