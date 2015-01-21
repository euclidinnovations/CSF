<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
	<title>CSF - Harris Teeter</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/css/bootstrap.css" rel="stylesheet">
	<link href="../resources/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="../resources/css/style.css" rel="stylesheet">	
	<link href="../resources/css/jquery-ui.css" rel="stylesheet">	
	<link href="../resources/css/chosen.css" rel="stylesheet">
	
	<script src="../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/siteJquery.js"></script>
	<script src="../resources/js/jquery-ui.js"></script>
	<script src="../resources/js/jqueryDobPicker.js"></script>
	<script>
	var itemCount = 2;

	$(document).ready(function(){ 	
		$('.dob, .dobtxt').hide();

		// Only notes td can be editable
		$("td.notes").click(function(){
			if($(this).attr("contentEditable") == true){
				$(this).attr("contentEditable","false");
			} else {
				$(this).attr("contentEditable","true");
			}
		})
				
		$(".delete").click(function() {
			var buttonId = $(this).attr("id");			
			var buttonCls = $("#tr"+ buttonId).attr("class");		
			//Start this is for the outofstock item row			
			if(buttonCls == 'outofstockrow'){			
				$( "#dialog-confirm" ).dialog({
			      resizable: false,
			      height:200,
			      width:450,
			      modal: true,
			      buttons: {
			        "Delete this item?": function() {
			          $("#tr"+ buttonId).remove();
			          $( this ).dialog( "close" );
			        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    });	
				//write the logic for removing from the array					
				//$("#tr"+ buttonId+" td:nth-child(4)").empty();							
				//if (confirm("Are you sure!") == true) {
				//	$("#tr"+ buttonId).remove();			
				//}
			}
			//End this is for the outofstock item row

			//Start this is for the Home Shopper Section
			var buttonName = $(this).attr("name");	
			if(buttonName == 'hss') {	
				var buttonVal = $(this).attr("value");				
				$( "#dialog-confirm" ).dialog({
			      resizable: false,
			      height:180,
			      width:450,
			      modal: true,
			      buttons: {
			        "Delete this item?": function() {
			          $("#"+buttonVal).remove(); //Deleting the Row (tr) Element
			          $( this ).dialog( "close" );
			        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    });								
				//if (confirm("Are you sure!") == true) {			        
			    //    $(this).parent().parent().remove(); //Deleting the Row (tr) Element
			    //}
			}
			//End this is for the Home Shopper Section 
		});

		$("input[type=radio]").click(function() {
			var buttonName = $(this).attr("name");	
			var buttonValue = $(this).attr("value");	
			if(buttonName == 'checkid' && buttonValue == 'yes'){
				$('.dob, .dobtxt').show();
				return true;
			}
			$('.dob, .dobtxt').hide();
		});

		$.dobPicker({
		    daySelector: '#dobday', /* Required */
		    monthSelector: '#dobmonth', /* Required */
		    yearSelector: '#dobyear', /* Required */
		    dayDefault: 'Day', /* Optional */
		    monthDefault: 'Month', /* Optional */
		    yearDefault: 'Year', /* Optional */
		    minimumAge: 8, /* Optional */
		    maximumAge: 100 /* Optional */
		});

		$(".hide-oosi").click(function() {
			$("#HSS").toggle( "slow" );
			$(".hide-oosi").hide();
			$(".show-oosi").show();
		});
		$(".show-oosi").click(function() {
			$("#HSS").toggle( "slow" );
			$(".hide-oosi").show();
			$(".show-oosi").hide();
		});
                
                $(".si").click(function() {
		 var ddValue = $(this).text();
                 var ddTitle = $(this).attr("title");
                 //alert("#"+ddTitle+" #"+ddTitle+"_input");
                 $("#"+ddTitle+" #"+ddTitle+"_input").val(ddValue);
		});
                
		$(".addthissubs").click(function() {
			
			var addName = $(this).attr("name");	
			var addID = $(this).attr("title");	
			var addValue = $("#"+addID).val();								
			//$(".chosen-select").append(new Option(addValue, addValue));
			/*$("#"+addName).append("<option value='"+addValue+"' selected='selected'>"+addValue+"</option>");			
			$("#"+addName+"_chosen .chosen-results").append('<li class="active-result" data-option-array-index="3">'+addValue+'</li>');*/
			//if(!addValue.length === 0 ){
				$("<option value='"+addValue+"' selected='selected'>"+addValue+"</option>").prependTo("#"+addName);
				$('<li class="active-result" data-option-array-index="3">'+addValue+'</li>').prependTo("#"+addName+"_chosen .chosen-results");
				/*$("#billing_items_div select").append("<option value='"+addValue+"' selected='selected'>"+addValue+"</option>");			
				$("#billing_items_div ul.chosen-results").append('<li class="active-result" data-option-array-index="3">'+addValue+'</li>');*/
				/*$("<option value='"+addValue+"' selected='selected'>"+addValue+"</option>").prependTo("#billing_items_div select");
				$('<li class="active-result" data-option-array-index="3">'+addValue+'</li>').prependTo("#billing_items_div ul.chosen-results");*/
				$(".no-results").remove();
			//}
		});	
	});
	</script>
	<!-- addRemove dependencies */ -->
</head>
<body>    
	<div class="container csf">
	<form>
		<div class="row">
			<div class="col-sm-6"><img src="../resources/images/logo.jpg" /></div>
		</div><!-- .row */ -->
		<hr width="97.6%" align="left">
		<div class="row">	
			<div class="col-sm-12">
				<div class="col-sm-6">
					<h4>
						<span class="label label-default left w100">Shopping for :</span><span class="custtext underline">MATTHEW SMITHSON</span>
					</h4>
					<h4>
						<span class="label label-default left w100">Picking UP on :</span><span class="custtext">10/3/2015 at 3:00 PM</span>
					</h4>
					<h4>
						<span class="label label-default left w100">VIC Card :</span><span class="custtext">41111111111</span>
					</h4>
					<h4>
						<span class="label label-default left w100">Phone # :</span><span class="custtext">(555)444-3333</span>
					</h4>
				</div>
				<div class="col-sm-6">
					<h4>
						<span class="label label-default left w100">Order # :</span><span class="custtext">7890123</span>
					</h4>
					<h4>
						<span class="label label-default left w100">Total :</span><span class="custtext">$100.79</span>
					</h4>
					<h4>
						<span class="label label-default left w100">VIC Savings :</span><span class="custtext">$35</span>
					</h4>
				</div>
			</div> <!-- .col-sm-12 */ -->
		</div><!-- .row */ -->	
		<div class="row">
			<!-- <hr width=97.6% align=left> -->
			<div class="col-sm-12">
				<!-- <h3 class="success">Add out of stock items</h3> -->
				<div class="bs-example table-bordered pad10 box-border-background" data-example-id="striped-table">							
					<div id="billing_items_div" class="table-bordered borderwhite">
					<h3>Out of stock items</h3>
						<table class="table table-striped" id='bill_table' rules="all">
							<thead>
								<tr class="headings">
									<th>#</th>
									<th>Items Originally Ordered</th>
									<th>Item Substituted</th>
									<th>Notes</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>				      
								<tr id="tr1" class="outofstockrow">
									<th scope="row">1</th>
									<td class="title">Oranges</td>
									<td>
                                                                            <div id="sidd1">                                                                            
                                                                              <input type="text" class="form-contorl input-xlarge pad15" id="sidd1_input" placeholder="No item substituted" />
                                                                              <span class="glyphicon glyphicon-chevron-down dropdown-toggle" data-toggle="dropdown" aria-expanded="true" ></span>                                                                            
                                                                              <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                                                               <li role="presentation"><a title="sidd1" href="javascript:void(0)" class="si">Florida Organges</a></li>
                                                                               <li role="presentation"><a title="sidd1" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>                                            
                                                                              </ul>
                                                                            </div>																			</td>
									<td class="notes">Nice and great!!</td>
									<td class="trash"><button id='1' type="button" class="btn delete" aria-label="Left Align">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</button>
								</td>
							</tr>
							<tr id="tr2" class="outofstockrow">
								<th scope="row">2</th>
								<td class="title">Pineapple</td>
								<td>
                                                                    <div id="sidd2">                                                                            
                                                                     <input type="text" class="form-contorl input-xlarge pad15" id="sidd2_input" placeholder="No item substituted" />
                                                                      <span class="glyphicon glyphicon-chevron-down dropdown-toggle" data-toggle="dropdown" aria-expanded="true" ></span>                                                                            
                                                                      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                                                       <li role="presentation"><a title="sidd2" href="javascript:void(0)" class="si">Florida Organges</a></li>
                                                                       <li role="presentation"><a title="sidd2" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>                                            
                                                                      </ul>
                                                                    </div>
								</td>
								<td class="notes">Juicy & sweet</td>
								<td class="trash">
									<button id='2' type="button" class="btn delete" aria-label="Left Align">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</button>
								</td>
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
	 	<h6>**Our policy regarding subsitutions…</h6>
	 	<h5>Your Personal Shopper today was <input type="text" class="input-large" name="personal_shopper" value="James"></h5>
	 	<h5>Your Order was delivered by <input type="text" class="input-large delivered_by" name="delivered_by" value="Stuart Lee"></h5>
	 	<!-- <h6>**Please call us @1-800-432-6111 and let us know if there is anything we can do to make you Express Lane experience more enjoyable**</h6> -->
	 	<h6 class="left nomar">Please call us @ 555-555-1212 and let us know about your experience and how we can make it better!</h6>
	 </div>	
	</div>		
	<div class="row homeshopper">
	 <div class="col-sm-12">
	    <div class="bs-example" data-example-id="simple-responsive-table">
    <div class="table-responsive box-border-background">
      <h3>Home Shopper Section<span class="glyphicon glyphicon-minus-sign hide-oosi"></span><span class="glyphicon glyphicon-plus-sign show-oosi"></span></h3>
      <hr>	
      <table class="table table-bordered" id="HSS">
        <thead>
          <tr class="headings">
            <th>Department</th>
            <th># Bags</th>
            <th>Section #</th>
            <th>Notes</th>            
          </tr>
        </thead>
        <tbody>
        <tr id="HStr1">
            <td><button type="button" class="btn delete" name="hss" value="HStr1" aria-label="Left Align"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button><span class="marleft0">Dry Goods</span></td>
            <td><input type="text" class="form-contorl input-medium" name="drygoods_bags" value="1" /></td>
            <td><input type="text" class="form-contorl input-medium" name="drygoods_section" value="4" /></td>
            <td><input type="text" class="form-contorl input-xxlarge" name="drygoods_notes" value="Bag is made from jute" /></td>
        </tr>
        <tr id="HStr2">
            <td><button type="button" class="btn delete" name="hss" value="HStr2" aria-label="Left Align"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button><span class="marleft0">Perishables</span></td>
            <td><input type="text" class="form-contorl input-medium" name="perishables_bags" value="1" /></td>
            <td><input type="text" class="form-contorl input-medium" name="perishables_section" value="6" /></td>
            <td><input type="text" class="form-contorl input-xxlarge" name="perishables_notes" value="Please see expiry date" /></td>
        </tr>
        <tr id="HStr3">
            <td><button type="button" class="btn delete" name="hss" value="HStr3" aria-label="Left Align"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button><span class="marleft0">Frozen</span></td>
            <td><input type="text" class="form-contorl input-medium" name="frozen_bags" value="2" /></td>
            <td><input type="text" class="form-contorl input-medium" name="frozen_section" value="9" /></td>
            <td><input type="text" class="form-contorl input-xxlarge" name="frozen_notes" value="It's fresh and tasty" /></td>
        </tr>
        <tr id="HStr4">
            <td><button type="button" class="btn delete" name="hss" value="HStr4" aria-label="Left Align"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button><span class="marleft0">Hot</span></td>
            <td><input type="text" class="form-contorl input-medium" name="hot_bags" value="N/A" /></td>
            <td><input type="text" class="form-contorl input-medium" name="hot_section" value="N/A"/></td>
            <td><input type="text" class="form-contorl input-xxlarge" name="hot_notes" value="N/A"/></td>
        </tr>
        <tr id="HStr5">
            <td><button type="button" class="btn delete" name="hss" value="HStr5" aria-label="Left Align"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button><span class="marleft0">Floral</span></td>
            <td><input type="text" class="form-contorl input-medium" name="floral_bags" value="1" /></td>
            <td><input type="text" class="form-contorl input-medium" name="floral_section" value="12" /></td>
            <td><input type="text" class="form-contorl input-xxlarge" name="floral_notes" value="Neat and clean ones" /></td>
        </tr>	                            
        <tr id="HStr6">
            <td><button type="button" class="btn delete" name="hss" value="HStr6" aria-label="Left Align"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button><span class="marleft0">Rx</span></td>
            <td colspan="3"><span class="spanInput"><input type="radio" class="form-contorl input-medium" name="rx" value="yes" /></span><span class="spanRadio">Yes</span><span class="spanInput marleft15"><input type="radio" class="form-contorl input-medium" name="rx" value="no" checked="checked" /></span><span class="spanRadio">No</span></td>
          </tr>
          <tr class="section2">
            <td>Customer Called?</td>
            <td><span class="spanInput"><input type="radio" class="form-contorl input-medium" name="custcalled" value="yes" checked="checked"/></span><span class="spanRadio">Yes</span><span class="spanInput marleft15"><input type="radio" class="form-contorl input-medium" name="custcalled" value="no" /></span><span class="spanRadio">No</span></td>
            <td colspan="2">Message : <input type="text" class="form-contorl input-xlarge martop10" name="custcalled_message" value="Just inquired about shipping" /></td>
          </tr>
          <tr>
            <td>Check ID</td>
            <td><span class="spanInput"><input type="radio" class="form-contorl input-medium" name="checkid" value="yes" /></span><span class="spanRadio">Yes</span><span class="spanInput marleft15"><input type="radio" class="form-contorl input-medium" name="checkid" value="no" checked="checked" /></span><span class="spanRadio">No</span></td>
            <td colspan="2"><span class="dobtxt">Enter DOB :</span> 
             <div class="row dob">
				<div class="col-xs-3 nopadleft">
				<select id="dobday" class="form-control input-lg"></select>
				</div>
				<div class="col-xs-3">
				<select id="dobmonth" class="form-control input-lg"></select>
				</div>
				<div class="col-xs-3">
				<select id="dobyear" class="form-control input-lg"></select>
				</div>
			 </div>
			</td>
          </tr>
          <tr class="payment">
            <td>Payment</td>
            <td colspan="3"><span class="spanInput"><input type="radio" class="form-contorl input-medium" name="payment" value="check" /></span><span class="spanRadio">Check</span><span class="spanInput marleft15"><input type="radio" class="form-contorl input-medium" name="payment" value="credit" checked="checked" /></span><span class="spanRadio">Credit</span><span class="spanInput marleft15"><input type="radio" class="form-contorl input-medium" name="payment" value="cash" /></span><span class="spanRadio">Cash</span></td>            
          </tr>
          <tr>
            <td class="toppad10">Coupons Reedemed</td>
            <td><input type="text" class="form-contorl input-medium martop10" name="couponRedeemed" value="N/A"/></td>
            <td colspan="2">Received : <input type="text" class="form-contorl input-medium martop10" name="couponReceived" value="N/A" /></td>                  
          </tr>
          <tr>
            <td class="valignmiddle toppad10">Notes Space</td>
            <td colspan="3"><textarea class="input-xxlarge" name="notesspace">1. Ruffles potato chips&#13;&#10;2. Tropicana orange juice - no pulp
            </textarea></td>                  
          </tr>
          <tr><td colspan="4"><div class="row">	
		<div class="col-sm-12 textcenter">
			<button type="submit" class="btn btn-success martop15">GO</button>
		</div>
	  </div> </td></tr>
        </tbody>

      </table>
       			
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