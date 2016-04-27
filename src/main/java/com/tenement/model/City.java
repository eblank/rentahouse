package com.tenement.model;

public class City {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.id
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.name
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.url
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.province_code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    private String provinceCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.id
     *
     * @return the value of city.id
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.id
     *
     * @param id the value for city.id
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.code
     *
     * @return the value of city.code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.code
     *
     * @param code the value for city.code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.name
     *
     * @return the value of city.name
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.name
     *
     * @param name the value for city.name
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.url
     *
     * @return the value of city.url
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.url
     *
     * @param url the value for city.url
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.province_code
     *
     * @return the value of city.province_code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.province_code
     *
     * @param provinceCode the value for city.province_code
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }
}