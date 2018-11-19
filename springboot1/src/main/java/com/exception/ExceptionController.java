package com.exception;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import com.common.Result;

/**
 * 全局异常统一处理
 *
 * 失效常见问题：
 * 1.确保注解@RestControllerAdvice/@ControllerAdvice的类被spring容器管理到。
 *     ①spring boot Java配置检查@SpringBootApplication(scanBasePackages = )（scanBasePackages 配置的包是否包含这个类默认情况下spring boot项目扫描的是@SpringBootApplication注解所在类的包及子包）
 *     ② xml配置的spring 普通项目检查<context:component-scan base-package="com.test"/>
 *
 * 2.检查项目中所有的切面编程，是否在某个切面将异常try-catch然后没有扔出来。常见的就是切面的环绕处理，捕获了异常忘记抛出来。
 *
 * 3.检查项目中是否有其他的相同的全局异常处理类，例如BaseController中是否已经定义了
 */
@RestControllerAdvice
public class ExceptionController {

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Result handle401(ShiroException e) {
        return new Result(WebError.UNAUTHORIZED);
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Result handle401() {
        return new Result(WebError.UNAUTHORIZED);
    }

    /** 文件上传大小异常 */
    @ExceptionHandler(MultipartException.class)
    public Result handleMultipart(Throwable t) {
      return Result.error(WebError.COMMON_UPLOAD_FILE_SIZE_MAX);
    }

    /** jackson转换Bean **/
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleJsonConv(Throwable t) {
      return Result.error(WebError.COMMON_PARAMS_NOT_EXIST);
    }

    /*@ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
      return Result.error(e.getMessage());
    }*/
    
    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result globalException(HttpServletRequest request, Throwable ex) {
        return new Result(getStatus(request).value(), ex.getMessage(),null);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}