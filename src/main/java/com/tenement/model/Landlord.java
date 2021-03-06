package com.tenement.model;

public class Landlord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column landlord.id
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column landlord.name
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column landlord.mobile
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column landlord.sex
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column landlord.type
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    private Long type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column landlord.id
     *
     * @return the value of landlord.id
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column landlord.id
     *
     * @param id the value for landlord.id
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column landlord.name
     *
     * @return the value of landlord.name
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column landlord.name
     *
     * @param name the value for landlord.name
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column landlord.mobile
     *
     * @return the value of landlord.mobile
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column landlord.mobile
     *
     * @param mobile the value for landlord.mobile
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column landlord.sex
     *
     * @return the value of landlord.sex
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column landlord.sex
     *
     * @param sex the value for landlord.sex
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column landlord.type
     *
     * @return the value of landlord.type
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public Long getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column landlord.type
     *
     * @param type the value for landlord.type
     *
     * @mbggenerated Tue May 03 15:55:21 CST 2016
     */
    public void setType(Long type) {
        this.type = type;
    }
}