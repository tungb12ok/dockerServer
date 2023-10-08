function validateEmail() {
    var emailInput = document.getElementById("email");
    var email = emailInput.value;

    // Regular expression for email validation
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,5}$/;

    if (emailPattern.test(email)) {
        // Valid email address
        alert("Email is valid!");
    } else {
        // Invalid email address
        alert("Please enter a valid email address!");
    }
}
function updateInput2(value) {
    document.getElementById("input2").value = value;
}