package utils;

import com.google.gson.Gson;

import javax.validation.constraints.NotNull;

/**
 * @创建者 CY
 * @创建时间 2019/12/30 13:50
 * @描述
 */
public class B2BUtil {

    public static <T>Object b2b(@NotNull Object o,@NotNull Class<T> c){
        Gson gson=new Gson();
        Object o1=gson.fromJson(gson.toJson(o),c);
        return o1;
    }


}
