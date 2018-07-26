package com.cw.common.domain.practice;

import java.util.List;

/**
 * 知识点分析结果实体类
 * @author yuanguangjie
 *
 */
public class KnowledgePointAnalysisResult {
	private int knowledgePointId; //知识点编号 
	private String knowledgePointName; //知识点名称
	private List<TypeAnalysis> typeAnalysis; //类型分析集合
	private float finishRate; //完成率

	public int getKnowledgePointId() {
		return knowledgePointId;
	}

	public void setKnowledgePointId(int knowledgePointId) {
		this.knowledgePointId = knowledgePointId;
	}

	public String getKnowledgePointName() {
		return knowledgePointName;
	}

	public void setKnowledgePointName(String knowledgePointName) {
		this.knowledgePointName = knowledgePointName;
	}

	public List<TypeAnalysis> getTypeAnalysis() {
		return typeAnalysis;
	}

	public void setTypeAnalysis(List<TypeAnalysis> typeAnalysis) {
		this.typeAnalysis = typeAnalysis;
	}

	public float getFinishRate() {
		return finishRate;
	}

	public void setFinishRate(float finishRate) {
		this.finishRate = finishRate;
	}
}
