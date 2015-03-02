<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Hashtable"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">	
	<title>CSF - Harris Teeter Exisiting CSF</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">	
	<!--[if gte IE 8]>
		<link href="resources/css/ie8-and-up.css" rel="stylesheet"  /></link>
		<link rel="stylesheet" media="print" href="../resources/css/print.css" type="text/css" />
	<![endif]-->

	<link href="resources/css/jquery-ui.css" rel="stylesheet">	
	<!-- <link href="resources/css/chosen.css" rel="stylesheet"> -->

	<script src="resources/js/jquery-1.11.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>	
	<script src="resources/js/jquery-ui.js"></script>
	<script src="resources/js/jqueryDobPicker.js"></script>
	<script src="resources/js/jquery.placeholder.js"></script>
	<script src="resources/js/jquery.corner.js"></script>	
	<script src="resources/js/jquery.autosize.js"></script>
	<script src="resources/js/siteJquery.js"></script>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.Hashtable"%>
	<%@page import="java.util.Map"%>
	<%@page import="java.util.HashMap"%>
	
</head>
<body>     
	<div class="container csf gtie8">
		<form method="GET">
<!-- <div class="row">
<div class="col-sm-6"><img src="resources/images/logo.jpg" /></div>
</div> --><!-- .row */ -->
<!-- <hr width="97.6%" align="left"> -->


<!-- end of post data -->

<div class="row topinfo">	
	<div class="col-sm-12">
		<div class="col-sm-7">
			<h4>
				<span class="label label-default left w100">Shopping for :</span><span class="custname custtext underline">${message.firstName} ${message.lastName}</span>
			</h4>
			<h4>
				<span class="label label-default left w100">Picking UP on :</span><span class="custtext pickup">${message.pickup}</span>
			</h4>
			<h4>
                 <span class="label label-default left w100">VIC Card :</span>
                 <c:choose>
                       <c:when test="${empty message.vic}">
                               <span class="novic custtext">No VIC on file</span>
                       </c:when>
                       <c:otherwise>
                              <span class="custtext">${message.vic}</span>        
                       </c:otherwise>
                 </c:choose>
             </h4>
			<!-- <h4>
				<span class="label label-default left w100">Address :</span><span class="custtext">13836, Ballantyne Meadows Drive, Charlotte, NC 28277</span>
			</h4> -->
			
		</div>
		<div class="col-sm-4 right">
			<!-- <h4>
				<span class="custname custtext"> ${message.orderTotal} </span><span class="label label-default left w100">Order total :</span>
			</h4>-->
			<h4 class="orderH4">
			
				<span class="custtext">${message.orderId}</span><span class="label label-default left w100 marright">Order # :</span>
			</h4>
			<h4>
				<span class="label label-default left w100">Phone # :</span><span class="custtext">${message.phone}</span>
			</h4>					
			<!-- <h4 class="vicsavingsH4">
				<span class="custtext"></span>${message.vicSavings}<span class="label label-default left w100 marright">VIC Savings :</span>
			</h4> -->
		</div>
	</div> <!-- .col-sm-12 */ -->
</div><!-- .row */ -->	
<div class="row dlvrdetails box-border-background pad10 floatnone martop20">
	<div class="col-sm-12 nopad marbot10 marbot29">
		<h5><div class="left">Special Instructions : </div><div class="font15 text-info left marleft15">${message.specialInstructions }</div></h5>
	</div>
</div>
<div class="row">
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
							<!-- <th>Notes</th> 
							<th>Delete ?</th>-->
						</tr>
					</thead>
					<tbody>			
						<c:forEach items="${message.modSavedMap}" var="list" varStatus="i">
						<tr id="tr${i.count}" class="outofstockrow">
							<!-- <th scope="row">1</th> -->
							<td class="title">${list.key}<input type="hidden" /></td>
							<td class="title">${list.value}<input type="hidden" /></td>
								<!-- <td class="notes"><div contenteditable="true">Nice and great!!!</div></td> -->
								
						</tr>
						</c:forEach>
					</tbody>
				</table>		
				<div class="printnone">
					<span class="title marleft9">Add an additional item : </span><img src="resources/images/plus24.png" id="addNewRow" />
				</div>		
			</div><!-- /.billing_items_div -->
		</div>
	</div><!-- /.col-sm-12 -->	
</div><!-- .row */ -->	
<!-- <hr width="97.6%" align="left"> -->
<div class="row dlvrdetails box-border-background pad10">
	<div class="col-sm-12 nopad">
		<h5>** Our Substitution Policy</h5>
		<h6 class="sp">Our goal is to never be out of stock on any item. However, if an item is out of stock our substitution policy is to give you that same item in the closest size at the cost of the item you actually receive. Or, if a sale item is substituted, you will only be charged the sale price. In most cases, we will substitute a national brand product for national brand and generic for generic. On certain items, we have a policy of not substituting unless you specifically tell us to do so. These items include baby products, soft drinks and hygiene products to name a few.</h6>
		<hr>
		<div class="shopper_delivered">
		
			<h5><div>Your Personal Shopper today was</div>
			<div>${message.personalShopper }</div>
			<h5><div>Your Order was delivered by</div>
			<div>${message.deliveryPerson}</div></h5>
		</div>
		<!-- <h6>**Please call us @1-800-432-6111 and let us know if there is anything we can do to make you Express Lane experience more enjoyable**</h6> -->
		<h6 class="left nomar"><br>Please call us @ 555-555-1212 and let us know about your experience and how we can make it better!</h6>
	</div>		
