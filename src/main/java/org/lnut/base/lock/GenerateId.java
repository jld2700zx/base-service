package org.lnut.base.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ListIterator;
import java.util.UUID;

/**
 * https://blog.csdn.net/RogueFist/article/details/79575665 四种spring静态注入方法
 *
 * @Auther ZhaoXin
 * @Date 2020/9/23
 */
@Component
public class GenerateId {

    public static final String LOCK_NAME = "lock:generateId";

    private static RedissonLock lock;

    @Autowired
    public GenerateId(RedissonLock lock) {
        GenerateId.lock = lock;
    }

    /**
     * 获取唯一ID
     * @return
     */
    public static String getUniqueId() {
        lock.lock(-1, -1, "lock:generateId");
        String id = UUID.randomUUID().toString();
        lock.unLock("lock:generateId");
        return id;
    }

}
