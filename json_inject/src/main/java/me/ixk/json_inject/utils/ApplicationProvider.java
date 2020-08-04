package me.ixk.json_inject.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProvider implements ApplicationContextAware {
  private static ApplicationContext context;

  public static ApplicationContext get() {
    return context;
  }

  @Override
  public void setApplicationContext(ApplicationContext ac)
    throws BeansException {
    context = ac;
  }
}
