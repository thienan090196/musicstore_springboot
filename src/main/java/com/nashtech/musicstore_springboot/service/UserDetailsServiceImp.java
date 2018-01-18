package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.dao.IAccountDao;
import com.nashtech.musicstore_springboot.model.Account;
import com.nashtech.musicstore_springboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private IAccountDao accountDao;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountDao.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Role role = account.getRole();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return new User(account.getEmail(), account.getPassword(), grantedAuthorities);
    }
}
