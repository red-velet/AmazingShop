package icu.chiou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("统一消息返回实体")
public class R<T> {
    private int status;
    private String message;
    private T data;


    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON string", e);
        }
    }

    public static <T> R<T> success(T data) {
        return new R<>(200, "OK", data);
    }

    public static <T> R<T> success() {
        return new R<>(200, "OK", null);
    }

    public static <T> R<T> fail(T data) {
        return new R<>(201, null, data);
    }

    public static <T> R<T> fail() {
        return new R<>(201, null, null);
    }
}

