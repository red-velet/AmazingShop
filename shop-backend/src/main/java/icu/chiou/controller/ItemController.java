package icu.chiou.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.chiou.constant.ItemStatusConstant;
import icu.chiou.dto.ItemDTO;
import icu.chiou.entity.ItemDescEntity;
import icu.chiou.entity.ItemEntity;
import icu.chiou.entity.ItemParamItemEntity;
import icu.chiou.service.ItemDescService;
import icu.chiou.service.ItemParamItemService;
import icu.chiou.service.ItemService;
import icu.chiou.utils.R;
import icu.chiou.vo.EasyUITableResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Api(tags = "商品管理接口")
@Slf4j
@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    ItemDescService itemDescService;

    @Autowired
    ItemParamItemService itemParamItemService;

    @GetMapping("query")
    @ApiOperation("分页查询商品数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码,从1开始", required = true),
            @ApiImplicitParam(name = "rows", value = "每页显示记录数", required = true),
    })
    public EasyUITableResponseVO<ItemEntity> pageList(@RequestParam("page") Integer curr, @RequestParam("rows") Integer size) {
        //TODO 分页查询商品数据
        //分页查询
        IPage<ItemEntity> page = new Page<>(curr, size);
        LambdaQueryWrapper<ItemEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(ItemEntity::getCreated);
        itemService.page(page, wrapper);

        //封装响应
        EasyUITableResponseVO<ItemEntity> response = new EasyUITableResponseVO<>();
        response.setTotal(page.getTotal());
        response.setRows(page.getRecords());

        return response;
    }

    @PostMapping("update")
    @ApiOperation("更新商品")
    @Transactional
    public R updateItem(ItemDTO itemDTO) {
        //TODO 更新商品
        log.info("更新商品-接收到参数：{}", itemDTO);
        ItemEntity itemEntity = new ItemEntity();
        BeanUtils.copyProperties(itemDTO, itemEntity, "priceView", "itemDesc", "itemParams", "itemParamId");

        ItemDescEntity itemDescEntity = ItemDescEntity.builder()
                .itemDesc(itemDTO.getItemDesc())
                .itemId(itemDTO.getId()).build();
        LambdaUpdateWrapper<ItemEntity> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ItemEntity::getId, itemDTO.getId());
        //修改item表
        itemService.update(itemEntity, wrapper);

        //修改item_desc表
        LambdaUpdateWrapper<ItemDescEntity> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ItemDescEntity::getItemId, itemDTO.getId());
        itemDescService.update(itemDescEntity, updateWrapper);
        return R.success();
    }

    @PostMapping("delete")
    @ApiOperation("删除商品")
    @ApiImplicitParam(name = "ids", value = "待删除商品的id集合")
    @Transactional
    public R deleteItemByItemIdList(@RequestParam("ids") List<Integer> ids) {
//        //TODO 删除商品
//        log.info("删除商品-接收到参数：{}", ids);
//        try {
//            //删除商品描述表信息
//            itemDescService.removeByIds(ids);
//
//            //删除商品参数表信息
//            itemParamItemService.removeByIds(ids);
//
//            //删除商品表信息
//            itemService.removeByIds(ids);
//            return R.success();
//
//        } catch (Exception e) {
//            //打印异常日志
//            e.printStackTrace();
//            return R.fail(e.getMessage());
//        }
        //TODO 删除商品
        log.info("删除商品-接收到参数：{}", ids);
        try {
            //批量删除多个商品
            LambdaUpdateWrapper<ItemEntity> wrapper = new LambdaUpdateWrapper<>();
            wrapper
                    .in(ItemEntity::getId, ids)
                    .set(ItemEntity::getStatus, ItemStatusConstant.PRODUCT_DELETE);
            itemService.update(wrapper);
            return R.success();

        } catch (Exception e) {
            //打印异常日志
            e.printStackTrace();
            return R.fail(e.getMessage());
        }
    }

    @PostMapping("save")
    @ApiOperation("新增商品")
