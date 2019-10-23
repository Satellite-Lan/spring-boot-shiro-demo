package com.mrlanwx.springbootshirodemo.common.redis;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;

import com.mrlanwx.springbootshirodemo.common.enums.CodeEnum;
import com.mrlanwx.springbootshirodemo.common.exception.ItcljException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @Auther: lanweixing
 * @Date: 2019/10/23 15:08
 * @Description:
 */
@Configuration
@ConditionalOnClass({JedisCluster.class})
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {

    private Logger logger= LoggerFactory.getLogger(RedisConfiguration.class);

    @Resource
    private RedisProperties redisProperties;

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodes = new HashSet<>();
        for (String node : redisProperties.getNodes()) {
            try {
                String[] parts = StringUtils.split(node, ":");
                Assert.state(parts.length == 2,
                        "redis node shoule be defined as 'host:port', not '" + Arrays.toString(parts) + "'");
                nodes.add(new HostAndPort(parts[0], Integer.parseInt(parts[1])));
            } catch (RuntimeException e) {
                throw new ItcljException(
                        CodeEnum.SYSTEM_ERROR.getCode(), "Invalid redis cluster nodes property '" + node + "'", e);
            }
        }
        if (nodes.isEmpty()) {
            return null;
        }
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(redisProperties.getMaxTotal());
        config.setMaxIdle(redisProperties.getMaxIdle());
        config.setMinIdle(redisProperties.getMinIdle());

        logger.info("========================redis========================");
        logger.info("redisProperties:{}", JSON.toJSONString(redisProperties));

        return new JedisCluster(nodes, redisProperties.getConnectionTimeout(),
                redisProperties.getSoTimeout(), redisProperties.getMaxRedirections(), config);
    }
}
