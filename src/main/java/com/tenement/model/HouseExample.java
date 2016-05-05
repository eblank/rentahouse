package com.tenement.model;

import java.util.ArrayList;
import java.util.List;

public class HouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMainTitleIsNull() {
            addCriterion("main_title is null");
            return (Criteria) this;
        }

        public Criteria andMainTitleIsNotNull() {
            addCriterion("main_title is not null");
            return (Criteria) this;
        }

        public Criteria andMainTitleEqualTo(String value) {
            addCriterion("main_title =", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotEqualTo(String value) {
            addCriterion("main_title <>", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleGreaterThan(String value) {
            addCriterion("main_title >", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleGreaterThanOrEqualTo(String value) {
            addCriterion("main_title >=", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleLessThan(String value) {
            addCriterion("main_title <", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleLessThanOrEqualTo(String value) {
            addCriterion("main_title <=", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleLike(String value) {
            addCriterion("main_title like", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotLike(String value) {
            addCriterion("main_title not like", value, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleIn(List<String> values) {
            addCriterion("main_title in", values, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotIn(List<String> values) {
            addCriterion("main_title not in", values, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleBetween(String value1, String value2) {
            addCriterion("main_title between", value1, value2, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andMainTitleNotBetween(String value1, String value2) {
            addCriterion("main_title not between", value1, value2, "mainTitle");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListIsNull() {
            addCriterion("primary_pic_List is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListIsNotNull() {
            addCriterion("primary_pic_List is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListEqualTo(String value) {
            addCriterion("primary_pic_List =", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListNotEqualTo(String value) {
            addCriterion("primary_pic_List <>", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListGreaterThan(String value) {
            addCriterion("primary_pic_List >", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListGreaterThanOrEqualTo(String value) {
            addCriterion("primary_pic_List >=", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListLessThan(String value) {
            addCriterion("primary_pic_List <", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListLessThanOrEqualTo(String value) {
            addCriterion("primary_pic_List <=", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListLike(String value) {
            addCriterion("primary_pic_List like", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListNotLike(String value) {
            addCriterion("primary_pic_List not like", value, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListIn(List<String> values) {
            addCriterion("primary_pic_List in", values, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListNotIn(List<String> values) {
            addCriterion("primary_pic_List not in", values, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListBetween(String value1, String value2) {
            addCriterion("primary_pic_List between", value1, value2, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicListNotBetween(String value1, String value2) {
            addCriterion("primary_pic_List not between", value1, value2, "primaryPicList");
            return (Criteria) this;
        }

        public Criteria andHousePriceIsNull() {
            addCriterion("house_price is null");
            return (Criteria) this;
        }

        public Criteria andHousePriceIsNotNull() {
            addCriterion("house_price is not null");
            return (Criteria) this;
        }

        public Criteria andHousePriceEqualTo(Integer value) {
            addCriterion("house_price =", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotEqualTo(Integer value) {
            addCriterion("house_price <>", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceGreaterThan(Integer value) {
            addCriterion("house_price >", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_price >=", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceLessThan(Integer value) {
            addCriterion("house_price <", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceLessThanOrEqualTo(Integer value) {
            addCriterion("house_price <=", value, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceIn(List<Integer> values) {
            addCriterion("house_price in", values, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotIn(List<Integer> values) {
            addCriterion("house_price not in", values, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceBetween(Integer value1, Integer value2) {
            addCriterion("house_price between", value1, value2, "housePrice");
            return (Criteria) this;
        }

        public Criteria andHousePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("house_price not between", value1, value2, "housePrice");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(String value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(String value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(String value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(String value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(String value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLike(String value) {
            addCriterion("pay_method like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotLike(String value) {
            addCriterion("pay_method not like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<String> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<String> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(String value1, String value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(String value1, String value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andBedRoomIsNull() {
            addCriterion("bed_room is null");
            return (Criteria) this;
        }

        public Criteria andBedRoomIsNotNull() {
            addCriterion("bed_room is not null");
            return (Criteria) this;
        }

        public Criteria andBedRoomEqualTo(Integer value) {
            addCriterion("bed_room =", value, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomNotEqualTo(Integer value) {
            addCriterion("bed_room <>", value, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomGreaterThan(Integer value) {
            addCriterion("bed_room >", value, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomGreaterThanOrEqualTo(Integer value) {
            addCriterion("bed_room >=", value, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomLessThan(Integer value) {
            addCriterion("bed_room <", value, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomLessThanOrEqualTo(Integer value) {
            addCriterion("bed_room <=", value, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomIn(List<Integer> values) {
            addCriterion("bed_room in", values, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomNotIn(List<Integer> values) {
            addCriterion("bed_room not in", values, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomBetween(Integer value1, Integer value2) {
            addCriterion("bed_room between", value1, value2, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andBedRoomNotBetween(Integer value1, Integer value2) {
            addCriterion("bed_room not between", value1, value2, "bedRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomIsNull() {
            addCriterion("living_room is null");
            return (Criteria) this;
        }

        public Criteria andLivingRoomIsNotNull() {
            addCriterion("living_room is not null");
            return (Criteria) this;
        }

        public Criteria andLivingRoomEqualTo(Integer value) {
            addCriterion("living_room =", value, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomNotEqualTo(Integer value) {
            addCriterion("living_room <>", value, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomGreaterThan(Integer value) {
            addCriterion("living_room >", value, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomGreaterThanOrEqualTo(Integer value) {
            addCriterion("living_room >=", value, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomLessThan(Integer value) {
            addCriterion("living_room <", value, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomLessThanOrEqualTo(Integer value) {
            addCriterion("living_room <=", value, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomIn(List<Integer> values) {
            addCriterion("living_room in", values, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomNotIn(List<Integer> values) {
            addCriterion("living_room not in", values, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomBetween(Integer value1, Integer value2) {
            addCriterion("living_room between", value1, value2, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andLivingRoomNotBetween(Integer value1, Integer value2) {
            addCriterion("living_room not between", value1, value2, "livingRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomIsNull() {
            addCriterion("rest_room is null");
            return (Criteria) this;
        }

        public Criteria andRestRoomIsNotNull() {
            addCriterion("rest_room is not null");
            return (Criteria) this;
        }

        public Criteria andRestRoomEqualTo(Integer value) {
            addCriterion("rest_room =", value, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomNotEqualTo(Integer value) {
            addCriterion("rest_room <>", value, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomGreaterThan(Integer value) {
            addCriterion("rest_room >", value, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomGreaterThanOrEqualTo(Integer value) {
            addCriterion("rest_room >=", value, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomLessThan(Integer value) {
            addCriterion("rest_room <", value, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomLessThanOrEqualTo(Integer value) {
            addCriterion("rest_room <=", value, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomIn(List<Integer> values) {
            addCriterion("rest_room in", values, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomNotIn(List<Integer> values) {
            addCriterion("rest_room not in", values, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomBetween(Integer value1, Integer value2) {
            addCriterion("rest_room between", value1, value2, "restRoom");
            return (Criteria) this;
        }

        public Criteria andRestRoomNotBetween(Integer value1, Integer value2) {
            addCriterion("rest_room not between", value1, value2, "restRoom");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Long value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Long value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Long value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Long value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Long value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Long value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Long> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Long> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Long value1, Long value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Long value1, Long value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andRentFloorIsNull() {
            addCriterion("rent_floor is null");
            return (Criteria) this;
        }

        public Criteria andRentFloorIsNotNull() {
            addCriterion("rent_floor is not null");
            return (Criteria) this;
        }

        public Criteria andRentFloorEqualTo(Integer value) {
            addCriterion("rent_floor =", value, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorNotEqualTo(Integer value) {
            addCriterion("rent_floor <>", value, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorGreaterThan(Integer value) {
            addCriterion("rent_floor >", value, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_floor >=", value, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorLessThan(Integer value) {
            addCriterion("rent_floor <", value, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorLessThanOrEqualTo(Integer value) {
            addCriterion("rent_floor <=", value, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorIn(List<Integer> values) {
            addCriterion("rent_floor in", values, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorNotIn(List<Integer> values) {
            addCriterion("rent_floor not in", values, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorBetween(Integer value1, Integer value2) {
            addCriterion("rent_floor between", value1, value2, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andRentFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_floor not between", value1, value2, "rentFloor");
            return (Criteria) this;
        }

        public Criteria andFloorsIsNull() {
            addCriterion("floors is null");
            return (Criteria) this;
        }

        public Criteria andFloorsIsNotNull() {
            addCriterion("floors is not null");
            return (Criteria) this;
        }

        public Criteria andFloorsEqualTo(Integer value) {
            addCriterion("floors =", value, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsNotEqualTo(Integer value) {
            addCriterion("floors <>", value, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsGreaterThan(Integer value) {
            addCriterion("floors >", value, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsGreaterThanOrEqualTo(Integer value) {
            addCriterion("floors >=", value, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsLessThan(Integer value) {
            addCriterion("floors <", value, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsLessThanOrEqualTo(Integer value) {
            addCriterion("floors <=", value, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsIn(List<Integer> values) {
            addCriterion("floors in", values, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsNotIn(List<Integer> values) {
            addCriterion("floors not in", values, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsBetween(Integer value1, Integer value2) {
            addCriterion("floors between", value1, value2, "floors");
            return (Criteria) this;
        }

        public Criteria andFloorsNotBetween(Integer value1, Integer value2) {
            addCriterion("floors not between", value1, value2, "floors");
            return (Criteria) this;
        }

        public Criteria andTowardIsNull() {
            addCriterion("toward is null");
            return (Criteria) this;
        }

        public Criteria andTowardIsNotNull() {
            addCriterion("toward is not null");
            return (Criteria) this;
        }

        public Criteria andTowardEqualTo(String value) {
            addCriterion("toward =", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotEqualTo(String value) {
            addCriterion("toward <>", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardGreaterThan(String value) {
            addCriterion("toward >", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardGreaterThanOrEqualTo(String value) {
            addCriterion("toward >=", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardLessThan(String value) {
            addCriterion("toward <", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardLessThanOrEqualTo(String value) {
            addCriterion("toward <=", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardLike(String value) {
            addCriterion("toward like", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotLike(String value) {
            addCriterion("toward not like", value, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardIn(List<String> values) {
            addCriterion("toward in", values, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotIn(List<String> values) {
            addCriterion("toward not in", values, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardBetween(String value1, String value2) {
            addCriterion("toward between", value1, value2, "toward");
            return (Criteria) this;
        }

        public Criteria andTowardNotBetween(String value1, String value2) {
            addCriterion("toward not between", value1, value2, "toward");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNull() {
            addCriterion("decoration is null");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNotNull() {
            addCriterion("decoration is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationEqualTo(String value) {
            addCriterion("decoration =", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotEqualTo(String value) {
            addCriterion("decoration <>", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThan(String value) {
            addCriterion("decoration >", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThanOrEqualTo(String value) {
            addCriterion("decoration >=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThan(String value) {
            addCriterion("decoration <", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThanOrEqualTo(String value) {
            addCriterion("decoration <=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLike(String value) {
            addCriterion("decoration like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotLike(String value) {
            addCriterion("decoration not like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationIn(List<String> values) {
            addCriterion("decoration in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotIn(List<String> values) {
            addCriterion("decoration not in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationBetween(String value1, String value2) {
            addCriterion("decoration between", value1, value2, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotBetween(String value1, String value2) {
            addCriterion("decoration not between", value1, value2, "decoration");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("town not between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andHousingEstateIsNull() {
            addCriterion("housing_estate is null");
            return (Criteria) this;
        }

        public Criteria andHousingEstateIsNotNull() {
            addCriterion("housing_estate is not null");
            return (Criteria) this;
        }

        public Criteria andHousingEstateEqualTo(String value) {
            addCriterion("housing_estate =", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateNotEqualTo(String value) {
            addCriterion("housing_estate <>", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateGreaterThan(String value) {
            addCriterion("housing_estate >", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateGreaterThanOrEqualTo(String value) {
            addCriterion("housing_estate >=", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateLessThan(String value) {
            addCriterion("housing_estate <", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateLessThanOrEqualTo(String value) {
            addCriterion("housing_estate <=", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateLike(String value) {
            addCriterion("housing_estate like", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateNotLike(String value) {
            addCriterion("housing_estate not like", value, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateIn(List<String> values) {
            addCriterion("housing_estate in", values, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateNotIn(List<String> values) {
            addCriterion("housing_estate not in", values, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateBetween(String value1, String value2) {
            addCriterion("housing_estate between", value1, value2, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andHousingEstateNotBetween(String value1, String value2) {
            addCriterion("housing_estate not between", value1, value2, "housingEstate");
            return (Criteria) this;
        }

        public Criteria andBuildNumIsNull() {
            addCriterion("build_num is null");
            return (Criteria) this;
        }

        public Criteria andBuildNumIsNotNull() {
            addCriterion("build_num is not null");
            return (Criteria) this;
        }

        public Criteria andBuildNumEqualTo(String value) {
            addCriterion("build_num =", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumNotEqualTo(String value) {
            addCriterion("build_num <>", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumGreaterThan(String value) {
            addCriterion("build_num >", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumGreaterThanOrEqualTo(String value) {
            addCriterion("build_num >=", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumLessThan(String value) {
            addCriterion("build_num <", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumLessThanOrEqualTo(String value) {
            addCriterion("build_num <=", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumLike(String value) {
            addCriterion("build_num like", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumNotLike(String value) {
            addCriterion("build_num not like", value, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumIn(List<String> values) {
            addCriterion("build_num in", values, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumNotIn(List<String> values) {
            addCriterion("build_num not in", values, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumBetween(String value1, String value2) {
            addCriterion("build_num between", value1, value2, "buildNum");
            return (Criteria) this;
        }

        public Criteria andBuildNumNotBetween(String value1, String value2) {
            addCriterion("build_num not between", value1, value2, "buildNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNull() {
            addCriterion("unit_num is null");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNotNull() {
            addCriterion("unit_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNumEqualTo(String value) {
            addCriterion("unit_num =", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotEqualTo(String value) {
            addCriterion("unit_num <>", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThan(String value) {
            addCriterion("unit_num >", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThanOrEqualTo(String value) {
            addCriterion("unit_num >=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThan(String value) {
            addCriterion("unit_num <", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThanOrEqualTo(String value) {
            addCriterion("unit_num <=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLike(String value) {
            addCriterion("unit_num like", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotLike(String value) {
            addCriterion("unit_num not like", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumIn(List<String> values) {
            addCriterion("unit_num in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotIn(List<String> values) {
            addCriterion("unit_num not in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumBetween(String value1, String value2) {
            addCriterion("unit_num between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotBetween(String value1, String value2) {
            addCriterion("unit_num not between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumIsNull() {
            addCriterion("room_num is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumIsNotNull() {
            addCriterion("room_num is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumEqualTo(String value) {
            addCriterion("room_num =", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotEqualTo(String value) {
            addCriterion("room_num <>", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThan(String value) {
            addCriterion("room_num >", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThanOrEqualTo(String value) {
            addCriterion("room_num >=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThan(String value) {
            addCriterion("room_num <", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThanOrEqualTo(String value) {
            addCriterion("room_num <=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLike(String value) {
            addCriterion("room_num like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotLike(String value) {
            addCriterion("room_num not like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumIn(List<String> values) {
            addCriterion("room_num in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotIn(List<String> values) {
            addCriterion("room_num not in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumBetween(String value1, String value2) {
            addCriterion("room_num between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotBetween(String value1, String value2) {
            addCriterion("room_num not between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andFurnitureIsNull() {
            addCriterion("furniture is null");
            return (Criteria) this;
        }

        public Criteria andFurnitureIsNotNull() {
            addCriterion("furniture is not null");
            return (Criteria) this;
        }

        public Criteria andFurnitureEqualTo(String value) {
            addCriterion("furniture =", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureNotEqualTo(String value) {
            addCriterion("furniture <>", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureGreaterThan(String value) {
            addCriterion("furniture >", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureGreaterThanOrEqualTo(String value) {
            addCriterion("furniture >=", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureLessThan(String value) {
            addCriterion("furniture <", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureLessThanOrEqualTo(String value) {
            addCriterion("furniture <=", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureLike(String value) {
            addCriterion("furniture like", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureNotLike(String value) {
            addCriterion("furniture not like", value, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureIn(List<String> values) {
            addCriterion("furniture in", values, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureNotIn(List<String> values) {
            addCriterion("furniture not in", values, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureBetween(String value1, String value2) {
            addCriterion("furniture between", value1, value2, "furniture");
            return (Criteria) this;
        }

        public Criteria andFurnitureNotBetween(String value1, String value2) {
            addCriterion("furniture not between", value1, value2, "furniture");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionIsNull() {
            addCriterion("housing_estate_description is null");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionIsNotNull() {
            addCriterion("housing_estate_description is not null");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionEqualTo(String value) {
            addCriterion("housing_estate_description =", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionNotEqualTo(String value) {
            addCriterion("housing_estate_description <>", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionGreaterThan(String value) {
            addCriterion("housing_estate_description >", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("housing_estate_description >=", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionLessThan(String value) {
            addCriterion("housing_estate_description <", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionLessThanOrEqualTo(String value) {
            addCriterion("housing_estate_description <=", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionLike(String value) {
            addCriterion("housing_estate_description like", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionNotLike(String value) {
            addCriterion("housing_estate_description not like", value, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionIn(List<String> values) {
            addCriterion("housing_estate_description in", values, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionNotIn(List<String> values) {
            addCriterion("housing_estate_description not in", values, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionBetween(String value1, String value2) {
            addCriterion("housing_estate_description between", value1, value2, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andHousingEstateDescriptionNotBetween(String value1, String value2) {
            addCriterion("housing_estate_description not between", value1, value2, "housingEstateDescription");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(Long value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(Long value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(Long value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(Long value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(Long value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(Long value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<Long> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<Long> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(Long value1, Long value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(Long value1, Long value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}