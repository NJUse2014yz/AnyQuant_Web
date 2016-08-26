package function.choose;

public class ConceptVO {
	public String concept;

	public ConceptVO(String concept) {
		super();
		this.concept = concept;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	@Override
	public String toString() {
		return "ConceptVO [concept=" + concept + "]";
	}
	
}
