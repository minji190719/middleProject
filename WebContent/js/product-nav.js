const filter = document.getElementById("filter");
const productNav = document.getElementById("product-nav");
const prodContainer = document.getElementById("prod-container");

let sideStatus = false;

const slideNav = function() {
//	const sideStatus = localStorage.getItem("sideStatus");
	
	if(sideStatus) {
		productNav.classList.add("slide-side");
		prodContainer.classList.remove("container-slide");
//		localStorage.setItem("sideStatus", true);
		sideStatus = false;
	} else {
		productNav.classList.remove("slide-side");
		prodContainer.classList.add("container-slide");
//		localStorage.removeItem("sideStatus");
		sideStatus = true;
	}
	
//	console.log(sideStatus);
}

filter.addEventListener("mouseup", slideNav);
