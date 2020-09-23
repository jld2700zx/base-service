package org.lnut.base.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther ZhaoXin
 * @Date 2020/9/17
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis" )
public class RedissonConfig {

    private String password;

    private RedisProperties.Cluster cluster;

    @Bean
    public RedissonClient redissonClient() {
        List<String> nodes = cluster.getNodes();
        for (int i = 0; i < nodes.size(); i++) {
            nodes.set(i, "redis://"+nodes.get(i));
        }
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers().addNodeAddress(nodes.toArray(new String[nodes.size()]));
        clusterServersConfig.setPassword(password);
        return Redisson.create(config);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RedisProperties.Cluster getCluster() {
        return cluster;
    }

    public void setCluster(RedisProperties.Cluster cluster) {
        this.cluster = cluster;
    }

}
