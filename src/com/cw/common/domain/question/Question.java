package com.cw.common.domain.question;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 问题类
 * @author yuanguangjie
 *
 */
@XmlRootElement
public class Question implements Serializable {

	private static final long serialVersionUID = 6335675770371435246L;
	private int id; //编号
	private String name; //问题名称
	private String content;//问题内容
	private int duration; //持续时长
	private float points; //分数
	private boolean is_visible = true; //是否可见
	private Date create_time; //创建时间
	private String last_modify; //最后修改时间
	private String answer; //回答
	private int group_id; 
	private int question_type_id; // 问题类型编号
	private int expose_times; //显示时长
	private int right_times; //正确的时长
	private int wrong_times; //错误的时长
	private float difficulty; //难点
	private String analysis; //分析
	private QuestionContent questionContent;//试题内容
	private String pointName; //测试点名称
	private String fieldName;  //题库名称
	private String questionTypeName; //试题类型名称
	private List<Integer> pointList;  //分数集合
	private String referenceName; //参考名称
	private String creator; //创建者
	private String examingPoint; //考试分数
	private String keyword; //关键字
	private String tags; //标签名称
	private List<QuestionTag> tagList;
	private List<KnowledgePoint> knowledgePoint; //知识点集合
	
	public List<QuestionTag> getTagList() {
		return tagList;
	}
	public void setTagList(List<QuestionTag> tagList) {
		this.tagList = tagList;
	}
	public List<KnowledgePoint> getKnowledgePoint() {
		return knowledgePoint;
	}
	public void setKnowledgePoint(List<KnowledgePoint> knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getExamingPoint() {
		return examingPoint;
	}
	public void setExamingPoint(String examingPoint) {
		this.examingPoint = examingPoint;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public boolean isIs_visible() {
		return is_visible;
	}
	public void setIs_visible(boolean is_visible) {
		this.is_visible = is_visible;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getLast_modify() {
		return last_modify;
	}
	public void setLast_modify(String last_modify) {
		this.last_modify = last_modify;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getQuestion_type_id() {
		return question_type_id;
	}
	public void setQuestion_type_id(int question_type_id) {
		this.question_type_id = question_type_id;
	}
	public int getExpose_times() {
		return expose_times;
	}
	public void setExpose_times(int expose_times) {
		this.expose_times = expose_times;
	}
	public int getRight_times() {
		return right_times;
	}
	public void setRight_times(int right_times) {
		this.right_times = right_times;
	}
	public int getWrong_times() {
		return wrong_times;
	}
	public void setWrong_times(int wrong_times) {
		this.wrong_times = wrong_times;
	}
	public float getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public QuestionContent getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(QuestionContent questionContent) {
		this.questionContent = questionContent;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getQuestionTypeName() {
		return questionTypeName;
	}
	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}
	public List<Integer> getPointList() {
		return pointList;
	}
	public void setPointList(List<Integer> pointList) {
		this.pointList = pointList;
	}
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
}
