package com.KonList.serve;

import com.KonList.exception.ValidationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> nameClass) {
        try {
            return mapper.readValue(json, nameClass);
        } catch (JsonProcessingException e) {
            throw new ValidationException(e.getMessage());
        }
    }

}
