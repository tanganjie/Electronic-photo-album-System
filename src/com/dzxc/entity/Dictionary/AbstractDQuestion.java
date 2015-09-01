package com.dzxc.entity.Dictionary;

/**
 * AbstractDQuestion entity provides the base persistence definition of the
 * DQuestion entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDQuestion implements java.io.Serializable {

	// Fields

	private Integer qusId;
	private String remark;

	// Constructors

	/** default constructor */
	public AbstractDQuestion() {
	}

	/** full constructor */
	public AbstractDQuestion(String remark) {
		this.remark = remark;
	}

	// Property accessors

	public Integer getQusId() {
		return this.qusId;
	}

	public void setQusId(Integer qusId) {
		this.qusId = qusId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}