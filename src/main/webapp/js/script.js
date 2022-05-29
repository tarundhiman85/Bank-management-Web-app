//----------------------------------- Verify Password -----------------------------------
function verifyPassword() {
    var pass = document.getElementById("password").value;
    var repass = document.getElementById("confirm_password").value;
    //check empty password field
    var returnval = true;

    if(pass == "") {
        alert("Fill the password please!");
        document.getElementById("hiddenSubmit").value="Fill the password please!";
        returnval = false;
    }

    //minimum password length validation
    if(pass.length < 8) {
        alert("Password length must be atleast 8 characters");
        document.getElementById("hiddenSubmit").value="Password length must be atleast 8 characters";
        returnval = false;
    }

    //maximum length of password validation
    if(pass.length > 15) {
        alert("Password length must not exceed 15 characters");
        document.getElementById("hiddenSubmit").value="Password Length gone above 15";
        returnval = false;
    }

    //Check password matching or npt
    if(pass !== repass){
        alert("Password Doesn't match");
        document.getElementById("hiddenSubmit").value="Password Doesn't match";
        returnval = false;
    }
    return returnval;
}

//------------------------------------------Set Present Address------------------------------------------
function setPresentAddress() {
    var Address = document.getElementById('address');
    var Present_Address = document.getElementById('present_address');
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

//----------------------------------- Verify Age -----------------------------------
function dobValidate(birth) {


    var today = new Date();
    var nowyear = today.getFullYear();
    var nowmonth = today.getMonth();
    var nowday = today.getDate();
    var b = document.getElementById('dob').value;



    var birth = new Date(b);

    var birthyear = birth.getFullYear();
    var birthmonth = birth.getMonth();
    var birthday = birth.getDate();

    var age = nowyear - birthyear;
    var age_month = nowmonth - birthmonth;
    var age_day = nowday - birthday;


    var returval = true;
    if (age > 100) {
        alert("Age cannot be more than 100 Years.Please enter correct age");
        returval = false;
    }
    if (age_month < 0 || (age_month == 0 && age_day < 0)) {
        age = parseInt(age) - 1;
    }
    if ((age == 18 && age_month <= 0 && age_day <= 0) || age < 18) {
        alert("Age should be more than 18 years.Please enter a valid Date of Birth");
        returval = false;
    }

    return returval;
}

//--------------------------------------Virtual Keyboard--------------------------------------------

var print = "";
var t = "";
var back = false
var caps = false;

function button_clicked_caps() {
    if (caps)
        caps = false;
    else {
        caps = true;
    }


}




function button_clicked(character) {
    if (caps) {
        print = print + character;

    } else {

        print = print + character.toLowerCase();
    }
    var output = document.getElementById("keys_output");
    output.textContent = print;


}

function button_clicked_back() {
    var temp = "";
    var output = document.getElementById("keys_output")
    output.textContent = temp
    print = "";
}
