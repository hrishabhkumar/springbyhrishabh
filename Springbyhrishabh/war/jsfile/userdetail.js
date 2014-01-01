$(document).ready(function() {
	//Date Picker
	$(document).ready(function(){
		$("#dob").click(function(){
			$('dob').val('');
		});
		$("#dob").keydown(false);
		$('#dob').datepick({dateFormat: 'dd-M-yyyy', maxDate: new Date()});

	});
	$(function(){
		$('input').attr("disabled",true);	
	});
	
	$ (function(){
		$('#contact').change(function(){
			var cont=$('#contact').val();
			var regex=/^\d{10}$/;
			if(regex.test(cont)){
				$('#submit').attr("disabled", false);
			}
			else{
				$('#ec').text("Please Enter valid contact no.");
				$('#submit').attr("disabled", true);
			}
			
		}); 
	 });

	
	$ (function(){
		$('#imgeupload').submit(function(event){
			event.preventDefault();
			var formObj = $(this);
			var formURL = formObj.attr("action");
			var formData = new FormData(this);
			$.ajax({
				url: formURL,
				type: "post",
				mimeType:"multipart/form-data",
				data: formData,
				contentType: false,
				cache: false,
				processData:false,
				success: function(data){
						alert("image uploaded");
					}
				});
			});
	});
	
	
	$ (function(){
		$("#edit").click(function(){
			$('input').attr("disabled",false);
			$('#email').attr("disabled", true)
			$('p').hide();
		});		
	});
	$ (function(){
		$("#save").click(function(){
			var name= $('#name').val();
			var email= $('#email').val();
			var password= $('#pass').val();
			var dob= $('#dob').val();
			var contact= $('#contact').val();
			var city=$('#city').val();
			
			//var abc="name="+name+"&email="+email+"&password="+password+"&dob="+dob+"&contact="+contact;
			//console.log(abc)
			var content={
					name: $('#name').val(),
					email: $('#email').val(),
					password: $('#pass').val(),
					dob: $('#dob').val(),
					contact: $('#contact').val(),
					city: $('#city').val()
					};
			var dataString={json:JSON.stringify(content)};
			if(name==""||name==null||email==""||email==null||password==""||password==null||dob==""||dob==null||contact==""||contact==null||city==""||city==null){
				$('p').show();
			    $('p').text("Please fill the all the mandetory fields!!");
			}
			else{
			 $.ajax({
				  url: "update",
				  type: "post",
				  dataType: "json",
				  data: dataString,
			      success : function(data){
			    	  
			    	  if(data.status=="success"){
			    		  $('p').show();
			    	$('p').text("Data has been saved Successfully");
			    	  $('input').attr("disabled",true);
			    	  
			    	  }
			    	  else{
			    		  $('#result').text("Error!!!! Data has not been saved.");
			    		  
			    	  }
			      },
			    error: function(data){
			    	
			    	$('p').show();
			    	$('p').text("error");
			    	window.location.reload(true);
			    }
			 });
			} 
		});
	});
	
});