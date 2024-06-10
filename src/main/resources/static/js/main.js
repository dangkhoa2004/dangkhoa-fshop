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

document.addEventListener('DOMContentLoaded', function() {
    const dropdownButton = document.getElementById('dropdownMenuButton');
    const dropdownMenu = document.querySelector('.dropdown-menu');

    dropdownButton.addEventListener('click', function(event) {
        event.preventDefault();
        dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
    });

    window.addEventListener('click', function(event) {
        if (!event.target.matches('#dropdownMenuButton')) {
            if (dropdownMenu.style.display === 'block') {
                dropdownMenu.style.display = 'none';
            }
        }
    });
});

