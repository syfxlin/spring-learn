package me.ixk.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = "cache")
public class CachedService {

    @Cacheable
    public String cache() {
        log.info("Enter method");
        return "cache";
    }

    @CacheEvict
    public void reloadCache() {
        log.info("Reload");
    }
}
