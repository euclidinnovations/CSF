<!DOCTYPE html>
<head>
	<meta charset="utf-8">	
	<title>CSF - Harris Teeter</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/css/bootstrap.css" rel="stylesheet">
	<link href="../resources/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="../resources/css/style.css" rel="stylesheet">	
	<!--[if gte IE 8]>
	<link href="../resources/css/ie8-and-up.css" rel="stylesheet"  /></link>
	<![endif]-->

	<link href="../resources/css/jquery-ui.css" rel="stylesheet">	
	<!-- <link href="../resources/css/chosen.css" rel="stylesheet"> -->

	<script src="../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>	
	<script src="../resources/js/jquery-ui.js"></script>
	<script src="../resources/js/jqueryDobPicker.js"></script>
	<script src="../resources/js/jquery.placeholder.js"></script>
	<script src="../resources/js/jquery.corner.js"></script>	
	<script src="../resources/js/siteJquery.js"></script>
</head>
<body>    	
	<div class="container">
		<div class="row">
			<div class="col-sm-6"><a href="/csf"><img src="../resources/images/logo.jpg" /></a></div>
		</div>
	</div>
	<div class="container csf gtie8 orderid">
		<form>
			<div class="row">			
				<div class="col-sm-7">		
					<div class="bs-example table-bordered pad10 box-border-background" data-example-id="striped-table">							
						<div id="enterorderid" class="table-bordered borderwhite">
							<h4>Please enter the Order ID for which you want the CSF generated</h4>
							<div class="form-group">								
								<input type="email" class="form-control width50 pad15" id="exampleInputEmail1" placeholder="Enter orderid here..." name="orderid">
							</div>							
							<button type="submit" class="btn btn-success">Submit</button>
						</div><!-- /.billing_items_div -->
					</div>
				</div><!-- /.col-sm-12 -->	
			</div><!-- .row */ -->		 
		</form>
	</div><!-- .container csf */ -->	
	<div id="dialog-confirm" title="Are you sure?" style="display:none;">
		<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>These items will be permanently deleted and cannot be recovered. Are you sure?</p>
	</div>
	<script src="../resources/js/chosen.jquery.js" type="text/javascript"></script>

	<script type="text/javascript">
		var config = {
			'.chosen-select'           : {},
			'.chosen-select-deselect'  : {allow_single_deselect:true},
			'.chosen-select-no-single' : {disable_search_threshold:10},
			'.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
			'.chosen-select-width'     : {width:"95%"}
		}
		for (var selector in config) {
			$(selector).chosen(config[selector]);
		}    
/*$("#select1").append("<option value='addValue' selected='selected'>addValue</option>");
this.$('select#select1').append('<option>newvalue</option>');
$("#select1").append('<option value="option6">option6</option>');*/
</script> 							
</body>
</html>