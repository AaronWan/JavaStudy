package com.utils.json;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonWriter;

public  class GsonUtil {
public  static final Gson gson=new GsonBuilder().create();

@SuppressWarnings("hiding")
public static  <Object> Object fromJson(String json, Class<Object> classOfT)
		throws JsonSyntaxException {
	return gson.fromJson(json, classOfT);
}


public static  void toJson(JsonElement arg0, Appendable arg1) throws JsonIOException {
	gson.toJson(arg0, arg1);
}

public static  void toJson(JsonElement arg0, JsonWriter arg1) throws JsonIOException {
	gson.toJson(arg0, arg1);
}

public static  String toJson(JsonElement jsonElement) {
	return gson.toJson(jsonElement);
}

public static  void toJson(Object src, Appendable writer) throws JsonIOException {
	gson.toJson(src, writer);
}

public static  void toJson(Object arg0, Type arg1, Appendable arg2)
		throws JsonIOException {
	gson.toJson(arg0, arg1, arg2);
}

public static  void toJson(Object arg0, Type arg1, JsonWriter arg2)
		throws JsonIOException {
	gson.toJson(arg0, arg1, arg2);
}

public static  String toJson(Object src, Type typeOfSrc) {
	return gson.toJson(src, typeOfSrc);
}

public static  String toJson(Object src) {
	return gson.toJson(src);
}

public static  JsonElement toJsonTree(Object src, Type typeOfSrc) {
	return gson.toJsonTree(src, typeOfSrc);
}

public static  JsonElement toJsonTree(Object src) {
	return gson.toJsonTree(src);
}

}
