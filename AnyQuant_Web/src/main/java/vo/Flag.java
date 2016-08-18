package vo;

import java.util.List;

import function.Function;

public class Flag {
	/**订单类型，可以只传入无参数的对象*/
	public Function orderType;
	/**出入场标志列表(内列表'且'，外列表'或')*/
	public List<List<Function>> flagList;
	public Flag(Function orderType, List<List<Function>> flagList) {
		super();
		this.orderType = orderType;
		this.flagList = flagList;
	}
	public Function getOrderType() {
		return orderType;
	}
	public void setOrderType(Function orderType) {
		this.orderType = orderType;
	}
	public List<List<Function>> getFlagList() {
		return flagList;
	}
	public void setFlagList(List<List<Function>> flagList) {
		this.flagList = flagList;
	}
	@Override
	public String toString() {
		return "Flag [orderType=" + orderType + ", flagList=" + flagList
				+ "]";
	}
}
