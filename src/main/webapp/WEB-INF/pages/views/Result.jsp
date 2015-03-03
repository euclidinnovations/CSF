<html lang="en">
<head>
    <meta charset="utf-8">
    <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
    <title>Error - Harris Teeter</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .panel-heading {
    padding: 5px 15px;
}

.panel-footer {
	padding: 1px 15px;
	color: #A0A0A0;
}

.profile-img {
	width: 96px;
	height: 96px;
	margin: 0 auto 10px;
	display: block;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
}
body{content: "";
background: url("resources/images/watermark.png");
background-repeat: no-repeat;
background-attachment: fixed;
background-position: top;
top: 0;
left: 0;
bottom: 0;
right: 0;
position: absolute;
z-index: -1;
width: 100%;}
    </style>
    <script src="resources/js/jquery-1.11.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    
</head>
<body>
    <div class="container">
    	<div class="row">
    	<div class="col-sm-6"><a href="/csf"><img src="resources/images/logo.jpg" /></a></div>
    	
    	
    	
    	<br/>
    	<br/><br/><br/><br/><br/><br/><br/>
    	<br/><br/><center>    		
    			<h3> Order number ${message.orderId } not found</h3>
    			<br/>
    			<h4>If you would prefer to contact us by phone, our toll free number is <b>1-800-432-6111</b>. <br/><br/>you can also send an email to customerrelations@harristeeter.com</h4>
    		
    	<br/>
    	<form method="POST" action="${pageContext.request.contextPath}/login">
											<input type="submit" class="btn btn-success" value="Back">
    	</form></center></div>
    	</div>
    	
<script type="text/javascript">

</script>
</body>
</html>
