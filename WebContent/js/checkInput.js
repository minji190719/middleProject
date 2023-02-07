const inputs = document.querySelectorAll(".memberForm input[pattern]");

const checkInput = function(event) {
	event.target.classList.add("checkInput");
}

inputs.forEach( function(item) {
	item.addEventListener("input", checkInput);
});
