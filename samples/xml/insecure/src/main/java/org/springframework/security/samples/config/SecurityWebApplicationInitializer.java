/**
 * @Title: SecurityWebApplicationInitializer.java
 * @Package org.springframework.security.samples.config
 * @author liyuchang
 * @date 2018年5月3日
 */
package org.springframework.security.samples.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @ClassName: SecurityWebApplicationInitializer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liyuchang
 * @date 2018年5月3日
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

  public SecurityWebApplicationInitializer() {
    super(SecurityConfig.class);
  }
}
