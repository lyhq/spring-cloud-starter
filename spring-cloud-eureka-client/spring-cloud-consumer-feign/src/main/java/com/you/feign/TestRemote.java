package com.you.feign;

import com.you.custom.MySelfRule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign 的客户端接口定义
 * 类中的方法和远程服务中 Contoller 中的方法名和参数需保持一致。
 *
 * @FeignClient(name = "eureka-producer") 引用调用的服务名
 * configuration = MySelfRule.class  自定义负载均衡的规则
 **/
//The bean 'eureka-producer.FeignClientSpecification' could not be registered.
//A bean with that name has already been defined and overriding is disabled.
@FeignClient(name = "eureka-producer", contextId = "remote", configuration = MySelfRule.class)
public interface TestRemote {

    /**
     * 绑定 eureka-producer 服务的 /test/ 接口
     *
     * @param name
     * @return
     */
    @GetMapping("/test")
    String produce(@RequestParam(value = "name") String name);

}

/**
 * Feign 自带的负载均衡策略
 * RoundRobinRule：轮询（默认）
 * RandomRule：随机
 * AvailabilityFilteringRule：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，
 *                            还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
 * WeightedResponseTimeRule：根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
 *                          刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，
 *                          会切换到WeightedResponseTimeRule
 * RetryRule：先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
 * BestAvailableRule：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
 * ZoneAvoidanceRule：默认规则,复合判断server所在区域的性能和server的可用性选择服务器
 */
