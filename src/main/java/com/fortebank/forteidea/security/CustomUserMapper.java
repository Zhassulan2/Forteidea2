package com.fortebank.forteidea.security;

import com.fortebank.forteidea.security.model.User;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import java.util.Collection;

public class CustomUserMapper extends LdapUserDetailsMapper {

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities){

        UserDetails details = super.mapUserFromContext(ctx, username, authorities);
        User usrdetails = new User((LdapUserDetails) details);

        String cn = ctx.getStringAttribute("cn");
        String sn = ctx.getStringAttribute("sn");
        String givenName = ctx.getStringAttribute("givenName");
        String company = ctx.getStringAttribute("company");
        String department = ctx.getStringAttribute("department");
        String email = ctx.getStringAttribute("mail");
        String employeeId = ctx.getStringAttribute("employeeID");

        usrdetails.setFullname(cn);
        usrdetails.setFirstname(givenName);
        usrdetails.setLastname(sn);
        usrdetails.setCompany(company);
        usrdetails.setDepartment(department);
        usrdetails.setEmail(email);
        usrdetails.setEmployeeId(employeeId);

        return usrdetails;
    }
}