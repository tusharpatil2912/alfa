<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Leave Management System</title>
	


<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>	

<!-- <script>

	// $(function(){   });

	$(function(){
		// do stuff after DOM is ready
		// find all "a" tags where href contains "delete"
		$("a[href*=delete]").on("click", function(evt){
			if(confirm('Hey, are you sure to delete?')===false){
				evt.preventDefault();
			}
		});
	});
</script> -->
    <script type="text/javascript">
        function GetDays(){
                var fromdt = new Date(document.getElementById("fromDate").value);
                var todt = new Date(document.getElementById("toDate").value);
                return parseInt(((todt - fromdt) / (24 * 3600 * 1000))+1);
        }

        function cal(){
        if(document.getElementById("toDate")){
            document.getElementById("days2").value=GetDays();
        }  
    }

    </script>
</head>
<body>
	<div class="alert alert-info">
		<h1 class="container">Leave Management System</h1>
	</div>
	
	<div class="container">
		