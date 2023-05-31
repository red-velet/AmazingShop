package icu.chiou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import icu.chiou.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_item")
@ApiModel(value = "ItemEntity对象", description = "商品表")
@ToString
public class ItemEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id，同时也是商品编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品标题")
    private String title;

    @ApiModelProperty(value = "商品卖点")
    private String sellPoint;

    @ApiModelProperty(value = "商品价格，单位为：分")
    private Long price;

    @ApiModelProperty(value = "库存数量")
    private Integer num;

    @ApiModelProperty(value = "商品条形码")
    private String barcode;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "所属类目，叶子类目")
    private Long cid;

    @ApiModelProperty(value = "商品状态，1-正常，2-下架，3-删除")
    private Integer status;
}
