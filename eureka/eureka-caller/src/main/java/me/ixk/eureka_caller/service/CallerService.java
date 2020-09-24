package me.ixk.eureka_caller.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client", contextId = "caller")
public interface CallerService {
  @GetMapping("/")
  String getIndex();
}
