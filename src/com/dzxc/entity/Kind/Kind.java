package com.dzxc.entity.Kind;

/**
 * Kind entity. @author MyEclipse Persistence Tools
 */
public class Kind extends AbstractKind implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Kind() {
	}

	/** minimal constructor */
	public Kind(String kindName) {
		super(kindName);
	}

	/** full constructor */
	public Kind(String kindName, String kindDesc) {
		super(kindName, kindDesc);
	}

}
