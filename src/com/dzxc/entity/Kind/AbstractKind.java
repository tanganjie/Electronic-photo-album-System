package com.dzxc.entity.Kind;

/**
 * AbstractKind entity provides the base persistence definition of the Kind
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKind implements java.io.Serializable {

	// Fields

	private Integer kindId;
	private String kindName;
	private String kindDesc;

	// Constructors

	/** default constructor */
	public AbstractKind() {
	}

	/** minimal constructor */
	public AbstractKind(String kindName) {
		this.kindName = kindName;
	}

	/** full constructor */
	public AbstractKind(String kindName, String kindDesc) {
		this.kindName = kindName;
		this.kindDesc = kindDesc;
	}

	// Property accessors

	public Integer getKindId() {
		return this.kindId;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public String getKindName() {
		return this.kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getKindDesc() {
		return this.kindDesc;
	}

	public void setKindDesc(String kindDesc) {
		this.kindDesc = kindDesc;
	}

}