package icu.chiou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.chiou.entity.ContentEntity;
import icu.chiou.mapper.ContentMapper;
import icu.chiou.service.ContentService;
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
public class ContentServiceImpl extends ServiceImpl<ContentMapper, ContentEntity> implements ContentService {

}
