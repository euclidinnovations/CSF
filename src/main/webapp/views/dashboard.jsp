<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
	<title>Sign in Panel - Bootsnipp.com</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/css/style.css" rel="stylesheet">
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
	</style>
	<script src="../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/siteJquery.js"></script>
	<script>
		$(document).ready(function(){ 
			$("table.table tr").click(function(){				
				// similar behavior as an HTTP redirect
				window.location.replace("pages/csf.jsp");

				// similar behavior as clicking on a link
				window.location.href = "pages/csf.jsp";
			});
			$( ".top-profile" ).click(function() {				
			  $( ".dropdown-menu" ).toggle( "slow", function() {
			    // Animation complete.
			  });
			});
		});
		
	</script>		
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 nopad">
				<div class="col-sm-12 nopad"><img src="../resources/images/logo.jpg" /><div class="profile-menu right">
					 <div class="top-profile">
					  	 <span class="glyphicon glyphicon-user" aria-hidden="true"><span class="uname">Matthew</span></span>
					  	 <ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header bg-light-blue">
									<img src="../resources/images/avatar3.png" class="img-circle" alt="User Image">
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
					</div><!-- */ .profile-menu --></div>
			</div>
			<div class="col-sm-12 dashmenuCol">
			<div class="col-sm-12 dashmenu">
					<nav class="navbar navbar-default">
						<div class="container-fluid">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>      
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">								
								<div class="col-sm-12">
									<form class="navbar-form navbar-right" role="search">
										<button type="submit" class="btn btn-success">Recent Requests</button>
										<div class="form-group">
											<input type="text" class="form-control" placeholder="Search Orders">
										</div>																		
									</form>
								</div>
							</div><!-- /.navbar-collapse -->
						</div><!-- /.container-fluid -->
					</nav>
				</div>
			</div> 
			<div class="row dashboard">
				<div class="bs-example" data-example-id="table-within-panel">
					<div class="panel panel-default" style="clear:both;">
						<!-- Default panel contents -->
						<div class="panel-heading">Outstanding Orders</div>
						<!-- Table -->
						<table class="table">
							<thead>
								<tr>
									<th>Order #</th>
									<th>Time</th>            
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row"><span class="spancenter">1</span></th>
									<td>2.00 PM</td>
								</tr>
								<tr>
									<th scope="row"><span class="spancenter">2</span></th>
									<td>3.30 PM</td>
								</tr>
								<tr>
									<th scope="row"><span class="spancenter">3</span></th>
									<td>6.00 PM</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</body>
		</html>
