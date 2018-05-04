/**  
 * @Title: UserServiceImpl.java
 * @Package org.springframework.security.samples.service
 * @author liyuchang
 * @date 2018年5月4日  
 */
package org.springframework.security.samples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.samples.entity.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liyuchang
 * @date 2018年5月4日
 */
@Service
public class UserServiceImpl implements UserDetailsManager{

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  /* (non-Javadoc)
   * @param username
   * @return
   * @throws UsernameNotFoundException
   * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO load from db
    User user = new User();
    user.setId(1l);
    user.setUsername("lyc");
    user.setPassword(passwordEncoder.encode("123456"));
    user.setEmail("lyc@qq.com");
    UserDetails authentication = new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER", "ROOT"));
    return authentication;
  }

  /* (non-Javadoc)
   * @param user
   * @see org.springframework.security.provisioning.UserDetailsManager#createUser(org.springframework.security.core.userdetails.UserDetails)
   */
  @Override
  public void createUser(UserDetails user) {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @param user
   * @see org.springframework.security.provisioning.UserDetailsManager#updateUser(org.springframework.security.core.userdetails.UserDetails)
   */
  @Override
  public void updateUser(UserDetails user) {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @param username
   * @see org.springframework.security.provisioning.UserDetailsManager#deleteUser(java.lang.String)
   */
  @Override
  public void deleteUser(String username) {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @param oldPassword
   * @param newPassword
   * @see org.springframework.security.provisioning.UserDetailsManager#changePassword(java.lang.String, java.lang.String)
   */
  @Override
  public void changePassword(String oldPassword, String newPassword) {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @param username
   * @return
   * @see org.springframework.security.provisioning.UserDetailsManager#userExists(java.lang.String)
   */
  @Override
  public boolean userExists(String username) {
    // TODO Auto-generated method stub
    return false;
  }

}
