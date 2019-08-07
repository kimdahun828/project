$(function() {
	
	$('a[id^=pageno]').on('click', function(event) {
		var id = $(this).attr('id');
		var pageNo = id.split('-')[1];
		var productNo = $(this).attr("dat" +
				"" +
				"")
		
		$('#prodcut-list').load('/PCsell/productList',
							{"productNo" : 1 },
							function() {});
				
	});

});