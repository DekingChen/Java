package dk.or;
//import java.util.Date;

/**
 * feature selector
 * 用于储存各证据计算后的域值
 * @author feng
 * 2016年3月8日
 **/
public class EvidenceThreshold implements Comparable<EvidenceThreshold>{

	private String evidence;
	private Boolean isPositive = false;
	private Double threshold;
	
	private Double p1;
	
	private Double p2;
	
	private Double orvalue;
	
	
	public EvidenceThreshold() {}
	
	
	public EvidenceThreshold(String evidence, Boolean isPositive,
			Double threshold, Double p1, Double p2, Double orvalue) {
		super();
		this.evidence = evidence;
		this.isPositive = isPositive;
		this.threshold = threshold;
		this.p1 = p1;
		this.p2 = p2;
		this.orvalue = orvalue;
	}


	public int compareTo(EvidenceThreshold o) {
		if (o==null) {
			return 1;
		}
		int i;
		if(this.orvalue==o.getOrvalue()){
			i = 0;
		}else if (this.orvalue>o.getOrvalue()) {
			i = 1;
		}else {
			i = -1;
		}

		return i;
	}
	

	
	@Override
	public String toString() {
		return "EvidenceThreshold [evidence=" + evidence + ", isPositive="
				+ isPositive + ", threshold=" + threshold + ", p1=" + p1
				+ ", p2=" + p2 + ", orvalue=" + orvalue +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orvalue == null) ? 0 : orvalue.hashCode());
		result = prime * result
				+ ((threshold == null) ? 0 : threshold.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvidenceThreshold other = (EvidenceThreshold) obj;
		if (orvalue == null) {
			if (other.orvalue != null)
				return false;
		} else if (!orvalue.equals(other.orvalue))
			return false;
		if (threshold == null) {
			if (other.threshold != null)
				return false;
		} else if (!threshold.equals(other.threshold))
			return false;
		return true;
	}

	public String getEvidence() {
		return evidence;
	}

	public Boolean getIsPositive() {
		return isPositive;
	}

	public Double getThreshold() {
		return threshold;
	}

	public Double getP1() {
		return p1;
	}

	public Double getP2() {
		return p2;
	}

	public Double getOrvalue() {
		return orvalue;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public void setIsPositive(Boolean isPositive) {
		this.isPositive = isPositive;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public void setP1(Double p1) {
		this.p1 = p1;
	}

	public void setP2(Double p2) {
		this.p2 = p2;
	}

	public void setOrvalue(Double orvalue) {
		this.orvalue = orvalue;
	}
	
	
}

