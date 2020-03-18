package com.fortebank.forteidea.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import java.util.Collection;

public class User implements LdapUserDetails {
    private static final long serialVersionUID = 1L;

    private LdapUserDetails details;
    private String fullname;
    private String firstname;
    private String lastname;
    private String email;
    private String company;
    private String department;
    private String employeeId;

    public User(LdapUserDetails details) {
        this.details = details;
    }

    public boolean isEnabled() {
        return details.isEnabled();
    }

    public String getDn() {
        return details.getDn();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return details.getAuthorities();
    }

    @JsonIgnore
    public String getPassword() {
        return details.getPassword();
    }

    public String getUsername() {
        return details.getUsername();
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return details.isAccountNonExpired();
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return details.isAccountNonLocked();
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return details.isCredentialsNonExpired();
    }

    @Override
    public void eraseCredentials() {

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}