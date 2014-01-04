$(document).ready(function(){

			if (!$('#friend').hasClass('active')) {
				$('#friend').addClass('active');
			}
	
	$('form').submit(function(){
		event.preventDefault();
		var value1=$('#search').val();
	var content={
			name: value1
	};
	if(value1!=""&&value1!=null){
		var dataString={json:JSON.stringify(content)};
		$.ajax({
			url: "friend",
			type: "post",
			dataType: "json",
			data: dataString,
			success : function(data){		    	  
				mydata=JSON.parse(data.result);
				if(mydata.length!=0){
				var output="<ul>";
				for (var i in mydata) {
					output+="<li>" + mydata[i].name + ", From " + mydata[i].city + "</li>";
					}
				output+="</ul>";
				$('span').html(output);	        
				}
				else{
					var output="<ul><li>Sorry!! No Result found... </li></ul>";
					$('span').html(output);
				}
			},
			error: function(data){
				var output="<ul><li>Sorry!! There is some error... </li></ul>";
				$('span').html(output);
				window.location.reload(true);
			}
		});
	}
	else{
		var output="<ul><li>Please Enter some value </li></ul>";
		$('span').html(output);
	}
	});
});
				
	
