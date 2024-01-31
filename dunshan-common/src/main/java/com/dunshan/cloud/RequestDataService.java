package com.dunshan.cloud;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 压测标识上下文
 * @author: 李文
 * @create: 2024-01-31 11:11
 **/
public class RequestDataService {
    //是否是性能测试请求
    private static final TransmittableThreadLocal<Boolean> isPerTest = TransmittableThreadLocal.withInitial(() -> false);

    //耗时统计
    private static final TransmittableThreadLocal<List<String>> timeStatistics = TransmittableThreadLocal.withInitial(ArrayList::new);

    //获取是否是性能测试请求
    public static Boolean isPerTest() {
        return RequestDataService.isPerTest.get();
    }

    //设置是否是压测标识
    public static void setIsPerTest(Boolean isPerTest) {
        RequestDataService.isPerTest.set(isPerTest);
    }

    // 移除静态变量
    public static void removeIsPerTest(Boolean isPerTest) {
        RequestDataService.isPerTest.remove();
    }

    //追加耗时统计
    public static void appendTimeStatistics(String appendStr) {
        RequestDataService.timeStatistics.get().add(appendStr);
    }

    //获取整体耗时统计
    public static List<String> getTimeStatistics() {
        return RequestDataService.timeStatistics.get();
    }

    //清除耗时统计
    public static void clearTimeStatistics() {
        RequestDataService.timeStatistics.remove();
    }
}

