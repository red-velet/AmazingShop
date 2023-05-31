package icu.chiou.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: chiou
 * Date: 2023/5/11
 * Time: 8:30
 * Description: No Description
 */
@Data
@ApiModel("EasyUI统一消息返回实体")
public class EasyUITableResponseVO<T> {
    public Long total;
    public List<T> rows;
}
