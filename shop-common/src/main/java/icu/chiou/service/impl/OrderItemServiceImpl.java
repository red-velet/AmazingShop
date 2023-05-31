package icu.chiou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.chiou.entity.OrderItemEntity;
import icu.chiou.mapper.OrderItemMapper;
import icu.chiou.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chiou
 * @since 2023-05-04
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {

}
