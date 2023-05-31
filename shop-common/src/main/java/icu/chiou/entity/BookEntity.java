package icu.chiou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.chiou.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_book")
@ApiModel(value = "BookEntity对象", description = "")
public class BookEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "书籍id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "书名")
    private String name;

    @ApiModelProperty(value = "书的数量")
    private Integer bookNum;

    @ApiModelProperty(value = "视频录像数量")
    private Integer videoNum;
}
