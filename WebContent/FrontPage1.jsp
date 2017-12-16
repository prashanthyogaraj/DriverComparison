<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Driver Comparison</title>
<style>
body{
background-color:transparent;
}


h1{
text-align : center;
font-family: "Comic Sans MS", "Comic Sans", cursive;
}

#select{
padding-top :5px;
pading-left : 50px;
}
#inp1{
padding-top: 10px;
}
#inp2{
padding-top : 10px;
 }
 #cec{
 padding-top : 15px:
 }
.my_dropdown {
height:35px;
}
.osdropdown{
height:35px;
}
input[type=text], input[type=text],input[type=text] {
	width: 100%;
    padding: 15px 25px;
    margin: 8px 0;
    display: inline-block;
    border-style: groove
    box-sizing: border-box;
	 margin: 0 auto;

}
#select{
	
        width : 100px;
        
}
#inphid{
	width :104px;
}
select.my_dropdown{
width:590%;
}
select.osdropdown{
width:590%;
}
#submit{
	align:center;
	background-color: #4CAF50;
    color: white;
    padding: 12px 18px;
    margin: 10px 0;
    border: none;
    cursor:pointer;
	width:30%;
	
	
}
#newsel{
width:107%;
height:35px;
}
#main{
border:none;
border-radius: 1px;
border-width :1px; 

width:50%;
border-bottom-width :150%;
height:300px; 
 margin: 0 auto;
    
   }
</style>
</head>
<body style="background-color:#f4f7f8;">
<script>
function hd(el){
//if(document.getElementById("osdrop").value="Single os file comparison"){
if(el.value == 0){

	document.getElementById('inphid').style.display = "block";
	document.getElementById('ostextbox').style.display = "block";
	 }
 else{
	 document.getElementById('inphid').style.display = "none";
	 document.getElementById('ostextbox').style.display = "none";
 }
} 
function addInput(){
	var num = document.getElementById('dropdown').value;
	//document.write(num);
	var input;
	var sel;
	if(num==0){
		 window.location="http://localhost:8080/DriverComparisonTool/Display.jsp";
	
		}
	else if (num==1){
		window.location="http://localhost:8080/DriverComparisonTool/Singleos.jsp";
	}
	else if (num==2){
		window.location="http://localhost:8080/DriverComparisonTool/clear.jsp";
	}
	else if (num==3){
		window.location="http://localhost:8080/DriverComparisonTool/Adapter.jsp";
	}
//	else if (num!=0){
	//	document.getElementById("newtext").remove();
	//	document.getElementById("newsel").remove();
	//	document.getElementById("sellabel").remove();
	//	document.getElementById("newlabel").remove();
		//main.removeChild(input);
//	}
}
</script>
<h1>Driver Comparison</h1>

<div id ="main" class="m_div">
<form name="my_form" action = "result" method = "post">
<table><tr><td>
Select the Input:</td></tr>
<tr><td><div id="select"><select class = "my_dropdown" name ="dropdown" value ="dropdown" id = "dropdown" style= "border-style:solid" onchange ="addInput()">
	<option>choose the test case</option>
	<option>VDS to VDS</option>
	<option>VDS to DriverRepo</option>
	<option>DriverRepo to DriverRepo</option>
<!-- <option value ="2">clearAllTextFile</option> -->
<!-- <option value = "1">Check Individual Os Content</option> -->
	<option value ="0">Check drivers by OS Name</option>
	<option value ="3">Check drivers by Adapter Vendor Name</option>
</select></div></td></tr>
<!--  <tr>
<td><input type="text" name="city" list="cityname">
<datalist id="cityname">
  <option value="Boston">
  <option value="Cambridge">
</datalist></td></tr>-->

<tr>
<td><div id ="inp1">Enter the URL1: <input type ="Text" name ="url1" "id = "url1" placeholder = "(e.g.https://cspg-releng.cisco.com/3rdparty/rack/3.0.3/Drivers)" size = "50"   style= "border-style:groove" style= "color:#dddddd" required/></div></td></tr>
<tr><td><div id ="inp2">
Enter the URL2: <input type = "text"  name = "url2" id = "url2" placeholder = "(e.g.https://cspg-releng.cisco.com/3rdparty/rack/2.0.13/Drivers)"Size = "50" style= "border-style:groove" required/></div></td>
</tr>
<tr>
<!-- <td><div id = "inphid" >Select the OS <select class = "osdropdown" id ="osdrop">
<option>Linux/</option>
<option>VMware/</option>
<option>Windows/</option>
<option>XenServer/</option>
</select>
</div></td></tr> -->

<!--<tr>
<td><div id ="ostextbox" >Enter the OS'es<input type ="text" name = "os" Size = "50" style= "border-style:groove" required></div></td></tr> -->
<tr>
<td><div id ="cec">Enter your CECID: <input type ="Text" name ="cecid" "id = "cecid" placeholder = "CEC ID" size = "50"   style= "border-style:groove" style= "color:#dddddd" required/></div></td></tr>
<tr>

 <td><input type ="submit" class="sub" name="submit" id ="submit" value = "submit" style= "border-style:groove" /></td></tr> 
<tr>
<td><h1>${Success }</h1></td></tr>
</table>
</form>
</div>

</body>
</html>