/**
 * Submit Form while Save/Update
 */
	function citationBook_Crud()
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/book/save.htm';
			var citationBookData = {}
			$('#citationBook_form input, #citationBook_form select, #citationBook_form textarea').each(function (index)
			{
				if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
				{
					citationBookData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}

			});
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(citationBookData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		             xhr.setRequestHeader(header, token);
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#book-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationBook_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
		event.preventDefault();
		return true;
	}
	
	function citationBook_Clear_FromData()
	{
		clearFields("citationBook_form");
		remove_child_Elements('citationBook-delete-btn');
	}
	
	function citationBook_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/book/returnCitationBookById';
		var rowData = jQuery("#book-detail-grid-list").getRowData(rowId); 
		var citationBookId = rowData['citationBookId'];
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationBookId : citationBookId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationBook_Set_FormData(data);
				var myElem = document.getElementById('citationBook-delete-btn');
				if (myElem == null)
				{
					$("#citationBook-save-btn").after("<input type='button' id='citationBook-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationBook_DeleteCitationBook() ;'/>");
				}
			 }
		});
	}
	
	
	function citationBook_Set_FormData(data)
	{
		$("#citationBook_citationBookId").val(data.citationBookId);
		$("#citationBook_employeeId").val(data.employeeId);
		$("#citationBook_title").val(data.title);
		$("#citationBook_url").val(data.url);
		$("#citationBook_author").val(data.authors);
		$("#citationBook_publication_date").val(data.publicationDate);
		$("#citationBook_book").val(data.book);
		$("#citationBook_volume").val(data.volume);
		$("#citationBook_issue").val(data.issue);
		$("#citationBook_pages").val(data.pages);
		$("#citationBook_publisher").val(data.publisher);
		$("#citationBook_description").val(data.description);
	}
	
	function citationBook_DeleteCitationBook()
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/book/deleteCitationBookById';
		var citationBookId = $("#citationBook_citationBookId").val();
		
		//event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         data:{citationBookId : citationBookId},
			 async:false,
			 beforeSend: function(xhr) 
	         {
				 xhr.setRequestHeader(header, token);
	         },
			 success : function(data) {
				if(data != undefined) {
					jQuery("#book-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					citationBook_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			}
		});
	}