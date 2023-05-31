package icu.chiou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.chiou.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品规格和商品的关系表
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_item_param_item")
@Accessors(chain = true)
@ApiModel(value = "ItemParamItemEntity对象", description = "商品规格和商品的关系表")
public class ItemParamItemEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品id")
    private Long itemId;

    @ApiModelProperty(value = "参数数据，格式为json格式")
    private String paramData;


}
