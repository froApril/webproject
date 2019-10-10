window.onload =function () {
	$(".reply-thread").click(function(e){
		var name = $(e.target).attr("id");

		$(".comment-textarea").html("@"+name);	
	});
}


