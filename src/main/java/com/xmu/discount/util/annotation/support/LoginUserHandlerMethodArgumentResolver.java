package com.xmu.discount.util.annotation.support;

import com.xmu.discount.util.annotation.LoginUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 *
 *
 * @author Zhang Bingyuan
 */
public class LoginUserHandlerMethodArgumentResolver implements
        HandlerMethodArgumentResolver {
    public static final String LOGIN_TOKEN_KEY = "X-Login-Token";


    /**
     * 判断是否支持要转换的参数类型
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(Integer.class)&&methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    /**
     * 当支持后进行相应的转换 做业务操作
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest request,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        //从请求头中获参数信息
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        if(token == null || token.isEmpty()){
            return "参数缺少token";
        }
        //若存在token可以从 redis 或 自定义的工具类中获取userId(必须返回值与使用注解参数同类型)
        return 1;
    }
}
