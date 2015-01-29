var itemCount = 2;

	$(document).ready(function(){ 	
		$('#HStr8').hide();
	 
		// Only notes td can be editable
		$("td.notes").click(function(){
			
			if($(this).attr("contentEditable") == true){
				$(this).attr("contentEditable","false");
			} else {
				$(this).attr("contentEditable","true");
			}
		})
		$(".delete").bind("click", Delete);			

		$("#ci_dd").change(function() {

			var buttonValue = $(this).val();				
			if(buttonValue == 'Yes'){
				$('#HStr8').show();
				return true;
			}
			$('#HStr8').hide();
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
			$("#"+ddTitle+" #"+ddTitle+"_input").css("font-weight","bold");
		});   
		
		/*$(".dropdown-toggle").click(function() {
			var spanTitle = $(this).attr("title");			
			myValue = parseInt(spanTitle.replace('tr',''));			
			staticVal = parseInt(myValue);				
			var deductedVal	=	myValue * 2;			
			$("#"+spanTitle+" ul.dropdown-menu").css("top",parseInt(myValue) * 14 - parseInt(deductedVal) + 33+"%");
		});*/

		//THis is for the placeholder IE8
		$('input, textarea').placeholder();

		$('span.label, div.bs-example, div.billing_items_div, div.dlvrdetails, button.btn').each(function() {            
            eval($(this).corner("4px"));
        });

        //START Convert the page into .PDF
        var specialElementHandlers = {
        	'#editor': function (element,renderer) {
            return true;
        	}
    	};
 		$('#cmd').click(function () {
        	var doc = new jsPDF();
        	doc.fromHTML($('#target').html(), 15, 15, {
            	'width': 170,'elementHandlers': specialElementHandlers
        	});
        	doc.save('sample-file.pdf');
    	});  
        //END Convert the page into .PDF

        //START Add new row
        
        $('#addNewRow').click(function () {        	
        	var trID	=	$('#bill_table tr:last').attr('id');
        	trID 		= 	trID.replace('tr', '');
        	var numRow 	= 	parseInt(trID) + 1;        	

		    var tr 		=   '<tr id="tr'+numRow+'" class="outofstockrow">';
				tr		+=			'<td class="title addedtd"><input type="text" class="input-medium addedinput" /></td>';
				tr		+=			'<td>';
				tr		+=			'	<div id="sidd'+numRow+'">';
				tr		+=			'		<input type="text" class="form-contorl input-xlarge pad15 width" id="sidd'+numRow+'_input" value="No item substituted"/>';
				tr		+=			'		<span class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true" title="tr'+numRow+'"><img src="../resources/images/dropdown-arrow.png" /></span>';
				tr		+=			'		<ul class="dropdown-menu" role="menu">';
				tr		+=			'			<li role="presentation"><a title="sidd'+numRow+'" href="javascript:void(0)" class="si">Florida Organges</a></li>';
				tr		+=			'			<li role="presentation"><a title="sidd'+numRow+'" href="javascript:void(0)" class="si">Kesar Mengo</a></li>'; 
				tr		+=			'			<li role="presentation"><a title="sidd'+numRow+'" href="javascript:void(0)" class="si">China Guava</a></li>'; 
				tr		+=			'			<li role="presentation"><a title="sidd'+numRow+'" href="javascript:void(0)" class="si">Hawaien Apple</a></li>'; 
				tr		+=			'			<li role="presentation"><a title="sidd'+numRow+'" href="javascript:void(0)" class="si">Indonesian Pineapple</a></li>';                                            
				tr		+=			'		</ul>';
				tr		+=			'	</div>';
				tr		+=			'</td>';
				tr		+=			'<td class="trash">';
				tr		+=			' <button id="'+numRow+'" type="button" class="btn delete" aria-label="Left Align">';
				tr		+=			'  <span class="delete"><img src="../resources/images/trash.png" class="delete"/></span>';
				tr		+=			' </button>';
				tr		+=			'</td>';
				tr		+=	'</tr>';
			$("#bill_table").append ( tr );	
			$(".delete").bind("click", Delete);		
			$(".si").bind("click", setSubItem);		
			$('#bill_table tr:last .addedinput').focus();	
			//$(this).children(":last").focus();
        });	
        //END Add new row

        //START DELETE 
        function Delete(){
        	var buttonId  = $(this).attr("id");			
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
			}
			//END this is for the outofstock item row	

			//Start this is for the Home Shopper Section -- Disable the functionality
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
			}
			//End this is for the Home Shopper Section -- Disable the functionality 
        }

        function setSubItem(){
        	var ddValue = $(this).text();
			var ddTitle = $(this).attr("title");
			//alert("#"+ddTitle+" #"+ddTitle+"_input");
			$("#"+ddTitle+" #"+ddTitle+"_input").val(ddValue);
			$("#"+ddTitle+" #"+ddTitle+"_input").css("font-weight","bold");
        }
        

    /*DASHBORAD*/
	    $("table.table tr").click(function(){				
			// similar behavior as an HTTP redirect
			window.location.replace("pages/csf.jsp");

			// similar behavior as clicking on a link
			window.location.href = "pages/csf.jsp";
		});
		$( ".top-profile" ).click(function() {				
		  $( ".top-profile .dropdown-menu" ).toggle( "slow", function() {
		    // Animation complete.
		  });
		});

		$("#recentRequests").click(function(){
			$( "#searchForm .dropdown-menu" ).toggle( "slow", function() {
		    	// Animation complete.
		  	});
		});
    /*DASHBOARD*/

	});