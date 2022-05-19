function verifyPassword() {
    var pass = document.getElementById("password").value;
    var repass = document.getElementById("confirm password").value;
    //check empty password field
    if(pass == "") {
        alert("Fill the password please!");
    }

    //minimum password length validation
    if(pass.length < 8) {
        alert("Password length must be atleast 8 characters");
    }

    //maximum length of password validation
    if(pass.length > 15) {
        alert("Password length must not exceed 15 characters");
    }

    //Check password matching or npt
    if(pass != repass){
        alert("Password Dosen't match");
    }
}

//------------------------------------------Set Present Address------------------------------------------
function setPresentAddress() {
    var Address = document.getElementById('address');
    var Present_Address = document.getElementById('present address');
    var Check = document.getElementById('yes');
    if (Check.checked == true) {
        Present_Address.value = Address.value;
        Present_Address.disabled = true;
    } else {
        Present_Address.disabled = false;
    }
}

var SameAsAbove = {
    init: function(){
        var Check = document.getElementById('homepostalcheck');
        Core.addEventListener(Check, 'click', setPresentAddress);
    }
}

Core.start(SameAsAbove);