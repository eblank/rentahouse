package com.tenement.model;

public class Town {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column town.id
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column town.code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column town.name
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column town.url
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column town.county_code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String countyCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column town.id
     *
     * @return the value of town.id
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column town.id
     *
     * @param id the value for town.id
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column town.code
     *
     * @return the value of town.code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column town.code
     *
     * @param code the value for town.code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column town.name
     *
     * @return the value of town.name
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column town.name
     *
     * @param name the value for town.name
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column town.url
     *
     * @return the value of town.url
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column town.url
     *
     * @param url the value for town.url
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column town.county_code
     *
     * @return the value of town.county_code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getCountyCode() {
        return countyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column town.county_code
     *
     * @param countyCode the value for town.county_code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }
}