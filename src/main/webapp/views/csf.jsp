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
	<div class="container csf gtie8">
		<form>
<!-- <div class="row">
<div class="col-sm-6"><img src="../resources/images/logo.jpg" /></div>
</div> --><!-- .row */ -->
<!-- <hr width="97.6%" align="left"> -->
<div class="row">	
	<div class="col-sm-12">
		<div class="col-sm-7">
			<h4>
				<span class="label label-default left w100">Shopping for :</span><span class="custname custtext underline">MATTHEW SMITHSON</span>
			</h4>
			<h4>
				<span class="label label-default left w100">Picking UP on :</span><span class="custtext">10/3/2015 @ 3:00 PM</span>
			</h4>
			<h4>
				<span class="label label-default left w100">VIC Card :</span><span class="custtext">41111111111</span>
			</h4>
			<h4>
				<span class="label label-default left w100">Address :</span><span class="custtext">13836, Ballantyne Meadows Drive, Charlotte, NC 28277</span>
			</h4>
			<h4>
				<span class="label label-default left w100">Phone # :</span><span class="custtext">(555)444-3333</span>
			</h4>
		</div>
		<div class="col-sm-4 right">
			<h4>
				<span class="custname custtext">$100.79</span><span class="label label-default left w100">Order total :</span>
			</h4>
			<h4 class="orderH4">
				<span class="custtext">7890123</span><span class="label label-default left w100 marright">Order # :</span>
			</h4>					
			<h4 class="vicsavingsH4">
				<span class="custtext">$35</span><span class="label label-default left w100 marright">VIC Savings :</span>
			</h4>
		</div>
	</div> <!-- .col-sm-12 */ -->
