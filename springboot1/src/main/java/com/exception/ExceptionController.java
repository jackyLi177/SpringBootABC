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