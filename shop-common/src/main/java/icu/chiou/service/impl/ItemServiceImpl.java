package icu.chiou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.chiou.entity.ItemEntity;
import icu.chiou.mapper.ItemMapper;
import icu.chiou.service.ItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemEntity> implements ItemService {

}
