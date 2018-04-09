package com.soft.util;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @ClassName: DateAdapter
 * @Description: TODO 日期适配器
 * @author Chen Xinjie  chenxinjie@bosideng.com
 * @date 2016年4月7日 下午2:40:07
 *  
 */
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
  
  @Override
  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    return null;
  }

  @Override
  public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    String value = "";
    if (src != null) {
      value = DateUtil.Date2Str(src);
    }
    return new JsonPrimitive(value);
  }

}
