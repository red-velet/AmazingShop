package icu.chiou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import icu.chiou.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

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
@TableName("tb_order")
@ApiModel(value = "OrderEntity对象", description = "")
public class OrderEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分")
    private String payment;

    @ApiModelProperty(value = "支付类型，1、在线支付，2、货到付款")
    private Integer paymentType;

    @ApiModelProperty(value = "邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分")
    private String postFee;

    @ApiModelProperty(value = "状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭")
    private Integer status;

    @ApiModelProperty(value = "付款时间")
    private LocalDateTime paymentTime;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime consignTime;

    @ApiModelProperty(value = "交易完成时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "交易关闭时间")
    private LocalDateTime closeTime;

    @ApiModelProperty(value = "物流名称")
    private String shippingName;

    @ApiModelProperty(value = "物流单号")
    private String shippingCode;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "买家留言")
    private String buyerMessage;

    @ApiModelProperty(value = "买家昵称")
    private String buyerNick;

    @ApiModelProperty(value = "买家是否已经评价")
    private Integer buyerRate;


}
