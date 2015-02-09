<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
	<title>Sign in Panel - Bootsnipp.com</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">	
	<!--[if gte IE 8]>
	<link href="../resources/css/ie8-and-up.css" rel="stylesheet"  /></link>
	<![endif]-->
	<style type="text/css">
		
	</style>
	<link href="resources/css/jquery-ui.css" rel="stylesheet">	
	<!-- <link href="../resources/css/chosen.css" rel="stylesheet"> -->

	<script src="resources/js/jquery-1.11.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/jquery-ui.js"></script>
	<script src="resources/js/jqueryDobPicker.js"></script>
	<script src="resources/js/jquery.placeholder.js"></script>
	<script src="resources/js/jquery.corner.js"></script>	
	<script src="resources/js/siteJquery.js"></script>		
</head>
<body>
	<div class="container dashboard">
		<div class="row">
			<div class="col-sm-12 nopad">
				<div class="col-sm-12 nopad"><img src="resources/images/logo.jpg" /><div class="profile-menu right">
					 <div class="top-profile">
					  	 <span class="usericon" aria-hidden="true"><span class="uname">Matthew</span></span>
					  	 <ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header bg-light-blue">
									<img src="resources/images/avatar.png" class="img-circle" alt="User Image" />
									<p>
									Matthew Smithson<!--  - Businessman -->
									<small>Member since Nov. 2012</small>
									</p>
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
						 </ul><!-- */ .dropdown-menu -->
					 </div>								 					 							 
					</div><!-- */ .profile-menu -->
				</div>
			</div>
			<div class="col-sm-12 dashmenuCol">
				<div class="col-sm-12 dashmenu">					
					<form id="searchForm" class="navbar-form navbar-right" role="search">
						<a class="btn btn-info" id="recentRequests">Recent Requests</a>
						<div class="row dropdown-menu col-sm-12">
						  <div class="col-sm-6">
						    <div class="input-group">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="button">Order ID</button>
						      </span>
						      <input type="text" class="form-control">
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
						  <div class="col-sm-6">
						    <div class="input-group">
						      <input type="text" class="form-control">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="button">Phone</button>
						      </span>
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
						  <div class="col-sm-6 martop10">
						    <div class="input-group">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="button">Last name</button>
						      </span>
						      <input type="text" class="form-control">
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
						  <div class="col-sm-6 martop10">
						    <div class="input-group">
						      <input type="text" class="form-control">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="button">VIC</button>
						      </span>
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
						  <button type="submit" class="btn btn-success">Search</button>
						</div><!-- /.row -->					 		
					</form>
				</div>
			</div> 
			<div class="searchResults OSO">
				<div class="row">
			        <div class="col-md-12 f6 maintitle">Search results</div>			        
				</div>
				<div class="row header">
			        <div class="col-md-3 ff bold title">Order ID</div>
			        <div class="col-md-3 ff bold title">Last Name</div>
			        <div class="col-md-3 ff bold title">Date/Time</div>
			        <div class="col-md-3 ff bold title">Store</div>
				</div>				
				<div class="row data">
			        <div class="col-md-3 f6">457845</div>
			        <div class="col-md-3 f6">Larson</div>
			        <div class="col-md-3 f6">1/25/15 @ 3.45PM</div>
			        <div class="col-md-3 f6">ABC</div>
				</div>
				<div class="row data">
			        <div class="col-md-3 ff">784512</div>
			        <div class="col-md-3 ff">Clarke</div>
			        <div class="col-md-3 ff">4/24/15 @ 11.11AM</div>
			        <div class="col-md-3 ff">XMY</div>
				</div>
				<div class="row data">
			        <div class="col-md-3 f6">457845</div>
			        <div class="col-md-3 f6">Larson</div>
			        <div class="col-md-3 f6">1/25/15 @ 3.45PM</div>
			        <div class="col-md-3 f6">ABC</div>
				</div>
				<div class="row data">
			        <div class="col-md-3 ff">784512</div>
			        <div class="col-md-3 ff">Clarke</div>
			        <div class="col-md-3 ff">4/24/15 @ 11.11AM</div>
			        <div class="col-md-3 ff">XMY</div>
				</div>				
			</div>
			<div class="blank_space"></div>
			<div class="OSO">
				<div class="row">
			        <div class="col-md-12 f6 maintitle">Outstanding Orders</div>			        
				</div>
				<div class="row header">
			        <div class="col-md-6 ff bold title">Order ID</div>
			        
			        <div class="col-md-6 ff bold title">Date/Time</div>
			        
				</div>				
				<div class="row data">
			        <div class="col-md-6 f6">457845</div>
			        
			        <div class="col-md-6 f6">1/25/15 @ 3.45PM</div>
			        
				</div>
				<div class="row data">
			        <div class="col-md-6 ff">784512</div>
			        
			        <div class="col-md-6 ff">4/24/15 @ 11.11AM</div>
			        
				</div>
				<div class="row data">
			        <div class="col-md-6 f6">457845</div>
			        
			        <div class="col-md-6 f6">1/25/15 @ 3.45PM</div>
			        
				</div>
				<div class="row data">
			        <div class="col-md-6 ff">784512</div>
			        
			        <div class="col-md-6 ff">4/24/15 @ 11.11AM</div>
			        
				</div>				
			</div>
			
			<h3>
				<a href="views/csf.jsp">Click here to See Welcome Message... </a>(to
				check Spring MVC Controller... @RequestMapping("/csf"))
			</h3>
		</body>
		</html>
