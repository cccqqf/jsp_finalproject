<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<% 
		int malecount=0;
		int femalecount=0;
		if(application.getAttribute("maleCount")!=null){
			malecount=(int)application.getAttribute("maleCount"); 
		}
		if(application.getAttribute("femaleCount")!=null){
			femalecount=(int)application.getAttribute("femaleCount");
		}
	%>
	<div id="container" style="color: #fff"></div>
	男生在线人数：<%=application.getAttribute("maleCount") %><br /> 女生在线人数:<%=application.getAttribute("femaleCount") %>
	<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
	<script>

var width = 400;
var height = 400;
var male= '<%=malecount%>';
var female='<%=femalecount%>';
if(male==0){
	var dataset = [["女生",female]];
}else if(female==0){
	var dataset = [["男生",male]];
}else if(male!=0&&female!=0){
	var dataset = [["男生",male],["女生",female]];
}


var svg = d3.select("#container")
			.append("svg")
			.attr("width", width)
			.attr("height", height);

var pie = d3.layout.pie().value(function(d){return d[1]; });

var piedata = pie(dataset);

var outerRadius = 150;	
var innerRadius = 0;	

var arc = d3.svg.arc()	
			.innerRadius(innerRadius)
			.outerRadius(outerRadius);

var color = d3.scale.category10();

var arcs = svg.selectAll("g")
			  .data(piedata)
			  .enter()
			  .append("g")
			  .attr("transform","translate("+ (width/2) +","+ (width/2) +")");
			  
arcs.append("path")
	.attr("fill",function(d,i){
		return color(i);
	})
	.attr("d",function(d){
		return arc(d);
	});

arcs.append("text")
	.attr("transform",function(d){
		return "translate(" + arc.centroid(d) + ")";
	})
	.attr("text-anchor","middle")
	.text(function(d){
		return d.data[0]+":"+d.data[1];
	});

console.log(dataset);
console.log(piedata);
  
      </script>
</body>
</html>