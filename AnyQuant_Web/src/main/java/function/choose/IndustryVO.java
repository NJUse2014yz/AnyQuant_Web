package function.choose;

public class IndustryVO {
	public String industry;

	public IndustryVO(String industry) {
		super();
		this.industry = industry;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Override
	public String toString() {
		return "IndustryVO [industry=" + industry + "]";
	}
	
}
