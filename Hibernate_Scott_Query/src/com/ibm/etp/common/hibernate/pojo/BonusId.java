package com.ibm.etp.common.hibernate.pojo;

// Generated 2011-8-29 9:29:24 by Hibernate Tools 3.3.0.GA

/**
 * BonusId generated by hbm2java
 */
public class BonusId implements java.io.Serializable {

	private String ename;
	private String job;
	private Double sal;
	private Double comm;

	public BonusId() {
	}

	public BonusId(String ename, String job, Double sal, Double comm) {
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getSal() {
		return this.sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return this.comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BonusId))
			return false;
		BonusId castOther = (BonusId) other;

		return ((this.getEname() == castOther.getEname()) || (this.getEname() != null
				&& castOther.getEname() != null && this.getEname().equals(
				castOther.getEname())))
				&& ((this.getJob() == castOther.getJob()) || (this.getJob() != null
						&& castOther.getJob() != null && this.getJob().equals(
						castOther.getJob())))
				&& ((this.getSal() == castOther.getSal()) || (this.getSal() != null
						&& castOther.getSal() != null && this.getSal().equals(
						castOther.getSal())))
				&& ((this.getComm() == castOther.getComm()) || (this.getComm() != null
						&& castOther.getComm() != null && this.getComm()
						.equals(castOther.getComm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEname() == null ? 0 : this.getEname().hashCode());
		result = 37 * result
				+ (getJob() == null ? 0 : this.getJob().hashCode());
		result = 37 * result
				+ (getSal() == null ? 0 : this.getSal().hashCode());
		result = 37 * result
				+ (getComm() == null ? 0 : this.getComm().hashCode());
		return result;
	}

}
