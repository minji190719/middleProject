const memPass = document.getElementById("memPass");
const confirmPass = document.getElementById("confirmPass");

const checkPass = function(event) {
	
	const { target } = event;
	const confirmValue = target.value;
	
	if ( memPass.value !== confirmValue || confirmValue === "" ) {
		target.classList.remove("equalsPass");
		target.classList.add("notEqualsPass");
	} else {
		target.classList.remove("notEqualsPass");
		target.classList.add("equalsPass");
	}
}

confirmPass.addEventListener("input", checkPass);