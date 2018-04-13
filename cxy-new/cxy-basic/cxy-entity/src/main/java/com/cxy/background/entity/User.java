package com.cxy.background.entity;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.flag
     *
     * @mbggenerated
     */
    private Boolean flag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.created_user
     *
     * @mbggenerated
     */
    private Integer createdUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.updated_user
     *
     * @mbggenerated
     */
    private Integer updatedUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.created_time
     *
     * @mbggenerated
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.updated_time
     *
     * @mbggenerated
     */
    private Date updatedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.username
     *
     * @return the value of sys_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.username
     *
     * @param username the value for sys_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.flag
     *
     * @return the value of sys_user.flag
     *
     * @mbggenerated
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.flag
     *
     * @param flag the value for sys_user.flag
     *
     * @mbggenerated
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.created_user
     *
     * @return the value of sys_user.created_user
     *
     * @mbggenerated
     */
    public Integer getCreatedUser() {
        return createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.created_user
     *
     * @param createdUser the value for sys_user.created_user
     *
     * @mbggenerated
     */
    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.updated_user
     *
     * @return the value of sys_user.updated_user
     *
     * @mbggenerated
     */
    public Integer getUpdatedUser() {
        return updatedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.updated_user
     *
     * @param updatedUser the value for sys_user.updated_user
     *
     * @mbggenerated
     */
    public void setUpdatedUser(Integer updatedUser) {
        this.updatedUser = updatedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.created_time
     *
     * @return the value of sys_user.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.created_time
     *
     * @param createdTime the value for sys_user.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.updated_time
     *
     * @return the value of sys_user.updated_time
     *
     * @mbggenerated
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.updated_time
     *
     * @param updatedTime the value for sys_user.updated_time
     *
     * @mbggenerated
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}