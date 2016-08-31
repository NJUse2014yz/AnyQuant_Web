package function;

public enum ResultType {
	BOOLEAN(1),
	INT(2),
	DOUBLE(3),
	STRING(4),
	LONG(5),
	INTLIST(6),
	DOUBLELIST(7),
	STRINGLIST(8),
	LONGLIST(9);
	
	private int code;
	
	private ResultType(int value)
	{
		code=value;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public static ResultType getEnum(int code)
	{
		switch(code)
		{
		case 1:
			return BOOLEAN;
		case 2:
			return INT;
		case 3:
			return DOUBLE;
		case 4:
			return STRING;
		case 5:
			return LONG;
		case 6:
			return INTLIST;
		case 7:
			return DOUBLELIST;
		case 8:
			return STRINGLIST;
		case 9:
			return LONGLIST;
		default:
			return null;	
		}
	}
}
