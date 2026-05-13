package com.KonList.serve;

public interface IConvertData {
    <T> T getData(String json, Class<T> nameClass);
}
