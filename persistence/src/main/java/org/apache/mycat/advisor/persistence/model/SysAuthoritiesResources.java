package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "sys_authorities_resources")
public class SysAuthoritiesResources {
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long resourceId;
    private Long authorityId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RESOURCE_ID", nullable = false, insertable = true, updatable = true)
    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "AUTHORITY_ID", nullable = false, insertable = true, updatable = true)
    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysAuthoritiesResources that = (SysAuthoritiesResources) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (resourceId != null ? !resourceId.equals(that.resourceId) : that.resourceId != null) return false;
        if (authorityId != null ? !authorityId.equals(that.authorityId) : that.authorityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
        result = 31 * result + (authorityId != null ? authorityId.hashCode() : 0);
        return result;
    }
}
