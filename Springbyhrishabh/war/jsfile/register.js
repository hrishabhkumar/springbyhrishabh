$(document).ready(function(){
	
	//Date Picker
	$(document).ready(function(){
		$("#dob").keydown(false);
		$('#dob').datepick({dateFormat: 'dd-M-yyyy', maxDate: new Date()});
	});
	
	// Validation of email
	function validateEmail(email)
	{
	 var reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
	 if (reg.test(email)){
		 
	 return true; 
	 }
	 else{
	 return false;
	 }
	} 
	//************************************************************************
	
	 //Contact validation
	 $ (function(){
		$('#contact').change(function(){
			var cont=$('#contact').val();
			var regex=/^\d{10}$/;
			if(regex.test(cont)){
				$('#contactspan').text("");
				$('#submit').attr("disabled", false);
			}
			else{
				$('#contactspan').text("Please Enter valid contact no.");
				$('#submit').attr("disabled", true);
			}
			
		}); 
	 });

		
//********************************************************************************	
	
	
//Email Validation and searching.
	$(function(){
	$('#email').change(function() {
		var email=$('#email').val();
		if(validateEmail(email)){	
		var	dataString="email="+email;
		$.ajax({
		  url: "search",
		  type: "post",
		  data: dataString,
		  success : function(data){
			  if(data=="found"){
				  $("#emailspan").text("opssss!!!! Email is already Registered ");
		    	$('#submit').attr("disabled", true);
		      }
				else{
					$("#emailspan").text("Congrats!! this is not yet registered");
					$('#submit').attr("disabled", false);
				}
			   }
		});
		}
		else{
			$("#emailspan").text("Please enter correct email adress");
			$('#submit').attr("disabled", true);
		}
	
	});
	});
	
//****************************************************************************************
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

//Form Submit.
	$ (function(){
	$('#reg').submit(function(event){
		event.preventDefault();
		var name= $('#name').val();
		var email= $('#email').val();
		var password= $('#pass').val();
		var dob= $('#dob').val();
		var contact= $('#contact').val();
		var city=$('#city').val();
		var dataStr = "name="+name+"&email="+email+"&password="+password+"&dob="+dob+"&contact="+contact+"&city="+city;
		
		$.ajax({
			url: "register",
			type: "post",
			data: dataStr,
			success : function(data){
				if(data=="success"){
					window.location="/";
				}
				else{
					alert("Sorry!!! There is Some Problem.");
		    	  }
		      	}
		});
	});
	});
	
	//***************************************************
	//image upload
});