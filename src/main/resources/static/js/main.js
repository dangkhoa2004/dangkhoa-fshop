function clearInputs() {
    var inputs = document.querySelectorAll('input');
    var selects = document.querySelectorAll('select');
    inputs.forEach(function (input) {
        input.value = '';
    });
    selects.forEach(function (select) {
        select.selectedIndex = 0;
    });
}