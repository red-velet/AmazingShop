package icu.chiou.handler;

import icu.chiou.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created with IntelliJ IDEA.
 * Author: chiou
 * Date: 2023/5/31
 * Time: 17:00
 * Description: 全局异常处理器配置
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.error("全局异常处理器捕获到异常: {}", ex.getMessage());
        ex.printStackTrace();
        return R.fail();
    }
}
