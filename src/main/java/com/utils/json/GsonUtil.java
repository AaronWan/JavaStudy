package com.utils.json;

import java.io.Reader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public  class GsonUtil {
public  static final Gson gson=new GsonBuilder().create();

public static  <T> T fromJson(JsonElement json, Class<T> classOfT)
		throws JsonSyntaxException {
	return gson.fromJson(json, classOfT);
}

public static  <T> T fromJson(JsonElement json, Type typeOfT)
		throws JsonSyntaxException {
	return gson.fromJson(json, typeOfT);
}

public static  <T> T fromJson(JsonReader arg0, Type arg1) throws JsonIOException,
		JsonSyntaxException {
	return gson.fromJson(arg0, arg1);
}

public static  <T> T fromJson(Reader json, Class<T> classOfT)
		throws JsonSyntaxException, JsonIOException {
	return gson.fromJson(json, classOfT);
}

public static  <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException,
		JsonSyntaxException {
	return gson.fromJson(json, typeOfT);
}

public static  <T> T fromJson(String json, Class<T> classOfT)
		throws JsonSyntaxException {
	return gson.fromJson(json, classOfT);
}

public static  <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
	return gson.fromJson(json, typeOfT);
}

public static  <T> TypeAdapter<T> getAdapter(Class<T> type) {
	return gson.getAdapter(type);
}

public static  <T> TypeAdapter<T> getAdapter(TypeToken<T> arg0) {
	return gson.getAdapter(arg0);
}

public static  <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory arg0,
		TypeToken<T> arg1) {
	return gson.getDelegateAdapter(arg0, arg1);
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
