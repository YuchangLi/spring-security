/**  
 * @Title: SecurityConfig.java
 * @Package org.springframework.security.samples.config
 * @author liyuchang
 * @date 2018年5月3日  
 */
package org.springframework.security.samples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @ClassName: SecurityConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liyuchang
 * @date 2018年5月3日
 */
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
