package icu.chiou.dto;

import icu.chiou.entity.ItemEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.lang.Nullable;

/**
 * Created with IntelliJ IDEA.
 * Author: chiou
 * Date: 2023/5/11
 * Time: 16:34
 * Description: No Description
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDTO extends ItemEntity {
    @ApiModelProperty(value = "商品价格-单位元")
    private Double priceView;

    @ApiModelProperty(value = "商品信息描述")
    private String itemDesc;

    @ApiModelProperty(value = "商品参数集合")
    @Nullable
    private String itemParams;

    @ApiModelProperty(value = "商品参数id")
    private Long itemParamId;
}
