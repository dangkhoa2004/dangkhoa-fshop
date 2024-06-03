document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/session-info')
        .then(response => response.json())
        .then(data => {
            const isLogin = data.login;
            const username = data.username;
            const ipv4Address = data.ipv4Address;
            const ipv6Address = data.ipv6Address;
            const deviceName = data.deviceName;
            const timestamp = data.timestamp;
            const userRole = data.userRole;
            const sessionDuration = data.sessionDuration;
            const browserInfo = data.browserInfo;
            const operatingSystem = data.operatingSystem;
            const appVersion = data.appVersion;
            const userLinkElement = document.getElementById('user-link');
            const deviceInfoElement = document.getElementById('device-info');

            if (isLogin === true && username !== undefined) {
                userLinkElement.innerHTML = `<a class="nav-link" href="/user/detail"><i class="fa-solid fa-circle-user"></i>${username}</a>`;
                deviceInfoElement.innerHTML = `
                    IPv4: ${ipv4Address || 'N/A'}, 
                    IPv6: ${ipv6Address || 'N/A'}, 
                    Device: ${deviceName}, 
                    Timestamp: ${timestamp}, 
                    Role: ${userRole}, 
                    Session Duration: ${sessionDuration} seconds, 
                    Browser: ${browserInfo}, 
                    OS: ${operatingSystem}, 
                    App Version: ${appVersion}
                `;
            } else {
                userLinkElement.innerHTML = '<a class="nav-link" href="/login"><i class="fa-solid fa-right-to-bracket"></i> Đăng Nhập</a>';
                deviceInfoElement.innerHTML = '';
            }
        })
        .catch(error => console.error('Error:', error));
});