package icu.chiou.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import icu.chiou.entity.ItemCatEntity;
import icu.chiou.service.ItemCatService;
import icu.chiou.vo.EasyUITreeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品类目 前端控制器
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Api(tags = "商品类别管理接口")
@Slf4j
@RestController
@RequestMapping("item/cat")
public class ItemCatController {
    @Autowired
    ItemCatService itemCatService;


    @PostMapping("queryItemName")
    @ApiOperation("根据类目id查询商品名")
    @Transactional
    public String findItemCategoryNameByCategoryId(Integer itemCatId) {
        //TODO 根据类目id查询商品名
        LambdaQueryWrapper<ItemCatEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ItemCatEntity::getId, itemCatId);
        ItemCatEntity itemCatEntity = itemCatService.getOne(wrapper);
        return itemCatEntity.getName();
    }

    @PostMapping("list")
    @ApiOperation("查询所有商品类别")
    public List<EasyUITreeVO> getCategoryTree(@RequestParam(value = "id", defaultValue = "0") Integer parentId) {
        //TODO 获取类目
        List<EasyUITreeVO> easyUITreeVOList = new ArrayList<>();
        LambdaQueryWrapper<ItemCatEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ItemCatEntity::getParentId, parentId);
        List<ItemCatEntity> itemCatEntityList = itemCatService.list(wrapper);


        for (ItemCatEntity itemCatEntity : itemCatEntityList) {
            EasyUITreeVO easyUITreeVO = new EasyUITreeVO();
            easyUITreeVO.setId(itemCatEntity.getId());
            easyUITreeVO.setText(itemCatEntity.getName());
            easyUITreeVO.setState(itemCatEntity.getIsParent() ? "closed" : "open");
            easyUITreeVOList.add(easyUITreeVO);
        }
        return easyUITreeVOList;
    }
}
