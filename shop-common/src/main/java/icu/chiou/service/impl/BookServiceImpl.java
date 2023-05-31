package icu.chiou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.chiou.entity.BookEntity;
import icu.chiou.mapper.BookMapper;
import icu.chiou.service.BookService;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, BookEntity> implements BookService {

}
