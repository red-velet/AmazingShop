package icu.chiou.entity.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: chiou
 * Date: 2023/5/4
 * Time: 11:18
 * Description: 基础实体类，所有实体都需要继承
 */
@Data
@ApiModel(value = "BaseEntity对象", description = "")
public class BaseEntity implements Serializable {
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime created;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updated;
}
