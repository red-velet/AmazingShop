package icu.chiou.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 * Author: chiou
 * Date: 2023/5/11
 * Time: 17:07
 * Description: No Description
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("EasyUITree统一消息返回实体")
public class EasyUITreeVO {
    private Long id;
    private String text;
    private String state;
}
