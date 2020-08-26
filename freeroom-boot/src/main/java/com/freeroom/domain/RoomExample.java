package com.freeroom.domain;

import java.util.ArrayList;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public List<Criterion> getAllCriteria() {
            return criteria;
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBuildnameIsNull() {
            addCriterion("buildname is null");
            return (Criteria) this;
        }

        public Criteria andBuildnameIsNotNull() {
            addCriterion("buildname is not null");
            return (Criteria) this;
        }

        public Criteria andBuildnameEqualTo(String value) {
            addCriterion("buildname =", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameNotEqualTo(String value) {
            addCriterion("buildname <>", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameGreaterThan(String value) {
            addCriterion("buildname >", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameGreaterThanOrEqualTo(String value) {
            addCriterion("buildname >=", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameLessThan(String value) {
            addCriterion("buildname <", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameLessThanOrEqualTo(String value) {
            addCriterion("buildname <=", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameLike(String value) {
            addCriterion("buildname like", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameNotLike(String value) {
            addCriterion("buildname not like", value, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameIn(List<String> values) {
            addCriterion("buildname in", values, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameNotIn(List<String> values) {
            addCriterion("buildname not in", values, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameBetween(String value1, String value2) {
            addCriterion("buildname between", value1, value2, "buildname");
            return (Criteria) this;
        }

        public Criteria andBuildnameNotBetween(String value1, String value2) {
            addCriterion("buildname not between", value1, value2, "buildname");
            return (Criteria) this;
        }

        public Criteria andRoomIsNull() {
            addCriterion("room is null");
            return (Criteria) this;
        }

        public Criteria andRoomIsNotNull() {
            addCriterion("room is not null");
            return (Criteria) this;
        }

        public Criteria andRoomEqualTo(String value) {
            addCriterion("room =", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotEqualTo(String value) {
            addCriterion("room <>", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThan(String value) {
            addCriterion("room >", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThanOrEqualTo(String value) {
            addCriterion("room >=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThan(String value) {
            addCriterion("room <", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThanOrEqualTo(String value) {
            addCriterion("room <=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLike(String value) {
            addCriterion("room like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotLike(String value) {
            addCriterion("room not like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomIn(List<String> values) {
            addCriterion("room in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotIn(List<String> values) {
            addCriterion("room not in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomBetween(String value1, String value2) {
            addCriterion("room between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotBetween(String value1, String value2) {
            addCriterion("room not between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andSessionIsNull() {
            addCriterion("session is null");
            return (Criteria) this;
        }

        public Criteria andSessionIsNotNull() {
            addCriterion("session is not null");
            return (Criteria) this;
        }

        public Criteria andSessionEqualTo(Integer value) {
            addCriterion("session =", value, "session");
            return (Criteria) this;
        }

        public Criteria andSessionNotEqualTo(Integer value) {
            addCriterion("session <>", value, "session");
            return (Criteria) this;
        }

        public Criteria andSessionGreaterThan(Integer value) {
            addCriterion("session >", value, "session");
            return (Criteria) this;
        }

        public Criteria andSessionGreaterThanOrEqualTo(Integer value) {
            addCriterion("session >=", value, "session");
            return (Criteria) this;
        }

        public Criteria andSessionLessThan(Integer value) {
            addCriterion("session <", value, "session");
            return (Criteria) this;
        }

        public Criteria andSessionLessThanOrEqualTo(Integer value) {
            addCriterion("session <=", value, "session");
            return (Criteria) this;
        }

        public Criteria andSessionIn(List<Integer> values) {
            addCriterion("session in", values, "session");
            return (Criteria) this;
        }

        public Criteria andSessionNotIn(List<Integer> values) {
            addCriterion("session not in", values, "session");
            return (Criteria) this;
        }

        public Criteria andSessionBetween(Integer value1, Integer value2) {
            addCriterion("session between", value1, value2, "session");
            return (Criteria) this;
        }

        public Criteria andSessionNotBetween(Integer value1, Integer value2) {
            addCriterion("session not between", value1, value2, "session");
            return (Criteria) this;
        }

        public Criteria andSchoolweekIsNull() {
            addCriterion("schoolweek is null");
            return (Criteria) this;
        }

        public Criteria andSchoolweekIsNotNull() {
            addCriterion("schoolweek is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolweekEqualTo(Integer value) {
            addCriterion("schoolweek =", value, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekNotEqualTo(Integer value) {
            addCriterion("schoolweek <>", value, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekGreaterThan(Integer value) {
            addCriterion("schoolweek >", value, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekGreaterThanOrEqualTo(Integer value) {
            addCriterion("schoolweek >=", value, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekLessThan(Integer value) {
            addCriterion("schoolweek <", value, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekLessThanOrEqualTo(Integer value) {
            addCriterion("schoolweek <=", value, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekIn(List<Integer> values) {
            addCriterion("schoolweek in", values, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekNotIn(List<Integer> values) {
            addCriterion("schoolweek not in", values, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekBetween(Integer value1, Integer value2) {
            addCriterion("schoolweek between", value1, value2, "schoolweek");
            return (Criteria) this;
        }

        public Criteria andSchoolweekNotBetween(Integer value1, Integer value2) {
            addCriterion("schoolweek not between", value1, value2, "schoolweek");
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

        private String typeHandler;

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

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}