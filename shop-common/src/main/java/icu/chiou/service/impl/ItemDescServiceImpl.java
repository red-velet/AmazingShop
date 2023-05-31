package icu.chiou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.chiou.entity.ItemDescEntity;
import icu.chiou.mapper.ItemDescMapper;
import icu.chiou.service.ItemDescService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品描述表 服务实现类
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Service
public class ItemDescServiceImpl extends ServiceImpl<ItemDescMapper, ItemDescEntity> implements ItemDescService {

}
