package org.apache.mycat.advisor.persistence.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Basic;
import javax.persistence.Id;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cjl on 2016/3/20.
 */
@javax.persistence.Table(name = "tab_user_info")
public class TabUserInfo {
    @Id
    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;

    @javax.persistence.Transient
    private Collection<GrantedAuthority> grantedAuthority;
    private String username;
    private String password;
    private Integer userType;
    private String userAlias;
    private String emailAddress;
    private String qq;
    private String telephone;
    private String weixin;
    private String weibo;
    private Integer gender;
    private Date birth;
    private String address;
    private Integer company;
    private Integer post;
    private String realName;
    private String idcard;
    private String zhifubao;
    private Date insertTime;
    private Date updateTime;
    private Integer status;
    private Integer delFlag;
    private Integer enabled;
    private Integer accountNonExpired;
    private Integer accountNonLocked;
    private Integer credentialsNonExpired;
    @javax.persistence.Transient
    private Set<SysUsersRoles> sysUsersRoleses = new HashSet<SysUsersRoles>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @javax.persistence.Column(name = "username", nullable = true, insertable = true, updatable = true, length = 32)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @javax.persistence.Column(name = "password", nullable = true, insertable = true, updatable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @javax.persistence.Column(name = "user_type", nullable = true, insertable = true, updatable = true)
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Basic
    @javax.persistence.Column(name = "user_alias", nullable = true, insertable = true, updatable = true, length = 20)
    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    @Basic
    @javax.persistence.Column(name = "email_address", nullable = true, insertable = true, updatable = true, length = 32)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @javax.persistence.Column(name = "qq", nullable = true, insertable = true, updatable = true, length = 20)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @javax.persistence.Column(name = "telephone", nullable = true, insertable = true, updatable = true, length = 11)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @javax.persistence.Column(name = "weixin", nullable = true, insertable = true, updatable = true, length = 32)
    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    @Basic
    @javax.persistence.Column(name = "weibo", nullable = true, insertable = true, updatable = true, length = 32)
    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    @Basic
    @javax.persistence.Column(name = "gender", nullable = true, insertable = true, updatable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @javax.persistence.Column(name = "birth", nullable = true, insertable = true, updatable = true)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Basic
    @javax.persistence.Column(name = "address", nullable = true, insertable = true, updatable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @javax.persistence.Column(name = "company", nullable = true, insertable = true, updatable = true)
    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    @Basic
    @javax.persistence.Column(name = "post", nullable = true, insertable = true, updatable = true)
    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    @Basic
    @javax.persistence.Column(name = "real_name", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @javax.persistence.Column(name = "idcard", nullable = true, insertable = true, updatable = true, length = 18)
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @javax.persistence.Column(name = "zhifubao", nullable = true, insertable = true, updatable = true, length = 50)
    public String getZhifubao() {
        return zhifubao;
    }

    public void setZhifubao(String zhifubao) {
        this.zhifubao = zhifubao;
    }

    @Basic
    @javax.persistence.Column(name = "insert_time", nullable = true, insertable = true, updatable = true)
    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Basic
    @javax.persistence.Column(name = "update_time", nullable = true, insertable = true, updatable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @javax.persistence.Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @javax.persistence.Column(name = "del_flag", nullable = true, insertable = true, updatable = true)
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Basic
    @javax.persistence.Column(name = "enabled", nullable = true, insertable = true, updatable = true)
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Basic
    @javax.persistence.Column(name = "account_non_expired", nullable = true, insertable = true, updatable = true)
    public Integer getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Integer accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Basic
    @javax.persistence.Column(name = "account_non_locked", nullable = true, insertable = true, updatable = true)
    public Integer getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Integer accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Basic
    @javax.persistence.Column(name = "credentials_non_expired", nullable = true, insertable = true, updatable = true)
    public Integer getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Integer credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Set<SysUsersRoles> getSysUsersRoleses() {
        return sysUsersRoleses;
    }

    public void setSysUsersRoleses(Set<SysUsersRoles> sysUsersRoleses) {
        this.sysUsersRoleses = sysUsersRoleses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabUserInfo that = (TabUserInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (userAlias != null ? !userAlias.equals(that.userAlias) : that.userAlias != null) return false;
        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        if (qq != null ? !qq.equals(that.qq) : that.qq != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (weixin != null ? !weixin.equals(that.weixin) : that.weixin != null) return false;
        if (weibo != null ? !weibo.equals(that.weibo) : that.weibo != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (birth != null ? !birth.equals(that.birth) : that.birth != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (post != null ? !post.equals(that.post) : that.post != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (idcard != null ? !idcard.equals(that.idcard) : that.idcard != null) return false;
        if (zhifubao != null ? !zhifubao.equals(that.zhifubao) : that.zhifubao != null) return false;
        if (insertTime != null ? !insertTime.equals(that.insertTime) : that.insertTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;
        if (accountNonExpired != null ? !accountNonExpired.equals(that.accountNonExpired) : that.accountNonExpired != null)
            return false;
        if (accountNonLocked != null ? !accountNonLocked.equals(that.accountNonLocked) : that.accountNonLocked != null)
            return false;
        if (credentialsNonExpired != null ? !credentialsNonExpired.equals(that.credentialsNonExpired) : that.credentialsNonExpired != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (userAlias != null ? userAlias.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (weixin != null ? weixin.hashCode() : 0);
        result = 31 * result + (weibo != null ? weibo.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (idcard != null ? idcard.hashCode() : 0);
        result = 31 * result + (zhifubao != null ? zhifubao.hashCode() : 0);
        result = 31 * result + (insertTime != null ? insertTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (accountNonExpired != null ? accountNonExpired.hashCode() : 0);
        result = 31 * result + (accountNonLocked != null ? accountNonLocked.hashCode() : 0);
        result = 31 * result + (credentialsNonExpired != null ? credentialsNonExpired.hashCode() : 0);
        return result;
    }

    public Collection<GrantedAuthority> getGrantedAuthority() {
        return grantedAuthority;
    }

    public void setGrantedAuthority(Collection<GrantedAuthority> grantedAuthority) {
        this.grantedAuthority = grantedAuthority;
    }

}
