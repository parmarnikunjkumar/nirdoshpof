<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/redmond/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" href="css/style.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript">
	$(function(){
		$("#birthday").datepicker({
			showButtonPanel:true,
			changeMonth: true,
		      changeYear: true
		});
		$("#time").timepicker();
		$("#calendar_button").button();
	});
</script>
</head>
<body>
<div id="container">
	<div id="header">
		<p><h1 class="center"><b>MY SHOP</b></h1></p>
	</div>
	<div id="content">	
		<div id="caleder_pos">
			<input type="text" id="birthday"/>			
		</div>	
		<div id="time_pos">
			<input type="text" id="time"/>
		</div>	
		<div id="time_pos">
			<input type="submit" id="calendar_button" value="Set An Appointment" />
		</div>
	</div>
	<div id="footer">
		<p><h4 align="center">@copyright  ashish ayurveda </h4></p>
	</div>
</div>

</body>
</html>