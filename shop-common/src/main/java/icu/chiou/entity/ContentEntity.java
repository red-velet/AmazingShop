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
@TableName("tb_content")
@ApiModel(value = "ContentEntity对象", description = "")
public class ContentEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "内容id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "内容类目id")
    private Long categoryId;

    @ApiModelProperty(value = "内容标题")
    private String title;

    @ApiModelProperty(value = "子标题")
    private String subTitle;

    @ApiModelProperty(value = "标题描述")
    private String titleDesc;

    @ApiModelProperty(value = "链接")
    private String url;

    @ApiModelProperty(value = "图片链接")
    private String pic;

    @ApiModelProperty(value = "图片2")
    private String pic2;

    @ApiModelProperty(value = "内容")
    private String content;


}
