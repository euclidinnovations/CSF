<html lang="en">
<head>
    <meta charset="utf-8">
    <title>CSF</title>
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
    </style>
    <script src="resources/js/jquery-1.11.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
    	<div class="row">
    	<div class="col-sm-6"><a href="/csf"><img src="resources/images/logo.jpg" /></a></div>
    	</div>
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> Welcome to CSF Application</strong>
					</div>
					<div class="panel-body">
						<form method="POST" action="${pageContext.request.contextPath}/login">
							<fieldset>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">										
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-primary btn-block" value="Load Data from Workbench">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>					
                </div>
			</div>
		</div>
	</div>
<script type="text/javascript">

</script>
</body>
</html>
