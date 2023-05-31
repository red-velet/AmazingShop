package icu.chiou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.chiou.entity.CartEntity;
import icu.chiou.mapper.CartMapper;
import icu.chiou.service.CartService;
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
public class CartServiceImpl extends ServiceImpl<CartMapper, CartEntity> implements CartService {

}
