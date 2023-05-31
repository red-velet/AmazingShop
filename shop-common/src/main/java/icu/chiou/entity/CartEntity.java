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
@TableName("tb_cart")
@ApiModel(value = "CartEntity对象", description = "")
public class CartEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "物品名字/物品标题")
    private Long itemId;

    @ApiModelProperty(value = "物品图片地址")
    private String itemTitle;

    @ApiModelProperty(value = "物品价格")
    private String itemImage;

    @ApiModelProperty(value = "价格单位：分")
    private Long itemPrice;

    @ApiModelProperty(value = "物品数量")
    private Integer num;


}
