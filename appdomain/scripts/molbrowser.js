function defineMolbrowserTable(root,url,selector) {

	var oTable = $(selector).dataTable( {
		"sAjaxDataProp" : "dataset.molecule",
		"bProcessing": true,
		"bServerSide": false,
		"bStateSave": false,
		"aoColumnDefs": [
				{ "mDataProp": "record" , "asSorting": [ "asc", "desc" ],
					  "aTargets": [ 0 ],	
					  "sWidth" : "5%",
					  "bSearchable" : true,
					  "bUseRendered" : false,
					  "bSortable" : true,
					  "fnRender" : function(o,val) {
  		        	    return val;
					  }
				},
				{ "mDataProp": "img" , "asSorting": [ "asc", "desc" ],
					  "aTargets": [ 1 ],	
					  "sWidth" : "150px",
					  "sHeight" : "150px",
					  "bSearchable" : true,
					  "bUseRendered" : false,
					  "bSortable" : true,
					  "fnRender" : function(o,val) {
			                return '<img src="'+val+'">';
					  }
				},
				{ "mDataProp": "tags" , "asSorting": [ "asc", "desc" ],
					  "aTargets": [ 2 ],	
					  "bSearchable" : true,
					  "bUseRendered" : false,
					  "sClass" : "wrap",
					  "bSortable" : true,
					  "fnRender" : function(o,val) {
						var sOut = "<table class='tags'><thead><th>Name</th><th>Value</th></thead><tbody>";
						$.each(val,function(index,tag) {
							sOut += "<tr>";
							if ("link"==index) {
								sOut += '<td colspan="2"><a href='+tag+'>link</a></td>';
							} else {
								sOut += '<td>'+index + "</td><td>" + tag + '</td>';
							}
							sOut += "</tr>";
						});
						sOut += '</tbody></table>';
		        	    return sOut;
					  }
				}			
					
			],
		"sSearch": "Filter:",
		"bJQueryUI" : true,
		"bSearchable": true,
		"sAjaxSource": url,
		"sDom" : '<"help remove-bottom"i><"help"p>Trt<"help"lf>',
		"bPaginate" : true,
		"sPaginationType": "full_numbers",
		"sPaginate" : ".dataTables_paginate _paging",
		"oLanguage": {
	            "sProcessing": "<img src='"+root+"24x24_ambit.gif' border='0'>",
	            "sLoadingRecords": "No structures found.",
	            "sZeroRecords": "No structures found.",
	            "sInfo": "Showing _TOTAL_ structures (_START_ to _END_)",
	            "sLengthMenu": 'Display <select>' +
	            '<option value="5">5</option>' +
              '<option value="10">10</option>' +
              '<option value="20">20</option>' +
              '<option value="50">50</option>' +
              '<option value="100">100</option>' +
              '<option value="-1">all</option>' +
              '</select> structures.'	            
		},
		"fnServerData" : function(sSource, aoData, fnCallback,
				oSettings) {
			
			oSettings.jqXHR = $.ajax({
				"type" : "GET",
				"url" : sSource,
				"data" : aoData,
				"dataType" : "json",
				"contentType" : "application/json",
				"success" : function(json) {
					$("#title").text(json.dataset.name);
					fnCallback(json);
				},
				"cache" : true,
				"error" : function(xhr, textStatus, error) {
					switch (xhr.status) {
					case 403: {
			        	alert("Restricted data access. You are not authorized to access the requested data.");
						break;
					}
					case 404: {
						//not found
						break;
					}
					default: {
			        	alert("Error loading data " + xhr.status + " " + error);
					}
					}
					oSettings.oApi._fnProcessingDisplay(oSettings, false);
				}
			});
		},		
	} );
	return oTable;
}