</div><!-- .row */ -->	
<div class="row martop20">
	<!-- <hr width=97.6% align=left> -->
	<div class="col-sm-12">
		<!-- <h3 class="success">Add out of stock items</h3> -->
		<div class="bs-example table-bordered pad10 box-border-background" data-example-id="striped-table">							
			<div id="billing_items_div" class="table-bordered borderwhite">
				<h3>Modified Items</h3>
				<table class="table table-striped" id='bill_table' rules="all">
					<thead>
						<tr class="headings">
							<!-- <th>#</th> -->
							<th>Items Ordered</th>
							<th>Item Substituted</th>
							<!-- <th>Notes</th> -->
							<th>Delete ?</th>
						</tr>
					</thead>
					<tbody>				      
						<tr id="tr1" class="outofstockrow">
							<!-- <th scope="row">1</th> -->
							<td class="title">Oranges</td>
							<td>
								<div id="sidd1">
									<input type="text" class="form-contorl input-xlarge pad15 width" id="sidd1_input" value="No item substituted"/>
									<span class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" title="tr1" ><img src="../resources/images/dropdown-arrow.png" /></span>      									               
									<ul class="dropdown-menu" role="menu">
										<li role="presentation"><a title="sidd1" href="javascript:void(0)" class="si">Florida Organges</a></li>
										<li role="presentation"><a title="sidd1" href="javascript:void(0)" class="si">Kesar Mengo</a></li> 
										<li role="presentation"><a title="sidd1" href="javascript:void(0)" class="si">China Guava</a></li> 
										<li role="presentation"><a title="sidd1" href="javascript:void(0)" class="si">Hawaien Apple</a></li> 
										<li role="presentation"><a title="sidd1" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>                                            
									</ul>
								</div>																			</td>
								<!-- <td class="notes"><div contenteditable="true">Nice and great!!!</div></td> -->
								<td class="trash"><button id='1' type="button" class="btn delete" aria-label="Left Align">
									<span><img src="../resources/images/trash.png" /></span>
								</button>
							</td>
						</tr>
						<tr id="tr2" class="outofstockrow">
							<!-- <th scope="row">2</th> -->
							<td class="title">Pineapple</td>
							<td>
								<div id="sidd2">
									<input type="text" class="form-contorl input-xlarge pad15 width" id="sidd2_input" value="No item substituted"/>
									<span class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" title="tr2"><img src="../resources/images/dropdown-arrow.png" /></span>
									<ul class="dropdown-menu" role="menu">
										<li role="presentation"><a title="sidd2" href="javascript:void(0)" class="si">Florida Organges</a></li>
										<li role="presentation"><a title="sidd2" href="javascript:void(0)" class="si">Kesar Mengo</a></li> 
										<li role="presentation"><a title="sidd2" href="javascript:void(0)" class="si">China Guava</a></li> 
										<li role="presentation"><a title="sidd2" href="javascript:void(0)" class="si">Hawaien Apple</a></li> 
										<li role="presentation"><a title="sidd2" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>                                            
									</ul>
								</div>
							</td>
							<!-- <td class="notes"><div contenteditable="true">Juicy & sweet</div></td> -->
							<td class="trash">
								<button id='2' type="button" class="btn delete" aria-label="Left Align">
									<span><img src="../resources/images/trash.png" /></span>
								</button>
							</td>
						</tr>	
						<tr id="tr3" class="outofstockrow">
							<!-- <th scope="row">3</th> -->
							<td class="title">Apple</td>
							<td>
								<div id="sidd3">
									<input type="text" class="form-contorl input-xlarge pad15 width" id="sidd3_input" value="No item substituted"/>
									<span class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" title="tr3"><img src="../resources/images/dropdown-arrow.png" /></span>
									<ul class="dropdown-menu" role="menu">
										<li role="presentation"><a title="sidd3" href="javascript:void(0)" class="si">Florida Organges</a></li>
										<li role="presentation"><a title="sidd3" href="javascript:void(0)" class="si">Kesar Mengo</a></li> 
										<li role="presentation"><a title="sidd3" href="javascript:void(0)" class="si">China Guava</a></li> 
										<li role="presentation"><a title="sidd3" href="javascript:void(0)" class="si">Hawaien Apple</a></li> 
										<li role="presentation"><a title="sidd3" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>                                            
									</ul>
								</div>
							</td>
							<!-- <td class="notes"><div contenteditable="true">Red and Yummy</div></td> -->
							<td class="trash">
								<button id='3' type="button" class="btn delete" aria-label="Left Align">
									<span><img src="../resources/images/trash.png" /></span>
								</button>
							</td>
						</tr>		
						<tr id="tr4" class="outofstockrow">
							<!-- <th scope="row">4</th> -->
							<td class="title">Guava</td>
							<td>
								<div id="sidd4">
									<input type="text" class="form-contorl input-xlarge pad15 width" id="sidd4_input" value="No item substituted"/>
									<span class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" title="tr4"><img src="../resources/images/dropdown-arrow.png" /></span>
									<ul class="dropdown-menu" role="menu">
										<li role="presentation"><a title="sidd4" href="javascript:void(0)" class="si">Florida Organges</a></li>
										<li role="presentation"><a title="sidd4" href="javascript:void(0)" class="si">Kesar Mengo</a></li> 
										<li role="presentation"><a title="sidd4" href="javascript:void(0)" class="si">China Guava</a></li> 
										<li role="presentation"><a title="sidd4" href="javascript:void(0)" class="si">Hawaien Apple</a></li> 
										<li role="presentation"><a title="sidd4" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>                                            
									</ul>
								</div>
							</td>
							<!-- <td class="notes"><div contenteditable="true">Green and medium soft</div>--></td>
							<td class="trash">
								<button id='4' type="button" class="btn delete" aria-label="Left Align">
									<span><img src="../resources/images/trash.png" /></span>
								</button>
							</td>
						</tr>
						<tr id="tr5" class="outofstockrow">
							<!-- <th scope="row">5</th> -->
							<td class="title">Watermelon</td>
							<td>
								<div id="sidd5">
									<input type="text" class="form-contorl input-xlarge pad15 width" id="sidd5_input" value="No item substituted"/>
									<span class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" title="tr5"><img src="../resources/images/dropdown-arrow.png" /></span>
									<ul class="dropdown-menu" role="menu">
										<li role="presentation"><a title="sidd5" href="javascript:void(0)" class="si">Florida Organges</a></li>
										<li role="presentation"><a title="sidd5" href="javascript:void(0)" class="si">Kesar Mengo</a></li> 
										<li role="presentation"><a title="sidd5" href="javascript:void(0)" class="si">China Guava</a></li> 
										<li role="presentation"><a title="sidd5" href="javascript:void(0)" class="si">Hawaien Apple</a></li> 
										<li role="presentation"><a title="sidd5" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>                                            
									</ul>
								</div>
							</td>
							<!-- <td class="notes"><div contenteditable="true">Big and watery</div></td> -->
							<td class="trash">
								<button id='5' type="button" class="btn delete" aria-label="Left Align">
									<span><img src="../resources/images/trash.png" /></span>
								</button>
							</td>
						</tr>
						<tr id="tr6" class="outofstockrow">
							<td colspan="3"><span class="title">Customer called and added item : </span><img src="../resources/images/plus24.png" id="addNewRow" /></td>
						</tr>
					</tbody>
				</table>				
			</div><!-- /.billing_items_div -->
		</div>
	</div><!-- /.col-sm-12 -->	
