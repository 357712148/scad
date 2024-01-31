package com.dunshan.cloud;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @description: 过滤器
 * @author: 李文
 * @create: 2024-01-31 10:53
 **/
@Log4j2
public class SpringHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private PrefTestConfig PrefTestConfig;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 请求时间
        request.setAttribute("startTime", System.currentTimeMillis());
        // 是否允许压测
        Boolean isPrefEnable = PrefTestConfig.getEnable();
        // 判断当前请求是否是压测
        RequestDataService.setIsPerTest(false);
        // header 中包含压测标识
        String pressFlag = request.getHeader(PrefTestConfig.getPerfHeaderKey());
        // 压测未开启
        if (!isPrefEnable && PrefTestConfig.getPerfHeaderVal().equals(pressFlag)) {
            throw new GroupException(0000, "参数错误");
        }
        if (isPrefEnable && PrefTestConfig.getPerfHeaderVal().equals(pressFlag)) {
            //允许压测
            RequestDataService.setIsPerTest(true);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg, Exception arg1) throws Exception {
        // 清除压测标识
        RequestDataService.setIsPerTest(false);
    }

}

