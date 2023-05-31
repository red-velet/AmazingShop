package icu.chiou.entity;

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
@TableName("tb_order_item")
@ApiModel(value = "OrderItemEntity对象", description = "")
public class OrderItemEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    private String itemId;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "商品购买数量")
    private Integer num;

    @ApiModelProperty(value = "商品标题")
    private String title;

    @ApiModelProperty(value = "商品单价")
    private Long price;

    @ApiModelProperty(value = "商品总金额")
    private Long totalFee;

    @ApiModelProperty(value = "商品图片地址")
    private String picPath;


}
