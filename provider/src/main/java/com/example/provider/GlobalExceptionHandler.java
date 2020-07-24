package com.example.provider;


import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 所有异常报错
     *
     * @param request
     * @param
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ResponsData allExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws Exception {
        log.error(e.getMessage()+"|"+e.getStackTrace());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return new ResponsData(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "内部服务器错误：" + e.getMessage());
    }

//	@ExceptionHandler(value = FileAlreadyExistsException.class)
//	public void FileAlreadyExistsExceptionHandler(HttpServletRequest request, HttpServletResponse response,
//			Exception e) throws Exception {
//		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
////		response.set
////		return new ResponsData(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "文件重复：" + e.getMessage());
//	}

    /**
     * 用户自定义异常错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomerException.class)
    public ResponsData handleCustomerException(CustomerException e) {
        log.error(e.getMessage()+"|"+e.getStackTrace());
        return ResponsData.Error("提示：" + e.getMessage());
    }


    /**
     * 处理请求对象属性不满足校验规则的异常信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponsData exception(HttpServletRequest request, HttpServletResponse response,
                                 MethodArgumentNotValidException e) {
        log.error(e.getMessage()+"|"+e.getStackTrace());
        BindingResult result = e.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();

        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage() + "\n");
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new ResponsData(HttpServletResponse.SC_BAD_REQUEST, builder.toString());
    }

    /**
     * 处理请求单个参数不满足校验规则的异常信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponsData constraintViolationExceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                                           ConstraintViolationException e) {
        log.error(e.getMessage()+"|"+e.getStackTrace());
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new ResponsData(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
    }

}