//    @ApiImplicitParam(name = "itemDTO", value = "新增商品参数")
    @Transactional
    public R addItem(ItemDTO itemDTO) {
        //TODO 添加商品
        log.info("添加商品-接收到参数：{}", itemDTO);
        try {
            //检测商品参数

            //添加商品信息到商品表
            ItemEntity itemEntity = new ItemEntity();
            BeanUtils.copyProperties(itemDTO, itemEntity);
            log.info("copy entity is {}", itemEntity);
            itemService.save(itemEntity);

            //添加商品描述信息到商品描述表
            ItemDescEntity itemDescEntity = new ItemDescEntity();
            itemDescEntity
                    .setItemId(itemEntity.getId())
                    .setItemDesc(itemDTO.getItemDesc());
            itemDescService.save(itemDescEntity);

            //添加商品参数信息到商品参数表
            ItemParamItemEntity itemParamItemEntity = new ItemParamItemEntity();
            itemParamItemEntity.setItemId(itemEntity.getId())
                    .setParamData(itemDTO.getItemParams());

            //异常回滚测试
//            int i = 1 / 0;
            return R.success();
        } catch (Exception e) {
            //打印异常日志
            e.printStackTrace();
            return R.fail(e.getMessage());
        }
    }

    @GetMapping("query/item/desc/{id}")
    @ApiOperation("查询商品描述明细")
    @ApiImplicitParam(name = "id", value = "商品id")
    public R queryItemDescByItemId(@PathVariable Long id) {
        //TODO 根据商品id查询商品详细描述
        LambdaQueryWrapper<ItemDescEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ItemDescEntity::getItemId, id);

        ItemDescEntity itemDescEntity = itemDescService.getOne(wrapper);

        //返回数据
        return R.success(itemDescEntity);
    }

    @GetMapping("param/item/query/{id}")
    @ApiOperation("查询商品参数明细")
    @ApiImplicitParam(name = "id", value = "商品id")
    public R queryItemParamByItemId(@PathVariable Long id) {
        //TODO 根据商品id查询商品参数
        LambdaQueryWrapper<ItemParamItemEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ItemParamItemEntity::getItemId, id);

        ItemParamItemEntity itemParamItemEntity = itemParamItemService.getOne(wrapper);

        //返回数据
        return R.success(itemParamItemEntity);
    }

    @PostMapping("instock")
    @ApiOperation("下架商品")
    @ApiImplicitParam(name = "ids", value = "待下架商品的id集合")
    @Transactional
    public R inStockItem(@RequestParam("ids") List<Integer> ids) {
        //TODO 下降商品
        log.info("下架商品-接收到参数：{}", ids);
        try {
            //批量下架多个商品
            LambdaUpdateWrapper<ItemEntity> wrapper = new LambdaUpdateWrapper<>();
            wrapper
                    .in(ItemEntity::getId, ids)
                    .set(ItemEntity::getStatus, ItemStatusConstant.PRODUCT_OFF_SALE);
            itemService.update(wrapper);

            return R.success();
        } catch (Exception e) {
            //打印异常日志
            e.printStackTrace();
            return R.fail(e.getMessage());
        }
    }

    @PostMapping("reshelf")
    @ApiOperation("上架商品")
    @ApiImplicitParam(name = "ids", value = "待上架商品的id集合")
    @Transactional
    public R reShelfItem(@RequestParam("ids") List<Integer> ids) {
        //TODO 上降商品
        log.info("上架商品-接收到参数：{}", ids);
        try {
            //批量上架多个商品
            LambdaUpdateWrapper<ItemEntity> wrapper = new LambdaUpdateWrapper<>();
            wrapper
                    .in(ItemEntity::getId, ids)
                    .set(ItemEntity::getStatus, ItemStatusConstant.PRODUCT_ON_SALE);
            itemService.update(wrapper);

            return R.success();
        } catch (Exception e) {
            //打印异常日志
            e.printStackTrace();
            return R.fail(e.getMessage());
        }
    }
}
