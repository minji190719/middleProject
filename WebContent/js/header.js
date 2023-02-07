const headerUl = document.querySelector(".menu-bar__nav ul");
const headerLi = headerUl.querySelectorAll("li");
const navDiv = document.querySelectorAll(".menu-bar__nav ul li > div");

console.log(headerUl);
console.log(headerLi);
console.log(navDiv);

let navIndex = 0;

const showNav = (event) => {
	const { tagName } = event.target;
	
	if(tagName === "LI") {
		const nodes = [...event.target.parentElement.children];
	    const index = nodes.indexOf(event.target);
		navIndex = index;
	}
	if(navIndex!==5) {
		navDiv[navIndex].classList.toggle("show-nav");
	}
	//const nav = event.target.nextElementSibling;
}

const hideNav = (event) => {
	//const nodes = [...event.target.parentElement.children];

    //console.log(event.target.parentElement, nodes);

    //const index = nodes.indexOf(event.target);

    //console.log("hide : "+index)
	const nav = event.target;
	nav.classList.toggle("show-nav");
	navIndex = 0;
}

headerLi.forEach((item) => {
	item.addEventListener("mouseenter", showNav)
});
navDiv.forEach((item) => item.addEventListener("mouseleave", hideNav));