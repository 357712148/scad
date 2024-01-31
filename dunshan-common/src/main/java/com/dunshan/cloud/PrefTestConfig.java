package com.dunshan.cloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 性能测试
 * @author: 李文
 * @create: 2024-01-31 11:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PrefTestConfig {

    @Value("${perf.isEnable}")
    private Boolean enable;

    private String PerfHeaderKey = "dunshan";

    private String PerfHeaderVal = "7dgroup";

}