</div><!-- .row */ -->	
<!-- <hr width="97.6%" align="left"> -->
<div class="row dlvrdetails box-border-background pad10">
	<div class="col-sm-12 nopad">
		<!-- <h6>**Harris Teeter Policy Wrt Substitutions</h6> -->
		<h4>**Subsitution policy goes here. </h4>
		<div class="shopper_delivered">
			<h5><div>Your Personal Shopper today was</div><textarea class="input-xxlarge" name="personal_shopper" rows="5">[Written note]</textarea> <!-- <input type="text" class="input-large right" name="personal_shopper" value="James"> --></h5>
			<h5><div>Your Order was delivered by</div><textarea class="input-xxlarge delivered_by" name="delivered_by" rows="5">[Written note]</textarea> <!-- <input type="text" class="input-large delivered_by right" name="delivered_by" value="Stuart Lee"> --></h5>
		</div>
		<!-- <h6>**Please call us @1-800-432-6111 and let us know if there is anything we can do to make you Express Lane experience more enjoyable**</h6> -->
		<h6 class="left nomar"><br>Please call us @ 555-555-1212 and let us know about your experience and how we can make it better!</h6>
	</div>	
</div>		
<div class="row dlvrdetails box-border-background pad10">
<div class="col-sm-12 nopad marbot10 marbot29">
<h5><div class="left">Special Instructions : </div><div class="font15 text-info left marleft15">I want my order to be delivered after 1week.</div></h5>
</div>
</div> 
<div class="row homeshopper">
	<div class="col-sm-9" style="float:none;margin:0 auto;">
		<div class="bs-example" data-example-id="simple-responsive-table">
			<div class="table-responsive box-border-background">
				<h3>Home Shopper Section<span class="hide-oosi"><img src="../resources/images/minus24.png" /></span><span class="show-oosi"><img src="../resources/images/plus24.png" /></span></h3>
				<hr>	
				<table class="table table-bordered" id="HSS">
					<thead>
						<tr class="headings">
							<th style="width:35%;">Department</th>
							<th style="width:30%;"># Bags</th>
							<th style="width:30%;">Section #</th>
							<!-- <th>Notes</th> -->            
						</tr>
					</thead>
					<tbody>
						<tr id="HStr1" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr1" aria-label="Left Align"><span><img src="../resources/images/trash.png" /></span></button> --><span class="marleft0">Dry Goods</span></td>
							<td><input type="text" class="form-contorl input-medium" name="drygoods_bags" value="1" /></td>
							<td><input type="text" class="form-contorl input-medium" name="drygoods_section" value="4" /></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="drygoods_notes" value="Bag is made from jute" /></td> -->
						</tr>
						<tr id="HStr2" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr2" aria-label="Left Align"><span><img src="../resources/images/trash.png" /></span></button> --><span class="marleft0">Perishables</span></td>
							<td><input type="text" class="form-contorl input-medium" name="perishables_bags" value="1" /></td>
							<td><input type="text" class="form-contorl input-medium" name="perishables_section" value="6" /></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="perishables_notes" value="Please see expiry date" /></td> -->
						</tr>
						<tr id="HStr3" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr3" aria-label="Left Align"><span><img src="../resources/images/trash.png" /></span></button> --><span class="marleft0">Frozen</span></td>
							<td><input type="text" class="form-contorl input-medium" name="frozen_bags" value="2" /></td>
							<td><input type="text" class="form-contorl input-medium" name="frozen_section" value="9" /></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="frozen_notes" value="It's fresh and tasty" /></td> -->
						</tr>
						<tr id="HStr4" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr4" aria-label="Left Align"><span><img src="../resources/images/trash.png" /></span></button> --><span class="marleft0">Hot</span></td>
							<td><input type="text" class="form-contorl input-medium" name="hot_bags" value="N/A" /></td>
							<td><input type="text" class="form-contorl input-medium" name="hot_section" value="N/A"/></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="hot_notes" value="N/A"/></td> -->
						</tr>
						<tr id="HStr5" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr5" aria-label="Left Align"><span><img src="../resources/images/trash.png" /></span></button> --><span class="marleft0">Floral</span></td>
							<td><input type="text" class="form-contorl input-medium" name="floral_bags" value="1" /></td>
							<td><input type="text" class="form-contorl input-medium" name="floral_section" value="12" /></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="floral_notes" value="Neat and clean ones" /></td> -->
						</tr>	                            
						<tr id="HStr6" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr6" aria-label="Left Align"><span><img src="../resources/images/trash.png" /></span></button> --><span class="marleft0">Rx</span></td>
							<td colspan="3">
								<select name="rx_dd" id="rx_dd">
									<option value="Yes">Yes</option>
									<option value="No">No</option>
								</select>
							</td>
						</tr>
						<tr id="HStr7" class="section2 HSStr">
							<td>Customer Called?</td>
							<td><select name="cc_dd" id="cc_dd">
								<option value="Yes">Yes</option>
								<option value="No" selected="selected">No</option>
							</select></td>
							<td rowspan="3">Notes about call <br> <input type="text" class="form-contorl input-xlarge w202 martop10 height" name="custcalled_message" value="Just inquired about shipping" /></td>
						</tr>
						<tr id="checkID" class="HSStr">
							<td>Check ID</td>
							<td><select name="ci_dd" id="ci_dd">
								<option value="N/A">N/A</option>
								<option value="Yes">Yes</option>
								<option value="No">No</option>
							</select>
						</td>            
					</tr>
					<tr id="HStr8" class="HSStr">
						<td><span class="dobtxt">Enter DOB :</span> 
							<td colspan="2"><div class="row dob">
								<div class="col-xs-3">
									<select id="dobday" class="form-control input-sm"></select>
								</div>
								<div class="col-xs-3">
									<select id="dobmonth" class="form-control input-sm"></select>
								</div>
								<div class="col-xs-3">
									<select id="dobyear" class="form-control input-sm"></select>
								</div>		
							</div>
						</td>
					</td>
				</tr>
				<tr id="HStr9" class="payment HSStr">
					<td>Payment</td>
					<td colspan="3"><select name="ci_dd" id="ci_dd">
						<option value="Credit">Credit</option>
						<option value="Check">Check</option>
						<option value="Cash">Cash</option>
					</select>
				</td>            
			</tr>
			<tr id="HStr10" class="HSStr">
				<td class="toppad10">Coupons Reedemed</td>
				<td><input type="text" class="form-contorl input-medium martop10" name="couponRedeemed" value="N/A"/></td>
				<td colspan="2">Received : <input type="text" class="form-contorl input-large w202 martop10 height" name="couponReceived" value="N/A" /></td>                  
			</tr>
			<tr id="HStr11" class="HSStr">
				<td class="valignmiddle toppad10">Additional Notes</td>
				<td colspan="3"><textarea class="input-xxlarge" name="notesspace">1. Ruffles potato chips&#13;&#10;2. Tropicana orange juice - no pulp
				</textarea></td>                  
			</tr>         
		</tbody>

	</table>

	<table class="table table-bordered"> <tr id="HStr12" class="HSStr"><td colspan="4"><div class="row">	
		<div class="col-sm-12 textcenter">
			<button type="submit" class="btn btn-success martop15">Save</button>
			<button type="submit" class="btn btn-primary martop15">Print</button>
			<button type="submit" class="btn btn-warning martop15">Email</button>
		</div>
	</div> </td></tr></table>		
</div><!-- /.table-responsive -->

</div>		
</div>
</div> 
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