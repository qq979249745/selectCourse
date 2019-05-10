package com.ztb.select_course.model;

import java.util.ArrayList;
import java.util.List;

public class CourseOfferingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseOfferingExample() {
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

        public Criteria andSemIdIsNull() {
            addCriterion("sem_id is null");
            return (Criteria) this;
        }

        public Criteria andSemIdIsNotNull() {
            addCriterion("sem_id is not null");
            return (Criteria) this;
        }

        public Criteria andSemIdEqualTo(Integer value) {
            addCriterion("sem_id =", value, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdNotEqualTo(Integer value) {
            addCriterion("sem_id <>", value, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdGreaterThan(Integer value) {
            addCriterion("sem_id >", value, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sem_id >=", value, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdLessThan(Integer value) {
            addCriterion("sem_id <", value, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdLessThanOrEqualTo(Integer value) {
            addCriterion("sem_id <=", value, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdIn(List<Integer> values) {
            addCriterion("sem_id in", values, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdNotIn(List<Integer> values) {
            addCriterion("sem_id not in", values, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdBetween(Integer value1, Integer value2) {
            addCriterion("sem_id between", value1, value2, "semId");
            return (Criteria) this;
        }

        public Criteria andSemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sem_id not between", value1, value2, "semId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIsNull() {
            addCriterion("professor_id is null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIsNotNull() {
            addCriterion("professor_id is not null");
            return (Criteria) this;
        }

        public Criteria andProfessorIdEqualTo(Integer value) {
            addCriterion("professor_id =", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotEqualTo(Integer value) {
            addCriterion("professor_id <>", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThan(Integer value) {
            addCriterion("professor_id >", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("professor_id >=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThan(Integer value) {
            addCriterion("professor_id <", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdLessThanOrEqualTo(Integer value) {
            addCriterion("professor_id <=", value, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdIn(List<Integer> values) {
            addCriterion("professor_id in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotIn(List<Integer> values) {
            addCriterion("professor_id not in", values, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdBetween(Integer value1, Integer value2) {
            addCriterion("professor_id between", value1, value2, "professorId");
            return (Criteria) this;
        }

        public Criteria andProfessorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("professor_id not between", value1, value2, "professorId");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteIsNull() {
            addCriterion("prerequisite is null");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteIsNotNull() {
            addCriterion("prerequisite is not null");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteEqualTo(Integer value) {
            addCriterion("prerequisite =", value, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteNotEqualTo(Integer value) {
            addCriterion("prerequisite <>", value, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteGreaterThan(Integer value) {
            addCriterion("prerequisite >", value, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteGreaterThanOrEqualTo(Integer value) {
            addCriterion("prerequisite >=", value, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteLessThan(Integer value) {
            addCriterion("prerequisite <", value, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteLessThanOrEqualTo(Integer value) {
            addCriterion("prerequisite <=", value, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteIn(List<Integer> values) {
            addCriterion("prerequisite in", values, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteNotIn(List<Integer> values) {
            addCriterion("prerequisite not in", values, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteBetween(Integer value1, Integer value2) {
            addCriterion("prerequisite between", value1, value2, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andPrerequisiteNotBetween(Integer value1, Integer value2) {
            addCriterion("prerequisite not between", value1, value2, "prerequisite");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
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