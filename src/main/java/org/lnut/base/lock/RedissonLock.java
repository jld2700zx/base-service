package org.lnut.base.lock;

import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Redisson
 * https://www.yuque.com/docs/share/10b346b7-cf42-44c3-b613-45038bbe20ca?# 《Redisson》
 * lua + watchDog实现分布式锁
 * @Auther ZhaoXin
 * @Date 2020/9/17
 */
@Component
public class RedissonLock {

    @Autowired
    private RedissonClient redissonClient;

    /**
     *
     * @param lockName 锁名称
     * @param waitTime 等待时间
     * @param leasetime 释放时间, 无填写-1
     * @return
     */
    public boolean lock(long waitTime, long leasetime, String lockName) {
        RLock lock = redissonClient.getLock(lockName);
        RedissonRedLock redLock = new RedissonRedLock(lock);
        boolean isLock = false;
        try {
            isLock = redLock.tryLock(waitTime, leasetime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            redLock.unlock();
        }
        return isLock;
    }

    /**
     * 释放锁
     * @param lockName 锁的名称
     */
    public void unLock(String lockName) {
        RLock lock = redissonClient.getLock(lockName);
        RedissonRedLock redLock = new RedissonRedLock(lock);
        redLock.unlock();
    }



}
