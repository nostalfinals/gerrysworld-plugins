package xyz.garslity093.gerrysworld.menu.framework.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @packageName: xyz.garslity093.gerrysworld.menu.framework.utils
 * @className: JsonUtils
 * @author: GerryYuu
 * @date: 7/12/2022 10:15 PM
 */

public final class JsonUtils {
    private JsonUtils() {
    }

    public static <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        return new Gson().fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
    }

}
