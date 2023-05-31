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
 * 内容分类
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_content_category")
@ApiModel(value = "ContentCategoryEntity对象", description = "内容分类")
public class ContentCategoryEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类目id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父类目id=0时，代表的是一级的类目")
    private Long parentId;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "状态。可选值:1(正常),2(删除)")
    private Integer status;

    @ApiModelProperty(value = "排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数")
    private Integer sortOrder;

    @ApiModelProperty(value = "该类目是否为父类目，1为true，0为false")
    private Boolean isParent;


}
