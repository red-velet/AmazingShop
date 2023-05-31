package icu.chiou.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * Author: chiou
 * Date: 2023/5/11
 * Time: 17:14
 * Description: 公共字段填充配置
 */
@Component
public class CommonFieldsHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("created", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updated", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updated", LocalDateTime.now(), metaObject);
    }
}