</div>		
 
<div class="row homeshopper">
	<div class="col-sm-9" style="float:none;margin:0 auto;">
		<div class="bs-example" data-example-id="simple-responsive-table">
			<div class="table-responsive box-border-background">
				<h3>Home Shopper Section<span class="hide-oosi"><img src="resources/images/minus24.png" /></span><span class="show-oosi"><img src="resources/images/plus24.png" /></span></h3>
				<hr>	
				<table class="table table-bordered" id="HSS" >
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
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr1" aria-label="Left Align"><span><img src="resources/images/trash.png" /></span></button> --><span class="marleft0">Dry Goods</span></td>
							<td><span class="form-contorl input-medium" name="drygoods_bags">${message.dryGoods}</span></td>
							<td><span class="form-contorl input-medium" name="drygoods_section">${message.dryGoodsSection}</span></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="drygoods_notes" value="Bag is made from jute" /></td> -->
						</tr>
						<tr id="HStr2" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr2" aria-label="Left Align"><span><img src="resources/images/trash.png" /></span></button> --><span class="marleft0">Perishables</span></td>
							<td><span class="form-contorl input-medium" name="perishables_bags" >${message.perishables}</span></td>
							<td><span class="form-contorl input-medium" name="perishables_section">${message.perishablesSection}</span></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="perishables_notes" value="Please see expiry date" /></td> -->
						</tr>
						<tr id="HStr3" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr3" aria-label="Left Align"><span><img src="resources/images/trash.png" /></span></button> --><span class="marleft0">Frozen</span></td>
							<td><span class="form-contorl input-medium" name="frozen_bags" >${message.frozen}</span></td>
							<td><span class="form-contorl input-medium" name="frozen_section">${message.frozenSection}</span></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="frozen_notes" value="It's fresh and tasty" /></td> -->
						</tr>
						<tr id="HStr4" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr4" aria-label="Left Align"><span><img src="resources/images/trash.png" /></span></button> --><span class="marleft0">Hot</span></td>
							<td><span class="form-contorl input-medium" name="hot_bags">${message.hot}</span></td>
							<td><span class="form-contorl input-medium" name="hot_section">${message.hotSection}</span></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="hot_notes" value="N/A"/></td> -->
						</tr>
						<tr id="HStr5" class="HSStr">
							<td><!-- <button type="button" class="btn delete" name="hss" value="HStr5" aria-label="Left Align"><span><img src="resources/images/trash.png" /></span></button> --><span class="marleft0">Floral</span></td>
							<td><span class="form-contorl input-medium" name="floral_bags">${message.floral}</span></td>
							<td><span class="form-contorl input-medium" name="floral_section">${message.floralSection}</span></td>
							<!-- <td><input type="text" class="form-contorl input-xxlarge" name="floral_notes" value="Neat and clean ones" /></td> -->
						</tr>	                            
						<tr id="HStr6" class="HSStr">
							<td><span class="marleft0">Rx</span></td>
							<td><span class="form-contorl input-medium" name="RX">${message.RX}</span></td>
						</tr>
						<tr id="HStr7" class="section2 HSStr">
							<td>Customer Called?</td>
							<td> <span class="form-contorl input-medium" name="customerCalled">${message.customerCalled}</span></td>
							<td>Notes about call : <span class="form-contorl input-medium w202 martop10 height" >${message.callNotes}</span></td>							
						</tr>
						<tr id="checkID" class="HSStr">
							<td>Check ID</td>
							<td><span class="form-contorl input-medium" name="checkID">${message.checkID}</span></td>
							<td><span class="form-contorl input-medium" name="checkID">${message.dob}</span></td>            
					</tr>
					
				<tr id="HStr9" class="payment HSStr">
					<td>Payment</td>
					<td colspan="3">
					<span class="form-contorl input-medium" name="paymentType">${message.paymentType}</span>
				</td>            
			</tr>
			<tr id="HStr10" class="HSStr">
				<td class="toppad10">Coupons Reedemed</td>
				<td><span class="form-contorl input-medium martop10" name="couponRedeemed">${message.couponsRedeemed}</span></td>
				<td colspan="2">Received : <span class="form-contorl input-large w202 martop10 height" name="couponReceived" >${message.received}</span></td>                  
			</tr>
			<tr id="HStr11" class="HSStr">
				<td class="valignmiddle toppad10">Bulk Items</td>
				<td colspan="3"><span class="input-xxlarge" name="notesspace">${message.bulkItems}</span></td>                  
			</tr>         
		</tbody>
		

	</table>

	<table class="table table-bordered"> <tr id="HStr12" class="HSStr"><td colspan="4"><div class="row">	
		<div class="col-sm-12 textcenter">
		</div>
	</div> </td></tr></table>	
	<table class="table table-bordered"> <tr id="HStr12" class="HSStr"><td colspan="4"><div class="row">	
		<div class="col-sm-12 textcenter">
			<button type="button" class="btn btn-primary martop15" value = "print">Print</button>
			<button type="button" class="btn btn-success martop15" value ="Back" onclick="goBack()">Back</button>
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
<script src="resources/js/chosen.jquery.js" type="text/javascript"></script>
<script>
function myFunction() {
    alert("Email feature is not implemented in this sprint.");
}
</script>
<script>
function goBack() {
    window.history.back()
}
</script>
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