function CompanySearch(){
	document.getElementById("js-human").classList.remove("active");
	document.getElementById("js-company").classList.add("active");
	document.getElementById("input-human").classList.add("hidden");
	document.getElementById("input-company").classList.remove("hidden");
}
function HumanSearch(){
	document.getElementById("js-company").classList.remove("active");
	document.getElementById("js-human").classList.add("active");
	document.getElementById("input-company").classList.add("hidden");
	document.getElementById("input-human").classList.remove("hidden");
}
function search1(){
	$("#CompanyForm").ajaxSubmit({
					dataType: "json",
					success: function(data){
						if(data.flag) {
							window.location="manage";
						}
						else {
							alert(data.msg);
						}
					}
				});
}
