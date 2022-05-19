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