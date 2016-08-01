function table(data,attrs,idName){
	$("table#"+idName+" tr#auto").remove();
	//遍历数组
	$.each(data,function(i,vo){
		
		htm="<tr id='auto'>";
		//遍历属性
		$.each(attrs,function(i,attr){
			htm+="<td>"+vo[attr]+"</td>";
		});
		htm+="</tr>";
		
		$("table#"+idName).append(htm);
	});
}



//监听点击股票事件
function selectStockListener(data,key,idName){
	var index=0;
	$.each(data,function(i,vo){
		var id='"'+vo[key]+'"';
		$("table#"+idName+" tr#auto").eq(index).attr("onclick","requiryStock("+id+")");
		index++;
	});
}
//跳转到相应股票页面
function requiryStock(id){
	window.location.href="/AnyQuant_web/stockInfo.action?id="+id;
}