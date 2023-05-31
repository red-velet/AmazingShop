package icu.chiou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.chiou.entity.ItemParamItemEntity;
import icu.chiou.mapper.ItemParamItemMapper;
import icu.chiou.service.ItemParamItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格和商品的关系表 服务实现类
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Service
public class ItemParamItemServiceImpl extends ServiceImpl<ItemParamItemMapper, ItemParamItemEntity> implements ItemParamItemService {

}
