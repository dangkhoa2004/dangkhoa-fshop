document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/session-info')
        .then(response => response.json())
        .then(data => {
            const isLogin = data.login;
            const username = data.username;
            const userLinkElement = document.getElementById('user-link');

            if (!isLogin) {
                userLinkElement.innerHTML = '<a class="nav-link" href="/login"><i class="fa-solid fa-right-to-bracket"></i> Đăng Nhập</a>';
            } else {
                userLinkElement.innerHTML = `<a class="nav-link" href="/user/detail"><i class="fa-solid fa-circle-user"></i>${username}</a>`;
            }
        })
        .catch(error => console.error('Error:', error));
});
