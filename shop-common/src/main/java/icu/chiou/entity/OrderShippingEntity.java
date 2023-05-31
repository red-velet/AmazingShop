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
@TableName("tb_order_shipping")
@ApiModel(value = "OrderShippingEntity对象", description = "")
public class OrderShippingEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "收货人全名")
    private String receiverName;

    @ApiModelProperty(value = "固定电话")
    private String receiverPhone;

    @ApiModelProperty(value = "移动电话")
    private String receiverMobile;

    @ApiModelProperty(value = "省份")
    private String receiverState;

    @ApiModelProperty(value = "城市")
    private String receiverCity;

    @ApiModelProperty(value = "区/县")
    private String receiverDistrict;

    @ApiModelProperty(value = "收货地址，如：xx路xx号")
    private String receiverAddress;

    @ApiModelProperty(value = "邮政编码,如：310001")
    private String receiverZip;


}
